package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Trabajador;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-04-09T23:41:20")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-04-10T16:48:38")
>>>>>>> Stashed changes
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Date> fecha;
    public static volatile ListAttribute<Pago, Trabajador> trabajadores;
    public static volatile SingularAttribute<Pago, Float> costo;
    public static volatile SingularAttribute<Pago, String> especificaciones;
    public static volatile SingularAttribute<Pago, Long> id;
    public static volatile SingularAttribute<Pago, Cargo> cargo;

}