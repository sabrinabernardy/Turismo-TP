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

@WebServlet(name = "SvVenderServicio", urlPatterns = {"/SvVenderServicio"})
public class SvVenderServicio extends HttpServlet {
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
        
        int codigo_servicio= Integer.parseInt(request.getParameter("new_servicio"));
        Date fecha_servicio=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
               
        String nombre_servicio=request.getParameter("nombre");
        String costo_servicio = request.getParameter("costo");
        try {
            fecha_servicio = formato.parse(request.getParameter("fecha_servicio"));
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String destino=request.getParameter("destino");
        String descripcion=request.getParameter("descripcion");
        
        
        control.venderServicio(codigo_servicio);

        response.sendRedirect("index.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
private int codigo_servicio;
    @Basic
    private String nombre_servicio;
    private double costo_servicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_servicio;
    @Basic
    private String destino;
    private String descripcion;
    @ManyToMany
    private List<Paquete> lista_paquetes;
    @OneToMany
    private List<Venta> lista_ventas_servicios;
*/


//PARA EL JSP
/*
   <select name="select">
      <option name="hotel">Hotel por noche/s</option>
      <option name="auto">Alquiler de auto</option>
      <option name="colectivo">Pasaje de colectivo</option>
      <option name="avion">Pasaje de avión</option>
      <option name="tren">Pasaje de tren</option>
      <option name="excursion">Excursiones</option>
      <option name="eventos">Entradas a Eventos</option>
    </select>
*/