package com.itson.proyecto2_233410_233023.dominio;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "Gastos")
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")

    private Long id;

    @Temporal(TemporalType.TIMESTAMP) // O usar LocalDateTime si estás en Java 8 o superior
    @Column(name = "fecha", nullable = false)
    private Calendar fecha;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "total", nullable = false)
    private float total;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", nullable = false)
    private Trabajador trabajador;
    
    @OneToMany(mappedBy = "gastos", cascade = CascadeType.ALL)
    private List<Inventario> inventarioList;

    // Constructores, getters y setters
    // ...

    public Gastos() {
    }

    public Gastos(Long id, Calendar fecha, String motivo, float total, Trabajador trabajador, List<Inventario> inventarioList) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.total = total;
        this.trabajador = trabajador;
        this.inventarioList = inventarioList;
    }

    public Gastos(Calendar fecha, String motivo, float total, Trabajador trabajador, List<Inventario> inventarioList) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.total = total;
        this.trabajador = trabajador;
        this.inventarioList = inventarioList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }
    
}
