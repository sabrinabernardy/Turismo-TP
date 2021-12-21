package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis =new ControladoraPersistencia();

    List<Cliente> listaCliente;//declaro lista para guardar los clientes en ella
    
    List<Empleado> listaEmpleado;
    
    
    
    public void crearCliente(String nombre, String apellido, String dni, Date fecha_nac, String direccion, String nacionalidad, String celular, String email) {
        
        Cliente cliente = new Cliente();
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setFecha_nac(fecha_nac);
        cliente.setDireccion(direccion);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        
        listaCliente =new ArrayList<>();
        listaCliente.add(cliente);
        
        controlPersis.crearCliente(cliente);

        
    }
    
    public List<Cliente> traerCliente(){
        return controlPersis.traerCliente();
    }

    public void crearServicio(String nombre_servicio, Date fecha_servicio, String destino, String descrip) {
        //QUITE EL COSTO PERO DEBO SOLUCIONAR ESE PROBLEMA
        //NO ME DA EL ALTA SI COLOCO EL COSTO, QUIZAS SEA UN ERROR DE CASTEO IDK
        Servicio servicio= new Servicio();
        
        servicio.setNombre_servicio(nombre_servicio);
        servicio.setFecha_servicio(fecha_servicio);
        servicio.setDestino(destino);
        servicio.setDescripcion(descrip);
        
        controlPersis.crearServicio(servicio);
                
    }


    public void crearEmpleado(String nombre, String apellido, String dni, Date fecha_nac, String direccion, String nacionalidad, String celular, String email, String cargo, Double sueldo, String usuario, String contrasenia) {
        
        //Inicializo objetos
        Empleado emple=new Empleado();
        Usuario usu= new Usuario();
        
        //asigno valores a empleado
        emple.setNombreE(nombre);
        emple.setApellidoE(apellido);
        emple.setDniE(dni);
        emple.setFecha_nacE(fecha_nac);
        emple.setDireccionE(direccion);
        emple.setNacionalidadE(nacionalidad);
        emple.setCelularE(celular);
        emple.setEmailE(email);
        emple.setCargo(cargo);
        try{
        emple.setSueldo(sueldo);
        }catch(Exception e){
            sueldo=0.0;
        }
        
        //asigno valores a usuario (Creo el usuario)
        usu.setUsuario(usuario);
        usu.setContrasenia(contrasenia);
        
        //Asigno usuario a empleado
        emple.setUsu(usu);
        //DE ESTA MANERA CREO EL OBJETO COMPLETO DE EMPLEADO, ahora llamo a la persis:
        List<Usuario> listaUsuario;
        listaUsuario=new ArrayList<>();
        listaUsuario.add(usu);
                
        controlPersis.crearEmpleado(emple, usu);

    }
    
    public boolean verificarUsuario(String usuario, String contrasenia){
        List<Usuario> listaUsuario=controlPersis.traerUsuario();
        
        if(listaUsuario != null){
            for(Usuario usu: listaUsuario){
                if (usu.getUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)){
                return true;
                }
            }            
        }
        return false;
    }

    public List<Empleado> traerEmpleado() {
        
        return controlPersis.traerEmpleado();
        
    }
    
    public List<Servicio> traerServicio(){
        return controlPersis.traerServicio();
    }
    
    public Servicio traerServicio(int codigo_servicio){
        
        return controlPersis.traerServicio(codigo_servicio);
    }

    public Cliente traerCliente(int id) {
        
        return controlPersis.traerCliente(id);
    }

    public void editarCliente(Cliente cli) {
        
        controlPersis.editarCliente(cli);
    }

    public void eliminarCliente(int id_cliente) {
        
        controlPersis.eliminarCliente(id_cliente);
        
    }

    public Empleado traerEmpleado(int id) {
        
        return controlPersis.traerEmpleado(id);
    }

    public void editarEmpleado(Empleado emple) {
        controlPersis.editarEmpleado(emple);
    }

    public void eliminarEmpleado(int id_emple) {
        controlPersis.eliminarEmpleado(id_emple);        
    }

    public void crearVenta(String pago, Date fecha_vta) {
        
        //Inicializo objetos
        List<Venta> lista_ventas_paquetes;
        List<Venta> lista_ventas_servicios;
        lista_ventas_servicios=new ArrayList<>();
        Venta vta=new Venta();
        
        
        //asigno valores a venta        
        vta.setMedio_pago(pago);
        vta.setFecha_venta(fecha_vta);
        
        //agrego la venta a la lista
        lista_ventas_servicios.add(vta);
        
                
        controlPersis.crearVenta(vta);
    }
    
    public Venta traerVenta(int num_venta) {
        
        return controlPersis.traerVenta(num_venta);
    }

    public void venderServicio(int codigo_servicio) {
        
        
    }

    public void crearServicio(String nombre_servicio, Double costo_servicio, Date fecha_servicio, String destino, String descripcion) {
        
        Servicio servicio = new Servicio();
        
        servicio.setNombre_servicio(nombre_servicio);
        servicio.setCosto_servicio(costo_servicio);
        servicio.setFecha_servicio(fecha_servicio);
        servicio.setDestino(destino);
        servicio.setDescripcion(descripcion);
        
        List<Servicio> lista_servicio;
        lista_servicio=new ArrayList<>();
        lista_servicio.add(servicio);
                
        controlPersis.crearServicio(servicio);

        
    }


    public void crearPaquete(List<Servicio> lista_servicios_incluidos, double costo_paquete) {
        
        controlPersis.crearPaquete(lista_servicios_incluidos, costo_paquete);
    }

    public void venderServicio(String nombre_servicio, Double costo_servicio, Date fecha_servicio, String destino, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarServicio(Servicio ser) {
        controlPersis.editarServicio(ser);
        
    }

    public void eliminarUsuario(int id) {
        
        controlPersis.eliminarUsuario(id);        

        
    }

}
