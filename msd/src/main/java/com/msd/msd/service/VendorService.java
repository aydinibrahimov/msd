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
import java.util.Optional;

@Service
@AllArgsConstructor
public class VendorService {

    private final VendorReposotory vendorReposotory;

    public List<Vendor> getAllVendors() {
        return vendorReposotory.findAll();
    }

    public Vendor getVendorById(Long id) {
        return vendorReposotory.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor with ID= " + id + " does not exist"));
    }

    public boolean deleteVendorById(Long id) {
        Optional<Vendor> vendor = vendorReposotory.findById(id);
        if (vendor.isPresent()) {
            vendorReposotory.deleteById(id);
        } else {
            vendor.orElseThrow(() -> new RuntimeException("Vendor with ID= " + id + " does not exist"));
        }
        return true;
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorReposotory.save(vendor);
    }

    public Vendor updateVendorById(Vendor vendor, Long id) {
        Optional<Vendor> v = vendorReposotory.findById(id);
        if (v.isPresent()) {
            return vendorReposotory.save(vendor);
        } else {
            return v.orElseThrow(() -> new RuntimeException("Vendor with ID= " + id + " does not exist"));
        }

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
