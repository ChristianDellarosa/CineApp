package com.web.appcine.persistenceTests.crudOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppFindAll {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        Iterable<Noticia> noticiaIterable = repo.findAll();
        for (Noticia n : noticiaIterable) {
            System.out.println(n);
        }
        context.close();
    }
}
