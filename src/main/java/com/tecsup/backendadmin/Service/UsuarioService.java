package com.tecsup.backendadmin.Service;

import com.tecsup.backendadmin.Login.Usuario;
import com.tecsup.backendadmin.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para cargar un usuario por nombre de usuario (para autenticación)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                AuthorityUtils.createAuthorityList(usuario.getRole())
        );
    }

    // Método para obtener un usuario por nombre de usuario
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username).orElse(null); // Devuelve el usuario o null si no existe
    }
}



