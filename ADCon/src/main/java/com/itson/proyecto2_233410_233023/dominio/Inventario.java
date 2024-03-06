package com.itson.proyecto2_233410_233023.dominio;

import javax.persistence.*;

@Entity
@Table(name = "Inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "numSerie", nullable = false)
    private String numSerie;

    @ManyToOne
    @JoinColumn(name = "catalogo_productos_id", nullable = false)
    private CatalogoProductos catalogoProductos;

    @ManyToOne
    @JoinColumn(name = "gastos_id", nullable = false)
    private Gastos gastos;

    // Constructores, getters y setters
    // ...

    public Inventario() {
    }

    public Inventario(Long id, String numSerie, CatalogoProductos catalogoProductos, Gastos gastos) {
        this.id = id;
        this.numSerie = numSerie;
        this.catalogoProductos = catalogoProductos;
        this.gastos = gastos;
    }

    public Inventario(String numSerie, CatalogoProductos catalogoProductos, Gastos gastos) {
        this.numSerie = numSerie;
        this.catalogoProductos = catalogoProductos;
        this.gastos = gastos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public CatalogoProductos getCatalogoProductos() {
        return catalogoProductos;
    }

    public void setCatalogoProductos(CatalogoProductos catalogoProductos) {
        this.catalogoProductos = catalogoProductos;
    }

    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }
    
}
