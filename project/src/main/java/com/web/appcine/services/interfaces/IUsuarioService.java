package com.web.appcine.services.interfaces;

import com.web.appcine.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    void save(Usuario usuario);
    List<Usuario> searchAll();
    Usuario searchById(int idUser);
    void delete(int idUsuario);
}
