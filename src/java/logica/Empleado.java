package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Empleado implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_emple;
    @Basic
    private String nombreE;
    private String apellidoE;
    private String dniE;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_nacE;
    @Basic
    private String direccionE;
    private String nacionalidadE;
    private String celularE;
    private String emailE;
    private String cargo;
    private double sueldo;
    @OneToOne
    private Usuario usu;
    @OneToMany
    public List<Venta> lista_ventas;

    public Empleado() {
    }

    public Empleado(int id_emple, String nombreE, String apellidoE, String dniE, Date fecha_nacE, String direccionE, String nacionalidadE, String celularE, String emailE, String cargo, double sueldo, Usuario usu, List<Venta> lista_ventas) {
        this.id_emple = id_emple;
        this.nombreE = nombreE;
        this.apellidoE = apellidoE;
        this.dniE = dniE;
        this.fecha_nacE = fecha_nacE;
        this.direccionE = direccionE;
        this.nacionalidadE = nacionalidadE;
        this.celularE = celularE;
        this.emailE = emailE;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usu = usu;
        this.lista_ventas = lista_ventas;
    }

    public int getId_emple() {
        return id_emple;
    }

    public void setId_emple(int id_emple) {
        this.id_emple = id_emple;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getApellidoE() {
        return apellidoE;
    }

    public void setApellidoE(String apellidoE) {
        this.apellidoE = apellidoE;
    }

    public String getDniE() {
        return dniE;
    }

    public void setDniE(String dniE) {
        this.dniE = dniE;
    }

    public Date getFecha_nacE() {
        return fecha_nacE;
    }

    public void setFecha_nacE(Date fecha_nacE) {
        this.fecha_nacE = fecha_nacE;
    }

    public String getDireccionE() {
        return direccionE;
    }

    public void setDireccionE(String direccionE) {
        this.direccionE = direccionE;
    }

    public String getNacionalidadE() {
        return nacionalidadE;
    }

    public void setNacionalidadE(String nacionalidadE) {
        this.nacionalidadE = nacionalidadE;
    }

    public String getCelularE() {
        return celularE;
    }

    public void setCelularE(String celularE) {
        this.celularE = celularE;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public List<Venta> getLista_ventas() {
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }
    
    

   
    
}
