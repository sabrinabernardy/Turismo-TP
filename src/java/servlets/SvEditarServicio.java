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
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Servicio;


@WebServlet(name = "SvEditarServicio", urlPatterns = {"/SvEditarServicio"})
public class SvEditarServicio extends HttpServlet {
    Controladora control=new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //traigo el codigo del servicio para redirigirme al editarServicio y poder editar
        int codigo_servicio= Integer.parseInt(request.getParameter("codigo"));
        
        Servicio ser=control.traerServicio(codigo_servicio);
        
        
        HttpSession misession=request.getSession();
        misession.setAttribute("servicio", ser);
        //me envia al apartado para editar el serv
        response.sendRedirect("editarServicio.jsp");
        
      
    }   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //PARA EDITAR
        Date fecha_servicio=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");     
        
        
        //traigo id
        int codigo_servicio=Integer.parseInt(request.getParameter("codigo"));
        String nombre_servicio=request.getParameter("nombre");
        Double costo_servicio= Double.parseDouble(request.getParameter("costo"));
        try {
            fecha_servicio = formato.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String destino=request.getParameter("destino");
        String descripcion=request.getParameter("descripcion");
        
        
        Servicio ser=(Servicio) control.traerServicio(codigo_servicio);
        ser.setNombre_servicio(nombre_servicio);
        ser.setCosto_servicio(costo_servicio);
        ser.setFecha_servicio(fecha_servicio);
        ser.setDestino(destino);
        ser.setDescripcion(descripcion);
        
        control.editarServicio(ser);
        //actualizo la lista de personas de la session
        request.getSession().setAttribute("lista_servicio", control.traerServicio());
        response.sendRedirect("editarServicio.jsp");
        
        
    }

  
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
