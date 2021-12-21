package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;

@WebServlet(name = "SvEditarCliente", urlPatterns = {"/SvEditarCliente"})
public class SvEditarCliente extends HttpServlet {
Controladora control=new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traigo el ID del cliente para ...... sus datos
        int id= Integer.parseInt(request.getParameter("id_cliente"));
        
        Cliente cli= control.traerCliente(id);
        
        HttpSession misession=request.getSession();
        misession.setAttribute("cliente", cli);
        //me envia al apartado LISTA DE CLIENTES
        response.sendRedirect("editarCliente.jsp");
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //PARA EDITAR
        
        //traigo id
        int id=Integer.parseInt(request.getParameter("id_cliente"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String dni=request.getParameter("dni");
        String fecha_nac=request.getParameter("fecha_nac");
        try {
        Date fecha = formato.parse("fecha_nac");
    } catch (ParseException ex) {
        Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
        String direccion=request.getParameter("direccion");
        String nacionalidad=request.getParameter("nacionalidad");
        String celular=request.getParameter("celular");
        String email=request.getParameter("email");
        Date fecha = new Date();
        
        
        Cliente cli=control.traerCliente(id);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDni(dni);
        cli.setFecha_nac(fecha);
        cli.setDireccion(direccion);
        cli.setNacionalidad(nacionalidad);
        cli.setCelular(celular);
        cli.setEmail(email);
        
        control.editarCliente(cli);
        //actualizo la lista de personas de la session
        request.getSession().setAttribute("listaCliente", control.traerCliente());
        response.sendRedirect("principal.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}




















