package com.msd.msd.service;

import com.msd.msd.entity.Client;
import com.msd.msd.logging.MSD_Logging;
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
    private final MSD_Logging msd_logging;

    public Client addClient(Client client) {
        log.info("Client is working in. . . ");
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

    public Client getClientById(Long id) {
        Optional<Client> client= clientRepository.findById(id);
        msd_logging.saveLog(new Client());
        if (client.isPresent()){
            log.info("Client with id-"+id+" was fetched");
            return client.get();
        }else{
            log.warn("Client with id-"+id+" was not found");
        }
       return client.orElseThrow();
    }

    public List<Client> getAllClients() {
        log.info("Clients' list is taking");
        return clientRepository.findAll();
    }


}
