package com.exampledb.demodb.config;

import com.exampledb.demodb.model.Clients;
import com.exampledb.demodb.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunnerClients(ClientRepository clientRepository) {
        return args -> {
            Clients clients1 = new Clients(
                    "Popescu",
                    "Ion",
                    "popescuion@gmail.com");
            Clients clients2 = new Clients(
                    "Filip",
                    "Andrei",
                    "filipandrei@gmail.com");
            clientRepository.saveAll(List.of(clients1, clients2));
        };
    }
}
