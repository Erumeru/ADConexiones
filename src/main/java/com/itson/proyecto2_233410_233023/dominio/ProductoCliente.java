package com.itson.proyecto2_233410_233023.dominio;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "ProductoCliente")
public class ProductoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "inventario_cliente_id", nullable = false, unique = true)
    private InventarioCliente inventarioCliente;

    
    @ManyToMany(mappedBy = "productosClientes")
    private List<ContratoServicio> contratosServicio;
    // Constructores, getters y setters
    // ...

    public ProductoCliente() {
    }

    public ProductoCliente(Long id, String nombre, InventarioCliente inventarioCliente, List<ContratoServicio> contratosServicio) {
        this.id = id;
        this.nombre = nombre;
        this.inventarioCliente = inventarioCliente;
        this.contratosServicio = contratosServicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InventarioCliente getInventarioCliente() {
        return inventarioCliente;
    }

    public void setInventarioCliente(InventarioCliente inventarioCliente) {
        this.inventarioCliente = inventarioCliente;
    }

    public List<ContratoServicio> getContratosServicio() {
        return contratosServicio;
    }

    public void setContratosServicio(List<ContratoServicio> contratosServicio) {
        this.contratosServicio = contratosServicio;
    }

    public ProductoCliente(String nombre, InventarioCliente inventarioCliente, List<ContratoServicio> contratosServicio) {
        this.nombre = nombre;
        this.inventarioCliente = inventarioCliente;
        this.contratosServicio = contratosServicio;
    }
    
    
}
