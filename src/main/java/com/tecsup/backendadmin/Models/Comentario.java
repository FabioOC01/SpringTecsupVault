package com.tecsup.backendadmin.Models;

import com.tecsup.backendadmin.Login.Usuario;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 30)
    private  String usuario;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_integrador_id", nullable = false)
    private ProyectoIntegrador proyecto;

    @Column(nullable = false, length = 500)
    private String contenido;


    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ProyectoIntegrador getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoIntegrador proyecto) {
        this.proyecto = proyecto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
