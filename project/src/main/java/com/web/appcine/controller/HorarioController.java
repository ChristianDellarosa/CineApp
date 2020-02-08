package com.web.appcine.controller;

import com.web.appcine.model.Horario;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping("/create")
    public String create(@ModelAttribute("horario") Horario horario, Model model) {
        model.addAttribute("peliculas",peliculasService.searchAll());
        return "horarios/formHorario";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("horario") Horario horario, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("peliculas",peliculasService.searchAll());
            System.out.println("Existieron Errores");
            return "horarios/formHorario";
        }
        System.out.println("Guardando el objeto Horario: " + horario);
        redirectAttributes.addFlashAttribute("msg","Horario creado correctamente");
        return "redirect:/horarios/create";
    }

    @InitBinder("horario")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
