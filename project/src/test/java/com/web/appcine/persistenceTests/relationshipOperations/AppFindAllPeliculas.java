package com.web.appcine.persistenceTests.relationshipOperations;

import com.web.appcine.model.Pelicula;
import com.web.appcine.repository.PeliculaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppFindAllPeliculas {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        PeliculaRepository repo = context.getBean("peliculaRepository", PeliculaRepository.class);

       List<Pelicula> list = repo.findAll();

        for (Pelicula p:list) {
            System.out.println(p);
        }
        context.close();
    }

}
