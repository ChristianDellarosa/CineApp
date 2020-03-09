package com.web.appcine.persistenceTests.relationshipOperations;

import com.web.appcine.model.Horario;
import com.web.appcine.repository.HorarioRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppRepoHorario {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        HorarioRepository repo = context.getBean("horarioRepository", HorarioRepository.class);

        List<Horario> list = repo.findAll();

        for (Horario h:list) {
            System.out.println(h);
        }
        context.close();
    }
}
