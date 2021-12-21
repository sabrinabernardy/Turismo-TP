<%-- 
    Document   : principal
    Created on : 18/12/2021, 16:25:55
    Author     : GomezBernardy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="user-scalable-no, width=device,with">
	<title>Ingresar</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
        <title>Sistema de Gestion TODOTURISMO</title>
    </head>
    <body>
        <%HttpSession misession=request.getSession(true);%>
        <form action="SvUsuario" method="POST" class="login">
            <fieldset>
    
              <legend class="legend">Entrar</legend>
              
                <!-- INGRESAR USUARIO ------------------------------------->
                <div class="input">
                    <input  type="text" name="usuario" placeholder="Usuario">
                    <span><i class="fa fa-envelope-o"></i></span>
                </div>
    
                <!-- INGRESAR CONTRASEÑA ------------------------------------->
                <div class="input">
                    <input type="password" name="contrasenia" placeholder="Contraseña">
                    <span><i class="fa fa-lock"></i></span>
                </div>
                <!-- BOTÓN INGRESAR ----------------------------------------->
                 <button type="submit" class="submit">O<i class="O"></i></button>
    
            </fieldset>
        </form>          
    </body>
</html>
