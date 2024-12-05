package com.tecsup.backendadmin.Controller;

import com.tecsup.backendadmin.Models.Alumno;
import com.tecsup.backendadmin.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("alumnoController")
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno nuevoAlumno) {
        return alumnoRepository.findById(id).map(alumno -> {
            alumno.setNombre(nuevoAlumno.getNombre());
            alumno.setApellido(nuevoAlumno.getApellido());
            alumno.setGrupo(nuevoAlumno.getGrupo());
            alumno.setSeccion(nuevoAlumno.getSeccion());
            alumno.setAño(nuevoAlumno.getAño());
            return ResponseEntity.ok(alumnoRepository.save(alumno));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}