package com.msd.msd.repository;

import com.msd.msd.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
