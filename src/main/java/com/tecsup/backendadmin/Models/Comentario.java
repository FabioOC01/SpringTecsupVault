package com.tecsup.backendadmin.Models;

import com.tecsup.backendadmin.Login.Usuario;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)  // Cambiado de LAZY a EAGER
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    @ManyToOne(fetch = FetchType.EAGER)  // Cambiado de LAZY a EAGER
    @JoinColumn(name = "proyecto_integrador_id", nullable = false)
    private ProyectoIntegrador proyecto;

    @Column(nullable = false, length = 500)
    private String contenido; // El contenido no debe ser null

    @Column(nullable = false)
    private LocalDate fecha;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
