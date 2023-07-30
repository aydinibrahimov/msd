package com.msd.msd.controller;

import com.msd.msd.entity.Vendor;
import com.msd.msd.rest.model.dto.VendorDTO;
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
    public Vendor insertVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }


    @PutMapping("/{id}")
    public Vendor updateVendor(@RequestBody Vendor vendor, @PathVariable Long id) {
        return vendorService.updateVendorById(vendor, id);
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
    public List<Vendor> findAllVendors() {
        return vendorService.getAllVendors();
    }
}
