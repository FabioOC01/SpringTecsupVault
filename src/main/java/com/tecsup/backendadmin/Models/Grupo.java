package com.tecsup.backendadmin.Models;

import jakarta.persistence.*;

@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @ManyToOne
    private Seccion seccion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Seccion getSeccion() { return seccion; }
    public void setSeccion(Seccion seccion) { this.seccion = seccion; }
}
