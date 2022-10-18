package com.cinelitas.cinelitas.service;

import com.cinelitas.cinelitas.entity.Sala;
import java.util.List;


public interface ISalaService {
    public List<Sala> getAllSala();
    public Sala getSalaById(long id);
    public void saveSala(Sala sala);
    public void delete (long id);
}
