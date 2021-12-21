package persistencia;


import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.Servicio;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    ClienteJpaController clienteJpa =new ClienteJpaController();
    EmpleadoJpaController empleJpa= new EmpleadoJpaController();
    UsuarioJpaController usuJpa= new UsuarioJpaController();
    VentaJpaController ventaJpa=new VentaJpaController();
    ServicioJpaController servicioJpa=new ServicioJpaController();

    public void crearCliente(Cliente cliente) {
             
        clienteJpa.create(cliente);
             
    }
    

    public void crearServicio(Servicio servicio) {
             
        servicioJpa.create(servicio);
        
                
    }

    public void crearEmpleado(Empleado emple, Usuario usu) {
        
        usuJpa.create(usu);
        empleJpa.create(emple);
        
    }

    public List<Cliente> traerCliente() {
        
        return clienteJpa.findClienteEntities();
       
    }

    public List<Usuario> traerUsuario() {
        
        return usuJpa.findUsuarioEntities();
        
    }

    public List<Empleado> traerEmpleado() {
        
        return empleJpa.findEmpleadoEntities();
    }

    public Cliente traerCliente(int id) {
        
        return clienteJpa.findCliente(id);
    }

    public void editarCliente(Cliente cli) {
        
        try{
            clienteJpa.edit(cli);
        }catch(Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }

    public void eliminarCliente(int id_cliente) {
        
        try{
            clienteJpa.destroy(id_cliente);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }        

    public Empleado traerEmpleado(int id) {
        
        return empleJpa.findEmpleado(id);
        
    }

    public void editarEmpleado(Empleado emple) {
        try{
            empleJpa.edit(emple);
        }catch(Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }

    public void eliminarEmpleado(int id_emple) {
        
        try{
            empleJpa.destroy(id_emple);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }

    public void crearVenta(Venta vta) {
        ventaJpa.create(vta);    
    }

    public Venta traerVenta(int num_venta) {
        
        return ventaJpa.findVenta(num_venta);
    }
    
    public Servicio traerServicio(int codigo_servicio) {
        
        return servicioJpa.findServicio(codigo_servicio);
    }
    
    public List<Servicio> traerServicio() {
        
        return servicioJpa.findServicioEntities();
    }


    public void crearPaquete(List<Servicio> lista_servicios_incluidos, double costo_paquete) {
        
        
    }

    public void editarServicio(Servicio ser) {
        try{
            servicioJpa.edit(ser);
        }catch(Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);

        }  
        
        
    }

    public void eliminarUsuario(int id) {
        try{
            usuJpa.destroy(id);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
            
}
