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
import logica.Controladora;
import logica.Empleado;

@WebServlet(name = "SvEditarEmpleado", urlPatterns = {"/SvEditarEmpleado"})
public class SvEditarEmpleado extends HttpServlet {
//llamo a la logica
Controladora control=new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo el ID del EMPLEADO para .... sus datos
        int id= Integer.parseInt(request.getParameter("id_emple"));
        
        Empleado emple= control.traerEmpleado(id);
        
        HttpSession misession=request.getSession();
        misession.setAttribute("empleado", emple);
        
        //redirecciona al panel principal
        response.sendRedirect("editarEmpleado.jsp");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date fecha_nac=new Date();
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //PARA EDITAR
        
        //traigo id
        int id=Integer.parseInt(request.getParameter("id_emple"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String dni=request.getParameter("dni");
        try {
         fecha_nac = formato.parse(request.getParameter("fecha_nac"));
        } catch (ParseException ex) {
        Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        String direccion=request.getParameter("direccion");
        String nacionalidad=request.getParameter("nacionalidad");
        String celular=request.getParameter("celular");
        String email=request.getParameter("email");
        String cargo=request.getParameter("cargo");
        
        
        Empleado emple=control.traerEmpleado(id);
        emple.setNombreE(nombre);
        emple.setApellidoE(apellido);
        emple.setDniE(dni);
        emple.setFecha_nacE(fecha_nac);
        emple.setDireccionE(direccion);
        emple.setNacionalidadE(nacionalidad);
        emple.setCelularE(celular);
        emple.setEmailE(email);
        emple.setCargo(cargo);
        
        control.editarEmpleado(emple);
        //actualizo la lista de personas de la session
        request.getSession().setAttribute("listaEmpleado", control.traerEmpleado());
        response.sendRedirect("principal.jsp");
        
        
        
        
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
