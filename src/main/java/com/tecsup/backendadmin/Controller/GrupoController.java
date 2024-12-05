package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.Grupo;
import com.tecsup.backendadmin.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping
    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    @PostMapping
    public Grupo crearGrupo(@RequestBody Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> obtenerGrupo(@PathVariable Long id) {
        return grupoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> actualizarGrupo(@PathVariable Long id, @RequestBody Grupo nuevoGrupo) {
        return grupoRepository.findById(id).map(grupo -> {
            grupo.setNombre(nuevoGrupo.getNombre());
            return ResponseEntity.ok(grupoRepository.save(grupo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrupo(@PathVariable Long id) {
        if (grupoRepository.existsById(id)) {
            grupoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}