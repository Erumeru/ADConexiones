package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.CatalogoProductos;
import com.itson.proyecto2_233410_233023.dominio.Gastos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-03-13T00:45:12")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, CatalogoProductos> catalogoProductos;
    public static volatile SingularAttribute<Inventario, Long> id;
    public static volatile SingularAttribute<Inventario, String> numSerie;
    public static volatile SingularAttribute<Inventario, Gastos> gastos;

}