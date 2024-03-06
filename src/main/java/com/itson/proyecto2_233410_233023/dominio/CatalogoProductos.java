package com.itson.proyecto2_233410_233023.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CatalogoProductos")
public class CatalogoProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "catalogoProductos", cascade = CascadeType.ALL)
    private List<Inventario> inventarioList;

    // Constructores, getters y setters

    public CatalogoProductos(Long id, String nombre, List<Inventario> inventarioList) {
        this.id = id;
        this.nombre = nombre;
        this.inventarioList = inventarioList;
    }

    public CatalogoProductos(String nombre, List<Inventario> inventarioList) {
        this.nombre = nombre;
        this.inventarioList = inventarioList;
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

    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }
    
    
    // ...

    public CatalogoProductos() {
    }
}
