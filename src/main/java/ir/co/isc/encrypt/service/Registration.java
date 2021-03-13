package ir.co.isc.encrypt.service;


import ir.co.isc.encrypt.model.Agent;
import ir.co.isc.encrypt.model.AgentDto;
import ir.co.isc.encrypt.model.AgentKey;
import ir.co.isc.encrypt.model.EncryptedAgentKey;
import org.springframework.data.repository.CrudRepository;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface Registration {
    void saveNewAgent(Agent agent) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException;
//    List<Agent> retrieveAll();
    List<Agent> retrieveAll() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException;
}
