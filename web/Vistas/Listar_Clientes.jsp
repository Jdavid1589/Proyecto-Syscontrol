

<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Persistencia.DaoDocumento"%>

<%@page import="Modelo.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Clientes</title>

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

        <main>

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
                                <button  type="submit" name="accion" value="buscar" style="background:  rgb(212, 173, 17)" class="btn btn-warning ml-1">Buscar</button>
                            </form>

                        </ul>
                        <ul class="navbar-nav mx-auto text-center" >   
                            <li class="nav-item" >
                                <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                    <span >
                                        LISTA  DE CLIENTES
                                    </span>
                                </a>
                            </li>
                        </ul>

                        <ul class="navbar-nav mb-3 mb-lg-0 float-start ">   

                            <li class="nav-item ">
                                <a class="nav-link active"  aria-current="page" href="./index3.jsp"><b>
                                        <span style="margin-left: 10px; border:none" class=" btn btn-outline-light ">
                                            <i class="bi bi-arrow-left-square-fill text-dark"></i> <b> Inicio </b>
                                        </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link active" aria-current="page" href="ControladorClientes?accion=add">
                                    <span  style="margin-left: 10px; border:none" class=" btn btn-outline-light ">
                                        <i class="bi bi-plus-circle"></i> <b>Añadir</b> </span>
                                </a>
                            </li>

                        </ul>


                    </div>
                </div>
            </nav>
            <!--Barra de Navegacion -->
            <div  style="margin-top:55px; margin-bottom: ">
                <br>
                <a title="Agregar Clientes" href="ControladorClientes?accion=add" 
                   class=" btn btn-primary text-warning ml-5 float-start">           
                    <i class="fas fa-plus"></i>
                </a>
            </div>

            <div class="col-sm-12 mb-4 sticky-top" style="margin-top: 60px">

                <div class=" table-container ml-3 md-3 table-responsive" >
                    <table id="miTabla" class="table table-striped table-hover sticky-top">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Empresa</th>                       
                                <th>Nombres</th>
                                <th>Tipo_Doc</th>
                                <th># Docum</th>
                                <th>Direccion</th>
                                <th>Correo</th>
                                <th>Telefono</th>                           
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Clientes> Lista = (List<Clientes>) request.getAttribute("listaClientes");
                                for (Clientes clientes : Lista) {%>
                            <tr>
                                <td><%= clientes.getIdclientes()%></td>
                                <td><%= clientes.getRazon_Social()%></td>  
                                <td><%= clientes.getNombres_apellidos()%></td>
                                <td><%= DaoDocumento.obtenerTipoDocumento(clientes.getIdDocumento())%></td>                           
                                <td><%= clientes.getNumero_Documento()%></td>
                                <td><%= clientes.getDireccion()%></td>                           
                                <td><%= clientes.getCorreo()%></td>
                                <td><%= clientes.getNumero_Telefono()%></td> 


                                <td>
                                    <div class="btn-group" role="group" aria-label="Acciones">

                                        <a href="ControladorClientes?accion=eliminar&id=<%= clientes.getIdclientes()%>"
                                           class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este Cliente?')">
                                            <i class="fas fa-trash"></i> <!-- Ícono de papelera -->


                                            <%-- comment <a href="#" class="btn btn-danger btn-sm" onclick="eliminarCliente(<%= clientes.getIdclientes()%>)">    
                                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            </a> --%>

                                            <a href="ControladorClientes?accion=editarclientes&id=<%= clientes.getIdclientes()%>" class="btn btn-primary btn-sm">
                                                <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                            </a>
                                    </div>
                                </td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
              
                <h1>${mensaje}</h1>
            </div>

        </main>

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


            .btn {
                border-radius: 20px; /* Redondear los botones */
            }

        </style>

        <script>
            function eliminarCliente(id) {
                swal({
                    title: "¿Estás seguro?",
                    text: "Una vez eliminado, no podrás recuperar este Cliente.",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                        .then((willDelete) => {
                            if (willDelete) {
                                // Aquí rediriges a la URL de eliminación
                                window.location.href = "ControladorClientes?accion=eliminar&id=" + id;
                            } else {
                                swal("El Cliente está a salvo.");
                            }

                        });
            }
        </script>

        <script>
            $(document).ready(function () {
                $(document).on("click", ".btnDelete", function () {
                    var idp = $(this).data("id");
                    confirmarEliminacion(idp);
                });

                function confirmarEliminacion(idp) {
                    swal({
                        title: "¿Está seguro de eliminar Cliente?",
                        text: "Una vez eliminado deberá agregar de nuevo.",
                        icon: "warning",
                        buttons: {
                            confirmar: "Sí, Eliminar",
                            cancelar: "No, Cancelar"
                        },
                    }).then((isConfirm) => {
                        if (isConfirm) {
                            eliminarRegistro(idp);
                        } else {
                            swal("Cancelado", "Cancelaste la eliminación", "error");
                        }
                    });
                }

                function eliminarRegistro(idp) {
                    var url = "ControladorClientes?accion=eliminar&id=" + idp;

                    console.log("URL de eliminación:", url);

                    $.ajax({
                        type: 'POST',
                        url: url,
                        async: true,
                    }).done(function (response) {
                        console.log("Respuesta del servidor:", response);

                        if (response === "success") {
                            swal("Eliminado", "El Cliente se ha eliminado", "success");
                            setTimeout(function () {
                                window.location.href = "ControladorClientes?accion=listar";
                            }, 1000);
                        } else {
                            swal("Error Cliente en Uso", response, "error");
                        }
                    }).fail(function () {
                        swal("Error", "Hubo un problema al intentar eliminar el Cliente", "error");
                    });
                }
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


        </style>

    </body>
</html>

