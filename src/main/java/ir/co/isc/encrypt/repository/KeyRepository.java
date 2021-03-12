package ir.co.isc.encrypt.repository;

import ir.co.isc.encrypt.model.AgentDto;
import ir.co.isc.encrypt.model.AgentKey;
import ir.co.isc.encrypt.model.EncryptedAgent;
import ir.co.isc.encrypt.model.EncryptedAgentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyRepository extends JpaRepository<EncryptedAgent,Long> {

    @Query("select new ir.co.isc.encrypt.model.AgentDto(encryptedAgent.id,encryptedAgent.encryptedFirstName,encryptedAgent.encryptedLastName" +
            ", agentKey.privateKey) from EncryptedAgent encryptedAgent join encryptedAgent.agentKeySet agentKey")

    List<AgentDto> findAllEncryptedAgents();
}
