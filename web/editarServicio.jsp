<%-- 
    Document   : editarServicio
    Created on : 20/12/2021, 17:06:54
    Author     : GomezBernardy
--%>

<%@page import="logica.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="user-scalable-no, width=device,with">
	<title>Editar servicio</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/crud.js"></script>
    </head><br>
    <body>
                
        <!-- Tab content -->
        <div id="verClientes" class="editar-cliente" name="id">
          <h3>Editar datos del servicio</h3><br>                   
          <form action="SvEditarServicio" method="GET" class="editar">
          <%
            HttpSession misession=request.getSession();
            Servicio ser=(Servicio) misession.getAttribute("codigo");
            {%>
        
          <label>Nombre: </label> <input type="text" name="nombre" value="<%=ser.getNombre_servicio()%>"><br>                    
          <label>Precio: </label><input type="number" name="costo" value="<%=ser.getCosto_servicio()%>"><br>
          <label>Fecha de nacimiento:</label><input type="date" name="fecha" value="<%=ser.getFecha_servicio()%>"><br>
          <label>Destino</label><input type="text" name="destino" value="<%=ser.getDestino()%>"><br>
          <label>Descripcion </label><input type="text" name="descripcion" value="<%=ser.getDescripcion()%>"><br>
          <div>
            <input type="hidden" name="codigo" value="<%=ser.getCodigo_servicio()%>">
          </div>
          <button type="submit" id="crear" class="btn btn-success">Editar datos</button>
          <%}%>
          </form>
          
        </div>

    </body>
</html>
