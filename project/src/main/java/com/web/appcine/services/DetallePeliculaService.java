package com.web.appcine.services;

import com.web.appcine.model.DetallePelicula;
import com.web.appcine.repository.DetallePeliculaRepository;
import com.web.appcine.services.interfaces.IDetallePeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePeliculaService implements IDetallePeliculaService {

    @Autowired
    DetallePeliculaRepository detallePeliculaRepository;

    @Override
    public void insert(DetallePelicula detalle) {
        detallePeliculaRepository.save(detalle);
    }

    @Override
    public void delete(int idDetalle) {
        detallePeliculaRepository.deleteById(idDetalle);
    }
}
