package de.dbfuhrpark.demo.spring.boot.security.oauth2.client.feign;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        super.configure(http);
    }

}
