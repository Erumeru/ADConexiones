/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import java.util.List;



/**
 *
 * @author berly
 */
public interface ICargoDAO {

    Boolean generarCargo(Cargo cargo) throws Exception;

    public Cargo obtenerCargo(ContratoServicio contrato) throws Exception;
    public List<Cargo> obtenerCargos(ContratoServicio contrato)throws Exception;
    public List<Cargo> obtenerCargosPorContratoId(Long contratoId) throws Exception;
    public Cargo modificarCargo(Cargo cargoModificado) throws Exception ;
}
