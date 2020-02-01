package com.web.appcine.controller;

import com.web.appcine.model.Noticia;
import com.web.appcine.services.interfaces.INoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private INoticiasService noticiasService;

    @GetMapping("/create")
    public String crearNoticia() {
        return "noticias/formNoticia";
    }

    @PostMapping("/save")
    public String guardarNoticia(Noticia noticia) {
            noticiasService.save(noticia);
        return"noticias/formNoticia";
    }
}
