<%-- 
    Document   : partedos
    Created on : 19/12/2021, 11:44:33
    Author     : GomezBernardy
--%>

<%@page import="java.util.Date"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BACK UP SECCION CLIENTES</title>
    </head>
    <body>
        
        <h3>CLIENTES </h3>
<!-- Tab links -->
<div class="tab">
  <button class="tablinks" onclick="openAction(event, 'agregarCliente')">Nuevo Cliente</button>  
  <button class="tablinks" onclick="openAction(event, 'verCliente')">Clientes</button>
</div>

<!-- Tab content -->
<div id="agregarCliente" class="tabcontent">
  <h3>Nuevo Cliente</h3>
  <form action="SvCliente" method="POST">
  <p><label>Nombre: </label><input type="text" name="nombre"></p>
  <p><label>Apellido </label><input type="text" name="apellido"></p>
  <p><label>DNI </label><input type="number" name="dni"></p>
  <p><label>Fecha de nacimiento: </label><input type="text" name="fecha_nac"></p>
  <p><label>Direccion: </label><input type="text" name="direccion"></p>
  <p><label>Nacionalidad: </label><input type="text" name="nacionalidad"></p>
  <p><label>Celular: </label><input type="number" name="celular"></p>
  <p><label>Email: </label><input type="text" name="email"></p>
  <button type="submit" id="crear" class="btn btn-success">Crear</button>
  </form>
</div>

<!--//VER/EDITAR/ELIMINAR CLIENTEEEEEEEEEEE--------------->
<div id="verCliente" class="tabcontent">
  <h3> Clientes</h3>
  <form action="SvBuscarCliente" method="POST">
    <div class="container">
        <table>
            <thead>
                <tr>       
                    <th id="h-table">ID</th>
                    <th id="h-table">Nombre</th>
                    <th id="h-table">Apellido</th>
                    <th id="h-table">DNI</th>
                    <th id="h-table">Fecha Nacimiento</th>
                    <th id="h-table">Direccion</th>
                    <th id="h-table">Nacionalidad</th>
                    <th id="h-table">Celular</th>
                    <th id="h-table">Email</th>
                    <th class="1">MODIFICAR</th>
                    <th class="1">QUITAR Si/No</th>
                </tr>
            </thead>
            <tbody id="clientes-datos">
                <%  Controladora control=new Controladora();
                    for (Cliente cli: control.traerCliente()) {%>                  
                    <tr id="filas">
                        <%int id= cli.getId_cliente();%>
                        <td class="c2" name="id_cliente"> <%=id%></td>                        
                        <%String nombre= cli.getNombre();%>
                        <td class="c1" name="nombre"> <%=nombre%></td>                                                
                        <%String apellido= cli.getApellido();%>
                        <td class="c1" name="apellido"> <%=apellido%></td>
                        <%String dni= cli.getDni();%>
                        <td class="c2" name="dni"> <%=dni%></td>
                        <%Date fecha_nac= cli.getFecha_nac();%>
                        <td class="c3" name="fecha_nac"> <%=fecha_nac%></td>
                        <%String direccion= cli.getDireccion();%>
                        <td class="c4" name="direccion"> <%=direccion%></td>
                        <%String nacionalidad= cli.getNacionalidad();%>
                        <td class="c5" name="nacionalidad"> <%=nacionalidad%></td>
                        <%String celular= cli.getCelular();%>
                        <td class="c6" name="celular"> <%=celular%></td>
                        <%String email= cli.getEmail();%>
                        <td class="c7" name="email"> <%=email%></td>  
                        <td>
                            <form action="SvEditarCliente" method="POST">                           
                            <input type="hidden" name="id_cliente" value="<%=id%>">
                            <button type="submit" class="btn btn-primary" data-title="Edit"> Editar</button>
                            </form>
                        </td>
                        <td>
                            <form>
                            <form action="SvEliminarCliente" method="POST">
                                <input type="hidden" name="id_cliente" value="<%=id%>">
                                <button type="submit" class="btn btn-danger" data-title="Delete"> Eliminar</button>
                            </form>                      
                        </td>
                    </tr>
               <%}%> 
            </tbody>
        </table>
    </div>
   </form>
</div>

    </body>
</html>

<div>
         <%// List<Servicio> lista_servicios; %> 
         <%//lista_servicios = new ArrayList<>();%> 
         <% //for( Servicio servicio : lista_servicios){ %>

            <p> <%//= servicio.getNombre_servicio() %> </p>

        <%// }%>
</div>
