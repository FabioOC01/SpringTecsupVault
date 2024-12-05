package com.tecsup.backendadmin.Models;

import jakarta.persistence.*;
import java.time.Year;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"año", "semestre"})})
public class Año {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int año = Year.now().getValue();

    @Column(nullable = false)
    private int semestre;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
}
