package com.web.appcine.services;

import com.web.appcine.model.Noticia;
import com.web.appcine.repository.NoticiaRepository;
import com.web.appcine.services.interfaces.INoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiasService implements INoticiasService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Override
    public void save(Noticia noticia) {
        noticiaRepository.save(noticia);
    }

    @Override
    public List<Noticia> searchLast() {
        return noticiaRepository.findTop3ByStatusOrderByIdDesc("Activa");
    }

    @Override
    public List<Noticia> searchAll() {
        return noticiaRepository.findAll();
    }

    @Override
    public void delete(int idNoticia) {
        noticiaRepository.deleteById(idNoticia);
    }

    @Override
    public Noticia searchById(int idNoticia) {
        Optional<Noticia> noticia = noticiaRepository.findById(idNoticia);
        if(noticia.isPresent()) {
            return noticia.get();
        }
        return null;
    }
}
