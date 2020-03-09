package com.web.appcine.persistenceTests.queryMethodsOperations;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppKeywordAnd {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        NoticiaRepository repo = context.getBean("noticiaRepository", NoticiaRepository.class);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Noticia> list = null;

        try {
           list =  repo.findByStatusAndFecha("Activa",simpleDateFormat.parse("2017-09-02"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Noticia n : list) {
            System.out.println(n);
        }
        context.close();
    }
}

