package com.web.appcine.controller;

import com.web.appcine.helpers.Utils;
import com.web.appcine.model.Pelicula;
import com.web.appcine.services.interfaces.IDetallePeliculaService;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private IPeliculasService peliculasService;

    @Autowired
    private IDetallePeliculaService detallePeliculaService;

    @GetMapping("/create")
    public String create(@ModelAttribute("pelicula") Pelicula pelicula) {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("pelicula") Pelicula pelicula, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("imageFile") MultipartFile multipartFile, HttpServletRequest request) {
        if(result.hasErrors()) {
            System.out.println("Existieron Errores");
            return "peliculas/formPelicula";
        }
        if(!multipartFile.isEmpty()) {
            String imageName = Utils.saveImage(multipartFile,request);
            pelicula.setImagen(imageName);
        }
        detallePeliculaService.insert(pelicula.getDetalle());
        peliculasService.insert(pelicula);
        redirectAttributes.addFlashAttribute("msg","Pelicula guardada correctamente");
        return "redirect:/peliculas/indexPaginate";
    }

    @GetMapping("index")
    public String viewIndex(Model model) {
        List<Pelicula> peliculas = peliculasService.searchAll();
        model.addAttribute("peliculas",peliculas);
        return "peliculas/listPeliculas";
    }

    @GetMapping(value = "edit/{id}")
    public String update(@PathVariable("id") int idPelicula, Model model) {
        Pelicula pelicula = peliculasService.searchById(idPelicula);
        model.addAttribute("pelicula",pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") int idPelicula, RedirectAttributes redirectAttributes) {
        Pelicula pelicula = peliculasService.searchById(idPelicula);
        peliculasService.delete(idPelicula);
        detallePeliculaService.delete(pelicula.getDetalle().getId());
        redirectAttributes.addFlashAttribute("msgDelete","Pelicula eliminada correctamente");
        return "redirect:/peliculas/indexPaginate";
    }

    @GetMapping(value = "/indexPaginate")
    public String mostrarIndexPaginado(Model model, Pageable page) {
        Page<Pelicula> lista = peliculasService.searchAll(page);
        model.addAttribute("peliculas", lista);
        return "peliculas/listPeliculas";
    }

    @ModelAttribute("generos") // Esta disponible para cualquier controlador dentro de esta clase con el nombre "generos"
    public List<String> getGeneros(){
        return peliculasService.searchGenders();
    }

    @ModelAttribute("categorias")
    public List<String> getCategorias(){
        return peliculasService.searchCategories();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
