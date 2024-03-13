package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cargo")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @Column(name = "deuda", nullable = false)
    private float deuda;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // O usar LocalDateTime si estás en Java 8 o superior
    private Date fecha;

    @OneToMany(mappedBy = "cargo")
    private List<Pago> pagos;

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    @ManyToOne
    @JoinColumn(name = "contrato_servicio_id", nullable = false)
    private ContratoServicio contratoServicio;

    // Constructores, getters y setters
    public Cargo() {
        // Constructor por defecto necesario para JPA
    }

    public Cargo(float deuda, Date fecha, ContratoServicio contratoServicio) {
        this.deuda = deuda;
        this.fecha = fecha;
        this.contratoServicio = contratoServicio;
    }
    
    

    public Cargo(Long id, float deuda, Date fecha, List<Pago> pagos, ContratoServicio contratoServicio) {
        this.id = id;
        this.deuda = deuda;
        this.fecha = fecha;
        this.pagos = pagos;
        this.contratoServicio = contratoServicio;
    }

    public Cargo(float deuda, Date fecha, List<Pago> pagos, ContratoServicio contratoServicio) {
        this.deuda = deuda;
        this.fecha = fecha;
        this.pagos = pagos;
        this.contratoServicio = contratoServicio;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
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
