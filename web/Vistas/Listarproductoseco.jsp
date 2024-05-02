
<%@page import="Modelo.ControlSeco"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Productos"%>

<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoProductoSeco"%>

<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Persistencia.DaoProductos"%>

<%@page import="Persistencia.DaoSeguimientos"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista ProductoSeco</title>



        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
              integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" 
              crossorigin="anonymous" referrerpolicy="no-referrer">

        <!-- DataTable -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.3.3/css/buttons.bootstrap5.min.css">
        <!-- Incluye los archivos CSS de Bootstrap -->  
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...." crossorigin="anonymous" />
        <!-- Incluye los archivos CSS de Bootstrap Local -->  
        <link href="Vistas/css4/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css4/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <link href="Vistas/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous" >

        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.3/css/dataTables.dataTables.min.css">

    </head>
    <body> 

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
            <div class="container-fluid ">
                <a class="navbar-brand  " href="#"></a>
                <img src="./Vistas/Imagenes/MI.jpg" alt="Logo" style="float: left; width: 90px;" />

                <button 
                    class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse  " id="navbarSupportedContent">  
                    <ul class="navbar-nav ml-3 me-auto">  
                        <form class="navbar-nav ms-auto ml-auto" action="ControladorPs" method="post" class="custom-form" role="search">
                            <input class="form-control " type="search" name="txtbuscar" placeholder="Aux, Fecha, Lote, Ref" aria-label="Buscar">
                            <button  type="submit" name="accion" value="buscar" style="background:  rgb(212, 173, 17)" class="btn btn-warning bt-sm ml-1">Buscar</button>
                        </form>

                    </ul>
                    <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span 
                                    <b> REGISTRO PRODUCTO SECO</b>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav mb-3 mb-lg-0 float-start">

                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="./index3.jsp">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</span>
                            </a></b>
                        </li>

                        <li class="nav-item ">
                            <a class="nav-link active" aria-current="page" href="ControladorPs?accion=listar">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-list"></i> <b>Listar</b></span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link active" aria-current="page" href="ControladorPs?accion=add" >
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-plus"></i></span>
                            </a>
                        </li>

                    </ul>


                </div>
            </div>
        </nav>

        <!--Barra de Navegacion -->

        <style>
            .campo-invalido {
                border: 1px solid red; /* Cambia el borde a rojo para resaltar el campo */
                background-color: #ffcccc; /* Cambia el fondo a un tono rojo claro */
            }
        </style>

        <div class="col-12">   
            <br >    
            <div class=" mt-5 mx-auto">
                <a href="ControladorPs?accion=add" 
                   class="btn btn-warning text-primary ml-3 mb-2 float-start"
                   title="Agregar Nuevo"> <!-- Agrega el atributo title -->
                    <i class="fas fa-plus"></i>
                </a>
            </div>


            <div class="table-container ml-3 md-3 table-responsive pagination-container" id="paginationContainer">
                <table id="miTabla2" id="agregarCampoHumedad" class="table table-striped table-hover sticky-top">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Referencia</th>
                            <th>Lote</th>
                            <th>Cantidad NC</th>
                            <th>Causas</th>
                                <%
                                    int numCamposHumedad = 12; // Definir el número de campos de humedad inicial a mostrar
                                    for (int i = 1; i <= numCamposHumedad; i++) {
                                %>
                            <th class="miTH" id="Hum_<%= i%>">Hum_<%= i%></th>
                                <%
                                    }
                                %>

                            <th  >Hum_Prom</th>


                            <th>R.325</th>
                            <th>pH</th>
                            <th>pH</th>
                            <th>pH</th>
                            <th>pH_Prom</th>
                            <th>Dv(50)</th>
                            <th>Dv(90)</th>
                            <th>Abs.A</th>
                            <th>Brigh</th>
                            <th>Wh</th>
                            <th>Auxiliar</th>
                            <th style="background: #ffcd39">
                                <b style="color: #0000ff; font-family: Arial; font-size: 14px;"># Consecutivo</b>
                            </th>
                            <th style="background: #ffcd39">
                                <b style="color: #0000ff; font-family: Arial; font-size: 14px;">Referencia</b>
                            </th>
                            <th style="background: #ffcd39">
                                <b style="color: #0000ff; font-family: Arial; font-size: 14px;">Cliente</b>
                            </th>
                            <th>Comentarios</th>
                            <th>Observación</th>
                            <th><b>Acciones</b></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<ControlSeco> Lista = (List<ControlSeco>) request.getAttribute("listaProducSeco");
                            for (ControlSeco terminadoseco : Lista) {%>
                        <tr class="negrita">
                            <td><%= terminadoseco.getIdControlCalidad()%></td>
                            <td><%= terminadoseco.getFecha()%></td>
                            <td><strong><%= DaoProductos.obtenerNombreProducto(terminadoseco.getIdProductos())%></strong></td>
                            <td><%= terminadoseco.getLote()%></td>
                            <td><%= terminadoseco.getCant_noconf()%></td>
                            <td><%= terminadoseco.getCausas()%></td>

                            <% for (int i = 1; i <= numCamposHumedad; i++) {%>  
                            <td id="Hum_<%= i%>"><%= terminadoseco.getHumedad(i) != null ? terminadoseco.getHumedad(i) : ""%></td>
                            <% }%>

                            <td><%= terminadoseco.getHumedad_promedio()%></td>
                            <td><%= terminadoseco.getRetenido325()%></td>
                            <td><%= terminadoseco.getPH()%></td>
                            <td><%= terminadoseco.getpH_2()%></td>
                            <td><%= terminadoseco.getpH_3()%></td>
                            <td><%= terminadoseco.getpH_promedio()%></td>
                            <td><%= terminadoseco.getDv50()%></td>
                            <td><%= terminadoseco.getDv90()%></td>
                            <td><%= terminadoseco.getAbs_Aceite()%></td>
                            <td><%= terminadoseco.getBrigh()%></td>
                            <td><%= terminadoseco.getWhitness()%></td>
                            <td><%= DaoUsuarios.obtenerNombreUsuario(terminadoseco.getIdUsuarios())%></td>
                            <td>
                                <b style="font-family: Arial; font-size: 14px;">
                                    <%= String.format("%04d", terminadoseco.getIdConsecutivo())%>
                                </b>
                            </td>
                            <td><strong><%= DaoProductoSeco.obtenerProductoFinal(terminadoseco.getIdControlCalidad())%></strong></td>
                            <td><strong><%= DaoProductoSeco.obtenerclienteFinal(terminadoseco.getIdControlCalidad())%></strong></td>
                            <td><%= terminadoseco.getComentarios()%></td>
                            <td><%= terminadoseco.getObservacion()%></td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Acciones">
                                    <a href="ControladorPs?accion=editar_ps&id=<%= terminadoseco.getIdControlCalidad()%>"
                                       class="btn btn-sm ms-1">
                                        <i class="fas fa-pencil-alt mb-2" style="font-size: 20px; color: #0000ff"></i> <!-- Ícono de lápiz -->
                                    </a>
                                    <a href="ControladorPs?accion=editar_ps2&id=<%= terminadoseco.getIdControlCalidad()%>"
                                       class="btn btn-sm ms-1">
                                        <i class="fas fa-pencil-alt mb-2" style="font-size: 20px; color: #09f"></i> <!-- Ícono de lápiz -->
                                    </a>
                                    <a href="ControladorPs?accion=pdf&id=<%= terminadoseco.getIdControlCalidad()%>"
                                       class="btn btn-sm ms-1 ">
                                        <i class="bi bi-file-pdf" style="font-size: 22px; color: red"></i> <!-- Ícono pdf más grande -->
                                    </a>
                                    <a href="ControladorPs?accion=eliminar2&id=<%= terminadoseco.getIdControlCalidad()%>"
                                       class="btn btn-sm ms-1" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?')">
                                        <i class="fas fa-trash" style="font-size: 20px; color: #00ff00"></i> <!-- Ícono de papelera -->
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
                <div class="dataTable_bottom">
                    <div class="dataTables_info"></div>
                    <div class="dataTables_paginate"></div>
                </div>


                <!<!-- Boton para ira al inicio de la tabla -->
                <div class="form-group mt-3 mb-2  mg-2 ml-3 float-start"> 
                    <button id="btnInicio" class="btn  btn-sm btn-primary " title="Primeara Fila">
                        <i class="bi bi-arrow-up-square "></i>

                    </button>
                </div>
                <div class="form-group  float-start ml-1 mt-3 mb-2  mg-2"> 
                    <button id="btnFinal" class="btn  btn-sm btn-primary " title="Ultima Fila">
                        <i class="bi bi-arrow-down-square"></i>
                    </button>
                </div>

                <div class="form-group text-right  ml-1 mt-3 mb-2  mg-2">
                    <a href="ControladorProductoSeco?accion=listar" class="btn btn-success ml-2"
                       title="Actualizar Lista">
                        <!<!-- Icono Pagina Inicio -->
                        <i class="fas fa-list"></i> </a>

                    <!<!-- Icono Listar -->
                    <a href="index3.jsp" class="btn btn-warning"
                       title="Pagina Inicio">
                        <i class="bi bi-arrow-left-square-fill text-dark"></i> </a>
                </div>
            </div>




            <!-- JQuery -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" 
                    integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" 
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>

            <!-- DataTable -->
            <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
             <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
             <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
             <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>--%>


            <%-- <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
            <script src="https://cdn.datatables.net/buttons/2.3.3/js/dataTables.buttons.min.js"></script>
            <script src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.bootstrap5.min.js"></script>
            <script src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.html5.min.js"></script>
            <script src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.print.min.js"></script>--%>

            <!-- Otros scripts -->
            <%--  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!-- Para mensajes emergentes estilo alerta -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- Para funcionalidad AJAX -->--%>


            <script src="./js/Funsiones2.js" type="text/javascript"></script>
            <script src="./js/Funsiones_Varias.js" type="text/javascript"></script>

            <!-- JQuery 
            <script
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
                integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
                crossorigin="anonymous"
                referrerpolicy="no-referrer"
            ></script>-->
            <!-- DataTable -->
            <script   type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>

            <script    type="text/javascript"   src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
            <script    type="text/javascript"   src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
            <script    type="text/javascript"   src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
            <script    type="text/javascript"   src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>

            <script    type="text/javascript"   src="https://cdn.datatables.net/buttons/2.3.3/js/dataTables.buttons.min.js"></script>



            <script    type="text/javascript"   src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.bootstrap5.min.js"></script>
            <script    type="text/javascript"   src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.html5.min.js"></script>
            <script    type="text/javascript"   src="https://cdn.datatables.net/buttons/2.3.3/js/buttons.print.min.js"></script>


            <!-- Bootstrap-->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>


            <!-- Funsiones de Datable y Funsion para agregar Campos de Humedad  a lista -->
            <script src="./js/JS_PS.js" type="text/javascript"></script>



            <!-- Styles particular para Lista Seco-->
            <style>
                /* CSS personalizado para DataTables */
                .dataTables_wrapper {
                    font-family: 'Roboto', sans-serif;

                }
                .dataTables_info {
                    font-family: 'Roboto', sans-serif;
                    font-weight: 700;
                    position: absolute;
                    bottom: -10%;
                    left: 30%;
                    transform: translateX(-50%);
                    margin-bottom: 15px; /* Ajusta según sea necesario */
                    color: red;
                }

                /* Con la propiedad bottom y letf controlo l aubicacion de la info */
                .dataTables_paginate {
                    font-family: 'Roboto', sans-serif;
                    font-weight: 700;
                    bottom: -10%;
                    left:  100%;
                    margin-bottom: 5px; /* Ajusta según sea necesario */
                    color: red;
                }
                /* Move the buttons below the table */

               .dataTables_wrapper .dt-buttons {
                      position: absolute;
                      bottom: -50px;
                      left: 50%;
                      transform: translateX(-60%);
                      margin-bottom: 20px; /* Ajusta según sea necesario */
                  }

                /* Estilos redondeados para los btn */

                .btn {
                    border-radius: 25px; /* Redondear los botones */
                }


            </style>



    </body>
</html>
