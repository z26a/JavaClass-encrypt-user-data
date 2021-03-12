package ir.co.isc.encrypt.controller;


import ir.co.isc.encrypt.model.EncryptedAgent;
import ir.co.isc.encrypt.repository.AgentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/agents")
@Slf4j
public class NewController {
    @Autowired
    private AgentRepository agentRepository;

    public List agents() {
        return StreamSupport.stream(agentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public EncryptedAgent agent(@PathVariable(name = "id") Long id) {
        return agentRepository.findById(id).get();
    }
}
