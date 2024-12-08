package com.tecsup.backendadmin.Service;

import com.tecsup.backendadmin.Models.ProyectoIntegrador;
import com.tecsup.backendadmin.Repository.ProyectoIntegradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoIntegradorRepository proyectoIntegradorRepository;

    public ProyectoIntegrador crearProyecto(ProyectoIntegrador proyectoIntegrador) {
        return proyectoIntegradorRepository.save(proyectoIntegrador);
    }

    public List<ProyectoIntegrador> obtenerTodosProyectos() {
        return proyectoIntegradorRepository.findAll();
    }

    public ProyectoIntegrador actualizarProyecto(Long id, ProyectoIntegrador proyectoIntegrador) {
        Optional<ProyectoIntegrador> proyectoExistente = proyectoIntegradorRepository.findById(id);
        if (proyectoExistente.isPresent()) {
            ProyectoIntegrador proyectoIntegradorAActualizar = proyectoExistente.get();
            return proyectoIntegradorRepository.save(proyectoIntegradorAActualizar);
        } else {
            return null;
        }
    }


    public boolean eliminarProyecto(Long id) {
        Optional<ProyectoIntegrador> proyectoExistente = proyectoIntegradorRepository.findById(id);
        if (proyectoExistente.isPresent()) {
            proyectoIntegradorRepository.delete(proyectoExistente.get());
            return true;
        } else {
            return false;
        }
    }
}
