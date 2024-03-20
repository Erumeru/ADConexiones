package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.Inventario;
import com.itson.proyecto2_233410_233023.dominio.Trabajador;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-03-20T13:36:31")
@StaticMetamodel(Gastos.class)
public class Gastos_ { 

    public static volatile SingularAttribute<Gastos, Trabajador> trabajador;
    public static volatile SingularAttribute<Gastos, Calendar> fecha;
    public static volatile SingularAttribute<Gastos, String> motivo;
    public static volatile SingularAttribute<Gastos, Float> total;
    public static volatile ListAttribute<Gastos, Inventario> inventarioList;
    public static volatile SingularAttribute<Gastos, Long> id;

}