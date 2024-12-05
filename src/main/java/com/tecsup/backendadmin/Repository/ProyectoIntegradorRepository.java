package com.tecsup.backendadmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.backendadmin.Models.ProyectoIntegrador;

@Repository
public interface ProyectoIntegradorRepository extends JpaRepository<ProyectoIntegrador, Long> {

}
