package com.web.appcine.services.interfaces;

import com.web.appcine.model.DetallePelicula;

public interface IDetallePeliculaService {
    void insert(DetallePelicula detalle);
    void delete(int idDetalle);
}
