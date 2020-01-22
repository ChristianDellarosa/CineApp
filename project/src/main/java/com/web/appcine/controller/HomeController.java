package com.web.appcine.controller;

import com.web.appcine.helpers.Utils;
import com.web.appcine.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("fechas", Utils.getNextDays(6));
        model.addAttribute("peliculas", peliculasService.searchAll());
        model.addAttribute("fechaBusqueda",simpleDateFormat.format(new Date()));
        return "index";
    }

    @GetMapping(value = "/detail/{id}")
    public String detallePelicula(@PathVariable("id") int idPelicula, @RequestParam(value = "fecha") String fecha, Model model) {
        System.out.println("IdPelicula: "+ idPelicula);
        System.out.println("Fecha: "+ fecha);

        model.addAttribute("pelicula",peliculasService.searchById(idPelicula));
        return "detail";
    }

    @GetMapping(value="/movies")
    public String mostrarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculasService.searchAll());
        return "movies";
    }

    @PostMapping(value = "/search")
    public String buscarFecha(@RequestParam("fecha") String fecha, Model model) {
        System.out.println("Fecha: "+fecha);
        model.addAttribute("fechas", Utils.getNextDays(6));
        model.addAttribute("peliculas", peliculasService.searchAll());
        model.addAttribute("fechaBusqueda",fecha);
        return "index";
    }
}

