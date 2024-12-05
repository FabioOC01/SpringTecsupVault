package com.tecsup.backendadmin.Repository;

import com.tecsup.backendadmin.Models.CategoriaProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProyectoRepository extends JpaRepository<CategoriaProyecto, Long> {
    // Puedes agregar métodos personalizados si lo necesitas.
}
