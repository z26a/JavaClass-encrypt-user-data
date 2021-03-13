package ir.co.isc.encrypt.model;


import lombok.Getter;
import lombok.Setter;


public class AgentDto {

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


    public String getEncryptedFirstName() {
        return encryptedFirstName;
    }

    public String getEncryptedLastName() {
        return encryptedLastName;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public Long getId() {
        return id;
    }
}
