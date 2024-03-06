package com.itson.proyecto2_233410_233023.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Plan")
public class Plan {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "costoMensualidad", nullable = false)
    private float costoMensualidad;

    @Column(name = "megas", nullable = false, length = 50)
    private String megas;

    @OneToMany(mappedBy = "plan")
    private List<ContratoServicio> contratosServicio;

    // Constructores, getters y setters
    public Plan() {
        // Constructor por defecto necesario para JPA
    }

    public Plan(float costoMensualidad, String megas) {
        this.costoMensualidad = costoMensualidad;
        this.megas = megas;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCostoMensualidad() {
        return costoMensualidad;
    }

    public void setCostoMensualidad(float costoMensualidad) {
        this.costoMensualidad = costoMensualidad;
    }

    public String getMegas() {
        return megas;
    }

    public void setMegas(String megas) {
        this.megas = megas;
    }

    public List<ContratoServicio> getContratosServicio() {
        return contratosServicio;
    }

    public void setContratosServicio(List<ContratoServicio> contratosServicio) {
        this.contratosServicio = contratosServicio;
    }
}
