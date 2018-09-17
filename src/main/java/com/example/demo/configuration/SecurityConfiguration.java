package com.example.demo.configuration;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserService userService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            builder
                    .inMemoryAuthentication()
                    .passwordEncoder(encoder)
                    .withUser("admin")
                    .password(encoder.encode("admin"))
                    .roles("admin");

            userService.getUsers().forEach(user -> {
                try {
                    builder
                            .inMemoryAuthentication()
                            .passwordEncoder(encoder)
                            .withUser(user.getUsername())
                            .password(encoder.encode(user.getPassword()))
                            .roles(user.getRole());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // CW: read the users, passwords and roles from the db
            // and then load them up in memory

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
