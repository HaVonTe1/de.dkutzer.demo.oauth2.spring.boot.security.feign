package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {


    private String firstname;
    private String lastname;

    private int age;

}
