package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.Año;
import com.tecsup.backendadmin.Repository.AñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciclo")
public class AñoController {

    @Autowired
    private AñoRepository añoRepository;

    @GetMapping
    public List<Año> listarAños() {
        return añoRepository.findAll();
    }

    @PostMapping
    public Año crearAño(@RequestBody Año año) {
        return añoRepository.save(año);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Año> obtenerAño(@PathVariable Long id) {
        return añoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Año> actualizarAño(@PathVariable Long id, @RequestBody Año nuevoAño) {
        return añoRepository.findById(id).map(año -> {
            año.setAño(nuevoAño.getAño());
            año.setSemestre(nuevoAño.getSemestre());
            return ResponseEntity.ok(añoRepository.save(año));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAño(@PathVariable Long id) {
        if (añoRepository.existsById(id)) {
            añoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}