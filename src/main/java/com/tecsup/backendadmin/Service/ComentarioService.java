package com.tecsup.backendadmin.Service;


import com.tecsup.backendadmin.Models.Comentario;
import com.tecsup.backendadmin.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    public List<Comentario> findAllComentarios() {
        return comentarioRepository.findAll();
    }


    public Comentario findComentarioById(Long id) {
        Optional<Comentario> comentario = comentarioRepository.findById(id);
        return comentario.orElse(null);
    }


    public Comentario saveComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
}
