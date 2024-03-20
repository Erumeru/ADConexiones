package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-03-19T20:27:21")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, Date> fecha;
    public static volatile SingularAttribute<Cita, String> motivo;
    public static volatile SingularAttribute<Cita, Long> id;
    public static volatile SingularAttribute<Cita, ContratoServicio> contratoServicio;

}