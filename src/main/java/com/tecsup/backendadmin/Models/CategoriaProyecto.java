package com.tecsup.backendadmin.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "api_proyectos_categoriaproyecto")
public class CategoriaProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

}
