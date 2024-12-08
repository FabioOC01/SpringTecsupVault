package com.tecsup.backendadmin.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "api_proyectos_proyectointegrador")
public class ProyectoIntegrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 100, nullable = true)
    private String imagen; // Almacena solo el nombre del archivo

    @Column(length = 100, nullable = true)
    private String documento;

    @Column(length = 100, nullable = true)
    private String video;

    @Column(name = "url_github", length = 255, nullable = true)
    private String urlGithub;

    @ManyToOne
    @JoinColumn(name = "año_id", nullable = true)
    private Año año;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private CategoriaProyecto categoria;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @JsonProperty("imagen")
    public String getImagenUrl() {
        if (imagen != null) {
            return "https://tecsupvault.s3.us-east-2.amazonaws.com/" + imagen;
        }
        return null;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public Año getAño() {
        return año;
    }

    public void setAño(Año año) {
        this.año = año;
    }

    public CategoriaProyecto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProyecto categoria) {
        this.categoria = categoria;
    }
}