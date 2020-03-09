package com.web.appcine.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping(value="/index")
    public String viewAdminIndex(Authentication authentication) {
        System.out.println("Username: " + authentication.getName()); /*Devuelve el username del usuario autenticado*/

        for (GrantedAuthority rol: authentication.getAuthorities()) {
            System.out.println("Rol: " + rol.getAuthority()); /*Devuelve los roles del usuario autenticado*/
        }
        return "admin";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/formLogin";
    }
}