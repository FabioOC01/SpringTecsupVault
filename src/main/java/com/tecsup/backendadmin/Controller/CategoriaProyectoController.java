package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.CategoriaProyecto;
import com.tecsup.backendadmin.Repository.CategoriaProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaProyectoController {

    @Autowired
    private CategoriaProyectoRepository categoriaProyectoRepository;

    // Obtener todas las categorías
    @GetMapping
    public List<CategoriaProyecto> listarCategorias() {
        return categoriaProyectoRepository.findAll();
    }

    // Crear una nueva categoría
    @PostMapping
    public CategoriaProyecto crearCategoria(@RequestBody CategoriaProyecto categoria) {
        return categoriaProyectoRepository.save(categoria);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProyecto> obtenerCategoria(@PathVariable Long id) {
        return categoriaProyectoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar una categoría
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProyecto> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaProyecto nuevaCategoria) {
        return categoriaProyectoRepository.findById(id).map(categoria -> {
            categoria.setNombre(nuevaCategoria.getNombre());
            return ResponseEntity.ok(categoriaProyectoRepository.save(categoria));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (categoriaProyectoRepository.existsById(id)) {
            categoriaProyectoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
