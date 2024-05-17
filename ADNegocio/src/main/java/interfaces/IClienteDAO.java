/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author berly
 */
public interface IClienteDAO {

    /**
     * Método para realizar la inserción masiva de 10 clientes a la base de
     * datos.
     *
     * @return Valor booleano.
     */
    boolean insercionMasivaPersonas();
    public boolean agregarPersona(Cliente cliente);
    public Cliente obtenerPersona(Long id);
    public List<Cliente> obtenerClientes() throws SQLException;
    public List<Cliente> obtenerClientesContrato() throws SQLException;
    public List<Cliente> obtenerClientesAtrasados() throws SQLException;

    public List<Cliente> obtenerClientesSemana() throws SQLException;
    public List<Cliente> obtenerClientesContratoCargos() throws SQLException;
    public List<Cliente> obtenerClientesPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException;

}
