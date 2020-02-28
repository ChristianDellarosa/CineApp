package com.web.appcine.repository;

import com.web.appcine.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario,Integer> {
    List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
}
