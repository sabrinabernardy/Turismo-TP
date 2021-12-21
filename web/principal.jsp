<%@page import="logica.Venta"%>
<%@page import="logica.Empleado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logica.Servicio"%>
<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="user-scalable-no, width=device,with">
	<title>INICIO</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/crud.js"></script>

</head>
<body>
    <!-- CODIGO PARA VALIDAR USUARIOS AL INICIO  ----------------------------------------------------------------------------------------->
    <%  HttpSession misession =request.getSession();
        String usuario = (String) misession.getAttribute("usuario");
            if(usuario == null){
                response.sendRedirect("index.jsp");                                
            }
            else
            {
    %>
    
	<h1>SISTEMA DE GESTIÓN TODOTURISMO</h1>

<BR/>

<!-- ////////////////// CLIENTES /////////////////////// CLIENTES ///////////// CLIENTES!///////////////////// CILENTES //////////////////////////// -->

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
  <p><label>Fecha de nacimiento: </label><input type="date" name="fecha_nac"></p>
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
                    <th id="h-table"> Apellido</th>
                    <th id="h-table">DNI</th>
                    <th id="h-table">Fecha Nacimiento</th>
                    <th id="h-table">Direccion</th>
                    <th id="h-table">Nacionalidad</th>
                    <th id="h-table">Celular</th>
                    <th id="h-table">Email</th>
                    <th class="1">MODIFICAR</th>
                    <th class="1">ELIMINAR</th>
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
                        <td class="c3" name="fecha_nac" type="date"> <%=fecha_nac%></td>
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
                            <form action="SvEliminarCliente" method="POST">
                                <input type="hidden" name="id" value="<%=id%>">
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

<br/>
<!-- ////////////////// EMPLEADOS /////////////////////// EMPLEADOS ///////////// EMPLEADOS!///////////////////// EMPLEADOS //////////////////////////// -->   

<h3>EMPLEADOS </h3>
        <!-- Tab links -->
<div class="tab">
          <button class="tablinks" onclick="openAction(event, 'agregarEmpleado')">Nuevo Empleado</button>
          <button class="tablinks" onclick="openAction(event, 'buscarEmpleado')">Empleados</button>
</div>

        <!-- Tab content -->
<div id="agregarEmpleado" class="tabcontent">
          <h3>Nuevo Empleado</h3>
          <form action="SvEmpleado" method="POST">
          <p><label>Nombre: </label><input type="text" name="nombre"></p>
          <p><label>Apellido </label><input type="text" name="apellido"></p>
          <p><label>DNI </label><input type="number" name="dni"></p>
          <p><label>Fecha de nacimiento: </label><input type="date" name="fecha_nac"></p>
          <p><label>Direccion: </label><input type="text" name="direccion"></p>
          <p><label>Nacionalidad: </label><input type="text" name="nacionalidad"></p>
          <p><label>Celular: </label><input type="number" name="celular"></p>
          <p><label>Email: </label><input type="text" name="email"></p>
          <p><label>Cargo </label><input type="text" name="cargo"></p>
          <p><label>Sueldo: </label><input type="number" value="0.0" name="sueldo"></p>
          <p><label>Nombre de usuario: </label><input type="text" name="usuario"></p>
          <p><label>Contraseña: </label><input type="password" name="contra"></p>

          <button type="submit" id="crear" class="btn btn-success">Crear</button>
          </form>
</div>

<div id="buscarEmpleado" class="tabcontent">
    <form action="SvBuscarEmpleado" method="GET">
    <div class="container">
        <table>
            <thead>
                <tr>       
                    <th id="h-table">ID</th>
                    <th id="h-table">Nombre</th>
                    <th id="h-table"> Apellido</th>
                    <th id="h-table">DNI</th>
                    <th id="h-table">Fecha Nacimiento</th>
                    <th id="h-table">Direccion</th>
                    <th id="h-table">Nacionalidad</th>
                    <th id="h-table">Celular</th>
                    <th id="h-table">Email</th>
                    <th id="h-table">Cargo</th>
                    <th class="1">MODIFICAR</th>
                    <th class="1">ELIMINAR</th>
                </tr>
            </thead>
            <tbody id="clientes-datos">
                <%  
                    for (Empleado emple: control.traerEmpleado()) {%>                  
                    <tr id="filas">
                        <%int id= emple.getId_emple();%>
                        <td class="c2" name="id_cliente"> <%=id%></td>                        
                        <%String nombre= emple.getNombreE();%>
                        <td class="c1" name="nombre"> <%=nombre%></td>                                                
                        <%String apellido= emple.getApellidoE();%>
                        <td class="c1" name="apellido"> <%=apellido%></td>
                        <%String dni= emple.getDniE();%>
                        <td class="c2" name="dni"> <%=dni%></td>
                        <%Date fecha_nac= emple.getFecha_nacE();%>
                        <td class="c3" name="fecha_nac" type="date"> <%=fecha_nac%></td>
                        <%String direccion= emple.getDireccionE();%>
                        <td class="c4" name="direccion"> <%=direccion%></td>
                        <%String nacionalidad= emple.getNacionalidadE();%>
                        <td class="c5" name="nacionalidad"> <%=nacionalidad%></td>
                        <%String celular= emple.getCelularE();%>
                        <td class="c6" name="celular"> <%=celular%></td>
                        <%String email= emple.getEmailE();%>
                        <td class="c7" name="email"> <%=email%></td>
                        <%String cargo= emple.getCargo();%>
                        <td class="c6" name="celular"> <%=celular%></td>
                        <td>
                            <form action="SvEditarEmpleado" method="POST">                           
                               <input type="hidden" name="id_emple" value="<%=id%>">
                               <button type="submit" class="btn btn-primary" data-title="Edit"> Editar</button>
                            </form>
                        </td>
                        <td>
                            <form action="SvEliminarEmpleado" method="POST">
                                <input type="hidden" name="id" value="<%=id%>">
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
 
<!-- ////////////////// VENTAS /////////////////////// VENTAS ///////////// VENTAS!///////////////////// VENTAS //////////////////////////// -->

<h3>VENTAS </h3>
<!-- Tab links -->
<div class="tab">
  <button class="tablinks" onclick="openAction(event, 'agregarVenta')">Nueva Venta</button>
  <button class="tablinks" onclick="openAction(event, 'buscarVenta')">Buscar Venta</button>
  <button class="tablinks" onclick="openAction(event, 'agregarServicio')">Añadir Servicio</button>
  <button class="tablinks" onclick="openAction(event, 'servicios')">Lista de Servicios</button>
  <button class="tablinks" onclick="openAction(event, 'agregarPaquete')">Crear Paquete</button>
</div>

<!-- Tab content -->
<div id="agregarVenta" class="tabcontent">
  <h3>Nueva Venta</h3>
  <form action="SvVenta" method="POST">
  <p><label>Cliente: </label><input type="text" name="cliente"></p>
  <p><label>Servicio: </label><input type="text" name="servicio"></p>
  <p><label>Medio de pago: </label><input type="number" name="pago"></p>
  <p><label>Fecha de venta: </label><input type="date" name="fecha_venta"></p>
  <button type="submit" id="crear" class="btn btn-success">Crear</button>
  </form>
</div>

<div id="buscarVenta" class="tabcontent">
  <h3> Ventas</h3>
</div>

<div id="agregarServicio" class="tabcontent">
  <h3>Agregar un nuevo servicio</h3>
  <form action="SvServicio" method="POST">
  <p><label>Nombre: </label><input type="text" name="nombre"></p>
  <p><label>Costo </label><input type="number" name="costo"></p>
  <p><label>Fecha: </label><input type="date" name="fecha"></p>
  <p><label>Destino: </label><input type="text" name="destino"></p>
  <p><label>Descripcion: </label><input type="text" name="descripcion"></p>
  <button type="submit" id="crear" class="btn btn-success">Crear</button>
  </form>
</div>

<div id="servicios" class="tabcontent">
   <h3>Servicios disponibles</h3>
  <form action="SvServicio" method="POST">
      <table>
            <thead>
                <tr> 
                    <th>Nombre:</th>
                    <th>Precio </th>
                    <th>Fecha: </th>
                    <th>Destino:</th>
                    <th>Descripción: </th>
                    <th> </th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Servicio> listaServicio=control.traerServicio();%>
                    <form action="SvVenderServicio" method="POST">
                        <%for (Servicio ser: listaServicio){%>
                        <tr>
                            <%String nombre=ser.getNombre_servicio();%>
                            <td name="nombre"><%=nombre%></td>
                            <%Double costo=ser.getCosto_servicio();%>
                            <td name="costo"><%=costo%></td>
                            <%Date fecha_servicio=ser.getFecha_servicio();%>
                            <td name="fecha_servicio"><%=fecha_servicio%></td>
                            <%String destino=ser.getDestino();%>
                            <td name="destino"><%=destino%></td>
                            <%String descripcion=ser.getDescripcion();%>
                            <td name="descripcion"><%=descripcion%></td>
                            <!-- ID -->
                            <%int codigo = ser.getCodigo_servicio();%>
                            <input type="hidden" name="codigo" value="<%=codigo%>">
                            <td>
                                <button type="submit" class="btn btn-success" name="<%=codigo%>">Vender</button>
                            </td>
                            <td>
                            <form action="SvEditarServicio" method="POST">                           
                               <input type="hidden" name="codigo" value="<%=codigo%>">
                               <button type="submit" class="btn btn-primary" data-title="Edit"> Editar</button>
                            </form>
                            </td>
                            <td>    
                            <form action="SvEliminarServicio" method="POST">
                                <input type="hidden" name="id" value="<%=codigo%>">
                                <button type="submit" class="btn btn-danger" data-title="Delete"> Eliminar</button>
                            </form>                               
                            </td>
                            </tr>                        
                        <%}%>
            </tbody>
      </table>
  </form>
</div>
            
<div id="agregarPaquete" class="tabcontent">
  <h3>Servicios disponibles para su paquete:</h3>
  <h5>Selección mínima requerida: dos servicios</h1>
  <form action="SvServicio" method="POST">
      <table>
            <thead>
                <tr> 
                    <th>Nombre:</th>
                    <th>Precio </th>
                    <th>Fecha: </th>
                    <th>Destino:</th>
                    <th>Descripción: </th>
                    <th>Seleccionar:</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Servicio> lista_servicio=control.traerServicio();%>
                    <form action="SvPaquete" method="POST">
                        <%for (Servicio ser: listaServicio){%>
                        <tr>
                            <%String nombre=ser.getNombre_servicio();%>
                            <td><%=nombre%></td>
                            <%Double costo=ser.getCosto_servicio();%>
                            <td><%=costo%></td>
                            <%Date fecha_servicio=ser.getFecha_servicio();%>
                            <td><%=fecha_servicio%></td>
                            <%String destino=ser.getDestino();%>
                            <td><%=destino%></td>
                            <%String descripcion=ser.getDescripcion();%>
                            <td><%=descripcion%></td>
                            <!-- ID -->
                            <%int id = ser.getCodigo_servicio();%>
                            <td>
                                <input type="checkbox" class="btn btn-success" name="seleccion" value="<%=id%>" >Crear Paquete</button>
                            </td>
                        </tr>                        
                        <%}%>
                    </form>   
                <button type="submit" class="btn btn-success" >Crear paquete</button>        
            </tbody>
      </table>
  </form>
</div>
          
            
        <%}%>

</body>
</html> 
