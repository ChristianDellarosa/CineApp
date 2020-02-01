package com.web.appcine.controller;

import com.web.appcine.model.Pelicula;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping("/create")
    public String create() {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String save(Pelicula pelicula, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            System.out.println("Existieron Errores");
            return "peliculas/formPelicula";
        }
        peliculasService.insert(pelicula);
        redirectAttributes.addFlashAttribute("msg","Pelicula guardada correctamente");
        return "redirect:/peliculas/index";
    }

    @GetMapping("index")
    public String viewIndex(Model model) {
        List<Pelicula> peliculas = peliculasService.searchAll();
        model.addAttribute("peliculas",peliculas);
        return "peliculas/listPeliculas";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
