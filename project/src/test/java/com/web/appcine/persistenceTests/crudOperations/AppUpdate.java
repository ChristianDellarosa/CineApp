package com.web.appcine.persistenceTests.crudOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class AppUpdate {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        Optional<Noticia> optional = repo.findById(1);

        if(optional.isPresent()) {
            Noticia noticia = optional.get();
            noticia.setStatus("Inactiva");
            repo.save(noticia);
        }
        context.close();
    }
}