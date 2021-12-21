package servlets;

import java.io.IOException;
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
import logica.Controladora;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
Controladora control= new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    //METODO DO GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    //METODO DO POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date fecha_nac=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");     
        
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String dni= request.getParameter("dni");
        try {
            fecha_nac = formato.parse(request.getParameter("fecha_nac"));
         } catch (ParseException ex) {
        Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
         }
        String direccion= request.getParameter("direccion");
        String nacionalidad= request.getParameter("nacionalidad");
        String celular= request.getParameter("celular");
        String email= request.getParameter("email");
        String cargo= request.getParameter("cargo");
        Double sueldo= Double.parseDouble(request.getParameter("sueldo"));
   
        String usuario= request.getParameter("usuario");
        String contrasenia= request.getParameter("contra");
        
        //seteo la session
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fecha_nac", fecha_nac);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("nacionalidad", nacionalidad);
        request.getSession().setAttribute("celular", celular);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("cargo", cargo);
        request.getSession().setAttribute("sueldo", sueldo);
        request.getSession().setAttribute("usuario", usuario);
        request.getSession().setAttribute("contrasenia", contrasenia);
        
        
        control.crearEmpleado(nombre, apellido, dni, fecha_nac, direccion, nacionalidad, celular, email, cargo, sueldo, usuario, contrasenia);

        response.sendRedirect("principal.jsp");
   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
