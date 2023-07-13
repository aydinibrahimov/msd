package com.msd.msd.controller;

import com.msd.msd.entity.Invoice;
import com.msd.msd.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;


    @PostMapping
    public Invoice insertInvoice(Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }


    @PutMapping
    public Invoice updateInvoice(Invoice invoice, Long id) {
        return invoiceService.updateInvoiceById(invoice, id);
    }


    @DeleteMapping
    public void removeInvoice(Long id) {
        invoiceService.deleteInvoiceById(id);
    }


    @GetMapping("/{id}")
    public Invoice findInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }


    @GetMapping("/list")
    public List<Invoice> findAllInvoices() {
        return invoiceService.getAllInvoices();
    }

}
