package ir.co.isc.encrypt.model;

public class EncryptedAgentKey {
    private AgentKey agentKey;
    private EncryptedAgent encryptedAgent;

    public EncryptedAgentKey(AgentKey agentKey, EncryptedAgent encryptedAgent) {
        this.agentKey = agentKey;
        this.encryptedAgent = encryptedAgent;
    }

    public AgentKey getAgentKey() {
        return agentKey;
    }


    public EncryptedAgent getEncryptedAgent() {
        return encryptedAgent;
    }

}
