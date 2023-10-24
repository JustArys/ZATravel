package com.example.zatravel;

import com.example.zatravel.User.Role;
import com.example.zatravel.auth.AuthenticationService;
import com.example.zatravel.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import static com.example.zatravel.User.Role.ADMIN;

@SpringBootApplication()
public class ZaTravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaTravelApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .username("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());
        };
    }
}
