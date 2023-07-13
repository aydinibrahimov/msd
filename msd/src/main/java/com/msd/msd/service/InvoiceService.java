package com.msd.msd.service;

import com.msd.msd.entity.Invoice;
import com.msd.msd.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;


    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoiceById(Invoice invoice, Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) {
            return invoiceRepository.save(invoice);
        } else {
            return optionalInvoice
                    .orElseThrow(() -> new RuntimeException("It failed to find the invoice with the ID of " + id));
        }
    }

    public void deleteInvoiceById(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) {
            invoiceRepository.deleteById(id);
        } else {
            optionalInvoice
                    .orElseThrow(() -> new RuntimeException("It failed to find the invoice with the ID of " + id));
        }
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It failed to find the invoice with the ID of " + id));
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

}
