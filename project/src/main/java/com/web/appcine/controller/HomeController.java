package com.web.appcine.controller;

import com.web.appcine.helpers.Utils;
import com.web.appcine.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("fechas", Utils.getNextDays(6));
        model.addAttribute("peliculas",getPeliculas());
        model.addAttribute("fechaBusqueda",simpleDateFormat.format(new Date()));
        return "index";
    }

    @GetMapping(value = "/detail/{id}")
    public String detallePelicula(@PathVariable("id") int idPelicula, @RequestParam(value = "fecha") String fecha, Model model) {
        System.out.println("IdPelicula: "+ idPelicula);
        System.out.println("Fecha: "+ fecha);

        model.addAttribute("peliculas",getPeliculas());
        return "detail";
    }

    @GetMapping(value="/movies")
    public String mostrarPeliculas(Model model) {
        model.addAttribute("peliculas",getPeliculas());
        return "movies";
    }

    private List<Pelicula> getPeliculas() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        List<Pelicula> peliculas = new LinkedList<>();
        try {
            peliculas.add(new Pelicula(0,"Power Rangers",120,"B","Aventura",formatter.parse("02-05-2017"),"PowerRangers.jpg",true));
            peliculas.add(new Pelicula(1,"Cars 2",150,"A","Suspenso",formatter.parse("20-05-2017"),"Cars2.jpg",true));
            peliculas.add(new Pelicula(2,"Contratiempo",80,"C","Accion",formatter.parse("28-05-2017"),"Contratiempo.jpg",false));
            peliculas.add(new Pelicula(3,"TheWitcher",80,"A","Aventura",formatter.parse("28-05-2019"),"theWitcher.jpg",true));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    @PostMapping(value = "/search")
    public String buscarFecha(@RequestParam("fecha") String fecha, Model model) {
        System.out.println("Fecha: "+fecha);
        model.addAttribute("fechas", Utils.getNextDays(6));
        model.addAttribute("peliculas",getPeliculas());
        model.addAttribute("fechaBusqueda",fecha);
        return "index";
    }
}

