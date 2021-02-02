package com.exampledb.demodb.config;

import com.exampledb.demodb.model.Users;
import com.exampledb.demodb.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            Users firstUser = new Users(
                    "firstUser",
                    "firstUserPass"
            );
            Users secondUser = new Users(
                    "secondUser",
                    "secondUserPass"
            );
            Users thirdUser = new Users(
                    "user",
                    "pass"
            );
            userRepository.saveAll(List.of(firstUser, secondUser, thirdUser));
        };
    }
}
