package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Paquete;
import logica.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T20:20:49")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile ListAttribute<Servicio, Venta> lista_ventas_servicios;
    public static volatile SingularAttribute<Servicio, Date> fecha_servicio;
    public static volatile SingularAttribute<Servicio, String> nombre_servicio;
    public static volatile ListAttribute<Servicio, Paquete> lista_paquetes;
    public static volatile SingularAttribute<Servicio, Double> costo_servicio;
    public static volatile SingularAttribute<Servicio, Integer> codigo_servicio;
    public static volatile SingularAttribute<Servicio, String> destino;

}