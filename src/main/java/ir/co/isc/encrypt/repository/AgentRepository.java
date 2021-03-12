package ir.co.isc.encrypt.repository;




import ir.co.isc.encrypt.model.EncryptedAgent;
import ir.co.isc.encrypt.model.EncryptedAgentKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author rbabaei
 */


public interface AgentRepository extends CrudRepository<EncryptedAgent, Long> {

}