package com.tecsup.backendadmin.Login;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password("{noop}admin123")
                    .roles("ADMIN")
                    .build();
        } else if ("user".equals(username)) {
            return User.withUsername("user")
                    .password("{noop}user123")
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}


