package com.web.appcine.services.interfaces;

import com.web.appcine.model.Noticia;
import java.util.List;

public interface INoticiasService {
    void save(Noticia noticia);
    List<Noticia> searchLast();
    List<Noticia> searchAll();
    void delete(int idNoticia);
    Noticia searchById(int idNoticia);
}
