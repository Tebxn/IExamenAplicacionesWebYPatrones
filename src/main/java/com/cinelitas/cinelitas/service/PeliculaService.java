package com.cinelitas.cinelitas.service;

import com.cinelitas.cinelitas.entity.Pelicula;
import com.cinelitas.cinelitas.repository.PeliculaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeliculaService implements IPeliculaService {
    
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Override
    public List<Pelicula> listaPelicula() {
        return (List<Pelicula>)peliculaRepository.findAll();
    }
    
}
