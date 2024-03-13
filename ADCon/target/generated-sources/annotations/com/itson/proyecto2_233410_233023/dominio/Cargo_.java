package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.dominio.Pago;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-03-13T00:45:12")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Float> deuda;
    public static volatile SingularAttribute<Cargo, Date> fecha;
    public static volatile SingularAttribute<Cargo, Long> id;
    public static volatile ListAttribute<Cargo, Pago> pagos;
    public static volatile SingularAttribute<Cargo, ContratoServicio> contratoServicio;

}