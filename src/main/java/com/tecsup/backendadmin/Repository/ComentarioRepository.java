package com.tecsup.backendadmin.Repository;

import com.tecsup.backendadmin.Models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
