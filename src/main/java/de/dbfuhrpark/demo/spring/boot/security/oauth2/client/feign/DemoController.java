package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign;


import de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person.Person;
import de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person.PersonClientCredentialsFeignClient;
import de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person.PersonResourceOwnerFeignClient;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    private PersonClientCredentialsFeignClient personClientCredentialsFeignClient;
    private PersonResourceOwnerFeignClient personResourceOwnerFeignClient;

    public DemoController(
        PersonClientCredentialsFeignClient personClientCredentialsFeignClient,
        PersonResourceOwnerFeignClient personResourceOwnerFeignClient) {
        this.personClientCredentialsFeignClient = personClientCredentialsFeignClient;
        this.personResourceOwnerFeignClient = personResourceOwnerFeignClient;
    }

    @GetMapping("/persons/cc")
    public ResponseEntity<Collection<Person>> getPersonFromResourceServerViaClientCredentials() {
        ResponseEntity<Collection<Person>> response = personClientCredentialsFeignClient.getPersons();
        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("error: REST-response: [{}] ", response.getStatusCode());
        }
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/persons/ro")
    public ResponseEntity<Collection<Person>> getPersonFromResourceServerViaResourceOwner() {
        ResponseEntity<Collection<Person>> response = personResourceOwnerFeignClient.getPersons();
        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("error: REST-response: [{}] ", response.getStatusCode());
        }
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }



}
