/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adnegocio;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import interfaces.IClienteDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author berly
 */
public class ClienteDAO implements IClienteDAO {

    /**
     * Atributo que representa una conexión con la base de datos para realizar
     * consultas, insertar o actualizar.
     */
    private final IConexionBD conexionBD;

    /**
     * Método constructor el cual inicializa el atributo conexionBD al valor del
     * parámetro enviado.
     *
     * @param conexionBD conexionBD a iniciar.
     */
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public boolean agregarPersona(Cliente cliente) {
        try {

            conexionBD.getEM().getTransaction().begin();

            conexionBD.getEM().persist(cliente);

            conexionBD.getEM().getTransaction().commit();
            return true;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public boolean insercionMasivaPersonas() {
        try {
            //String nombreCliente, String coloniaCliente, String calleCliente, String numeroCliente, String telefonoCliente
            Cliente c1 = new Cliente("Carmen Hernandez", "Misiones", "Altamira", "123A", "6442738927");
            Cliente c2 = new Cliente("Diego Robles", "Urbi", "Santillana", "122A", "6442733327");
            Cliente c3 = new Cliente("Elmer Arredondo", "Sol", "Yaqui", "129A", "6435763327");
            Cliente c4 = new Cliente("Kim Serrano", "Tobarito", "Santillana", "142A", "6442734027");
            Cliente c5 = new Cliente("Alejandro Uribe", "Rosales", "Ramon", "102", "6441789023");
            Cliente c6 = new Cliente("Patricia Rosas", "Urbi", "5 febrero", "902B", "6441789023");
            Cliente c7 = new Cliente("Jack Eceverria", "Tobarito", "Principal", "702B", "6444586023");
            Cliente c8 = new Cliente("Ambar Baca", "Urbi", "Altamira", "602B", "6441739456");
            Cliente c9 = new Cliente("Daniela Lopez", "Urbi", "5 febrero", "402B", "6445789023");
            Cliente c10 = new Cliente("Karla Silva", "Urbi", "5 febrero", "573B", "64417665023");
            Cliente c11 = new Cliente("Tilina ", "Urbi", "San Ancelmo", "575A", "6441769038");

            conexionBD.getEM().getTransaction().begin();
            List<Cliente> clientes = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11);
            for (Cliente cliente : clientes) {
                conexionBD.getEM().persist(cliente);
            }
            conexionBD.getEM().getTransaction().commit();
            return true;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public Cliente obtenerPersona(Long id) {
        try {
            String consulta = "SELECT p FROM Cliente p WHERE p.id = :id";
            Query query = conexionBD.getEM().createQuery(consulta);
            query.setParameter("id", id);
            Cliente cliete = (Cliente) query.getSingleResult();
            return cliete;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public List<Cliente> obtenerClientesContrato() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        try {
            String consulta = "SELECT DISTINCT cliente FROM ContratoServicio contrato JOIN contrato.cliente cliente";
            Query query = conexionBD.getEM().createQuery(consulta);
            clientes = query.getResultList();
        } catch (NoResultException e) {
            // No se encontraron resultados
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al obtener todos los clientes con contratos: " + e.getMessage());
        }

        return clientes;
    }

    @Override
    public List<Cliente> obtenerClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        try {
            String consulta = "SELECT c FROM Cliente c";
            Query query = conexionBD.getEM().createQuery(consulta);
            clientes = query.getResultList();
        } catch (NoResultException e) {
            // No se encontraron resultados
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al obtener todos los clientes: " + e.getMessage());
        }

        return clientes;
    }

    @Override
    public List<Cliente> obtenerClientesAtrasados() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        try {
            String consulta = "SELECT DISTINCT cliente "
                    + "FROM Cargo c "
                    + "JOIN ContratoServicio contrato ON c.contratoServicio.id = contrato.id "
                    + "JOIN Cliente cliente ON contrato.cliente.id = cliente.id "
                    + "WHERE c.deuda > 0 AND c.fecha < CURRENT_DATE";

            Query query = conexionBD.getEM().createQuery(consulta);
            System.out.println(consulta);
            clientes = query.getResultList();
        } catch (NoResultException e) {
            // No se encontraron resultados
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al obtener clientes con contratos: " + e.getMessage());
        }

        return clientes;
    }

    @Override
    public List<Cliente> obtenerClientesSemana() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

        try {
            LocalDate fechaLimite = LocalDate.now().plusDays(7); // Fecha actual más 7 días

            String consulta = "SELECT DISTINCT cliente "
                    + "FROM Cargo c "
                    + "JOIN ContratoServicio contrato ON c.contratoServicio.id = contrato.id "
                    + "JOIN Cliente cliente ON contrato.cliente.id = cliente.id "
                    + "WHERE c.deuda > 0 "
                    + "AND c.fecha >= CURRENT_DATE "
                    + "AND c.fecha <= :fechaLimite";

            Query query = conexionBD.getEM().createQuery(consulta);
            query.setParameter("fechaLimite", java.sql.Date.valueOf(fechaLimite));

            clientes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al obtener clientes con contratos atrasados: " + e.getMessage());
        }

        return clientes;
    }

    @Override
    public List<Cliente> obtenerClientesPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        try {
            String consulta = "SELECT DISTINCT cliente "
                    + "FROM Cargo c "
                    + "JOIN ContratoServicio contrato ON c.contratoServicio.id = contrato.id "
                    + "JOIN Cliente cliente ON contrato.cliente.id = cliente.id "
                    + "WHERE c.deuda > 0 "
                    + "AND c.fecha BETWEEN :fechaInicio AND :fechaFin";

            Query query = conexionBD.getEM().createQuery(consulta);

            query.setParameter("fechaInicio", java.sql.Date.valueOf(fechaInicio));
            query.setParameter("fechaFin", java.sql.Date.valueOf(fechaFin));
            System.out.println(consulta);
            System.out.println(java.sql.Date.valueOf(fechaInicio) + "AND " + java.sql.Date.valueOf(fechaFin));
            clientes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al obtener clientes por período: " + e.getMessage());
        }

        return clientes;
    }

}
