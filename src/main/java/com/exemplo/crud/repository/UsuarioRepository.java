package com.exemplo.crud.repository;

import com.exemplo.crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // save(), findAll(), findById(), deleteById()
}