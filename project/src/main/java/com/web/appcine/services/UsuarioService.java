package com.web.appcine.services;

import com.web.appcine.model.Pelicula;
import com.web.appcine.model.Usuario;
import com.web.appcine.repository.UsuarioRepository;
import com.web.appcine.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> searchAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario searchById(int idUser) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUser);
        if(usuario.isPresent()){
            return usuario.get();
        }
        return null;
    }

    @Override
    public void delete(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
