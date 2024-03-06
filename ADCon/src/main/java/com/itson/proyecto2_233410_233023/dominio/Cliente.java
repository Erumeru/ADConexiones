package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombreCliente", nullable = false, length = 100)
    private String nombreCliente;
    
    @Column(name = "coloniaCliente", nullable = false, length = 100)

    private String coloniaCliente;

    @Column(name = "calleCliente", nullable = false, length = 100)
    private String calleCliente;

    @Column(name = "numeroCliente", nullable = false, length = 100)
    private String numeroCliente;

    @Column(name = "telefonoCliente", nullable = false, length = 100)
    private String telefonoCliente;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ContratoServicio> contratosServicio;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ContratoServicio> getContratosServicio() {
        return contratosServicio;
    }

    public void setContratosServicio(List<ContratoServicio> contratosServicio) {
        this.contratosServicio = contratosServicio;
    }
    
    

    // Constructor, getters y setters
    public Cliente() {
        // Constructor por defecto necesario para JPA
    }

    public Cliente(Long id, String nombreCliente, String coloniaCliente, String calleCliente, String numeroCliente, String telefonoCliente, List<ContratoServicio> contratosServicio) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.coloniaCliente = coloniaCliente;
        this.calleCliente = calleCliente;
        this.numeroCliente = numeroCliente;
        this.telefonoCliente = telefonoCliente;
        this.contratosServicio = contratosServicio;
    }

    public Cliente(String nombreCliente, String coloniaCliente, String calleCliente, String numeroCliente, String telefonoCliente, List<ContratoServicio> contratosServicio) {
        this.nombreCliente = nombreCliente;
        this.coloniaCliente = coloniaCliente;
        this.calleCliente = calleCliente;
        this.numeroCliente = numeroCliente;
        this.telefonoCliente = telefonoCliente;
        this.contratosServicio = contratosServicio;
    }

    

    
    
    // Getters y setters
    public Long getIdCliente() {
        return id;
    }

    public void setIdCliente(Long idCliente) {
        this.id = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getColoniaCliente() {
        return coloniaCliente;
    }

    public void setColoniaCliente(String coloniaCliente) {
        this.coloniaCliente = coloniaCliente;
    }

    public String getCalleCliente() {
        return calleCliente;
    }

    public void setCalleCliente(String calleCliente) {
        this.calleCliente = calleCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
}
