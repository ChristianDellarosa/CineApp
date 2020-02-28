package com.web.appcine.persistenceTests.crudOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

public class AppFindAllById {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        List<Integer> ids = new LinkedList<>();
        ids.add(2);
        ids.add(5);
        ids.add(8);

        Iterable<Noticia> noticiaList = repo.findAllById(ids);
        for (Noticia n : noticiaList) {
            System.out.println(n);
        }
    }
}
