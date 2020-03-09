package com.web.appcine.services.interfaces;

import com.web.appcine.model.Perfil;

public interface IPerfilesService {
    void save(Perfil perfil);
    void delete(String username);
}
