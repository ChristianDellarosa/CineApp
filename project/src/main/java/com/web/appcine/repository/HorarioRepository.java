package com.web.appcine.repository;

import com.web.appcine.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Integer> {
    List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);

    /* mysql.cnf
     *  [mysqld]
     * 	sql_mode = "STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"
     */
    @Query("select h from Horario h where h.fecha = :fecha and pelicula.status='Activa' group by h.pelicula order by pelicula.id asc")
    List<Horario> findByFecha(@Param("fecha") Date fecha);
}
