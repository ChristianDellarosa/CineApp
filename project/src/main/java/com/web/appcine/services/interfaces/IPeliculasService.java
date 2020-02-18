package com.web.appcine.services.interfaces;

import com.web.appcine.model.Pelicula;
import java.util.List;

public interface IPeliculasService {

    List<Pelicula> searchAll();
    Pelicula searchById(int idPelicula);
    void insert(Pelicula pelicula);
    List<String> searchGenders();
    List<String> searchCategories();
    void delete(int idPelicula);
}
