package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign.person;


import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;


// no @Configuration here!!
public class PersonClientCredentialsFeignClientConfiguration {

    @Value("${person-service.security.oauth2.access-token-uri}")
    private String accessTokenUri;

    @Value("${person-service.security.oauth2.client.id}")
    private String clientId;

    @Value("${person-service.security.oauth2.client.secret}")
    private String clientSecret;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), oAuth2ProtectedResourceDetails());
    }

    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri(accessTokenUri);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setId(clientId);
        return details;
    }
}
