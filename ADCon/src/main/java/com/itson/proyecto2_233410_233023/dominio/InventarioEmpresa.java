package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "InventarioEmpresa")
public class InventarioEmpresa extends Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @OneToOne(mappedBy = "inventarioEmpresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductoEmpresa productoEmpresa;

    // Constructores, getters y setters
    public InventarioEmpresa(Long id, ProductoEmpresa productoEmpresa) {
        this.id = id;
        this.productoEmpresa = productoEmpresa;
    }

    public InventarioEmpresa(ProductoEmpresa productoEmpresa) {
        this.productoEmpresa = productoEmpresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoEmpresa getProductoEmpresa() {
        return productoEmpresa;
    }

    public void setProductoEmpresa(ProductoEmpresa productoEmpresa) {
        this.productoEmpresa = productoEmpresa;
    }

    // ...
    public InventarioEmpresa() {
    }
}
