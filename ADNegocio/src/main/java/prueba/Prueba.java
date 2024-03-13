/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.dominio.Pago;
import com.itson.proyecto2_233410_233023.dominio.Plan;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.mycompany.adnegocio.CargoDAO;
import com.mycompany.adnegocio.ClienteDAO;
import com.mycompany.adnegocio.ContratoServicioDAO;
import com.mycompany.adnegocio.PagoDAO;
import com.mycompany.adnegocio.PlanDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author berly
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        ConexionBD conexionBD = new ConexionBD("adconexiones");
        ClienteDAO cliente = new ClienteDAO(conexionBD);
        // INSERTAR DUMMIES
        cliente.insercionMasivaPersonas();

        //INSERTAR UN PLAN
        PlanDAO plan = new PlanDAO(conexionBD);
        Plan planObjeto = new Plan(300F, "200m");
        plan.insertarPlan(planObjeto);

        //AGREGAR CONTRATO
        ContratoServicioDAO contrato = new ContratoServicioDAO(conexionBD);
        //float montoPagar, int diaAPagar, Plan plan, Cliente cliente
        contrato.crearContrato(new ContratoServicio(300F, 11, planObjeto, cliente.obtenerPersona(1L)));
        contrato.crearContrato(new ContratoServicio(300F, 11, planObjeto, cliente.obtenerPersona(2L)));
        contrato.crearContrato(new ContratoServicio(300F, 10, planObjeto, cliente.obtenerPersona(3L)));
        contrato.crearContrato(new ContratoServicio(300F, 9, planObjeto, cliente.obtenerPersona(4L)));
        contrato.crearContrato(new ContratoServicio(300F, 12, planObjeto, cliente.obtenerPersona(5L)));
        contrato.crearContrato(new ContratoServicio(300F, 12, planObjeto, cliente.obtenerPersona(6L)));
        contrato.crearContrato(new ContratoServicio(300F, 13, planObjeto, cliente.obtenerPersona(7L)));
        contrato.crearContrato(new ContratoServicio(300F, 13, planObjeto, cliente.obtenerPersona(8L)));
        contrato.crearContrato(new ContratoServicio(300F, 15, planObjeto, cliente.obtenerPersona(9L)));
        contrato.crearContrato(new ContratoServicio(300F, 15, planObjeto, cliente.obtenerPersona(10L)));

        //AGREGAR CARGO
        CargoDAO cargo = new CargoDAO(conexionBD);
        //float deuda, Date fecha, ContratoServicio contratoServicio
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 11), contrato.obtenerContrato(cliente.obtenerPersona(1L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 11), contrato.obtenerContrato(cliente.obtenerPersona(2L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 10), contrato.obtenerContrato(cliente.obtenerPersona(3L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 9), contrato.obtenerContrato(cliente.obtenerPersona(4L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 12), contrato.obtenerContrato(cliente.obtenerPersona(5L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 12), contrato.obtenerContrato(cliente.obtenerPersona(6L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 13), contrato.obtenerContrato(cliente.obtenerPersona(7L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 13), contrato.obtenerContrato(cliente.obtenerPersona(8L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 15), contrato.obtenerContrato(cliente.obtenerPersona(9L))));
        cargo.generarCargo(new Cargo(300F, new Date(124, 2, 15), contrato.obtenerContrato(cliente.obtenerPersona(10L))));

        //AGREGAR PAGO
        PagoDAO pago = new PagoDAO(conexionBD);
        //float costo, String especificaciones, Date fecha, Cargo cargo
        pago.generarPago(new Pago(300f, "mensualidad", new Date(124, 2, 11), cargo.obtenerCargo(contrato.obtenerContrato(cliente.obtenerPersona(1L)))));
        pago.generarPago(new Pago(200f, "mensualidad", new Date(124, 2, 12), cargo.obtenerCargo(contrato.obtenerContrato(cliente.obtenerPersona(6L)))));

        //Consultar atrasados
        System.out.println("------------------------------------------------");
        System.out.println("CLIENTES ATRASADOS");
        List<Cliente> clientes = cliente.obtenerClientesAtrasados();
        for (Cliente a : clientes) {
            System.out.println(a.toString());
        }

        System.out.println("------------------------------------------------");
        System.out.println("CLIENTES A COBRAR EN LA SEMANA");
        List<Cliente> clientesS = cliente.obtenerClientesSemana();
        for (Cliente a : clientesS) {
            System.out.println(a.toString());
        }

    }

}
