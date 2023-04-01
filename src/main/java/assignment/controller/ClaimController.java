package assignment.controller;

import assignment.model.Claim;
import assignment.repository.ClaimDBManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ComponentScan("assignment")
@EntityScan("assignment")
@SpringBootApplication(scanBasePackages={"assignment"})
//@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

@Slf4j
public class ClaimController {

    @Autowired
    ClaimDBManager claimDBManager;

    @GetMapping(value = "/api/claims")
    @ResponseBody
    public List<Claim> getAll() {
        log.info("Inside root");
        return claimDBManager.findAll();
    }

    @GetMapping(value = "/api/claims/{id}")
    @ResponseBody
    public Claim home(@PathVariable("id") int id) {
        log.info("Inside root");
        return claimDBManager.findById(id).get();
    }

    @PostMapping(value = "/api/claims", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Claim create(@RequestBody Claim claim) {
        log.info("Inside root");
        System.out.println(claim);
        return claimDBManager.save(claim);
    }

    @DeleteMapping(value = "/api/claims/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        log.info("Inside root");
        claimDBManager.deleteUserById(id);
    }
}
