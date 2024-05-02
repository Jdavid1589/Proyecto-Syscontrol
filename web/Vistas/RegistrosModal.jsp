

<%@page import="Modelo.Seguimientos"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Persistencia.DaoTipoProducto"%>
<%@page import="Modelo.TipoProducto"%>
<%@page import="Modelo.Perfil"%>
<%@page import="Modelo.Documento"%>

<%@page import="Modelo.Productos"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Persistencia.DaoSeguimientos"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="Modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>

        <!-- Incluye los archivos CSS de Bootstrap Local -->

        <link href="Vistas/css4/bootstrap.css" rel="stylesheet" type="text/css"/>

        <link href="Vistas/css4/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>

        <link href="Vistas/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <link href="Vistas/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>

        <!-- Incluye los archivos CSS de Bootstrap -->


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <!--link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"-->
        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->
        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
        crossorigin="anonymous"-->
        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>  

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"></a>
                <img src="./Vistas/Imagenes/MI.jpg" alt="Logo" style="float: left; width: 90px;" />

                <button 
                    class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse  " id="navbarSupportedContent">                    

                     <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span>
                                    REGISTROS VARIOS
                                </span>
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav mb-3 mb-lg-0 centrado ">   

                        <li class="nav-item ">
                              <a class="nav-link active" aria-current="page" href="./index3.jsp"><b>
                                    <span style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                        <i class="bi bi-arrow-left-square-fill text-dark"></i> <b> Inicio </b>
                                    </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link active" aria-current="page" href="ControladorRegModal?accion=listar">
                                <span style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-list"></i><b> Listar </b>
                                </span>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <!--Barra de Navegacion -->

        <div class="container-fluid mt-5">

            <div class="row">
                <div class="col-md-6 mt-5 md-3">


                    <span data-toggle="modal" data-target="#registroModalVariables"
                          class=" btn btn-primary ml-3 mb-2 float-start">
                        <i class="fas fa-plus"></i> 
                    </span>
                    <div class=" table-container ml-3 md-3 table-responsive" >
                        <table id="miTabla" class="table table-striped table-hover sticky-top">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>ANALISIS</th>                            
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Seguimientos> listaV = (List<Seguimientos>) request.getAttribute("listaVariables");
                                    for (Seguimientos variables_Calidad : listaV) {%>
                                <tr>
                                    <td><%= variables_Calidad.getIdSeguimientos()%></td>
                                    <td><%= variables_Calidad.getNumSeguimiento()%></td>                            
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Acciones">
                                            <a href="ControladorRegModal?accion=eliminar3&id=<%= variables_Calidad.getIdSeguimientos()%>"
                                               class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de Eliminar referencia?')">
                                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            </a>

                                            <a href="ControladorUsuarios?accion=editar&id=<%= variables_Calidad.getIdSeguimientos()%>" class="btn btn-primary btn-sm">
                                                <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                            </a>
                                        </div>
                                    </td>

                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </diV>



                </div>

                <div class="col-md-6 mt-5 md-3">
                    <span  class=" btn btn-primary ml-3 mb-2 float-start" data-toggle="modal" data-target="#registroModalPerfil">
                        <i class="fas fa-plus"></i> 
                    </span>
                    <div class=" table-container ml-3 md-3 table-responsive" >
                        <table id="miTabla" class="table table-striped table-hover sticky-top">
                            <thead >
                                <tr>
                                    <th>ID</th>
                                    <th>PERFIL</th>                            
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Perfil> listaper = (List<Perfil>) request.getAttribute("listaPerfil");
                                    for (Perfil perfil : listaper) {%>
                                <tr>
                                    <td><%= perfil.getIdperfil()%></td>
                                    <td><%= perfil.getTipo_Perfil()%></td>                            
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Acciones">
                                            <a href="ControladorRegModal?accion=eliminar&id=<%= perfil.getIdperfil()%>"
                                               class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de Eliminar referencia?')">
                                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            </a>

                                            <%-- 
                                            Ok Funsiona
                                               <a href="ControladorRegModal?accion=editarPerfil&id=<%= perfil.getIdperfil()%>" 
                                                   class="btn btn-primary btn-sm">
                                                 <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                                </a>
                                            --%>

                                            <!-- Botón para abrir el modal -->
                                            <span class="btn btn-primary  float-start abrir-modal"
                                                  data-toggle="modal" data-target="#ModalEditar" data-id="<%= perfil.getIdperfil()%>">
                                                <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                            </span>




                                        </div>
                                    </td>

                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </diV>
                </diV>
            </div>

            <div class="row">
                <div class="col-md-6 mt-3">
                    <span data-toggle="modal" data-target="#registroModalDocumento" class=" btn btn-primary ml-3 mb-2 float-start">
                        <i class="fas fa-plus"></i> 
                    </span>
                    <div class=" table-container ml-3 md-3 table-responsive" >
                        <table id="miTabla" class="table table-striped table-hover sticky-top">
                            <thead >
                                <tr>
                                    <th>ID</th>
                                    <th><strong>DOCUMENTO</strong></th>                            
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Documento> listaD = (List<Documento>) request.getAttribute("listaDocumento");
                                    for (Documento documento : listaD) {%>
                                <tr>
                                    <td><%= documento.getIdDocumento()%></td>
                                    <td><%= documento.getTipo_documento()%></td>                            
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Acciones">
                                            <a href="ControladorRegModal?accion=eliminar4&id=<%= documento.getIdDocumento()%>"
                                               class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de Eliminar Tipo Documento?')">
                                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            </a>

                                            <a href="ControladorReModal?accion=editar&id=<%= documento.getIdDocumento()%>" class="btn btn-primary btn-sm">
                                                <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                            </a>
                                        </div>
                                    </td>

                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </diV>
                </diV>

                <div class="col-md-6 mt-3">
                    <span data-toggle="modal" data-target="#registroModalTipoProducto" class=" btn btn-primary ml-3 mb-2 float-start">
                        <i class="fas fa-plus"></i> 
                    </span>
                    <div class=" table-container ml-3 md-3 table-responsive" >
                        <table id="miTabla" class="table table-striped table-hover sticky-top">
                            <thead >
                                <tr>
                                    <th>ID</th>
                                    <th><strong>TIPO PRODUCTO</strong></th>                            
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<TipoProducto> listaE = (List<TipoProducto>) request.getAttribute("listaTipoProducto");
                                    for (TipoProducto tipoProducto : listaE) {%>
                                <tr>
                                    <td><%= tipoProducto.getIdtipoProducto()%></td>
                                    <td><%= tipoProducto.getTipo()%></td>                            
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Acciones">
                                            <a href="ControladorRegModal?accion=eliminar5&id=<%= tipoProducto.getIdtipoProducto()%>"
                                               class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de Eliminar Tipo Documento?')">
                                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            </a>

                                            <a href="ControladorReModal?accion=editar&id=<%= tipoProducto.getTipo()%>" class="btn btn-primary btn-sm">
                                                <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                            </a>
                                        </div>
                                    </td>

                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </diV>      


                </div>

            </div>
            <h1>${Mensaje}</h1>
        </div>

        <div class="form-group text-right">
            <a href="ControladorRegModal?accion=listar" class="btn btn-primary">
                <i class="fas fa-list"></i>Listar </a>
            <a href="./index3.jsp" class="btn btn-warning"> 
                <i class="bi bi-arrow-left-square-fill"></i>Inicio</a>
        </div>



        <!-- ***** Modal de Registro de Perfil ****-->


        <div class="modal fade" id="registroModalPerfil" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="background-color: #F2F2F2;"> <!-- Cambia el color de fondo aquí -->
                    <div class="modal-header">
                        <h5 class="modal-title text-primary mx-auto " id="registroModalLabel">REGRISTRAR PERFIL</h5>
                        <!-- Botón de cerrar estático -->
                        <button type="button" class="close"  data-dismiss="modal" aria-label="Close" style="position: static;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Formulario de Registro de Perfil -->
                        <form action="ControladorRegModal" method="post">
                            <!-- Agrega los campos del formulario aquí -->
                            <div class="form-group">
                                <!--label for="nombre">Tipo de Perfil</label-->
                                <input type="text" class="form-control" id="nombre" name="perfil" placeholder="Ingrese Perfil">
                            </div>
                            <button type="submit" name="accion" value="registrarPerfil" class="btn  btn-primary mt-4">
                                <i class="fas fa-save"></i> Guardar </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <style>
            .modal-dialog-centered {
                display: flex;
                align-items: center;
                min-height: calc(100% - 3.5rem);
            }
        </style>




        <!-- Modal de Registro de Documento -->

        <div class="modal fade" id="registroModalDocumento" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="background-color: #F2F2F2;"> <!-- Cambia el color de fondo aquí -->
                    <div class="modal-header">
                        <h5 class="modal-title text-primary elegant-font" id="registroModalLabel"> AGREGAR DOCUMENTO</h5>

                        <!-- Botón de cerrar estático -->
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="position: static;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Formulario de Registro de Tipo Documento -->
                        <form action="ControladorRegModal" method="post">
                            <!-- Agrega los campos del formulario aquí -->
                            <div class="form-group">
                                <!--label for="nombre">Tipo de Perfil</label-->
                                <input type="text" class="form-control" id="Documento" name="documento" placeholder="Ingrese Tipo Documento">
                            </div>
                            <button type="submit" name="accion" value="registrarDocumento" class="btn btn-primary mt-4">
                                <i class="fas fa-save "></i> Guardar</button>

                        </form>
                    </div>
                </div>
            </div>

        </div>


        <!-- -------------------------------- -->

        <!-- Modal de Registro Variables_Calidad -->

        <div class="modal fade" id="registroModalVariables" tabindex="-1" role="dialog" 
             aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="background-color: #F2F2F2;"> 
                    <div class="modal-header">

                        <h5 class="modal-title text-primary mx-auto " 
                            id="registroVaribalesLabel">REGISTRAR VARIABLES</h5>

                        <!-- Botón de cerrar estático -->
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close" style="position: static;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body"> 

                        <!-- Formulario de Registro Variables -->

                        <form action="ControladorRegModal" method="post">
                            <div class="form-group">                         
                                <input type="text" class="form-control " id="Variables"
                                       name="Variables_calidad"  placeholder="Ingrese Producto">
                            </div>           
                            <button type="submit" name="accion" value="registrarVariables" class="btn btn-primary mt-4">
                                <i class="fas fa-save "></i> Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal de Registro Productos-->
        <div class="modal fade" id="registroModalProductos" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="background-color: #F2F2F2;"> <!-- Cambia el color de fondo aquí -->
                    <div class="modal-header">

                        <h5 class="modal-title text-primary  mx-auto  "style="font-size: 25px; " id="registroProductosLabel">REGRISTRAR PRODUCTOS</h5>

                        <!-- Botón de cerrar estático -->
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="position: static;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body"> 


                        <!-- Formulario de Registro Productods -->
                        <form action="ControladorRegModal" method="post">
                            <div class="form-group"> 
                                <input type="text" class="form-control" id="nombres_Productos"   
                                       name="nombres_Productos" 
                                       placeholder="Ingrese Producto">                           
                            </div>  
                            <div class="form-group text-left">
                                <label for="tipoProducto">Tipo</label>
                                <select class="form-control" id="tipoPerfil" name="tipoProducto_idtipoProducto">
                                    <option value="0">Seleccione Tipo</option>
                                    <% List<TipoProducto> tipopro = DaoTipoProducto.listar();
                                        if (tipopro != null) {
                                            for (TipoProducto tipoproducto : tipopro) {
                                                if (tipoproducto != null) {%>
                                    <option value="<%=tipoproducto.getIdtipoProducto()%>"><%=tipoproducto.getTipo()%></option>
                                    <% }
                                            }
                                        }%>
                                </select>

                            </div>

                            <button type="submit" name="accion" value="registrarProducto" class="btn btn-custom mt-4 btn-primary  elegant-font" >
                                <i class="bi bi-floppy-fill "></i> Guardar </button>
                        </form>

                    </div>
                </div>
            </div>
        </div>


        <script>
            // JavaScript para mostrar la alerta fuera del modal
            <% if (request.getAttribute("Mensaje") != null) {%>
            var mensajeRegistroExitoso = '<%= request.getAttribute("Mensaje")%>';
            document.getElementById("mensajeRegistroExitoso").textContent = mensajeRegistroExitoso;
            document.getElementById("registroExitoso").style.display = "block";
            // Esto limpia el campo de texto
            document.getElementById("Productos").value = "";
            // Ocultar la alerta después de 5 segundos (5000 milisegundos)
            setTimeout(function () {
                document.getElementById("registroExitoso").style.display = "none";
            }, 2000);
            <% }%>
        </script>

        <!-- Alerta fuera del modal -->
        <div class="alert alert-success mt-4" id="registroExitoso" style="display: none;">
            Registro exitoso: <span id="mensajeRegistroExitoso"></span>
        </div>


        <!-- Modal de Registro Tipo Productos-->
        <div class="modal fade" id="registroModalTipoProducto" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="background-color: #F2F2F2;"> <!-- Cambia el color de fondo aquí -->
                    <div class="modal-header">

                        <h5 class="modal-title text-primary  mx-auto  "style="font-size: 25px; " id="registroProductosLabel">REGRISTRAR  TIPO PRODUCTOS</h5>

                        <!-- Botón de cerrar estático -->
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="position: static;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">                          
                        <!-- Formulario de Registro Variables -->

                        <form action="ControladorRegModal" method="post">
                            <!-- Agrega los campos del formulario aquí -->
                            <div class="form-group"> 
                                <!--label for="nombre">Tipo Producto</label--> 
                                <input type="text" class="form-control" id="Tipo"   name="tipo"  placeholder="Ingrese Tipo Producto">
                            </div>           
                            <button type="submit" name="accion" value="registrarTipoProducto" class="btn btn-custom mt-4 btn-primary  elegant-font" >
                                <i class="bi bi-floppy-fill "></i> Guardar </button>
                        </form>

                    </div>
                </div>
            </div>
        </div>       

        <!-- Alerta fuera del modal -->
        <div class="alert alert-success mt-4" id="registroExitoso" style="display: none;">
            Registro exitoso: <span id="mensajeRegistroExitoso"></span>
        </div>

        <script>
            // JavaScript para mostrar la alerta fuera del modal
            <% if (request.getAttribute("mensaje") != null) {%>
            var mensajeRegistroExitoso = '<%= request.getAttribute("mensaje")%>';
            document.getElementById("mensajeRegistroExitoso").textContent = mensajeRegistroExitoso;
            document.getElementById("registroExitoso").style.display = "block";
            // Esto limpia el campo de texto
            document.getElementById("nombre").value = "";
            // Ocultar la alerta después de 5 segundos (5000 milisegundos)
            setTimeout(function () {
                document.getElementById("registroExitoso").style.display = "none";
            }, 2000);
            <% }%>
        </script>



        <!-- Modal para editar -->

        <div class="modal fade" id="ModalEditar" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="background-color: #F2F2F2;">
                    <div class="modal-header">
                        <h5 class="modal-title text-primary mx-auto" id="registroModalLabel">EDITAR PERFIL</h5>
                        <!-- Botón de cerrar estático -->
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="position: static;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>


                    <div class="modal-body">
                        <!-- Formulario de Edición de Perfil -->
                        <form action="ControladorRegModal" method="post">

                            <!-- Campo oculto para enviar el ID del perfil -->

                            <!--  type="hidden" se envia como Campo oculto -->
                            <div class="form-group text-left ">
                                <label  for="perfilId">ID</label>
                                <input   class="form-control col-md-2 text-center  " style=" font-weight: bold;"
                                         readonly="" id="perfilId" name="txtid">

                                <div class="form-group">
                                    <label for="nombre">Nombre del Perfil</label>
                                    <input type="text" class="form-control" id="nombre"  name="tipo_Perfil" placeholder="Ingrese el nombre del perfil">
                                </div>
                            </div>

                            <button type="submit" name="accion" value="registrarEdicion_perf" class="btn btn-primary">
                                <i class="fas fa-save"></i> Guardar Cambios
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <%-- jQuery Para poder usar la funsion  $('.abrir-modal').click(function () { 
               Se debe colocar antes de toso los otros Script
        --%>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


        <%--   Función para abrir el modal y cargar el ID del perfil    --%>

        <script>
            $(document).ready(function () {
                // Función para abrir el modal y cargar el ID del perfil
                $('.abrir-modal').click(function () {
                    var perfilId = $(this).data('id'); // Obtener el ID del perfil desde el atributo data
                    $('#perfilId').val(perfilId); // Establecer el ID del perfil en el campo oculto del formulario
                });
            });
        </script>






        <!-- Incluye los archivos JavaScript de Bootstrap y jQuery -->
        <!-- Bootstrap CSS y JavaScript -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous"
        ></script>

        <style>
            /* CSS personalizado para DataTables */
            .dataTables_wrapper {
                font-family: 'Roboto', sans-serif;
                color:green;

            }

            /* Estilos redondeados para los btn */

            .btn {
                border-radius: 20px; /* Redondear los botones */
            }

            /*   CSS para los títulos de las columnas
              .dataTables_wrapper thead th {
                  color: #000;  /*Cambia el color a azul, puedes usar cualquier color que desees 
               } */


        </style>



    </body>
</html>

