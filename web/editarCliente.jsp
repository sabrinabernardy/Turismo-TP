<%-- 
    Document   : editarCliente
    Created on : 19/12/2021, 00:36:21
    Author     : GomezBernardy
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="user-scalable-no, width=device,with">
	<title>Editar cliente</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/crud.js"></script>
    </head><br>
    <body>
                
        <!-- Tab content -->
        <div id="verClientes" class="editar-cliente" name="id">
          <h3>Editar datos del cliente</h3><br>                   
          <form action="SvEditarCliente" method="GET" class="editar">
          <%HttpSession misession=request.getSession();
            Cliente cli=(Cliente) misession.getAttribute("cliente");
            {%>
        
          <label>Nombre: </label> <input type="text" name="nombre" value="<%=cli.getNombre()%>"><br>                    
          <label>Apellido: </label><input type="text" name="apellido" value="<%=cli.getApellido()%>"><br>
          <label>DNI: </label><input type="number" name="dni" value="<%=cli.getDni()%>"><br>
          <label>Fecha de nacimiento:</label><input type="date" name="fecha_nac" value="<%=cli.getFecha_nac()%>"><br>
          <label>Direccion:</label><input type="text" name="direccion" value="<%=cli.getDireccion()%>"><br>
          <label>Nacionalidad: </label><input type="text" name="nacionalidad" value="<%=cli.getNacionalidad()%>"><br>
          <label>Celular: </label><input type="number" name="celular" value="<%=cli.getCelular()%>"><br>
          <label>Email: </label><input type="text" name="email" value="<%=cli.getEmail()%>"><br>
          <div>
            <input type="hidden" name="id_cliente" value="<%=cli.getId_cliente()%>">
          </div>
          <button type="submit" id="crear" class="btn btn-success">Editar datos</button>
          <%}%>
          </form>
          
        </div>

    </body>
</html>
