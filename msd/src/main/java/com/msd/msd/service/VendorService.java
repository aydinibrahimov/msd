package com.msd.msd.service;


import com.msd.msd.entity.Vendor;
import com.msd.msd.enums.CustomErrorCode;
import com.msd.msd.exception.CustomException;
import com.msd.msd.repository.VendorReposotory;
import com.msd.msd.rest.model.dto.VendorDTO;
import com.msd.msd.rest.model.response.VendorResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendorService {

    private final VendorReposotory vendorReposotory;

    public VendorResponse getAllVendors() {
        List<VendorDTO> vendorDTOList = vendorReposotory.findAll()
                .stream()
                .map(vendors -> convertToVendorDTO(vendors))
                .collect(Collectors.toList());
        return makeVendorResponse(vendorDTOList);
    }

    public VendorDTO getVendorById(Long id) {
        return convertToVendorDTO(getVendor(id));
    }

    public void deleteVendorById(Long id) {
        vendorReposotory.delete(getVendor(id));

    }

    public VendorDTO addVendor(VendorDTO vendorDTO) {
        Vendor vendor = new Vendor();
        vendor.setName(vendorDTO.getName());
        vendorReposotory.save(vendor);
        return vendorDTO;
    }

    public VendorDTO updateVendorById(VendorDTO vendorDTO, Long id) {
        Vendor vendor = getVendor(id);
        vendor.setName(vendorDTO.getName());
        vendorReposotory.save(vendor);
        return vendorDTO;
    }

    private Vendor getVendor(Long id) {
        return vendorReposotory.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.VENDOR_NOT_FOUND));
    }

    private VendorDTO convertToVendorDTO(Vendor vendor) {
        VendorDTO vendorDTO = new VendorDTO();
        BeanUtils.copyProperties(vendor, vendorDTO);
        return vendorDTO;
    }

    private VendorResponse makeVendorResponse(List<VendorDTO> vendorDTOList) {
        return VendorResponse.builder()
                .vendors(vendorDTOList)
                .build();

    }


}
