package com.Spring.Banking.Security;

import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
@Autowired DataSource dataSource;
    /*@Bean
    public InMemoryUserDetailsManager userDetails(PasswordEncoder passwordEncoder){

        UserDetails user = User.withUsername("ram").password(passwordEncoder.encode("payilagam")).roles("USER").build();
        UserDetails user1 = User.withUsername("admin").password( passwordEncoder.encode("payilagam")).roles("USER","ADMIN").build();
        return new InMemoryUserDetailsManager(user,user1);
    }*/
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
   /* @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/payilagam");
        dataSourceBuilder.username("prithivi");
        dataSourceBuilder.password(("password"));
       // dataSourceBuilder
        return dataSourceBuilder.build();
    }*/

   /* @Bean
    public EmbeddedDatabase dataSource(){

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("payilagam")
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }*/


    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager( PasswordEncoder passwordEncoder) throws Exception{

        UserDetails user = User.builder()
                .username("prithiviraj")
                .password(passwordEncoder.encode("payilagam"))
                .roles("ADMIN")
               // .disabled(false)
                .build();
        UserDetails user0 = User.builder()
                .username("vinod")
                .password(passwordEncoder.encode("payilagam"))
                .roles("ADMIN","USER")
                // .disabled(false)
                .build();
        UserDetails user1 = User.builder()
                .username("ram")
                .password(passwordEncoder.encode("payilagam"))
                .roles("USER")
               // .disabled(false)
                .build();

          System.out.println( user1.getPassword());
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);

        jdbc.createUser(user);
        jdbc.createUser(user0);
        jdbc.createUser(user1);

        return jdbc;

    }



    @Bean
    public SecurityFilterChain securityFilter (HttpSecurity http) throws Exception{

      return http.authorizeHttpRequests(request -> request.anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults())
                .build();

            }

    /*@Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/payilagam");
        dataSourceBuilder.username("prithivi");
        dataSourceBuilder.password(passwordEncoder().encode("password"));
        return dataSourceBuilder.build();
    }*/
   /* @Bean
    public UserDetailsManager users(DataSource dataSource){
        UserDetails user = User.withUsername("ram").password(passwordEncoder().encode("payilagam")).roles("USER").build();
        UserDetails user1 = User.withUsername("muthu").password( passwordEncoder().encode("payilagam")).roles("USER","ADMIN").build();
        JdbcUserDetailsManager jdbcusers = new JdbcUserDetailsManager(dataSource);
        jdbcusers.createUser(user);
        jdbcusers.createUser(user1);

        return jdbcusers;
    }*/


   /* public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(" select username, password , enabled from users where username = ?")
                .authoritiesByUsernameQuery(" select username, authority from authorities where username = ?")
                .passwordEncoder(passwordEncoder());
    }*/


}
