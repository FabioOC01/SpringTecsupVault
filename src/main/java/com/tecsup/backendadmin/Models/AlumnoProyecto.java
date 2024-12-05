package com.tecsup.backendadmin.Models;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"proyecto_id", "grupo_id"})})
public class AlumnoProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProyectoIntegrador proyecto;

    @ManyToOne
    private Grupo grupo;

    @ManyToOne
    private Seccion seccion;

    @ManyToOne
    private Año año;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ProyectoIntegrador getProyecto() { return proyecto; }
    public void setProyecto(ProyectoIntegrador proyecto) { this.proyecto = proyecto; }
    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }
    public Seccion getSeccion() { return seccion; }
    public void setSeccion(Seccion seccion) { this.seccion = seccion; }
    public Año getAño() { return año; }
    public void setAño(Año año) { this.año = año; }
}
