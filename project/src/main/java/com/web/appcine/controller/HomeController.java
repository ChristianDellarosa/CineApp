package com.web.appcine.controller;

import com.web.appcine.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goHome(){
        return "index";
    }

    @RequestMapping(value="/detail", method = RequestMethod.GET)
    public String mostrarDetalle(Model model){
        String titulo = "Rapido y furioso 6";
        int duracion = 154;
        double precioEntrada = 50;
        model.addAttribute("titulo", titulo);
        model.addAttribute("duracion",duracion);
        model.addAttribute("precio",precioEntrada);
        return "detail";
    }

    @RequestMapping(value="/movies", method = RequestMethod.GET)
    public String mostrarPeliculas(Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        List<Pelicula> peliculas = new LinkedList<>();
        try {
            peliculas.add(new Pelicula(1,"Power Rangers",120,"B","Aventura",formatter.parse("02-05-2017"),"PowerRangers.jpg",true));
            peliculas.add(new Pelicula(2,"Cars 2",150,"A","Suspenso",formatter.parse("20-05-2017"),"Cars2.jpg",true));
            peliculas.add(new Pelicula(3,"Contratiempo",80,"C","Accion",formatter.parse("28-05-2017"),"Contratiempo.jpg",false));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("peliculas",peliculas);
        return "movies";
    }
}

