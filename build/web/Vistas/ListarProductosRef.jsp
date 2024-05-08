

<%@page import="Modelo.TipoProducto"%>
<%@page import="Modelo.TipoProducto"%>
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
        <title>Lista-Productos</title>


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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...." crossorigin="anonymous" />
        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->
        <link href="Vistas/css4/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistascss4/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css4/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>

        <link href="Vistas/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <link href="Vistas/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>


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
                    <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span>
                                    REFERENCIAS 
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
                            <a class="nav-link active" aria-current="page" href="ControladorProductos?accion=listar">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-list"></i> <b>Listar</b></span>
                            </a>
                        </li>
                    </ul>
                    <span onclick="location.reload()" class="btn  btn-outline-light text-center" style="font-size: 20px; color: #ffcd39; margin-left: 25px; border:none">
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
                <span  class=" btn btn-warning   text-primary ml-3 mb-2 float-start" data-toggle="modal" data-target="#registroReferencia">
                    <i class="fas fa-plus"></i> 
                </span>

                <%--   <a href="ControladorProductos?accion=add" 
                   class=" btn btn-warning text-primary ml-3 mb-2 float-start">           
                    <i class="fas fa-plus"></i>
                </a>--%>
            </div>

            <div class=" table-container ml-3 md-3 table-responsive" >
                <table id="miTabla" class="table table-striped table-hover sticky-top">
                    <thead >
                        <tr>
                            <th>ID</th>
                            <th>REFERENCIA</th>                                                              
                            <th>TIPO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Productos> listap = (List<Productos>) request.getAttribute("listaProductos");
                            for (Productos productos : listap) {%>
                        <tr>
                            <td><%= productos.getIdProductos()%></td>
                            <td><%= productos.getNombres_Productos()%></td>   
                            <td><%= DaoTipoProducto.obtenerNombreTipoProd(productos.getTipoProducto_idtipoProducto())%></td>                          




                            <td>
                                <div class="btn-group" role="group" aria-label="Acciones">
                                    <a href="ControladorProductos?accion=eliminar2&id=<%= productos.getIdProductos()%>"
                                       class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de Eliminar Producto?')">
                                        <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                    </a>

                                    <a href="ControladorProductos?accion=editarProducto&id=<%= productos.getIdProductos()%>" class="btn btn-primary btn-sm">
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


        <!<!-- Boton para ira al inicio de la tabla -->
        <div class="form-group mt-3 mb-2  mg-2 ml-3 float-start"> 
            <button id="btnInicio" class="btn  btn-sm btn-primary ">
                <i class="bi bi-arrow-up-square "></i>

            </button>
        </div>
        <div class="form-group  float-start ml-1 mt-3 mb-2  mg-2"> 
            <button id="btnFinal" class="btn  btn-sm btn-primary ">
                <i class="bi bi-arrow-down-square"></i>
            </button>
        </div>

        <div class="form-group text-right  ml-1 mt-3 mb-2  mg-2">
            <a href="ControladorProductos?accion=listar" class="btn btn-success ml-2">
                <!<!-- Icono Pagina Inicio -->
                <i class="fas fa-list"></i> </a>

            <!<!-- Icono Listar -->
            <a href="index3.jsp" class="btn btn-warning">
                <i class="bi bi-arrow-left-square-fill text-dark"></i> </a>
        </div>
    </div>


    <!-- ***** Modal de Registro Productos****-->


    <div class="modal fade" id="registroReferencia" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content" style="background-color: #F2F2F2;"> <!-- Cambia el color de fondo aquí -->
                <div class="modal-header">
                    <h5 class="modal-title text-primary  mx-auto" id="registroModalLabel">REGRISTRAR PRODUCTO</h5>
                    <!-- Botón de cerrar estático -->
                    <button type="button" class="close"  data-dismiss="modal" aria-label="Close" style="position: static;">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <!-- Formulario de Registro Productos -->
                    <form action="ControladorProductos" method="post">

                        <!-- Agrega los campos del formulario aquí -->
                        <div class="form-group">
                            <div class="form-group text-left"> 
                                <label for="variablesEspecificacion" class="text-left">
                                    <b style="color: #00008B; font-family: Century Gothic;">REFERENCIA</b></label>
                                <input  style="color: #00008B; background: #8fd19e; font-family: Century Gothic ; font-size: 18PX;" 
                                        type="text" class="form-control" id="referencia"   
                                        name="referencia" 
                                        placeholder="Ingrese Producto">                           
                            </div>  

                            <div class="form-group text-left">
                                <label for="tipoProducto">Tipo</label>
                                <select class="form-control" id="idtipo" name="idtipo">
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
                        </div>
                        <button type="submit" name="accion" value="registrar" class="btn  btn-primary mt-4">
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
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>  

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
                                                   "pageLength": 7, // Número de registros por página
                                                   "language": {
                                                       "processing": "Procesando...",
                                                       "lengthMenu": "Mostrar _MENU_ registros por página",
                                                       "zeroRecords": "No se encontraron resultados",
                                                       "emptyTable": "Ningún dato disponible en esta tabla",
                                                       "info": "Mostrando _START_ a _END_ de _TOTAL_ entradas",
                                                       "infoEmpty": "Mostrando 0 a 0 de 0 entradas",
                                                       "infoFiltered": "(filtrado de un total de _MAX_ entradas)",
                                                       "search": "Buscar:",
                                                       "paginate": {
                                                           "first": "Primero",
                                                           "last": "Último",
                                                           "next": "Siguiente",
                                                           "previous": "Anterior"
                                                       },
                                                       "aria": {
                                                           "sortAscending": ": Activar para ordenar la columna ascendente",
                                                           "sortDescending": ": Activar para ordenar la columna descendente"
                                                       }
                                                   },
                                                   "scrollX": false // Habilita el desplazamiento horizontal
                                               });
                                           });
    </script>

    <style>
        /* CSS personalizado para DataTables */
        .dataTables_wrapper {
            font-family: 'Roboto', sans-serif;

            color:blue;
            font-weight: 700;

        }
        /* Estilos redondeados para los btn */

        .btn {
            border-radius: 20px; /* Redondear los botones */
        }



    </style>



</body>
</html>
