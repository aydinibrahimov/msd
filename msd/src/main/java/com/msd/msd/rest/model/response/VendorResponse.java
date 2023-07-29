package com.msd.msd.rest.model.response;

import com.msd.msd.rest.model.dto.ProductDTO;
import com.msd.msd.rest.model.dto.VendorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VendorResponse {
    List<VendorDTO>  vendors;
}
