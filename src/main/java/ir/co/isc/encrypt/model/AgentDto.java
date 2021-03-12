package ir.co.isc.encrypt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@Entity
public class AgentDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long AgentDtoId;
    private Long id;
    private String encryptedFirstName;
    private String encryptedLastName;
    private String privateKey;

    public AgentDto(Long id, String encryptedFirstName, String encryptedLastName, String privateKey) {
        this.id = id;
        this.encryptedFirstName = encryptedFirstName;
        this.encryptedLastName = encryptedLastName;
        this.privateKey = privateKey;
    }

    public AgentDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEncryptedFirstName() {
        return encryptedFirstName;
    }

    public void setEncryptedFirstName(String encryptedFirstName) {
        this.encryptedFirstName = encryptedFirstName;
    }

    public String getEncryptedLastName() {
        return encryptedLastName;
    }

    public void setEncryptedLastName(String encryptedLastName) {
        this.encryptedLastName = encryptedLastName;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

}
