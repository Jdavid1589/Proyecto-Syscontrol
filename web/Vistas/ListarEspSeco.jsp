

<%@page import="Persistencia.DaoEspecificacionesSeco"%>
<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Modelo.EspecificacionesSeco"%>
<%@page import="Modelo.EspecificacionesSeco"%>
<%@page import="Persistencia.DaoTipoProducto"%>
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
        <title>Lista-Especificacion-Seco</title>


        <%--title>Tabla con Bootstrap y DataTables</title--%>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- DataTables CSS -->
        <link href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css" rel="stylesheet">

        <!-- DataTables Spanish Language -->
        <script src="https://cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json"></script>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto&display=swap">



        <!-- Incluye los archivos CSS de Bootstrap -->  
        <script src="./js/EliminarProducto.js" type="text/javascript"></script>

        <!--link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" 
              integrity="sha512-...." crossorigin="anonymous" />

        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->





        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>       

        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>


    </head>
    <body> 

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-lg navbar-dark bg-primary border-3 fixed-top border-bottom " id="menu">
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

                    <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span class="text-dark elegant-font"" 
                                      style="font-size: 30px; color: darkblue;">
                                    <b>  REFERENCIAS   </b>
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
                            <a class="nav-link active" aria-current="page" href="ControladorEspSeco?accion=listar">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-list"></i> <b>Listar</b></span>
                            </a>
                        </li>
                    </ul>
                    <span onclick="location.reload()" class="btn btn-primary text-center" style="font-size: 2em;">
                        <i class="bi bi-arrow-clockwise"></i>
                    </span>

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
            <hr> 

            <hr class="mt-3">    
            <!--h1 class="mt-3">lodos</h1-->
            <div class=" mt-5 mx-auto">

                <a href="ControladorEspSeco?accion=add" 
                   class=" btn btn-warning text-primary ml-3 mb-2 float-start">           
                    <i class="fas fa-plus"></i>
                </a>
            </div>

            <div class=" table-container ml-3 md-3 table-responsive" >
                <table id="miTabla" class="table table-striped table-hover sticky-top">
                    <thead >
                        <tr>
                            <th>ID</th>
                            <th style="color:  #00ff00">REFERENCIA</th>                           
                            <th style="color:  #00ff00">CLIENTE</th>                              
                            <th>Caract # 1</th> 
                            <th> Rango </th> 
                            <th>Caract # 2</th> 
                            <th>Rango</th> 
                            <th>Caract # 3</th> 
                            <th>Rango</th> 
                            <th>Caract # 4</th> 
                            <th>Rango</th> 
                            <th>Caract # 5</th> 
                            <th>Rango</th> 
                            <th>Caract # 6</th> 
                            <th>Rango</th> 
                            <th>Caract # 7</th> 
                            <th>Rango</th> 
                            <th>Caract # 8</th> 
                            <th>Rango</th> 
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<EspecificacionesSeco> Lista = (List<EspecificacionesSeco>) request.getAttribute("listaEspcif");
                            for (EspecificacionesSeco especificaciones : Lista) {%>  

                    <td><%= especificaciones.getIdespecificaciones()%></td>
                    <td><%= DaoProductos.obtenerNombreProducto(especificaciones.getIdProductos())%></td>                    
                    <td><%= DaoEspecificacionesSeco.obtenerNombreclientes(especificaciones.getIdclientes())%></td>                       
                    <td><%= especificaciones.getVariableEsp1()%></td>
                    <td><%= especificaciones.getRango1()%></td>
                    <td><%= especificaciones.getVariableEsp2()%></td>
                    <td><%= especificaciones.getRango2()%></td>
                    <td><%= especificaciones.getVariableEsp3()%></td>
                    <td><%= especificaciones.getRango3()%></td>
                    <td><%= especificaciones.getVariableEsp4()%></td>
                    <td><%= especificaciones.getRango4()%></td>
                    <td><%= especificaciones.getVariableEsp5()%></td>
                    <td><%= especificaciones.getRango5()%></td>
                    <td><%= especificaciones.getVariableEsp6()%></td>
                    <td><%= especificaciones.getRango6()%></td>
                    <td><%= especificaciones.getVariableEsp7()%></td>
                    <td><%= especificaciones.getRango7()%></td>
                    <td><%= especificaciones.getVariableEsp8()%></td>
                    <td><%= especificaciones.getRango8()%></td>

                    <td>
                        <div class="btn-group" role="group" aria-label="Acciones">

                            <a href="ControladorEspSeco?accion=eliminar&id=<%= especificaciones.getIdespecificaciones()%>"
                               class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?')">
                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->

                                <!--Boton Eliminar Alert-->
                                <!--input type="hidden" class="idp" value="<--%= clientes.getIdclientes()%>">
                                <a href="#" class="btn btnDelete btn-danger btn-sm" data-id="<--%= clientes.getIdclientes()%>">
                                    <i class="fas fa-trash"></i> 
                                </a-->

                                <%-- <a href="#" class="btn btn-danger btn-sm" onclick="eliminarCliente(<%= especificaciones.getIdespecificaciones()%>)">
                                    <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                </a--%>

                                <a href="ControladorEspSeco?accion=editarEspecif&id=<%= especificaciones.getIdespecificaciones()%>" 
                                   class="btn btn-primary btn-sm">
                                    <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                </a>

                        </div>
                    </td>

                    </tr>
                    <% }%>
                    </tbody>
                </table>
            </diV>
            <div class="form-group text-right  ml-1  mb-2  mg-2">
                <!<!-- Boton para ira al inicio de la tabla -->
                <div class="form-group mt-3 mb-2  mg-2  float-start"> 
                    <button id="btnInicio" class="btn  btn-sm btn-primary ">
                        <i class="bi bi-arrow-up-square "></i>

                    </button>
                </div>
                <div class="form-group  float-start ml-1 mt-3 mb-2  mg-2"> 
                    <button id="btnFinal" class="btn  btn-sm btn-primary ">
                        <i class="bi bi-arrow-down-square"></i>
                    </button>
                </div>


                <a href="ControladorProductos?accion=listar" class="btn btn-success ml-2">
                    <!<!-- Icono Pagina Inicio -->
                    <i class="fas fa-list"></i> </a>

                <!<!-- Icono Listar -->
                <a href="index3.jsp" class="btn btn-warning">
                    <i class="bi bi-arrow-left-square-fill text-dark"></i> </a>
            </div>
        </div>

        <h1>${mensaje}</h1>


    </div>





    <!-- Jquery-3.5.1 sirve para ejecutar funsion dezplazamiento dentro de la tabla -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
    ></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" 
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"
    ></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!-- For alert-style pop-up messages -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- For AJAX functionality -->
    <script src="./js/Funsiones2.js" type="text/javascript"></script>
    <script src="./js/Funsiones_Varias.js" type="text/javascript"></script>

    <script src="./js/EliminarProducto.js" type="text/javascript"></script>



    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>

    <script>
                                   $(document).ready(function () {
                                       $('#miTabla').DataTable({
                                           "paging": true, // Habilita la paginación
                                           "pageLength": 5, // Número de registros por página
                                           "language": {
                                               "url": "//cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json"
                                           }
                                       });
                                   });
    </script>

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
