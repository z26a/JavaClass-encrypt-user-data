package ir.co.isc.encrypt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.security.PublicKey;

@Entity
@Getter
@Setter
public class AgentKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publicKey;
    @Column(columnDefinition = "TEXT")
    private String privateKey;


    @ManyToOne
    @JoinColumn(name = "Agent_Id", nullable = false)
    @JsonIgnore
    private EncryptedAgent agent;


    public AgentKey(String publicKey, String privateKey) {

        this.publicKey = publicKey;
        this.privateKey = privateKey;

    }

    public AgentKey() {
    }

    public void setAgent(EncryptedAgent agent) {
        this.agent = agent;
    }
}
