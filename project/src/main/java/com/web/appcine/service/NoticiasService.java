package com.web.appcine.service;

import com.web.appcine.model.Noticia;
import org.springframework.stereotype.Service;

@Service
public class NoticiasService implements INoticiasService {

    public NoticiasService() {
        System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
    }

    @Override
    public void save(Noticia noticia) {
        System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
        /*Logica para guardar noticia*/
    }
}
