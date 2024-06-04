package com.Spring.Banking.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetails(PasswordEncoder passwordEncoder){

        UserDetails user = User.withUsername("ram").password(passwordEncoder.encode("payilagam")).roles("USER").build();
        UserDetails user1 = User.withUsername("admin").password( passwordEncoder.encode("payilagam")).roles("USER","ADMIN").build();
        return new InMemoryUserDetailsManager(user,user1);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }


    @Bean
    public SecurityFilterChain securityFilter (HttpSecurity http) throws Exception{

        return http.authorizeHttpRequests(request -> request.anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }


}
