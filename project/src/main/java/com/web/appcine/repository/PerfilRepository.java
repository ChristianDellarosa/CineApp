package com.web.appcine.repository;

import com.web.appcine.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
    void deleteByUsername(String Username);
}
