package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-03-13T03:21:18")
@StaticMetamodel(Plan.class)
public class Plan_ { 

    public static volatile SingularAttribute<Plan, Float> costoMensualidad;
    public static volatile ListAttribute<Plan, ContratoServicio> contratosServicio;
    public static volatile SingularAttribute<Plan, Long> id;
    public static volatile SingularAttribute<Plan, String> megas;

}