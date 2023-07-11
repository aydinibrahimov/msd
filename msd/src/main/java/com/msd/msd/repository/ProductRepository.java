package com.msd.msd.repository;

import com.msd.msd.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {



  }
