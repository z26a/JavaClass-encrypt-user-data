package ir.co.isc.encrypt.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Slf4j
@Getter
@Setter
public class EncryptedAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String encryptedFirstName;

    private String encryptedLastName;

    @OneToMany(mappedBy = "agent"
            , cascade = CascadeType.ALL)
    private Set<AgentKey> agentKeySet;


    public EncryptedAgent(String encryptedFirstName, String encryptedLastName) {
        this.encryptedFirstName = encryptedFirstName;
        this.encryptedLastName = encryptedLastName;
    }

    public EncryptedAgent() {
    }

    public Long getId() {
        return id;
    }

    public String getEncryptedFirstName() {
        return encryptedFirstName;
    }

    public String getEncryptedLastName() {
        return encryptedLastName;
    }

    public Set<AgentKey> getAgentKeySet() {
        return agentKeySet;
    }

    @Override
    public String toString() {
        return "Agent{" + "firstName=" + encryptedFirstName + ", lastName=" + encryptedLastName + '}';
    }

    public void addKey(AgentKey agentKey) {
        if (agentKeySet == null)
            agentKeySet = new HashSet<AgentKey>();
        agentKey.setAgent(this);
        agentKeySet.add(agentKey);
    }
}
