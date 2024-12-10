package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.Comentario;
import com.tecsup.backendadmin.Repository.ComentarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;

    public ComentarioController(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @GetMapping
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        if (comentario.getContenido() == null || comentario.getContenido().isEmpty()) {
            return ResponseEntity.badRequest().body(null);  // Devolver un error si el contenido es nulo
        }
        Comentario comentarioGuardado = comentarioRepository.save(comentario);
        return ResponseEntity.ok(comentarioGuardado);  // Devuelve el comentario guardado
    }


}
