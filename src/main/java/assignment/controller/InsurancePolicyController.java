package assignment.controller;

import assignment.model.InsurancePolicy;
import assignment.repository.InsurancePolicyDBManager;
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
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyDBManager insurancePolicyDBManager;

    @GetMapping(value = "/api/policies")
    @ResponseBody
    public List<InsurancePolicy> getAll() {
        log.info("Inside root");
        return insurancePolicyDBManager.findAll();
    }

    @GetMapping(value = "/api/policies/{id}")
    @ResponseBody
    public InsurancePolicy home(@PathVariable("id") int id) {
        log.info("Inside root");
        return insurancePolicyDBManager.findById(id).get();
    }


    @PostMapping(value = "/api/policies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InsurancePolicy create(@RequestBody InsurancePolicy insurancePolicy) {
        log.info("Inside root");
        System.out.println(insurancePolicy);
        return insurancePolicyDBManager.save(insurancePolicy);
    }

    @DeleteMapping(value = "/api/policies/{id}")
    public void delete(@PathVariable int id) {
        insurancePolicyDBManager.deleteUserById(id);
    }
}
