package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int num_venta;
    @Basic
    private String medio_pago;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;

    public Venta() {
    }

    public Venta(int num_venta, String medio_pago, Date fecha_venta) {
        this.num_venta = num_venta;
        this.medio_pago = medio_pago;
        this.fecha_venta = fecha_venta;
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    
}
