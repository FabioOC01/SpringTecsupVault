package com.tecsup.backendadmin.Config;

import com.tecsup.backendadmin.Login.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())  // Deshabilitar CSRF temporalmente
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // Permitir todas las rutas sin autenticación
                )
                .formLogin(form -> form
                        .loginPage("/auth/login")  // Página de login personalizada (sin autenticación real)
                        .permitAll()  // Permitir acceso a la página de login
                );
        return http.build();
    }
}




