package ir.co.isc.encrypt.service;

import ir.co.isc.encrypt.model.*;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

@Service
public class CryptographyImp implements Cryptography {


    public CryptographyImp() {
    }

    @Override
    public Map<String, EncryptedAgentKey> encrypt(Agent agent) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String encryptedLastName, encryptedFirstName;
        Map<String, EncryptedAgentKey> result = new HashMap<String, EncryptedAgentKey>();

        KeyPairGenerator kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
        PublicKey publicKey = kp.getPublic();
        Cipher cipher = null;
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] name = agent.getFirstName().getBytes();


        try {
            encryptedFirstName = Base64.getEncoder().encodeToString(cipher.doFinal(name));

        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new IllegalArgumentException(e);
        }


        byte[] lastName = agent.getLastName().getBytes();
        try {
            encryptedLastName = Base64.getEncoder().encodeToString(cipher.doFinal(lastName));
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new IllegalArgumentException(e);
        }


        EncryptedAgent encryptedAgent = new EncryptedAgent(encryptedFirstName, encryptedLastName);

        byte[] byte_pubkey = publicKey.getEncoded();
        String str_key_pub = Base64.getEncoder().encodeToString(byte_pubkey);




        byte[] byte_prikey = kp.getPrivate().getEncoded();
        String str_key_pri = Base64.getEncoder().encodeToString(byte_prikey);



        AgentKey key = new AgentKey(str_key_pub, str_key_pri);
        EncryptedAgentKey encryptedAgentKey = new EncryptedAgentKey(key, encryptedAgent);

        result.put("key1", encryptedAgentKey);

        return result;
    }

    @Override
    public List<Agent> decrypt(List<AgentDto> agentDtos) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, NoSuchProviderException, BadPaddingException, IllegalBlockSizeException {

        String firstName, lastName;

        List<Agent> agentsList = new ArrayList<>();

        for (AgentDto agentDto : agentDtos) {
            byte[] byte_prikey = Base64.getDecoder().decode(agentDto.getPrivateKey());


            KeyFactory kf = KeyFactory.getInstance("RSA");

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(byte_prikey);
            PrivateKey privateKey = kf.generatePrivate(spec);

            Cipher cipher = null;
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] name=Base64.getDecoder().decode(agentDto.getEncryptedFirstName());

            firstName=new String(cipher.doFinal(name),StandardCharsets.UTF_8);
            System.out.println(firstName);

            byte[] lName =Base64.getDecoder().decode(agentDto.getEncryptedLastName());
            lastName=new String(cipher.doFinal(lName),StandardCharsets.UTF_8);

            Agent agent = new Agent(firstName, lastName);
            agent.setId(agentDto.getId());
            agentsList.add(agent);
        }
            return agentsList;
        }



}

