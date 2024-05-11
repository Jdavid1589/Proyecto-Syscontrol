
<%@page import="Modelo.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->

        <link href="Vistas/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <!-- Link to Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!-- Link to Font Awesome CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>   

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


                    <ul class="navbar-nav ml-3 me-auto">  
                        <form class="navbar-nav ms-auto ml-auto" role="search">
                            <input class="form-control " type="search" name="txtbuscar" placeholder="Buscar Auxiliar, CC" aria-label="Buscar">
                            <button  type="submit" name="accion" value="buscar" class="btn btn-warning ml-1">Buscar</button>
                        </form>

                    </ul>
                    <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span>
                                    USUARIOS
                                </span>
                            </a>
                        </li>
                    </ul>

                    <ul class="navbar-nav mb-3 mb-lg-0 float-start ">   

                        <li class="nav-item ">
                            <a class="nav-link active"  aria-current="page" href="./index3.jsp"><b>
                                    <span  style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                        <i class="bi bi-arrow-left-square-fill text-dark"></i> <b> Inicio </b>
                                    </span>
                            </a>
                        </li>
                        <%-- <li class="nav-item ">
                            <a class="nav-link active" aria-current="page" href="ControladorUsuarios?accion=add">
                                <span  style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="bi bi-plus-circle"></i> <b> Añadir </b> </span>
                            </a>
                        </li>--%>

                    </ul>


                </div>
            </div>
        </nav>
        <!--Barra de Navegacion -->

               <div class="row " style=" padding: 15px 0; ">                   

            <div class="card col-sm-4 mb-4  mt-5 sticky-top">

                <h4>FORMULARIO DE REGISTRO</h4> 

                <form id="miform" action="ControladorUsuarios" method="POST" autocomplete="off" class="custom-form">

                    <div class="row">
                        <div class="col-md-6 ">

                            <div class="form-group text-left">
                                <label for="nombres" class="text-left">Nombres</label>
                                <input type="text" class="form-control" value="${User.getNombres_apellido()}"  id="nombres" name="nombres_apellido" placeholder="Ingrese Nombres">
                            </div>                           

                            <div class="form-group text-left">
                                <label for="telefono"># Teléfono</label>
                                <input type="text" class="form-control" id="telefono" value="${User.getNumero_Telefono()}" name="numeroTelefono" placeholder="Ingrese Telefono">
                            </div>

                            <div class="form-group text-left">
                                <label for="correo">Correo</label>
                                <input type="email" class="form-control" id="correo" 
                                       value="${User.getCorreo()}" 
                                       name="correo" placeholder="Ingrese Correo">
                            </div>

                        </div>
                        <div class="col-md-6">        

                            <div class="form-group text-left">
                                <label for="usuario">Usuario</label>
                                <input type="text" class="form-control" id="usuario" value="${User.getUsuario()}" name="usuario" placeholder="Ingrese Usuario">
                            </div>

                            <div class="form-group text-left">
                                <label for="clave">Clave</label>
                                <input type="password" class="form-control" id="clave" value="${User.getClave()}" name="clave" placeholder="Ingrese Clave">
                            </div>



                            <%-- Nuevo Select datalist--%>
                            <div class="form-group text-left">
                                <label for="tipoPerfil">Perfil</label>
                                <input list="perfiles" class="form-control" id="tipoPerfil" name="perfil_nombre">
                                <datalist id="perfiles">
                                    <option value="0">Seleccione perfil</option>
                                    <% List<Perfil> perfiles = DaoPerfil.listar();
                                        if (perfiles != null) {
                                            for (Perfil perfil : perfiles) {
                                                if (perfil != null) {%>
                                    <option value="<%=perfil.getTipo_Perfil()%>" data-id="<%=perfil.getIdperfil()%>"><%=perfil.getTipo_Perfil()%></option>
                                    <% }
                                            }
                                        }%>
                                </datalist>
                                <!-- Campo oculto para almacenar el ID del perfil -->
                                <input type="hidden" id="perfil_idperfil" name="perfil_idperfil">
                            </div>

                            <script>
                                // Obtener el valor del data-id cuando se seleccione una opción
                                document.getElementById('tipoPerfil').addEventListener('input', function () {
                                    var selectedOption = document.querySelector('#perfiles option[value="' + this.value + '"]');
                                    if (selectedOption) {
                                        // Establecer el valor del data-id en el campo oculto
                                        document.getElementById('perfil_idperfil').value = selectedOption.getAttribute('data-id');
                                    }
                                });
                            </script>

                        </div>
                    </div>
                    <div class="form-group mt-3 text-center" style="border: none;">

                        <button type="submit" name="accion" value="registrar" class="btn btn-warning">
                            <i class="fas fa-save "></i> Agregar</button>
                        <button type="submit" name="accion" value="actualizar" class="btn btn-success">
                            <i class="bi bi-arrow-repeat"></i> Actualizar</button>

                        <button type="submit" name="accion" value="listar" class="btn btn-secondary">
                            <i class="bi bi-x-lg"></i> Cancelar</button>

                    </div>    
                </form>
            </div>   

            <div class="col-sm-8 mb-4 mt-5  ">
                <h4>LISTA USUARIOS</h4> 

                <div class=" table-container ml-3 md-3 table-responsive" >
                    <table id="miTabla" class="table table-striped table-hover sticky-top">
                        <thead >
                            <tr>
                                <th>ID</th>
                                <th>Nombres</th>                       
                                <th>Teléfono</th>
                                <th>Correo</th>
                                <th>Usuario</th>
                                <th>Clave</th>
                                <th>Perfil</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Usuarios> Lista = (List<Usuarios>) request.getAttribute("listaUsuarios");
                                for (Usuarios usuarios : Lista) {%>
                            <tr>
                                <td><%= usuarios.getIdUsuarios()%></td>
                                <td><%= usuarios.getNombres_apellido()%></td>                           
                                <td><%= usuarios.getNumero_Telefono()%></td>
                                <td><%= usuarios.getCorreo()%></td>
                                <td><%= usuarios.getUsuario()%></td>
                                <td><%= usuarios.getClave()%></td>
                                <td><%= DaoPerfil.obtenerNombrePerfil(usuarios.getPerfil_idperfil())%></td>


                                <td>
                                    <div class="btn-group" role="group" aria-label="Acciones">
                                        
                                        <%--  <a href="ControladorUsuarios?accion=eliminar&id=<%= usuarios.getIdUsuarios()%>"
                                           class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?')">
                                            <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                        </a>--%>

                                        <!--Boton Eliminar Alert-->                                    
                                        <a href="#" class="btn btn-danger btn-sm" onclick="eliminarUsuario(<%= usuarios.getIdUsuarios()%>)">
                                            <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                        </a>


                                        <a href="ControladorUsuarios?accion=editarUsu&id=<%= usuarios.getIdUsuarios()%>" class="btn btn-primary btn-sm">
                                            <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
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
            <a href="ControladorUsuarios?accion=listar" class="btn btn-primary"> 
                <i class="fas fa-list"></i> Listar</a>
            <a href="./index3.jsp" class="btn btn-warning">
                <i class="bi bi-arrow-left-square-fill text-dark"></i> Inicio</a>
        </div>
        <h1>${mensaje}</h1>
    </div>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!-- For alert-style pop-up messages -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- For AJAX functionality -->


    <script src="./js/Funsiones2.js" type="text/javascript"></script>
    <script src="./js/Funsiones_Varias.js" type="text/javascript"></script>


    <!-- Link para estilizar la tablas  -->


    <script>

                                            function eliminarUsuario(id) {
                                                swal({
                                                    title: "¿Estás seguro?",
                                                    text: "Una vez eliminado, no podrás recuperar este reporte.",
                                                    icon: "warning",
                                                    buttons: true,
                                                    dangerMode: true
                                                }).then((willDelete) => {
                                                    if (willDelete) {
                                                        // Muestra el mensaje de éxito
                                                        Swal.fire({
                                                            position: "center", // Centra el mensaje
                                                            icon: "success",
                                                            title: "Reporte Eliminado con Éxito",
                                                            showConfirmButton: false,
                                                            timer: 1000,
                                                            customClass: {
                                                                popup: 'swal2-popup-centered'
                                                            }
                                                        });

                                                        // Rediriges a la URL de eliminación después de 1.5 segundos (1500 milisegundos)
                                                        setTimeout(() => {
                                                            window.location.href = "ControladorUsuarios?accion=eliminar&id=" + id;
                                                        }, 1500);
                                                    } else {
                                                        swal("Operación cancelada.", {
                                                            icon: "error",
                                                            title: "Cancelado"
                                                        });
                                                    }
                                                });
                                            }

    </script>
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


    </style>

</body>
</html>

