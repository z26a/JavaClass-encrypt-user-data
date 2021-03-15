package ir.co.isc.encrypt.service;

import ir.co.isc.encrypt.model.*;
import ir.co.isc.encrypt.repository.AgentRepository;
import ir.co.isc.encrypt.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;


@Service
public class RegistrationImp implements Registration {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private Cryptography cryptography;

    @Autowired
    private KeyRepository keyRepository;


    public RegistrationImp() {
        super();
    }

    @Override
    public void saveNewAgent(Agent agent) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        EncryptedAgentKey encryptedAgentKey=cryptography.encrypt(agent).get("key1");
        EncryptedAgent encryptedAgent=encryptedAgentKey.getEncryptedAgent();
        AgentKey agentKey=encryptedAgentKey.getAgentKey();


       encryptedAgent.addKey(agentKey);
        agentRepository.save(encryptedAgent);
    }

    @Override
    public List<Agent> retrieveAll() throws NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, InvalidKeySpecException,
            NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {

        List<AgentDto> agentDtos=new ArrayList<>();
        agentDtos.addAll(keyRepository.findAllEncryptedAgents());

        List<Agent> agents=new ArrayList<>();
        agents.addAll(cryptography.decrypt(agentDtos));

return agents;

    }


}
