package com.msd.msd.repository;

import com.msd.msd.entity.Client;
import com.msd.msd.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
