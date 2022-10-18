/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelitas.cinelitas.controller;

import com.cinelitas.cinelitas.entity.Pelicula;
import com.cinelitas.cinelitas.entity.Sala;
import com.cinelitas.cinelitas.service.IPeliculaService;
import com.cinelitas.cinelitas.service.ISalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ESTEBAN
 */
@Controller
public class SalaController {
    
    @Autowired
    private ISalaService salaService;
    
    @Autowired
    private IPeliculaService peliculaService;
    
    @GetMapping("/salas")
    public String index(Model model){
        List<Sala> listaSala = salaService.getAllSala();
        model.addAttribute("titulo", "Tabla Sala");
        model.addAttribute("salas", listaSala);
        return "salas";
                
    }
    @GetMapping("/salaNew")
    public String crearSala(Model model){
        List<Pelicula> listaPelicula = peliculaService.listaPelicula();
        model.addAttribute("sala", new Sala());
        model.addAttribute("pelicula", listaPelicula);
        return "crear";
    }
    @PostMapping("/save")
    public String guardarSala(@ModelAttribute Sala sala){
        salaService.saveSala(sala);
        return "redirect:/salas";
    }
    
   @GetMapping("/editSala/{id}")
   public String editarSala(@PathVariable("id") Long idSala, Model model){
       Sala sala = salaService.getSalaById(idSala);
       List<Pelicula> listaPelicula = peliculaService.listaPelicula();
       model.addAttribute("sala", sala);
       model.addAttribute("pelicula", listaPelicula);
       return "crear";
   }
   @GetMapping("/delete/{id}")
   public String eliminarSala(@PathVariable("id") Long idSala){
       salaService.delete(idSala);
       return "redirect:/salas";
   }
   
}
