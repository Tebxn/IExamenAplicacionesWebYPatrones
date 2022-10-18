package com.cinelitas.cinelitas.service;

import com.cinelitas.cinelitas.entity.Sala;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cinelitas.cinelitas.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SalaService implements ISalaService{

    @Autowired
    private SalaRepository salaRepository;
    
    @Override
    public List<Sala> getAllSala() {
        return (List<Sala>) salaRepository.findAll();
    }

    @Override
    public Sala getSalaById(long id) {
        return salaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSala(Sala sala) {
        salaRepository.save(sala);
    }

    @Override
    public void delete(long id) {
        salaRepository.deleteById(id);
    }
    
}
