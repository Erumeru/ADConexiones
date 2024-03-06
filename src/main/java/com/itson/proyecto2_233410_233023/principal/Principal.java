/*
Clase Principal.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.implementaciones.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.text.SimpleDateFormat;

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

        conexionBD.getEM().getTransaction().begin();
      //  conexionBD.getEM().persist(new Cliente("kim", "colonia", "calle", "numero", "telegono"));
        conexionBD.getEM().getTransaction().commit();

    }
}
