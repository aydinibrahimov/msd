package com.msd.msd.controller;

import com.msd.msd.entity.Client;
import com.msd.msd.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client insertClient(Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Long id) {
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/{id}")
    public Client findClientById(@PathVariable Long id) {
        return clientService.getClientbyId(id);
    }

    @GetMapping("/list")
    public List<Client> findAllClients() {
        return clientService.getAllClients();
    }


}
