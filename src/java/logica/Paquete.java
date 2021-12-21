package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Paquete implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo_paquete;
    @Basic
    private double costo_paquete;
    @ManyToMany
    private List<Servicio> lista_servicios_incluidos;
    @OneToMany
    private List<Venta> lista_ventas_paquetes;

    public Paquete() {
    }

    public Paquete(int codigo_paquete, double costo_paquete, List<Servicio> lista_servicios_incluidos, List<Venta> lista_ventas_paquetes) {
        this.codigo_paquete = codigo_paquete;
        this.costo_paquete = costo_paquete;
        this.lista_servicios_incluidos = lista_servicios_incluidos;
        this.lista_ventas_paquetes = lista_ventas_paquetes;
    }
    
     public Paquete(int codigo_paquete, double costo_paquete, List<Servicio> lista_servicios_incluidos) {
        this.codigo_paquete = codigo_paquete;
        this.costo_paquete = costo_paquete;
        this.lista_servicios_incluidos = lista_servicios_incluidos;
    }

    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public List<Servicio> getLista_servicios_incluidos() {
        return lista_servicios_incluidos;
    }

    public void setLista_servicios_incluidos(List<Servicio> lista_servicios_incluidos) {
        this.lista_servicios_incluidos = lista_servicios_incluidos;
    }

    public List<Venta> getLista_ventas_paquetes() {
        return lista_ventas_paquetes;
    }

    public void setLista_ventas_paquetes(List<Venta> lista_ventas_paquetes) {
        this.lista_ventas_paquetes = lista_ventas_paquetes;
    }
    
    

    

    
}
