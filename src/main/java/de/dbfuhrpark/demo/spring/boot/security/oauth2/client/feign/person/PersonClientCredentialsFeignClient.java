package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person;

import java.util.Collection;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "person-service", configuration = PersonClientCredentialsFeignClientConfiguration.class)
public interface PersonClientCredentialsFeignClient {

    @RequestMapping(value = "${person-service.person.url}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Collection<Person>> getPersons();
}
