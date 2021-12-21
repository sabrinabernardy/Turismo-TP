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

@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {
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
        
        Date fecha_vta=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        //traigo atributos del front
        String cliente=request.getParameter("cliente");
        String servicio=request.getParameter("servicio");
        String pago=request.getParameter("pago");
        try{
            fecha_vta= formato.parse((request.getParameter("fecha_vta")));
        } catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        //traigo la session y asigno los atributos para todas las sessiones
        request.getSession().setAttribute("cliente", cliente);
        request.getSession().setAttribute("servicio", servicio);
        request.getSession().setAttribute("pago", pago);
        request.getSession().setAttribute("fecha_vta", fecha_vta);
        
        //comunico con la logica y creo la venta
        control.crearVenta(pago, fecha_vta);
        
        //control.agregarVentaServicio();
       
        
        //redirecciono al inicio
        response.sendRedirect("principal.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
