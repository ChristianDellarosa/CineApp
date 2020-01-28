package com.web.appcine.service;

import com.web.appcine.model.Pelicula;
import java.util.List;

public interface IPeliculasService {

    List<Pelicula> searchAll();
    Pelicula searchById(int idPelicula);
    void insert(Pelicula pelicula);
}
