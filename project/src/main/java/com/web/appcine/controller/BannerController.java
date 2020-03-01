package com.web.appcine.controller;

import com.web.appcine.helpers.Utils;
import com.web.appcine.model.Banner;
import com.web.appcine.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
@RequestMapping("/banners")
public class BannerController {

    @Autowired
    private IBannerService bannerService;

        /**
         * Metodo para mostrar el listado de banners
         * @param model
         * @return
         */
        @GetMapping("/index")
        public String viewIndex(Model model) {
            List<Banner> bannerList = bannerService.searchAll();
            model.addAttribute("banners",bannerList);
            return "banners/listBanners";
        }

        /**
         * Metodo para mostrar el formulario para crear un nuevo Banner
         * @return
         */
        @GetMapping("/create")
        public String create() {
            return "banners/formBanner";
        }

        /**
         * Metodo para guardar el objeto de modelo de tipo Banner
         * @return
         */
        @PostMapping("/save")
        public String save(@ModelAttribute("banner") Banner banner, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("imageFile") MultipartFile multipartFile, HttpServletRequest request) {
            if(result.hasErrors()) {
                System.out.println("Existieron Errores");
                return "banners/formBanner";
            }
            if(!multipartFile.isEmpty()) {
            String imageName = Utils.saveImage(multipartFile,request);
            banner.setArchivo(imageName);
            }
            bannerService.insert(banner);
            redirectAttributes.addFlashAttribute("msg","Banner guardado correctamente");
            return "redirect:/banners/index";
        }

        @GetMapping(value = "/edit/{id}")
        public String update(@PathVariable("id") int idBanner, Model model) {
            Banner banner = bannerService.searchById(idBanner);
            model.addAttribute("banner", banner);
            return "banners/formBanner";
        }

        @GetMapping(value = "/delete/{id}")
        public String delete(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
            bannerService.delete(idBanner);
            attributes.addFlashAttribute("msgDelete", "Banner eliminado correctamente.");
            return "redirect:/banners/index";
        }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    }

