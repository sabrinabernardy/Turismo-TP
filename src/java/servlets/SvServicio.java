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

@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {
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
        
        Date fecha_servicio=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        
        //traigo los atributos del front           
        String codigo_servicio=request.getParameter("codigo");
        String nombre_servicio=request.getParameter("nombre");
        Double costo_servicio=Double.parseDouble(request.getParameter("costo"));
        try {
            fecha_servicio = formato.parse(request.getParameter("fecha_servicio"));
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String destino=request.getParameter("destino");
        String descripcion=request.getParameter("descripcion");
        
        
        //traigo la session y asigno los atributos para todas las sessiones
        request.getSession().setAttribute("nombre", nombre_servicio);
        request.getSession().setAttribute("costo", costo_servicio);
        request.getSession().setAttribute("fecha", fecha_servicio);
        request.getSession().setAttribute("destino", destino);
        request.getSession().setAttribute("descripcion", descripcion);
        
        
        //comunico con la logica
        control.venderServicio(nombre_servicio, costo_servicio, fecha_servicio, destino, descripcion);
       
        
        //redirecciono al inicio
        response.sendRedirect("principal.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
