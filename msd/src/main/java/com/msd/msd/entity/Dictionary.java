package com.msd.msd.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "dictionary")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

@ManyToOne
@JoinColumn(name = "dict_type_id")
private DictionaryType dictionaryType;
}
