package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Usuario;
import logica.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T20:20:49")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile ListAttribute<Empleado, Venta> lista_ventas;
    public static volatile SingularAttribute<Empleado, Date> fecha_nacE;
    public static volatile SingularAttribute<Empleado, String> direccionE;
    public static volatile SingularAttribute<Empleado, String> dniE;
    public static volatile SingularAttribute<Empleado, Double> sueldo;
    public static volatile SingularAttribute<Empleado, String> celularE;
    public static volatile SingularAttribute<Empleado, String> emailE;
    public static volatile SingularAttribute<Empleado, String> apellidoE;
    public static volatile SingularAttribute<Empleado, Integer> id_emple;
    public static volatile SingularAttribute<Empleado, Usuario> usu;
    public static volatile SingularAttribute<Empleado, String> nombreE;
    public static volatile SingularAttribute<Empleado, String> nacionalidadE;
    public static volatile SingularAttribute<Empleado, String> cargo;

}