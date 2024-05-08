

<%@page import="Modelo.VariablesPL"%>
<%@page import="Modelo.ReportePdfLodo"%>
<%@page import="Modelo.Variable"%>
<%@page import="Modelo.ReportePdfSeco"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Persistencia.DaoDocumento"%>

<%@page import="Modelo.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista PDF</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->

        <link href="Vistas/css4/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css4/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css4/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>

        <link href="Vistas/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <link href="Vistas/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous"-->
        <!--link rel="stylesheet" href="@sweetalert2/themes/dark/dark.css">
        <script src="sweetalert2/dist/sweetalert2.min.js"></script-->

        <!--script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->

         <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>

        <%--title>Tabla con Bootstrap y DataTables</title--%>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- DataTables CSS -->
        <link href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css" rel="stylesheet">

        <!-- DataTables Spanish Language -->
        <script src="https://cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json"></script>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto&display=swap">

    </head>
    <body>  
        <h1 style="text-align: center; color: #00ff00">${mensaje}</h1>

        <script>
            // Obtenemos el mensaje desde el servidor y lo asignamos a una variable en JavaScript
            var mensaje = "${mensaje}";

            // Mostramos el mensaje utilizando un alerta
            alert(mensaje);
        </script>


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


                    <ul class="navbar-nav ml-3 me-auto">  
                        <form class="navbar-nav ms-auto ml-auto" role="search">
                            <input class="form-control " type="search" name="txtbuscar" placeholder="Buscar Empresa, Nombres" aria-label="Buscar">
                            <button  type="submit" name="accion" value="buscar" class="btn btn-warning ml-1">Buscar</button>
                        </form>

                    </ul>

                    <ul class="navbar-nav mb-3 mb-lg-0 float-start ">   

                        <li class="nav-item ">
                            <a class="nav-link active my-menu-item" aria-current="page" href="./index3.jsp"><b>
                             <span  style="margin-left: 10px; border:none; font-size: 16px" class="btn btn-outline-light">
                                        <i class="bi bi-arrow-left-square-fill text-dark"></i> <b> Inicio </b>
                                    </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <%--   <a class="nav-link active" aria-current="page" href="ControladorClientes?accion=add">
                                <span  style="margin-left: 10px; border:none" class=" btn btn-outline-light ">
                                    <i class="bi bi-plus-circle"></i> <b>Añadir</b> </span>
                            </a>--%>
                            <a class="nav-link active" aria-current="page"        href="ControladorPL?accion=listar">
                               <span  style="margin-left: 10px; border:none; font-size: 16px" class="btn btn-outline-light">
                                 <i class="bi bi-arrow-left-square-fill text-dark"></i> <b>Producto Lodo</b> </span>
                            </a>
                        </li>

                    </ul>


                </div>
            </div>
        </nav>
        <!--Barra de Navegacion -->

        <div class="col-sm-12 mb-4 mt-5 sticky-top">
            <br>
            <h1 class=" elegant-font text-center"><b style="font-size: 26px; text-align: center; color: #a71d2a">CERTIFICADOS PDF GENERADOS LODO</b></h1> 
            <div class=" table-container ml-3 md-3 table-responsive" >
                <table id="miTabla" class="table table-striped table-hover sticky-top">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Producto</th>                       
                            <th>Fecha </th>
                            <th>Cliente</th>
                            <th># Certificado</th>
                            <th>Num Remision  </th>
                            <th>Cant Kg</th>
                            <th>Lote</th>
                            <th>Solidos</th>
                            <th>Humedad</th>                           
                            <th>Densidad g/l</th>                           
                            <th>Densidad kg/gal</th>                           
                            <th>Visc cP</th>                           
                            <th>Visc Ku</th>                           
                            <th>UFC</th>                           
                            <th>pH</th>                           
                            <th>% R325</th>                           
                            <th>AA</th>                           
                            <th>Br</th>                           
                            <th>Wh</th>                           
                            <th>Yell</th>                           
                            <th>Dv50</th>                           
                            <th>Auxiliar</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Variable</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Rango</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           
                            <th>Metodo</th>                           

                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>



                        <%
                            List<ReportePdfLodo> reportes = (List<ReportePdfLodo>) request.getAttribute("listaPdfLodo");
                            for (ReportePdfLodo reporte : reportes) {%>

                        <tr class="negrita">

                            <td><%= reporte.getIdCertificadoLodo()%></td>
                            <td><%= reporte.getProducto()%></td>
                            <td><%= reporte.getFechaCertificado()%></td>                      
                            <td><%= reporte.getCliente()%></td>
                            <td><%= reporte.getNumCertificado()%></td>
                            <td><%= reporte.getNumRemision()%></td>
                            <td><%= reporte.getCantidadKg()%></td>
                            <td><%= reporte.getLote()%></td>
                            <td><%= reporte.getSolidos()%></td>
                            <td><%= reporte.getHumedad()%></td>
                            <td><%= reporte.getDensidadg()%></td>
                            <td><%= reporte.getDensidadkggal()%></td>
                            <td><%= reporte.getViscosidadCp()%></td>
                            <td><%= reporte.getViscosidadKu()%></td>
                            <td><%= reporte.getUfc()%></td>
                            <td><%= reporte.getpH()%></td>
                            <td><%= reporte.getRetenido325()%></td>
                            <td><%= reporte.getAA()%></td>
                            <td><%= reporte.getBr()%></td>
                            <td><%= reporte.getWh()%></td>
                            <td><%= reporte.getYell()%></td>
                            <td><%= reporte.getDv50()%></td>
                            <td><%= reporte.getAuxiliar()%></td>

                            <!-- Celdas para las variables y sus rangos -->
                            <%
                                List<VariablesPL> variables = reporte.getVariablesPL(); // Obtener la lista de variables de pdfseco
                                for (VariablesPL variable : variables) {
                            %>
                            <td><%= variable.getTipo()%></td> <!-- Columna para el tipo de la variable -->
                            <td><%= variable.getRango()%></td> <!-- Columna para el rango de la variable -->
                            <td><%= variable.getMetodo()%></td> 
                            <%
                                }
                            %>

                            <!-- Celda para las acciones -->
                            <td>
                                <div class="btn-group" role="group" aria-label="Acciones">
                                    <!-- Botones para las acciones -->
                                    <a href="ControladorReporteSeco?accion=eliminar&id=<%= reporte.getIdCertificadoLodo()%>"
                                       class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?')">
                                        <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                    </a>
                                    <a href="#" class="btn btn-primary btn-sm">
                                        <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>

            </div>
            <div class="form-group text-right">
                <a href="ControladorReporteSeco?accion=listar" class="btn btn-primary"> 
                    <i class="fas fa-list"></i> Listar</a>
                <a href="./index3.jsp" class="btn btn-warning">
                    <i class="bi bi-arrow-left-square-fill text-dark"></i> Inicio</a>
            </div>
            >
        </div>



        <!-- Jquery-3.5.1 sirve para ejecutar funsion dezplazamiento dentro de la tabla -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"
        ></script>


        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><%--lo de las alertas--%>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!-- For alert-style pop-up messages -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- For AJAX functionality -->
        <script src="./js/Funsiones2.js" type="text/javascript"></script>
        <script src="./js/Funsiones_Varias.js" type="text/javascript"></script>

        <!-- Link para estilizar la tablas  -->
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


            .btn {
                border-radius: 20px; /* Redondear los botones */
            }

        </style>





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


        </style>

    </body>
</html>

