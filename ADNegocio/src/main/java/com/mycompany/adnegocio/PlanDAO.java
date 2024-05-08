/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adnegocio;

import com.itson.proyecto2_233410_233023.dominio.Plan;
import com.itson.proyecto2_233410_233023.implementaciones.PersistenciaException;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import interfaces.IPlanDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author berly
 */
public class PlanDAO implements IPlanDAO {

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
    public PlanDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Boolean insertarPlan(Plan plan) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(plan);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo agregar este plan");
        } finally {
            conexionBD.getEM().clear();
        }
    }
    @Override
    public List<Plan> obtenerTodos() throws Exception {
        try {
            EntityManager entityManager = conexionBD.getEM();

            // Crear y ejecutar la consulta para obtener todos los planes
            Query query = entityManager.createQuery("SELECT p FROM Plan p");
            List<Plan> planes = query.getResultList();
            
            return planes;
        } catch (NoResultException ex) {
            // Manejar el caso cuando no se encuentran resultados
            return null;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al obtener todos los planes: " + ex.getMessage());
        }
    }

}
