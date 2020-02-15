package com.web.appcine.persistenceTests.jpaOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import java.util.List;

public class AppSorting {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        List<Noticia> noticiaList = repo.findAll(Sort.by("titulo").ascending());

        for (Noticia noticia: noticiaList) {
            System.out.println(noticia);
        }
        context.close();
    }

}
