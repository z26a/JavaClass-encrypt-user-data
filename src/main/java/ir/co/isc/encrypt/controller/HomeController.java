package ir.co.isc.encrypt.controller;


import ir.co.isc.encrypt.model.Agent;
import ir.co.isc.encrypt.service.Registration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

@Controller
@Slf4j
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private Registration registration;

    @GetMapping("/")
    public String homePage(Model model) throws NoSuchProviderException,
            NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        model.addAttribute("appName", appName);
        model.addAttribute("agents",registration.retrieveAll());
        log.debug("Home Page");
        return "home";
    }

   @GetMapping("/newAgent")
    public String newAgent(Agent agent) {
        return "add-agent";
    }


    @PostMapping("/addAgent")
    public String addUser(@Validated Agent agent, BindingResult result,
                          Model model) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        if (result.hasErrors()) {
            log.error(result.toString());
            return "add-agent";
        }

        registration.saveNewAgent(agent);
        log.debug("Save ok.");
        return "redirect:/";
    }
}
