package com.web.appcine.services.interfaces;

import com.web.appcine.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IPeliculasService {
    List<Pelicula> searchAll();
    Pelicula searchById(int idPelicula);
    void insert(Pelicula pelicula);
    List<String> searchGenders();
    List<String> searchCategories();
    void delete(int idPelicula);
    Page<Pelicula> searchAll(Pageable page);
    List<Pelicula> searchByDate(Date date);
}
