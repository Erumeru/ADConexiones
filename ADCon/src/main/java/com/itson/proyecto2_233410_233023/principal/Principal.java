/*
Clase Principal.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD conexionBD = new ConexionBD("adconexiones");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

//        conexionBD.getEM().getTransaction().begin();
//        List<ContratoServicio> c = new ArrayList<>();
//        Cliente cliente = new Cliente("c", "c1", "c2", "c3", "c4", c);
//        conexionBD.getEM().persist(cliente);
//        conexionBD.getEM().getTransaction().commit();

    }
}
