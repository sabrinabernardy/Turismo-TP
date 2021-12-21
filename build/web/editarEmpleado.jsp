<%-- 
    Document   : editarEmpleado
    Created on : 19/12/2021, 22:15:23
    Author     : GomezBernardy
--%>

<%@page import="logica.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="user-scalable-no, width=device,with">
	<title>Editar Empleado</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/crud.js"></script>
    </head><br>
    <body>
                
        <!-- Tab content -->
        <div id="verClientes" class="editar-cliente" name="id">
          <h3>Editar datos del empleado</h3><br>                   
          <form action="SvEditarEmpleado" method="GET" class="editar">
          <% HttpSession misession=request.getSession();
             Empleado emple=(Empleado) misession.getAttribute("empleado");
            {%>
          <label>Nombre: </label> <input type="text" name="nombre" value="<%=emple.getNombreE()%>"><br>                    
          <label>Apellido: </label><input type="text" name="apellido" value="<%=emple.getApellidoE()%>"><br>
          <label>DNI: </label><input type="number" name="dni" value="<%=emple.getDniE()%>"><br>
          <label>Fecha de nacimiento:</label><input type="date" name="fecha_nac" value="<%=emple.getFecha_nacE()%>"><br>
          <label>Direccion:</label><input type="text" name="direccion" value="<%=emple.getDireccionE()%>"><br>
          <label>Nacionalidad: </label><input type="text" name="nacionalidad" value="<%=emple.getNacionalidadE()%>"><br>
          <label>Celular: </label><input type="number" name="celular" value="<%=emple.getCelularE()%>"><br>
          <label>Email: </label><input type="text" name="email" value="<%=emple.getEmailE()%>"><br>
          <label>Cargo: </label><input type="text" name="cargo" value="<%=emple.getCargo()%>"><br>
          <div>
            <input type="hidden" name="id_emple" value="<%=emple.getId_emple()%>">
          </div>
          <button type="submit" id="crear" class="btn btn-success">Editar datos</button>
          <%}%>
          </form>
          
        </div>
    </body>
</html>
