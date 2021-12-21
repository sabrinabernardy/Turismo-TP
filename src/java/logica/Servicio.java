package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo_servicio;
    @Basic
    private String nombre_servicio;
    private double costo_servicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_servicio;
    @Basic
    private String destino;
    private String descripcion;
    @ManyToMany
    private List<Paquete> lista_paquetes;
    @OneToMany
    private List<Venta> lista_ventas_servicios;

    public Servicio() {
    }

    public Servicio(int codigo_servicio, String nombre_servicio, double costo_servicio, Date fecha_servicio, String destino, String descripcion, List<Paquete> lista_paquetes, List<Venta> lista_ventas_servicios) {
        this.codigo_servicio = codigo_servicio;
        this.nombre_servicio = nombre_servicio;
        this.costo_servicio = costo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.destino = destino;
        this.descripcion = descripcion;
        this.lista_paquetes = lista_paquetes;
        this.lista_ventas_servicios = lista_ventas_servicios;
    }

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Paquete> getLista_paquetes() {
        return lista_paquetes;
    }

    public void setLista_paquetes(List<Paquete> lista_paquetes) {
        this.lista_paquetes = lista_paquetes;
    }

    public List<Venta> getLista_ventas_servicios() {
        return lista_ventas_servicios;
    }

    public void setLista_ventas_servicios(List<Venta> lista_ventas_servicios) {
        this.lista_ventas_servicios = lista_ventas_servicios;
    }

    void setCosto_servicio(String costo_servicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
