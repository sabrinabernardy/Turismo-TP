package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Empleado;
import logica.Usuario;

@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {
    
    Controladora control=new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //PARA ELIMINAR EMPLEADOS--------------------------------
        int id_emple= Integer.parseInt(request.getParameter("id"));
        /* Codigo para eliminar Usuario sin implementar--------
        Empleado emple=new Empleado();
        emple= control.traerEmpleado(id_emple);
        emple.getUsu();
        Usuario usu=new Usuario();
        int id=usu.getId();
        
        
        control.eliminarUsuario(id);*/
        control.eliminarEmpleado(id_emple);        
        //actualizo lista de clientes----------------------------
        request.getSession().setAttribute("listaEmpleado", control.traerEmpleado());
        response.sendRedirect("principal.jsp");

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
