package com.msd.msd.rest.model.response;

import com.msd.msd.rest.model.dto.ClientDTO;
import com.msd.msd.rest.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponse {
    List<ProductDTO>  clients;
}
