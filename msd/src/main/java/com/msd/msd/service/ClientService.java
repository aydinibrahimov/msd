package com.msd.msd.service;

import com.msd.msd.entity.Client;
import com.msd.msd.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClientById(Client client, Long id) {
        Optional<Client> c = clientRepository.findById(id);
        if (c.isPresent()) {
            return clientRepository.save(client);
        } else {
            log.info("Client with id={}" + id + " was not found");
            return c.orElseThrow(() -> new RuntimeException("Client with id=" + id + " was not found"));
        }
    }

    public void deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            log.warn("Client with id{} "+id+" was not found");
            //client.orElseThrow(() -> new RuntimeException("Client with id=" + id + " was not found"));
        }

    }

    public Client getClientbyId(Long id) {
        Optional<Client> client= clientRepository.findById(id);
        if (client.isPresent()){
            log.warn("Client with id{} "+id+" was found");
            return client.get();
        }else{
            log.warn("Client with id{} "+id+" was not found");
        }
       return client.orElseThrow();
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


}
