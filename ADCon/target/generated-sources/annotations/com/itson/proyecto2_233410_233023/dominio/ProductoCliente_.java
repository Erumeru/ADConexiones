package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.dominio.InventarioCliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-04-09T23:41:20")
@StaticMetamodel(ProductoCliente.class)
public class ProductoCliente_ { 

    public static volatile SingularAttribute<ProductoCliente, InventarioCliente> inventarioCliente;
    public static volatile ListAttribute<ProductoCliente, ContratoServicio> contratosServicio;
    public static volatile SingularAttribute<ProductoCliente, Long> id;
    public static volatile SingularAttribute<ProductoCliente, String> nombre;

}