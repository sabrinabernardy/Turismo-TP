package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Servicio;

@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {
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
        //obtengo los datos del front
        String[] codigos_seleccionados=request.getParameterValues("seleccion");
        
        //creo lista para almacenar los codigos de servicios
        
        List<Servicio> lista_servicios_incluidos;
        lista_servicios_incluidos =new ArrayList<>();
        
        double costo_servicio=1;
        double costo_paquete=1;
        for (String cod: codigos_seleccionados){
            int codigo_servicio=Integer.parseInt(cod);
            
            //busco el codigo dentro de mis servicios ya creados
            //Servicio servicio = (Servicio) control.traerServicio(codigo_servicio);
            
            //lista_servicios_incluidos.add(codigo_servicio);
            
        }
        
        
        
        
        request.getSession().setAttribute("codigos_seleccionados", lista_servicios_incluidos);
        //request.getSession().setAttribute("costo_paquete", costo_paquete);

        
        
        control.crearPaquete(lista_servicios_incluidos, costo_paquete);
        
        response.sendRedirect("principal.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
