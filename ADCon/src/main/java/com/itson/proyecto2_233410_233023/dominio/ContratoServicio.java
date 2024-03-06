package com.itson.proyecto2_233410_233023.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ContratoServicio")
public class ContratoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MontoPagar", nullable = false)
    private float montoPagar;

    @Column(name = "DiaAPagar", nullable = false)
    private int diaAPagar;

    @ManyToMany
    @JoinTable(
        name = "ContratoServicio_ProductoCliente",
        joinColumns = @JoinColumn(name = "contrato_servicio_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_cliente_id")
    )
    private List<ProductoCliente> productosClientes;

    public List<ProductoCliente> getProductosClientes() {
        return productosClientes;
    }

    public void setProductosClientes(List<ProductoCliente> productosClientes) {
        this.productosClientes = productosClientes;
    }
    
    
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @OneToMany(mappedBy = "contratoServicio", cascade = CascadeType.ALL)
    private List<Cita> citas;

    @OneToMany(mappedBy = "contratoServicio", cascade = CascadeType.ALL)
    private List<Cargo> cargos;

    

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    // Constructores, getters y setters
    public ContratoServicio() {
        // Constructor por defecto necesario para JPA
    }

   
   
   
    

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(float montoPagar) {
        this.montoPagar = montoPagar;
    }

    public int getDiaAPagar() {
        return diaAPagar;
    }

    public void setDiaAPagar(int diaAPagar) {
        this.diaAPagar = diaAPagar;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public ContratoServicio(Long id, float montoPagar, int diaAPagar, List<ProductoCliente> productosClientes, Plan plan, List<Cita> citas, List<Cargo> cargos, Cliente cliente) {
        this.id = id;
        this.montoPagar = montoPagar;
        this.diaAPagar = diaAPagar;
        this.productosClientes = productosClientes;
        this.plan = plan;
        this.citas = citas;
        this.cargos = cargos;
        this.cliente = cliente;
    }

    public ContratoServicio(float montoPagar, int diaAPagar, List<ProductoCliente> productosClientes, Plan plan, List<Cita> citas, List<Cargo> cargos, Cliente cliente) {
        this.montoPagar = montoPagar;
        this.diaAPagar = diaAPagar;
        this.productosClientes = productosClientes;
        this.plan = plan;
        this.citas = citas;
        this.cargos = cargos;
        this.cliente = cliente;
    }


}
