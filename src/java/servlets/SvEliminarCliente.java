package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvEliminarCliente", urlPatterns = {"/SvEliminarCliente"})
public class SvEliminarCliente extends HttpServlet {
//llamo a la logica
Controladora control=new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo id
        int id_cliente= Integer.parseInt(request.getParameter("id"));
        //la controladora llama a la controlPersis y elimina
        control.eliminarCliente(id_cliente);        
        //actualizo lista de clientes
        request.getSession().setAttribute("listaCliente", control.traerCliente());
        response.sendRedirect("principal.jsp");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
        //traigo id
        int id= Integer.parseInt(request.getParameter("id_cliente_"));
        //la controladora llama a la controlPersis y elimina
        Cliente cli= control.traerCliente(id);
        control.eliminarCliente(id);
        
        //actualizo lista de clientes
        request.getSession().setAttribute("listaCliente", control.traerCliente());
        response.sendRedirect("partedos.jsp");
        */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
