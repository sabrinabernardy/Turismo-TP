package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;


@WebServlet(name = "SvBuscarCliente", urlPatterns = {"/SvBuscarCliente"})
public class SvBuscarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Controladora control=new Controladora();
        List<Cliente> listaCliente= control.traerCliente();
        HttpSession misession= request.getSession(true);
        misession.setAttribute("listaCliente", listaCliente);
        response.sendRedirect("principal.jsp");        
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
debajo de tbody:
<%HttpSession misession=request.getSession();%>
                List<Cliente> listaCliente=(List) request.getSession().getAttribute("listaCliente");
                for (Cliente cli: listaCliente){%>          
            <tr class="row-body">
                <%String nombreCompleto = cli.getNombre() + " " + cli.getApellido();%>
                <td class="c1"> <%=nombreCompleto %> </td>
                <%String dni = cli.getDni();%>
                <td class="c1"> <%=dni %> </td>
            </tr>
                <%}%>

otra opcionnnnn

<%
        List<Cliente> listaCliente=(List) request.getSession().getAttribute("listaCliente");
        for (Cliente cli: listaCliente){
            String nombreCompleto = cli.getNombre() + " " + cli.getApellido();%>
            <li>item <%=nombreCompleto%>/></li>
      <%}%>





*/

