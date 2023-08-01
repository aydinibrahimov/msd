package com.msd.msd.service;

import com.msd.msd.repository.ClientRepository;
import com.msd.msd.rest.model.dto.ClientDTO;
import com.msd.msd.rest.model.response.ClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {
    private ClientService clientService;
    private ClientRepository clientRepository;
    private ClientResponse clientResponse;
    private ClientDTO clientDTO;

    @BeforeEach
    void setUp() {
        clientService= Mockito.mock(ClientService.class);
        clientResponse= Mockito.mock(ClientResponse.class);
        clientDTO= Mockito.mock(ClientDTO.class);
        clientRepository=Mockito.mock(ClientRepository.class);
    }
}