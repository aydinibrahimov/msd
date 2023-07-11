package com.msd.msd.service;


import com.msd.msd.entity.Vender;
import com.msd.msd.repository.VenderReposotory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VenderService {

    private final VenderReposotory venderReposotory;
    
    public List<Vender> getAllVenders() {
        return venderReposotory.findAll();
    }

    public Vender getVenderById(Long id) {
        return venderReposotory.findById(id)
                .orElseThrow(() -> new RuntimeException("Vender with ID= " + id + " does not exist"));
    }

    public boolean deleteVenderById(Long id) {

        Optional<Vender> vender = venderReposotory.findById(id);
        if (vender.isPresent()) {
            venderReposotory.deleteById(id);
        } else {
            vender.orElseThrow(() -> new RuntimeException("Vender with ID= " + id + " does not exist"));
        }
        return true;
    }

    public Vender addVender(Vender vender) {
        venderReposotory.save(vender);
        return vender;
    }

    public boolean updateVender(Vender vender, Long id) {
        Optional<Vender> p = venderReposotory.findById(id);
        if (p.isPresent()) {
            venderReposotory.save(vender);
        } else {
            p.orElseThrow(() -> new RuntimeException("Vender with ID= " + id + " does not exist"));
        }
        return true;
    }


}
