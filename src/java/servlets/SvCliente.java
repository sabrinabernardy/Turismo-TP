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

@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {
Controladora control=new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Date fecha_nac=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        
        //traigo los atributos del front           
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String dni=request.getParameter("dni");        
        try {
            fecha_nac = formato.parse(request.getParameter("fecha_nac"));
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String direccion=request.getParameter("direccion");
        String nacionalidad=request.getParameter("nacionalidad");
        String celular=request.getParameter("celular");
        String email=request.getParameter("email");  
        
        
        //traigo la session y asigno los atributos para todas las sessiones
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fecha_nac", fecha_nac);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("nacionalidad", nacionalidad);
        request.getSession().setAttribute("celular", celular);
        request.getSession().setAttribute("email", email);
        
        
        //comunico con la logica
        control.crearCliente(nombre, apellido, dni, fecha_nac, direccion, nacionalidad, celular, email);
       
        
        //redirecciono al inicio
        response.sendRedirect("principal.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
 

/*
¿Cómo convertir de Date a String?

SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
String fechaComoCadena = sdf.format(acá va el date que tengan);


¿Cómo convertir de String a Date?

SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
Date fecha = formato.parse("23/11/2015");
*/