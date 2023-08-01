package com.msd.msd.service;

import com.msd.msd.entity.Client;
import com.msd.msd.enums.CustomErrorCode;
import com.msd.msd.exception.CustomException;
import com.msd.msd.repository.ClientRepository;
import com.msd.msd.rest.model.dto.ClientDTO;
import com.msd.msd.rest.model.response.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;


    public Client addClient(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        log.info("Client is been saving . . . ");
        return clientRepository.save(client);

    }

    public ClientDTO updateClientById(ClientDTO clientDTO, Long id) {
        Client client = getClient(id);
        client.setName(clientDTO.getName());
        clientRepository.save(client);
        return convertToDTO(client);
    }


    public void deleteClient(Long id) {
        clientRepository.delete(getClient(id));

    }

    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.CLIENT_NOT_FOUND));
        return convertToDTO(client);

    }

    public ClientResponse getAllClients() {
        log.info("Clients' list is taking");
        List<ClientDTO> clientDTOList = clientRepository.findAll()
                .stream()
                .map(clients -> convertToDTO(clients))
                .collect(Collectors.toList());
        return makeClientResponse(clientDTOList);
    }

    private Client getClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.CLIENT_NOT_FOUND));
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    private ClientResponse makeClientResponse(List<ClientDTO> clientDTOList) {
        return ClientResponse.builder()
                .clients(clientDTOList)
                .build();
    }

}
