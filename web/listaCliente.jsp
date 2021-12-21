<%-- 
    Document   : buscarCliente
    Created on : 18/12/2021, 13:13:35
    Author     : GomezBernardy
--%>

<%@page import="java.util.Date"%>
<%@page import="logica.Controladora"%>
<%@page import="java.util.Iterator"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="user-scalable-no, width=device,with">
    <title>Visualización de clientes</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/estilos.css">

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/crud.js"></script>
</head>
<body>
    <h3>LISTA DE CLIENTES </h3>
       
    <form action="SvBuscarCliente" method="GET">
        <%HttpSession misession=request.getSession();%>
    <br>
    <div class="container">
        <div class="table-responsive">
            <table id="verCliente">
            <thead>
                <tr>
                    <th id="h-table">Nombre</th>
                    <th id="h-table">DNI</th>
                    <th id="h-table">Fecha Nacimiento</th>
                    <th id="h-table">Direccion</th>
                    <th id="h-table">Nacionalidad</th>
                    <th id="h-table">Celular</th>
                    <th id="h-table">Email</th>
                    <th id="h-table">MODIFICAR</th>
                    <th id="h-table">ELIMINAR</th>
                </tr>
            </thead>
            <tbody id="clientes-datos">
                <%
                Controladora control=new Controladora();
                    for (Cliente cli: control.traerCliente()) {%>
                    <tr id="fila">
                        <%int id= cli.getId_cliente();%>
                        <td class="c2"> <%=id%></td>
                        <%String nombreCompleto= cli.getNombre()+" "+cli.getApellido();%>
                        <td class="c1"> <%=nombreCompleto%></td>
                        <%String dni= cli.getDni();%>
                        <td class="c2"> <%=dni%></td>
                        <%Date fecha_nac= cli.getFecha_nac();%>
                        <td class="c3"> <%=fecha_nac%></td>
                        <%String direccion= cli.getDireccion();%>
                        <td class="c4"> <%=direccion%></td>
                        <%String nacionalidad= cli.getNacionalidad();%>
                        <td class="c5"> <%=nacionalidad%></td>
                        <%String celular= cli.getCelular();%>
                        <td class="c6"> <%=celular%></td>
                        <%String email= cli.getEmail();%>
                        <td class="c7"> <%=email%></td>
                        <td>
                            <form name="frmEditarCliente" action="SvEditarCliente" method="POST" style="display:inline">                           
                            <input type="hidden" name="id" value="<%=id%>">
                            <button type="submit" class="btn btn-primary" data-title="Edit" style="display:inline">Editar</button>
                            </form>
                        </td>
                        <td>
                            <form>                           
                            <form name="frmBorrarCliente" action="SvEliminarCliente" method="POST" style="display:inline">                           
                            <input type="hidden" name="id" value="<%=id%>">
                            <button type="submit" class="btn btn-danger" data-title="Delete" style="display:inline">Eliminar</button>
                            </form>                            
                        </td>
                            
               <%}%>

            </tbody>
            </table>
            </form>

            <button type="submit" id="crear" class="btn btn-success"><a href="principal.jsp"> INICIO</a></button>
        </div>
    </div>
</body>
</html>
    