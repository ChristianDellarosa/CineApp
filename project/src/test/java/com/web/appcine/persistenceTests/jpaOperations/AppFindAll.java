package com.web.appcine.persistenceTests.jpaOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppFindAll {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

       List<Noticia> noticiaList = repo.findAll();
        for (Noticia n : noticiaList) {
            System.out.println(n);
        }
        context.close();
    }
}
