/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.dominio.ContratoServicio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author berly
 */
public interface IContratoServicio {

    Boolean crearContrato(ContratoServicio contrato) throws Exception;
    public ContratoServicio obtenerContrato(Cliente cliente) throws Exception;
    public List<ContratoServicio> obtenerContrato() throws SQLException;
    public List<ContratoServicio> obtenerContratos(Cliente cliente)throws Exception;
    public ContratoServicio obtenerContrato(Long contratoId) throws Exception ;
    public Boolean actualizarContrato(ContratoServicio contrato) throws Exception;
}
