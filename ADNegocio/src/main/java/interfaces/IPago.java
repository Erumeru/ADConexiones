/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.proyecto2_233410_233023.dominio.Cargo;
import com.itson.proyecto2_233410_233023.dominio.Pago;

/**
 *
 * @author berly
 */
public interface IPago {

    Boolean generarPago(Pago pago) throws Exception;

    public Pago obtenerPago(Cargo cargo) throws Exception;

}
