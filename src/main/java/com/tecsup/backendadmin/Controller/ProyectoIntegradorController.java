package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.ProyectoIntegrador;
import com.tecsup.backendadmin.Repository.ProyectoIntegradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoIntegradorController {

    @Autowired
    private ProyectoIntegradorRepository proyectoIntegradorRepository;

    @GetMapping
    public List<ProyectoIntegrador> listarProyectos() {
        return proyectoIntegradorRepository.findAll();
    }

    @PostMapping
    public ProyectoIntegrador crearProyecto(@RequestBody ProyectoIntegrador proyecto) {
        return proyectoIntegradorRepository.save(proyecto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoIntegrador> obtenerProyecto(@PathVariable Long id) {
        return proyectoIntegradorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoIntegrador> actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoIntegrador nuevoProyecto) {
        return proyectoIntegradorRepository.findById(id).map(proyecto -> {
            proyecto.setTitulo(nuevoProyecto.getTitulo());
            proyecto.setDescripcion(nuevoProyecto.getDescripcion());
            proyecto.setAño(nuevoProyecto.getAño());
            proyecto.setCategoria(nuevoProyecto.getCategoria());
            proyecto.setImagen(nuevoProyecto.getImagen());
            proyecto.setDocumento(nuevoProyecto.getDocumento());
            proyecto.setVideo(nuevoProyecto.getVideo());
            proyecto.setUrlGithub(nuevoProyecto.getUrlGithub());
            return ResponseEntity.ok(proyectoIntegradorRepository.save(proyecto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        if (proyectoIntegradorRepository.existsById(id)) {
            proyectoIntegradorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
