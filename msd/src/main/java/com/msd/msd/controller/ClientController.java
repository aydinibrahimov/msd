package com.msd.msd.controller;

import com.msd.msd.entity.Client;
import com.msd.msd.rest.model.dto.ClientDTO;
import com.msd.msd.rest.model.response.ClientResponse;
import com.msd.msd.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/msd/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public Client insertClient(@RequestBody ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        return clientService.updateClientById(clientDTO, id);
    }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/{id}")
    public ClientDTO findClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping
    public ClientResponse findAllClients() {
        return clientService.getAllClients();
    }


}
