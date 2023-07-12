package com.msd.msd.service;

import com.msd.msd.entity.Client;
import com.msd.msd.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client, Long id) {
        Optional<Client> c = clientRepository.findById(id);
        if (c.isPresent()) {
            return clientRepository.save(client);
        } else {
            return c.orElseThrow(() -> new RuntimeException("Client with id=" + id + " was not found"));
        }
    }

    public void deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            client.orElseThrow(() -> new RuntimeException("Client with id=" + id + " was not found"));
        }

    }

    public Client getClientbyId(Long id) {
        return clientRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Client with id=" + id + " was not found"));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


}
