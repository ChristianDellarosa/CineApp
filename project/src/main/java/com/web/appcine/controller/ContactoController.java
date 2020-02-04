package com.web.appcine.controller;

import com.web.appcine.model.Contacto;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/contacto")
    public String create(@ModelAttribute("contacto") Contacto contacto, Model model) {
        model.addAttribute("generos",peliculasService.searchGenders());
        model.addAttribute("notificationTypes", getNotificationsTypes());
        return "formContacto";
    }

    @PostMapping("/contacto")
    public String save(@ModelAttribute("contacto") Contacto contacto) {
        System.out.println(contacto);
        return "redirect:/contacto";
    }

    //TODO: Convertir en metodo en el Servicio de contacto(Crear)
    private List<String> getNotificationsTypes(){
        List<String> types = new LinkedList<>();
        types.add("Estrenos");
        types.add("Promociones");
        types.add("Noticias");
        types.add("Preventas");
        return types;
    }
}
