package com.itson.proyecto2_233410_233023.dominio;

import javax.persistence.*;

@Entity
@Table(name = "ProductoEmpresa")
public class ProductoEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "inventario_empresa_id", nullable = false, unique = true)
    private InventarioEmpresa inventarioEmpresa;

    // Constructores, getters y setters

    public ProductoEmpresa(Long id, String nombre, InventarioEmpresa inventarioEmpresa) {
        this.id = id;
        this.nombre = nombre;
        this.inventarioEmpresa = inventarioEmpresa;
    }

    public ProductoEmpresa(String nombre, InventarioEmpresa inventarioEmpresa) {
        this.nombre = nombre;
        this.inventarioEmpresa = inventarioEmpresa;
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

    public InventarioEmpresa getInventarioEmpresa() {
        return inventarioEmpresa;
    }

    public void setInventarioEmpresa(InventarioEmpresa inventarioEmpresa) {
        this.inventarioEmpresa = inventarioEmpresa;
    }


    // ...

    public ProductoEmpresa() {
    }
}
