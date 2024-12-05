package com.tecsup.backendadmin.Repository;

import com.tecsup.backendadmin.Models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
