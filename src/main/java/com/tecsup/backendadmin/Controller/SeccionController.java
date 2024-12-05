package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.Seccion;
import com.tecsup.backendadmin.Repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secciones")
public class SeccionController {

    @Autowired
    private SeccionRepository seccionRepository;

    @GetMapping
    public List<Seccion> listarSecciones() {
        return seccionRepository.findAll();
    }

    @PostMapping
    public Seccion crearSeccion(@RequestBody Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seccion> obtenerSeccion(@PathVariable Long id) {
        return seccionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seccion> actualizarSeccion(@PathVariable Long id, @RequestBody Seccion nuevaSeccion) {
        return seccionRepository.findById(id).map(seccion -> {
            seccion.setNombre(nuevaSeccion.getNombre());
            return ResponseEntity.ok(seccionRepository.save(seccion));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSeccion(@PathVariable Long id) {
        if (seccionRepository.existsById(id)) {
            seccionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}