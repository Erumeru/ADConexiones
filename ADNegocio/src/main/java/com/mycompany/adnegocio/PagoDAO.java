/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adnegocio;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Pago;
import com.itson.proyecto2_233410_233023.implementaciones.PersistenciaException;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import interfaces.IPago;
import javax.persistence.NoResultException;

/**
 *
 * @author berly
 */
public class PagoDAO implements IPago{

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
    public PagoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    @Override
    public Boolean generarPago(Pago pago) throws Exception {
     try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(pago);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar el contrato.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    public Pago obtenerPago(Cargo cargo) throws Exception {
      try {
            // Obtener el ID del cliente
            Long cargoId = cargo.getId();

            // Buscar el contrato asociado al cliente por su ID
            Pago pagoObtenido = conexionBD.getEM()
                    .createQuery("SELECT c FROM Pago c WHERE c.pago.id = :pagoId", Pago.class)
                    .setParameter("cargoIdId", cargoId)
                    .getSingleResult();

            // Si no se encuentra el contrato, retornamos null
            if (pagoObtenido == null) {
                return null;
            }

            return pagoObtenido;
        } catch (NoResultException ex) {
            return null; // No se encontró ningún contrato para ese cliente
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar la búsqueda del pago.");
        } finally {
            conexionBD.getEM().clear();
        }
    }
    
}
