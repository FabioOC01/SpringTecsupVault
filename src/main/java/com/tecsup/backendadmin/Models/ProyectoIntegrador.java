package com.tecsup.backendadmin.Models;

import jakarta.persistence.*;

@Entity
public class ProyectoIntegrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @Lob
    private String descripcion;

    @ManyToOne
    private Año año;

    private String imagen; // Ruta del archivo
    private String documento; // Ruta del archivo
    private String video; // Ruta del archivo

    @Column(length = 255)
    private String urlGithub;

    @ManyToOne
    private CategoriaProyecto categoria;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Año getAño() { return año; }
    public void setAño(Año año) { this.año = año; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getVideo() { return video; }
    public void setVideo(String video) { this.video = video; }
    public String getUrlGithub() { return urlGithub; }
    public void setUrlGithub(String urlGithub) { this.urlGithub = urlGithub; }
    public CategoriaProyecto getCategoria() { return categoria; }
    public void setCategoria(CategoriaProyecto categoria) { this.categoria = categoria; }
}

