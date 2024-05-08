/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.proyecto2_233410_233023.dominio.Plan;
import java.util.List;

/**
 *
 * @author berly
 */
public interface IPlanDAO {
    Boolean insertarPlan(Plan plan) throws Exception;
     public List<Plan> obtenerTodos() throws Exception;
}
