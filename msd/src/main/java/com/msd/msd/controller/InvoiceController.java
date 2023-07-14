package com.msd.msd.controller;

import com.msd.msd.entity.Invoice;
import com.msd.msd.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msd/v1/invoices")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;


    @PostMapping
    public Invoice insertInvoice(@RequestBody Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }


    @PutMapping("/{id}")
    public Invoice updateInvoice(@RequestBody Invoice invoice, @PathVariable Long id) {
        return invoiceService.updateInvoiceById(invoice, id);
    }


    @DeleteMapping("/{id}")
    public void removeInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoiceById(id);
    }


    @GetMapping("/{id}")
    public Invoice findInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }


    @GetMapping
    public List<Invoice> findAllInvoices() {
        return invoiceService.getAllInvoices();
    }

}
