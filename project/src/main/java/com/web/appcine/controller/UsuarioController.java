package com.web.appcine.controller;

import com.web.appcine.model.Perfil;
import com.web.appcine.model.Usuario;
import com.web.appcine.services.interfaces.IPerfilesService;
import com.web.appcine.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPerfilesService perfilesService;


    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("usuarios",usuarioService.searchAll());
        return "usuario/listUsuarios";
    }

    @GetMapping(value = "/create")
    public String create(@ModelAttribute("usuario") Usuario usuario) {
        return "usuario/formUsuario";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("usuario") Usuario usuario,  @RequestParam("perfil") String perfil, RedirectAttributes redirectAttributes) {
        usuario.setPassword(encoder.encode(usuario.getPassword())); /*Encripto pw*/
        usuarioService.save(usuario);

        Perfil p = new Perfil();
        p.setUsername(usuario.getUsername());
        p.setPerfil(perfil);
        perfilesService.save(p);
        redirectAttributes.addFlashAttribute("msg","Usuario guardado correctamente");
        return "redirect:/usuarios/index";
    }

    //TODO: No edita, solo agrega registro
    @GetMapping(value = "edit/{id}")
    public String update(@PathVariable("id") int idUsuario, Model model) {
        Usuario usuario = usuarioService.searchById(idUsuario);
        model.addAttribute("usuario",usuario);
        return "usuario/formUsuario";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") int idUsuario, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.searchById(idUsuario);
        usuarioService.delete(idUsuario);
        perfilesService.delete(usuario.getUsername());
        redirectAttributes.addFlashAttribute("msgDelete","Usuario eliminado correctamente");
        return "redirect:/usuarios/index";
    }

    @GetMapping("/demo-bcrypt")
    public String pruebaBCrypt() {
        String password="mari123";
        String encriptado=encoder.encode(password);
        System.out.println("Password encriptado: " + encriptado);
        return "usuario/formUsuario";
    }
}
