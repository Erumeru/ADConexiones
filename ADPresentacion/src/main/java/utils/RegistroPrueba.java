/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author diego
 */
public class RegistroPrueba {
     private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fecha;
    private int atraso;
    private double pago;

    public RegistroPrueba(int id, String nombre, String direccion, String telefono, String fecha, int atraso, double pago) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha = fecha;
        this.atraso = atraso;
        this.pago = pago;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public int getAtraso() {
        return atraso;
    }

    public double getPago() {
        return pago;
    }
}
