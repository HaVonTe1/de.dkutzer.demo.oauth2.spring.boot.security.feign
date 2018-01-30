package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootSecurityOauth2ClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityOauth2ClientFeignApplication.class, args);
	}
}
