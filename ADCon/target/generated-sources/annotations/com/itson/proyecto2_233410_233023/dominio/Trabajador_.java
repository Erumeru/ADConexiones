package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.Gastos;
import com.itson.proyecto2_233410_233023.dominio.Pago;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-04-09T23:41:20")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-04-10T16:48:38")
>>>>>>> Stashed changes
@StaticMetamodel(Trabajador.class)
public class Trabajador_ { 

    public static volatile SingularAttribute<Trabajador, String> apellidoPaterno;
    public static volatile SingularAttribute<Trabajador, Long> id;
    public static volatile SingularAttribute<Trabajador, String> nombre;
    public static volatile ListAttribute<Trabajador, Pago> pagos;
    public static volatile SingularAttribute<Trabajador, String> apellidoMaterno;
    public static volatile ListAttribute<Trabajador, Gastos> gastos;

}