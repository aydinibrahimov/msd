package com.msd.msd.rest.model.response;

import com.msd.msd.rest.model.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    List<ContactDTO> contacts;
}
