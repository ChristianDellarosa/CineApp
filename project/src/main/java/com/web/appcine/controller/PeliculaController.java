package com.web.appcine.controller;

import com.web.appcine.model.Pelicula;
import com.web.appcine.service.INoticiasService;
import com.web.appcine.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

   // @Autowired
    //private IPeliculasService peliculasService;

    @GetMapping("/create")
    public String create() {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String save(Pelicula pelicula) {
        System.out.println("La pelicula guardada es: " + pelicula);
        return "peliculas/formPelicula";
    }
}
