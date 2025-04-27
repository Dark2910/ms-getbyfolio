package com.eespindola.ms.getbyfolio.jpa;

import com.eespindola.ms.getbyfolio.jpa.Entities.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Object> {

    public Optional<UsuarioJPA> findByFolio(String folio);

}
