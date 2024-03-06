package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cita")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // O usar LocalDateTime si estás en Java 8 o superior
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "contrato_servicio_id", nullable = false)
    private ContratoServicio contratoServicio;

    // Constructores, getters y setters
    public Cita() {
        // Constructor por defecto necesario para JPA
    }

    public Cita(String motivo, Date fecha, ContratoServicio contratoServicio) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.contratoServicio = contratoServicio;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ContratoServicio getContratoServicio() {
        return contratoServicio;
    }

    public void setContratoServicio(ContratoServicio contratoServicio) {
        this.contratoServicio = contratoServicio;
    }
}
