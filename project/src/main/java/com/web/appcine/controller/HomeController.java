package com.web.appcine.controller;

import com.web.appcine.helpers.Utils;
import com.web.appcine.services.interfaces.IBannerService;
import com.web.appcine.services.interfaces.IPeliculasService;
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
    @Autowired
    private IBannerService bannerService;

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("fechas", Utils.getNextDays(6));
        model.addAttribute("peliculas", peliculasService.searchAll());
        model.addAttribute("fechaBusqueda",simpleDateFormat.format(new Date()));
        model.addAttribute("banners",bannerService.searchAll());

        return "index";
    }

    @GetMapping(value = "/detail/{id}")
    public String detallePelicula(@PathVariable("id") int idPelicula, @RequestParam(value = "fecha") String fecha, Model model) {
        System.out.println("IdPelicula: "+ idPelicula);
        System.out.println("Fecha: "+ fecha);

        model.addAttribute("pelicula",peliculasService.searchById(idPelicula));
        return "detail";
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

