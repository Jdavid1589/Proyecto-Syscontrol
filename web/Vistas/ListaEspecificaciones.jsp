
<%@page import="Persistencia.DaoEspecificacionesSeco"%>
<%@page import="Modelo.EspecificacionesSeco"%>
<%@page import="Persistencia.DaoTipoProducto"%>
<%@page import="Modelo.Consecutivo"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="Persistencia.DaoSeguimientos"%>
<%@page import="Persistencia.DaoConsecutivo"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Productos"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoClientes"%>

<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Persistencia.DaoDocumento"%>

<%@page import="Modelo.Clientes"%>
<%@page import="Modelo.Especificaciones"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Especificaciones</title>

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

    </head>
    <body>  

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-md navbar-dark bg-primary border-3 fixed-top border-bottom " id="menu">
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
                                    <span   style="margin-left: 10px; border:none" class=" btn btn-outline-light ">
                                        <i class="bi bi-arrow-left-square-fill text-dark"></i> <b> Inicio </b>
                                    </span>
                            </a>
                        </li>                      

                    </ul>


                </div>
            </div>
        </nav>
        <!--Barra de Navegacion -->

        <div class="row ">            
            <hr>
            <div class="card col-sm-4 mb-4  mt-5 sticky-top">

                <h4 class="text-primary elegant-font"><b>FORMULARIO DE REGISTRO</b></h4> 

                <form action="ControladorEspecificaciones" autocomplete="off" method="POST" class="custom-form">         
                    <div class="row">
                        <div class="col-md-6 ">

                            <div class="form-group text-left">
                                <label for="productos_idProductos"> Referencia</label>
                                <select class="form-control" id="productos_idProductos" value="${Espec.getIdProductos()}" 
                                        name="idProductos">
                                    <option value="0">Seleccione Referencia</option>
                                    <%
                                        for (Productos productos : DaoProductos.listar()) {
                                            if (productos != null) {
                                    %>
                                    <option  value="<%=productos.getIdProductos()%>"><%=productos.getNombres_Productos()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group text-left">
                                <label for="idclientes"> Cliente</label>
                                <select class="form-control" id="clientes_idclientes" value="${Espec.getIdclientes()}" 
                                        name="idclientes">
                                    <option value="0">Seleccione Cliente</option>
                                    <%
                                        for (Clientes clientes : DaoClientes.listar()) {
                                            if (clientes != null) {
                                    %>
                                    <option  value="<%=clientes.getIdclientes()%>"><%=clientes.getRazon_Social()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>

                        </div>
                        <div class="col-md-6"> 


                            <div class="form-group text-left">
                                <label for="variablesEspecificacion" class="text-left">Caracteristicas</label>
                                <input type="text" class="form-control" id="variablesEspecificacion" value="${Espec.getVariablesEspecificacion()}" 
                                       name="variablesEspecificacion" 
                                       placeholder="Ingrese Variable">
                            </div> 


                            <div class="form-group text-left">
                                <label for="valorEspecificacion" class="text-left">Especificacion</label>
                                <input type="text" class="form-control" id="valorEspecificacion" value="${Espec.getValorEspecific()}" name="valorEspecific" 
                                       placeholder="Ingrese Valor">
                            </div>                           
                            <div class="form-group text-left">
                                <label for="metodoAnalisis" class="text-left">Metodo Analisis</label>
                                <input type="text" class="form-control" value="${Espec.getMetodoAnalisis()}" id="metodoAnalisis" name="metodoAnalisis" 
                                       placeholder="Ingrese Metodo">
                            </div>

                        </div>

                        <div class="form-group mt-3 text-center" style="border: none;">

                            <button type="submit" name="accion" value="registrar" class="btn btn-warning">
                                <i class="fas fa-save "></i> Agregar</button>
                            <button type="submit" name="accion" value="Modificar" class="btn btn-success">
                                <i class="bi bi-arrow-repeat"></i> Actualizar</button>

                            <button type="submit" name="accion" value="listar" class="btn btn-secondary">
                                <i class="bi bi-x-lg"></i> Cancelar</button>

                        </div>
                    </div>


                </form>
            </div> 

            <div class="col-sm-8 mb-4 mt-5 sticky-top">
                <h4 class="text-primary elegant-font"><b>LISTA ESPECIFICACIONES</b></h4> 

                <div class=" table-container ml-3 md-3 table-responsive" >
                    <table id="miTabla" class="table table-striped table-hover sticky-top">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Referencia</th>                           
                                <th>Cliente</th>                              
                                <th>Caract # 1</th> 
                                <th>Rango</th> 
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

                                    <!--a href="#" class="btn btn-danger btn-sm" onclick="eliminarCliente(<%= especificaciones.getIdespecificaciones()%>)">
                                        <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                    </a-->

                                    <a href="ControladorEspSeco?accion=editarEspecif&id=<%= especificaciones.getIdespecificaciones()%>" 
                                       class="btn btn-primary btn-sm">
                                        <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                    </a>
                                    <a href="ControladorEspSeco?accion=editarpdf_Esp&id=<%= especificaciones.getIdespecificaciones()%>" 
                                       class="btn btn-warning btn-sm">
                                        <i class="bi bi-file-pdf bi-lg"></i> <!-- Ícono de lápiz -->
                                    </a>
                            </div>
                        </td>

                        </tr>
                        <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="form-group text-right">
            <a href="ControladorEspecificaciones?accion=listar" class="btn btn-primary"> 
                <i class="fas fa-list"></i> Listar</a>
            <a href="./index3.jsp" class="btn btn-warning">
                <i class="bi bi-arrow-left-square-fill text-dark"></i> Inicio</a>
        </div>
        <h1>${mensaje}</h1>
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


</body>
</html>

