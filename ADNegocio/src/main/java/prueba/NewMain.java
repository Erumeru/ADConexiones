/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import com.itson.proyecto2_233410_233023.dominio.Cliente;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.mycompany.adnegocio.ClienteDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoshi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ConexionBD conexionBD = new ConexionBD("adconexiones");
        ClienteDAO cliente = new ClienteDAO(conexionBD);
        try {
            List<Cliente> clientes = cliente.obtenerClientesAtrasados();
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
