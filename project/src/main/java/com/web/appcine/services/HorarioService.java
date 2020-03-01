package com.web.appcine.services;

import com.web.appcine.model.Horario;
import com.web.appcine.repository.HorarioRepository;
import com.web.appcine.services.interfaces.IHorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HorarioService implements IHorariosService {

    @Autowired
    HorarioRepository horarioRepository;

    @Override
    public List<Horario> searchByIdPelicula(int idPelicula, Date fecha) {
        return horarioRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula,fecha);
    }
}
