package com.security.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.example.models.Usuario;
import com.security.example.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsConfig implements UserDetailsService {

	@Autowired
	UsuarioRepository us;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = us.findByLogin(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException(username + " não foi encontrado;");
		}
		
		System.out.println(usuario.getNome());
		return usuario;
	}

}
