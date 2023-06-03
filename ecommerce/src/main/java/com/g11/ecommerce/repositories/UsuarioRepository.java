package com.g11.ecommerce.repositories;

import com.g11.ecommerce.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}