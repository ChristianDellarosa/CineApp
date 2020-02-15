package com.web.appcine.persistenceTests.relationshipOperations;

import com.web.appcine.model.Pelicula;
import com.web.appcine.repository.PeliculaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class AppGetHorariosPelicula {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        PeliculaRepository repo = context.getBean("peliculaRepository", PeliculaRepository.class);

       Optional<Pelicula> pelicula = repo.findById(7);

       System.out.println(pelicula.get().getHorarios().size());
        context.close();
    }
}
