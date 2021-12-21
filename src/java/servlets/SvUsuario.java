package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {
    
//Hago el llamado a la logica
    Controladora control= new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    //metodo para traer usuario y contraseña de la interfaz grafica
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario=request.getParameter("usuario");
        String contrasenia=request.getParameter("contrasenia");
        
        boolean autorizado= control.verificarUsuario(usuario, contrasenia);
        
        if(autorizado==true){
            //obtengo la sesion y le asigno el usuario y la contraseña para validar
            HttpSession misession= request.getSession(true);
            misession.setAttribute("usuario", usuario);
            misession.setAttribute("contrasenia", contrasenia);
            
            //redirecciono
            response.sendRedirect("principal.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

