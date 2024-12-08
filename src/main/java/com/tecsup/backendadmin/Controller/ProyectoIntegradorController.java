package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.ProyectoIntegrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tecsup.backendadmin.Repository.ProyectoIntegradorRepository;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoIntegradorController {

    @Autowired
    private ProyectoIntegradorRepository proyectoIntegradorRepository;

    @GetMapping
    public List<ProyectoIntegrador> listarProyectos() {
        return proyectoIntegradorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProyectoIntegrador obtenerProyectoPorId(@PathVariable Long id) {
        return proyectoIntegradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado con id: " + id));
    }
}

