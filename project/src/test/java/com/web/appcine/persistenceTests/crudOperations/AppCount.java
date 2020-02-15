package com.web.appcine.persistenceTests.crudOperations;

import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCount {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        long num = repo.count();
        System.out.println("Se encontraron " + num +" registros.");
        context.close();
    }
}
