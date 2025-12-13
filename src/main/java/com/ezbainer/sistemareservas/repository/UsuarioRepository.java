package com.ezbainer.sistemareservas.repository;

import com.ezbainer.sistemareservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
