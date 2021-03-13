package ir.co.isc.encrypt.service;



import ir.co.isc.encrypt.model.Agent;
import ir.co.isc.encrypt.model.AgentDto;
import ir.co.isc.encrypt.model.EncryptedAgentKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;

public interface Cryptography {
    Map<String, EncryptedAgentKey> encrypt(Agent agent) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException;
    List<Agent> decrypt(List<AgentDto> agentDtos) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;

}
