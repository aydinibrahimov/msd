package com.msd.msd.repository;

import com.msd.msd.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorReposotory extends JpaRepository<Vendor,Long> {
}
