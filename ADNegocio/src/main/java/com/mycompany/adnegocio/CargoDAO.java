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

}
