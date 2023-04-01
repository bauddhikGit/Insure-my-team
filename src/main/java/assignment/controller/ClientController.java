package assignment.controller;

import assignment.model.Client;
import assignment.repository.ClientDBManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ComponentScan("assignment")
@EntityScan("assignment")
@SpringBootApplication(scanBasePackages={"assignment"})
//@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ClientController {

    @Autowired
    ClientDBManager clientDBManager;

    @GetMapping(value = "/api/clients")
    @ResponseBody
    public List<Client> getAll() {
        log.info("Inside root");
        return clientDBManager.findAll();
    }

    @GetMapping(value = "/api/clients/{id}")
    @ResponseBody
    public Client home(@PathVariable("id") int id) {
        log.info("Inside root");
        return clientDBManager.findById(id).get();
    }

    @PostMapping(value = "/api/clients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Client create(@RequestBody Client insurancePolicy) {
        System.out.println(insurancePolicy);
        return clientDBManager.save(insurancePolicy);
    }

    @DeleteMapping(value = "/api/clients/{id}")
    public void delete(@PathVariable int id) {
        clientDBManager.deleteUserById(id);
    }
}
