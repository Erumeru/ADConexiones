package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "InventarioCliente")
public class InventarioCliente extends Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne(mappedBy = "inventarioCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductoCliente productoCliente;

    // Constructores, getters y setters

    public InventarioCliente(Long id, ProductoCliente productoCliente) {
        this.id = id;
        this.productoCliente = productoCliente;
    }

    public InventarioCliente(ProductoCliente productoCliente) {
        this.productoCliente = productoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoCliente getProductoCliente() {
        return productoCliente;
    }

    public void setProductoCliente(ProductoCliente productoCliente) {
        this.productoCliente = productoCliente;
    }
    
    
    // ...

    public InventarioCliente() {
    }
}
