package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "costo", nullable = false)
    private float costo;

    @Column(name = "especificaciones", nullable = false, length = 100)
    private String especificaciones;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // O usar LocalDateTime si estás en Java 8 o superior
    private Date fecha;

    
     @ManyToOne
     @JoinColumn(name="cargo_id", nullable=false)
    private Cargo cargo;
     
     
    @ManyToMany(mappedBy = "pagos")
    private List<Trabajador> trabajadores;

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public Cargo getCargos() {
        return cargo;
    }

    public void setCargos(Cargo  cargos) {
        this.cargo = cargos;
    }

    public Pago() {
    }

    public Pago(Long id) {
        this.id = id;
    }

    public Pago(Long id, float costo, String especificaciones, Date fecha, Cargo cargo, List<Trabajador> trabajadores) {
        this.id = id;
        this.costo = costo;
        this.especificaciones = especificaciones;
        this.fecha = fecha;
        this.cargo = cargo;
        this.trabajadores = trabajadores;
    }

    public Pago(float costo, String especificaciones, Date fecha, Cargo cargo, List<Trabajador> trabajadores) {
        this.costo = costo;
        this.especificaciones = especificaciones;
        this.fecha = fecha;
        this.cargo = cargo;
        this.trabajadores = trabajadores;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    

    

   
}
