package com.exampledb.demodb.controller;

import com.exampledb.demodb.model.Clients;
import com.exampledb.demodb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/demoDBClients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Clients> getClients(){
        return clientService.getAllClients();
    }

    @PostMapping()
    public void addClient(@RequestBody Clients clients){
        clientService.addClient(clients);
    }
}
