package com.exampledb.demodb.service;

import com.exampledb.demodb.model.Clients;
import com.exampledb.demodb.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Clients clients){
        clientRepository.save(clients);
    }

    public List<Clients> getAllClients(){
        return clientRepository.findAll();
    }
}
