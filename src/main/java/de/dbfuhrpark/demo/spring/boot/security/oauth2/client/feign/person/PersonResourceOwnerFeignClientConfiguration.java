package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

// no @Configuration here!!
public class PersonResourceOwnerFeignClientConfiguration {

    @Value("${person-service.security.oauth2.access-token-uri}")
    private String accessTokenUri;

    @Value("${person-service.security.oauth2.client.id}")
    private String clientId;

    @Value("${person-service.security.oauth2.client.secret}")
    private String clientSecret;

    @Value("${person-service.security.oauth2.client.username}")
    private String username;

    @Value("${person-service.security.oauth2.client.password}")
    private String password;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), oAuth2ProtectedResourceDetails());
    }

    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        details.setPassword(password);
        details.setUsername(username);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setId(clientId);
        return details;
    }
}
