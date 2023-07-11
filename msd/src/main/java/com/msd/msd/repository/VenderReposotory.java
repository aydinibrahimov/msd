package com.msd.msd.repository;

import com.msd.msd.entity.Vender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenderReposotory extends JpaRepository<Vender,Long> {
}
