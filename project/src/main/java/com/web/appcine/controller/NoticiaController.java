package com.web.appcine.controller;

import com.web.appcine.model.Noticia;
import com.web.appcine.model.Pelicula;
import com.web.appcine.services.interfaces.INoticiasService;
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
import java.util.List;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private INoticiasService noticiasService;

    @GetMapping(value = "/index")
    public String viewIndex(Model model) {
        List<Noticia> noticiaList = noticiasService.searchAll();
        model.addAttribute("noticias", noticiaList);
        return "noticias/listNoticias";
    }

    @GetMapping("/create")
    public String create() {
        return "noticias/formNoticia";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("noticia") Noticia noticia, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            System.out.println("Existieron Errores");
            return "noticias/formNoticia";
        }
        noticiasService.save(noticia);
        attributes.addFlashAttribute("msg", "Noticia guardada correctamente");
        return "redirect:/noticias/index";
    }

    @GetMapping(value = "edit/{id}")
    public String update(@PathVariable("id") int idNoticia, Model model) {
        Noticia noticia = noticiasService.searchById(idNoticia);
        model.addAttribute("noticia",noticia);
        return "noticias/formNoticia";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") int idNoticia, RedirectAttributes redirectAttributes) {
        noticiasService.delete(idNoticia);
        redirectAttributes.addFlashAttribute("msgDelete","Noticia eliminada correctamente");
        return "redirect:/noticias/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
