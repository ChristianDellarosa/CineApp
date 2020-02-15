package com.web.appcine.persistenceTests.crudOperations;

import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppExistsById {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        int idNoticia = 1;
        System.out.println(repo.existsById(idNoticia));

        context.close();
    }
}
