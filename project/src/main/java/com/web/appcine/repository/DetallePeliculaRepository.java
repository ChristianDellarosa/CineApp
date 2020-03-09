package com.web.appcine.repository;

import com.web.appcine.model.DetallePelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePeliculaRepository extends JpaRepository<DetallePelicula, Integer> {
}
