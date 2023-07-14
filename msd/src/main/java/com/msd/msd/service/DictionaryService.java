package com.msd.msd.service;

import com.msd.msd.repository.DictionaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;
}
