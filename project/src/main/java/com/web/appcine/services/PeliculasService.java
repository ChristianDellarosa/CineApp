package com.web.appcine.services;

import com.web.appcine.model.Pelicula;
import com.web.appcine.services.interfaces.IPeliculasService;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@Service para que no tome 2 instancias
public class PeliculasService implements IPeliculasService {

    private List<Pelicula> peliculas;

   public PeliculasService() {
       System.out.println("Inyecto como dependencia PeliculasService(Spring utiliza Singleton)");
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
       peliculas = new LinkedList<>();
       try {
           peliculas.add(new Pelicula(1,"Power Rangers",120,"B","Aventura",formatter.parse("02-05-2017"),"PowerRangers.jpg","Activa"));
           peliculas.add(new Pelicula(2,"Cars 2",150,"A","Suspenso",formatter.parse("20-05-2017"),"Cars2.jpg","Inactiva"));
           peliculas.add(new Pelicula(3,"Contratiempo",80,"C","Accion",formatter.parse("28-05-2017"),"Contratiempo.jpg","Activa"));
           peliculas.add(new Pelicula(4,"TheWitcher",80,"A","Aventura",formatter.parse("28-05-2019"),"theWitcher.jpg","Activa"));
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }

    @Override
    public List<Pelicula> searchAll() {
        return peliculas;
    }

    @Override
    public Pelicula searchById(int idPelicula) {
        for (Pelicula p : peliculas) {
            if(p.getId() == idPelicula) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void insert(Pelicula pelicula) {
       peliculas.add(pelicula);
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
        categorias.add("Clasificacion A");
        categorias.add("Clasificacion B");
        categorias.add("Clasificacion C");
        categorias.add("Clasificacion D");

        return categorias;
    }

    @Override
    public void delete(int idPelicula) {

    }


}
