package com.web.appcine.services;

import com.web.appcine.model.Perfil;
import com.web.appcine.repository.PerfilRepository;
import com.web.appcine.services.interfaces.IPerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService implements IPerfilesService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public void save(Perfil perfil) {
        perfilRepository.save(perfil);
    }

    @Override
    public void delete(String username) {
        perfilRepository.deleteByUsername(username);
    }
}
