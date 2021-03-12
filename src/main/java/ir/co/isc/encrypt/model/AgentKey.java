package ir.co.isc.encrypt.model;

import javax.persistence.*;
import java.security.PrivateKey;
import java.security.PublicKey;

@Entity
public class AgentKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publicKey;
    private String privateKey;

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public EncryptedAgent getAgent() {
        return agent;
    }

    public void setAgent(EncryptedAgent agent) {
        this.agent = agent;
    }

    @ManyToOne
    @JoinColumn(name = "Agent_Id", nullable = false)
    private EncryptedAgent agent;


    public AgentKey(String publicKey, String privateKey) {

        this.publicKey = publicKey;
        this.privateKey = privateKey;

    }

    public AgentKey() {
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
