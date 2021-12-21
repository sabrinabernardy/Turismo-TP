/* global xmlHttp */

//acciones de las pestañas principales
function openAction(evt, actionName) {
  // Declare all variables
  var i, tabcontent, tablinks;

  // Get all elements with class="tabcontent" and hide them
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // Get all elements with class="tablinks" and remove the class "active"
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }

  // Show the current tab, and add an "active" class to the button that opened the tab
  document.getElementById(actionName).style.display = "block";
  evt.currentTarget.className += " active";
}

function editar(){
    var id= document.getElementById("id").value;
}


function recorgerDatos(){
    
    let id= document.getElementById("Id_cliente").value;
    let nombre= document.getElementById("nombre").value;
    let apellido= document.getElementById("apellido").value;
    let dni= document.getElementById("dni").value;
    let fecha_nac= document.getElementById("fecha_nac").value;
    let direccion= document.getElementById("direccion").value;
    let nacionalidad= document.getElementById("nacionalidad").value;
    let celular= document.getElementByIdc("celular").value;
    let email= document.getElementById("email").value;
     
}

function recorgerDatos_(){
    
    document.getElementByClass("recoger").innerHTML=xmlHttp.responseText;
    
    let id= document.getElementById("Id_cliente").value;
    let nombre= document.getElementById("nombre").value;
    let apellido= document.getElementById("apellido").value;
    let dni= document.getElementById("dni").value;
    let fecha_nac= document.getElementById("fecha_nac").value;
    let direccion= document.getElementById("direccion").value;
    let nacionalidad= document.getElementById("nacionalidad").value;
    let celular= document.getElementByIdc("celular").value;
    let email= document.getElementById("email").value;
     
}

function mostrarDatos(){
    
    let id= document.setElementById("Id_cliente").value;
    let nombre= document.setElementById("nombre").value;
    let apellido= document.setElementById("apellido").value;
    let dni= document.setElementById("dni").value;
    let fecha_nac= document.setElementById("fecha_nac").value;
    let direccion= document.setElementById("direccion").value;
    let nacionalidad= document.setElementById("nacionalidad").value;
    let celular= document.setElementByIdc("celular").value;
    let email= document.setElementById("email").value;
    
    
}

function recogerId(id){
    
    var id=document.getElementById("id").value;
}