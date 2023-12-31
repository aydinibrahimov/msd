package com.msd.msd.rest.model.response;

import com.msd.msd.rest.model.dto.ClientDTO;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ClientResponse {
    List<ClientDTO>  clients;
}
