package com.web.appcine.controller;

import com.web.appcine.helpers.Utils;
import com.web.appcine.model.Horario;
import com.web.appcine.model.Noticia;
import com.web.appcine.model.Pelicula;
import com.web.appcine.services.interfaces.IBannerService;
import com.web.appcine.services.interfaces.IHorariosService;
import com.web.appcine.services.interfaces.INoticiasService;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    @Autowired
    private IPeliculasService peliculasService;
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IHorariosService horariosService;
    @Autowired
    private INoticiasService noticiasService;

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("fechas", Utils.getNextDays(6));
        model.addAttribute("peliculas", peliculasService.searchAll());
        model.addAttribute("fechaBusqueda",simpleDateFormat.format(new Date()));
        model.addAttribute("banners",bannerService.searchAll());
        return "index";
    }

    @PostMapping(value = "/search")
    public String searchDate(@RequestParam("fecha") Date fecha, Model model) {
        try {
            Date fechaSinHora = simpleDateFormat.parse(simpleDateFormat.format(fecha));
            List<String> listaFechas = Utils.getNextDays(4);
            List<Pelicula> peliculas  = peliculasService.searchByDate(fechaSinHora);
            model.addAttribute("fechas", listaFechas);
            model.addAttribute("fechaBusqueda",simpleDateFormat.format(fecha));
            model.addAttribute("peliculas", peliculas);
            return "index";
        } catch (ParseException e) {
            System.out.println("Error: HomeController.buscar" + e.getMessage());
        }
        return "index";
    }

    @GetMapping(value = "/detail/{id}")
    public String viewDetail(@PathVariable("id") int idPelicula, @RequestParam("fecha") Date fecha, Model model) {
        List<Horario> horarioList  = horariosService.searchByIdPelicula(idPelicula,fecha);
        model.addAttribute("horarios",horarioList);
        model.addAttribute("fechaBusqueda",simpleDateFormat.format(fecha));
        model.addAttribute("pelicula",peliculasService.searchById(idPelicula));
        return "detail";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "acerca";
    }

    @GetMapping(value = "/formLogin" )
    public String viewLogin() {
        return "formLogin";
    }

    @ModelAttribute("noticias")
    public List<Noticia> getNoticias(){
        return noticiasService.searchLast();
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }
}

