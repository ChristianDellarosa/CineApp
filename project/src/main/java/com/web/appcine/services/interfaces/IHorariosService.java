package com.web.appcine.services.interfaces;

import com.web.appcine.model.Horario;

import java.util.Date;
import java.util.List;

public interface IHorariosService {
    List<Horario> searchByIdPelicula(int idPelicula, Date fecha);
}
