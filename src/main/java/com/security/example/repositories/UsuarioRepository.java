package com.security.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.example.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByLogin(String login);

}
