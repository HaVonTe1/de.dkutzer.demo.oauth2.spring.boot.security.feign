package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign;


import de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person.Person;
import de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person.PersonClient;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    @Autowired
    private PersonClient personClient;


    @GetMapping("/person")
    public ResponseEntity<Collection<Person>> getPersonFromOauth2Service() {
        ResponseEntity<Collection<Person>> response = personClient.getPersons();
        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("error: REST-response: [{}] ", response.getStatusCode());
        }
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }


}
