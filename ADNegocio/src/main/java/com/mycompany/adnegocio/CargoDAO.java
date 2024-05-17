/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adnegocio;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import com.itson.proyecto2_233410_233023.implementaciones.PersistenciaException;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import interfaces.ICargoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author berly
 */
public class CargoDAO implements ICargoDAO {

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
    public CargoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Boolean generarCargo(Cargo cargo) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(cargo);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar el contrato.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public Cargo obtenerCargo(ContratoServicio contrato) throws Exception {
        try {
            // Obtener el ID del contrato
            Long contratoId = contrato.getId();

            // Buscar el cargo asociado al contrato por su ID
            Cargo cargoObtenido = conexionBD.getEM()
                    .createQuery("SELECT c FROM Cargo c WHERE c.contratoServicio.id = :contratoId", Cargo.class)
                    .setParameter("contratoId", contratoId)
                    .getSingleResult();

            // Si no se encuentra el cargo, retornamos null
            if (cargoObtenido == null) {
                return null;
            }

            return cargoObtenido;
        } catch (NoResultException ex) {
            return null; // No se encontró ningún cargo para ese contrato
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo realizar la búsqueda del cargo.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public List<Cargo> obtenerCargos(ContratoServicio contrato) throws Exception {
        List<Cargo> cargos = new ArrayList<>();

        try {
            // Obtener el ID del contrato
            Long contratoId = contrato.getId();

            // Buscar los cargos asociados al contrato por su ID
            cargos = conexionBD.getEM()
                    .createQuery("SELECT c FROM Cargo c WHERE c.contratoServicio.id = :contratoId", Cargo.class)
                    .setParameter("contratoId", contratoId)
                    .getResultList();

            return cargos;
        } catch (NoResultException ex) {
            return new ArrayList<>(); // No se encontró ningún cargo para ese contrato
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo realizar la búsqueda de los cargos.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public List<Cargo> obtenerCargosPorContratoId(Long contratoId) throws Exception {
        List<Cargo> cargos = new ArrayList<>();

        try {
            // Buscar los cargos asociados al contrato por su ID
            cargos = conexionBD.getEM()
                    .createQuery("SELECT c FROM Cargo c WHERE c.contratoServicio.id = :contratoId", Cargo.class)
                    .setParameter("contratoId", contratoId)
                    .getResultList();

            return cargos;
        } catch (NoResultException ex) {
            return new ArrayList<>(); // No se encontró ningún cargo para ese contrato
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo realizar la búsqueda de los cargos.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public Cargo modificarCargo(Cargo cargoModificado) throws Exception {
        EntityManager em = conexionBD.getEM();

        try {
            // Iniciar una transacción
            em.getTransaction().begin();

            // Hacer el merge del cargo modificado
            Cargo cargoActualizado = em.merge(cargoModificado);

            // Finalizar la transacción
            em.getTransaction().commit();

            return cargoActualizado;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo realizar la modificación del cargo.");
        } finally {
            em.clear();
        }
    }

}
