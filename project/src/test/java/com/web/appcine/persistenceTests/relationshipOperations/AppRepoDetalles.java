package com.web.appcine.persistenceTests.relationshipOperations;

import com.web.appcine.model.DetallePelicula;
import com.web.appcine.repository.DetallePeliculaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppRepoDetalles {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        DetallePeliculaRepository repo = context.getBean("detallePeliculaRepository", DetallePeliculaRepository.class);

       List<DetallePelicula> list = repo.findAll();

        for (DetallePelicula d:list) {
            System.out.println(d);
        }
        context.close();
    }

}
