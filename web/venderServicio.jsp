<%-- 
    Document   : venderServicio
    Created on : 20/12/2021, 15:48:37
    Author     : GomezBernardy
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Servicio"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="user-scalable-no, width=device,with">
	<title>Venta de servicio</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/crud.js"></script>
    </head>
    <body>
        <h3>Vender Servicio </h3>
        <!-- Tab content -->
        <div id="venderServicio" class="tabcontent">
          <h3>Nueva venta</h3>
          <% 
              HttpSession misession=request.getSession();
            Controladora control=new Controladora();
            //List<Servicio> listaServicio=control.traerServicio(request.getAttribute(<%=id%>));%>
          <form action="SvServicio" method="POST">              
          <%for (Servicio ser: listaServicio){%> 
              
          <p><label>Servicio seleccionado: </label>
          <p><label>Nombre: </label><input type="text" name="nombre"></p>
          <p><label>Apellido </label><input type="text" name="apellido"></p>
          <p><label>DNI </label><input type="number" name="dni"></p>
          <p><label>Fecha de nacimiento: </label><input type="date" name="fecha_nac"></p>
          <p><label>Direccion: </label><input type="text" name="direccion"></p>
          <p><label>Nacionalidad: </label><input type="text" name="nacionalidad"></p>
          <p><label>Celular: </label><input type="number" name="celular"></p>
          <p><label>Email: </label><input type="text" name="email"></p>
          <button type="submit" id="crear" class="btn btn-success">Crear</button>
          <%}%>
          </form>
        </div>
    </body>
</html>
