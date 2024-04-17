package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-04-09T23:41:20")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> calleCliente;
    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile SingularAttribute<Cliente, String> coloniaCliente;
    public static volatile ListAttribute<Cliente, ContratoServicio> contratosServicio;
    public static volatile SingularAttribute<Cliente, String> numeroCliente;
    public static volatile SingularAttribute<Cliente, String> telefonoCliente;
    public static volatile SingularAttribute<Cliente, Long> id;

}