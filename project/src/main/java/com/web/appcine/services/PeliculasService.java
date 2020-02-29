package com.web.appcine.services;

import com.web.appcine.model.Horario;
import com.web.appcine.model.Pelicula;
import com.web.appcine.repository.HorarioRepository;
import com.web.appcine.repository.PeliculaRepository;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeliculasService implements IPeliculasService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private HorarioRepository horariosRepository;


    @Override
    public List<Pelicula> searchAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula searchById(int idPelicula) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(idPelicula);
        if(pelicula.isPresent()){
            return pelicula.get();
        }
    return null;
    }

    @Override
    public void insert(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public List<String> searchGenders() {
        // Nota: Esta lista podria ser obtenida de una BD
        List<String> generos = new ArrayList<>();
        generos.add("Accion");
        generos.add("Aventura");
        generos.add("Accion y Aventura");
        generos.add("Romantica");
        generos.add("Infantil");
        generos.add("Terror");
        generos.add("Drama");
        generos.add("Comedia Romantica");
        generos.add("Prueba");
        return generos;
    }

    @Override
    public List<String> searchCategories() {
        // Nota: Esta lista podria ser obtenida de una BD
        List<String> categorias = new ArrayList<>();
        categorias.add("A");
        categorias.add("B");
        categorias.add("C");
        categorias.add("D");
        return categorias;
    }

    @Override
    public void delete(int idPelicula) {
        peliculaRepository.deleteById(idPelicula);
    }

    @Override
    public Page<Pelicula> searchAll(Pageable page) {
        return peliculaRepository.findAll(page);
    }

    @Override
    public List<Pelicula> searchByDate(Date date) {
        List<Pelicula> peliculas = new LinkedList<>();
        List<Horario> horarios = horariosRepository.findByFecha(date);
        for (Horario h : horarios) {
            peliculas.add(h.getPelicula());
        }
        return peliculas;
    }

}
