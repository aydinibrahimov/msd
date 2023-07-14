package com.msd.msd.repository;

import com.msd.msd.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {
}
