package com.web.appcine.persistenceTests.jpaOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class AppPaging {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        Page<Noticia> page = repo.findAll(PageRequest.of(0,5, Sort.by("titulo")));

        for(Noticia n : page) {
            System.out.println(n);
        }

        context.close();
    }
}
