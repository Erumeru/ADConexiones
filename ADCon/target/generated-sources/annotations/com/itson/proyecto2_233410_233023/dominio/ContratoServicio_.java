package com.itson.proyecto2_233410_233023.dominio;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Cita;
import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.Plan;
import com.itson.proyecto2_233410_233023.dominio.ProductoCliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-05-08T13:31:13")
@StaticMetamodel(ContratoServicio.class)
public class ContratoServicio_ { 

    public static volatile SingularAttribute<ContratoServicio, Integer> diaAPagar;
    public static volatile SingularAttribute<ContratoServicio, Cliente> cliente;
    public static volatile SingularAttribute<ContratoServicio, Float> montoPagar;
    public static volatile ListAttribute<ContratoServicio, Cita> citas;
    public static volatile SingularAttribute<ContratoServicio, Long> id;
    public static volatile ListAttribute<ContratoServicio, ProductoCliente> productosClientes;
    public static volatile ListAttribute<ContratoServicio, Cargo> cargos;
    public static volatile SingularAttribute<ContratoServicio, Plan> plan;

}