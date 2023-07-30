package com.msd.msd.controller;

import com.msd.msd.entity.Vendor;
import com.msd.msd.rest.model.dto.VendorDTO;
import com.msd.msd.rest.model.response.VendorResponse;
import com.msd.msd.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msd/v1/vendors")
@AllArgsConstructor
public class VendorController {
    private final VendorService vendorService;


    @PostMapping
    public VendorDTO insertVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.addVendor(vendorDTO);
    }


    @PutMapping("/{id}")
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.updateVendorById(vendorDTO, id);
    }


    @DeleteMapping("/{id}")
    public void removeVendor(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }


    @GetMapping("/{id}")
    public VendorDTO findVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }


    @GetMapping
    public VendorResponse findAllVendors() {
        return vendorService.getAllVendors();
    }
}
