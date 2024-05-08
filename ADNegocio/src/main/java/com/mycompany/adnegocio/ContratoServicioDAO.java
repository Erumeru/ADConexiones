/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adnegocio;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.PersistenciaException;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import interfaces.IContratoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author berly
 */
public class ContratoServicioDAO implements IContratoServicio {

    /**
     * Atributo que representa una conexión con la base de datos para realizar
     * consultas, insertar o actualizar.
     */
    private final IConexionBD conexionBD;

    /**
     * Constructor para inicializar la conexión con la base de datos.
     *
     * @param conexionBD conexión con la base de datos.
     */
    public ContratoServicioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public ContratoServicio obtenerContrato(Cliente cliente) throws Exception {
        try {
            // Obtener el ID del cliente
            Long clienteId = cliente.getId();

            // Buscar el contrato asociado al cliente por su ID
            ContratoServicio contratoObtenido = conexionBD.getEM()
                    .createQuery("SELECT c FROM ContratoServicio c WHERE c.cliente.id = :clienteId", ContratoServicio.class)
                    .setParameter("clienteId", clienteId)
                    .getSingleResult();

            // Si no se encuentra el contrato, retornamos null
            if (contratoObtenido == null) {
                return null;
            }

            return contratoObtenido;
        } catch (NoResultException ex) {
            return null; // No se encontró ningún contrato para ese cliente
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar la búsqueda del contrato.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public List<ContratoServicio> obtenerContratos(Cliente cliente) throws Exception {
        List<ContratoServicio> contratos = new ArrayList<>();

        try {
            // Obtener el ID del cliente
            Long clienteId = cliente.getId();

            // Buscar los contratos asociados al cliente por su ID
            contratos = conexionBD.getEM()
                    .createQuery("SELECT c FROM ContratoServicio c WHERE c.cliente.id = :clienteId", ContratoServicio.class)
                    .setParameter("clienteId", clienteId)
                    .getResultList();
        } catch (NoResultException ex) {
            // No se encontraron contratos para ese cliente
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar la búsqueda de los contratos.");
        } finally {
            conexionBD.getEM().clear();
        }

        return contratos;
    }

    @Override
    public Boolean crearContrato(ContratoServicio contrato) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(contrato);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo realizar el contrato.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

}
