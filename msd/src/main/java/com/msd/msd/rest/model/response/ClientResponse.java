package com.msd.msd.rest.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    List<ClientResponse>  clients;
}
