package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Servicio;
import logica.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T20:20:49")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, Double> costo_paquete;
    public static volatile SingularAttribute<Paquete, Integer> codigo_paquete;
    public static volatile ListAttribute<Paquete, Servicio> lista_servicios_incluidos;
    public static volatile ListAttribute<Paquete, Venta> lista_ventas_paquetes;

}