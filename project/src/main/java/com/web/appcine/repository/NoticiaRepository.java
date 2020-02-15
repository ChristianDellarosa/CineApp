package com.web.appcine.repository;

import com.web.appcine.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Integer> {

    List<Noticia> findByFecha(Date date);
    List<Noticia> findByStatus(String status);
    List<Noticia> findByStatusAndFecha(String status, Date date);
    List<Noticia> findByStatusOrFecha(String status, Date date);
    List<Noticia> findByFechaBetween(Date initial, Date finaly);

}
