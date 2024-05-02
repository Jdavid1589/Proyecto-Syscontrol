

<%@page import="Modelo.EspecificacionesSeco"%>
<%@page import="Persistencia.DaoEspecificacionesSeco"%>
<%@page import="Modelo.Especificaciones"%>
<%@page import="Persistencia.DaoConsecutivo"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Modelo.Productos"%>
<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Consecutivo"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Consecutivo</title>


        <!-- title>Tabla con Bootstrap y DataTables</title -->
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- DataTables CSS -->
        <link href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css" rel="stylesheet">
        <!-- DataTables Spanish Language -->
        <script src="https://cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto&display=swap">

        <!-- Incluye los archivos CSS de Bootstrap -->  

        <!--link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...." crossorigin="anonymous" />
        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->
        <link href="Vistas/css4/bootstrap.css" rel="stylesheet" type="text/css"/>
        ¿
        <link href="Vistas/css4/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>

        <link href="Vistas/css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <link href="Vistas/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>


        <!-- Estilos para los botones  -->
        <link href="Vistas/Estilos_css/StyleBotones.css" rel="stylesheet" type="text/css"/>

        <!-- 
        Estilos para los botones Formualario 
        Link estilos4.css
        -->



    </head>
    <body>        
        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
            <div class="container-fluid ">
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
                            <input class="form-control " type="search" name="txtbuscar" placeholder="Buscar Remis, Consec" aria-label="Buscar">
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
                    </ul>

                    <span onclick="location.reload()" class="btn  btn-outline-light text-center" style="font-size: 20px; color: #ffcd39; margin-left: 25px; border:none">
                        <i class="bi bi-arrow-clockwise"></i>
                    </span>
                </div>
            </div>
        </nav>
        <!--Fin Barra de Navegacion -->

        <div class="row ">            
            <div class="card col-sm-4 mb-4  mt-5 ">
                <h4>FORMULARIO DE REGISTRO</h4> 

                <!-- Inicio de Formulario -->
                <form id="miform" action="ControladorConsecutivo" autocomplete="off" method="POST" onsubmit="return validarFormulario();"  class="custom-form">         
                    <div class="row">
                        <div class="col-md-6 ">

                            <div class="form-group text-left">
                                <label for="nroRemision"  class="text-left"># Remision</label>
                                <input type="text" class="form-control" value="${Consec.getNroRemision()}"  id="nroRemision" name="nroRemision" 
                                       placeholder="Ingrese ">
                            </div>

                            <div class="form-group text-left">
                                <label for="idespecificaciones"> Referencia-Cliente</label>
                                <select class="form-control"   style="border: 2px solid #ffdf7e;"  id="idespecificaciones"  value="${Consec.getIdEspecificaciones()}" name="idespecificaciones"   >
                                    <option value="0" >Seleccione Referencia</option>
                                    <%for (EspecificacionesSeco especificaciones : DaoEspecificacionesSeco.listarPS_PL()) {
                                            if (especificaciones != null) {
                                    %> <option  value="<%=especificaciones.getIdespecificaciones()%>"><%=DaoEspecificacionesSeco.obtReferenciaCliente(especificaciones.getIdespecificaciones())%></option>
                                    <% }
                                        } %>
                                </select>
                            </div>

                            <div class="form-group text-left">
                                <label for="lote">Lote</label>
                                <input type="text" class="form-control" id="lote" value="${Consec.getLote()}" name="lote" 
                                       placeholder="Ingrese Lote">
                            </div>

                            <!-- Etiquetas Flotantes -->
                            <!--     <div class="form-floating">                             
                                 <input type="text" class="form-control" id="lote" placeholder="lote">
                                 <label for="lote">Lote</label>
                             </div> -->


                        </div>
                        <div class="col-md-6">  

                            <div class="form-group text-left">
                                <label for="fechaCertificado">Fecha Registro</label>
                                <input type="date" class="form-control" id="fechaCertificado" value="${Consec.getFechaCertificado()}" name="fechaCertificado" 
                                       placeholder="Ingrese Fecha">
                            </div>

                            <div class="form-group text-left">
                                <label for="fechaProduccion">Fecha Produccion</label>
                                <input type="date" class="form-control" id="fechaProduccion" value="${Consec.getFechaProduccion()}" name="fechaProduccion" 
                                       placeholder="Ingrese Fecha">
                            </div>

                            <div class="form-group text-left">
                                <label for="idUsuarios"> Auxiliar</label>
                                <select class="form-control" id="idUsuarios" style="border: 2px solid #ffdf7e;" 
                                        value="${Consec.getIdUsuarios()}" name="idUsuarios">
                                    <option value="0">Seleccione Aux</option>
                                    <% for (Usuarios usuarios : DaoUsuarios.listar()) {
                                            if (usuarios != null) {%>
                                    <option  value="<%=usuarios.getIdUsuarios()%>"><%=usuarios.getNombres_apellido()%></option>
                                    <%   }
                                        }  %>
                                </select>
                            </div>

                            <!-- Agrega este campo de entrada específico -->
                            <div class="form-group text-left">
                                <label for="cantidadMaterial">Cant Material</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="cantidadMaterial" 
                                           value="${Consec.getCantidadMaterial()}" name="cantidadMaterial"  placeholder="Ingrese Cant">
                                    <div class="input-group-append">
                                        <button  class="btn btn-outline-primary" type="button" onclick="abrirCalculadora()" >
                                            <i class="fas fa-calculator"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Grupo: Botones -->                 
                    <div class="formulario__grupo formulario__grupo-btn-enviar">       
                        <button    type="submit" name="accion" value="RegistrarConsecutivo"   class="btn btn-success" >
                            Registrar   
                            <i class="fas fa-save " style="color: #000;"></i>
                        </button> 
                        <button  type ="submit" name="accion" value="actualizar"    class="btn btn-warning" >
                            Actualizar  
                            <i class="bi bi-arrow-repeat"></i>
                        </button>
                        <a href="ControladorConsecutivo?accion=Listar2" class="btn  btn-secondary">
                            Cancelar  
                            <i class="bi bi-x-lg"></i>
                        </a>
                    </div> 

                </form>
            </div> 
            <!-- Inicio Tabla Listar -->                  
            <div class="col-sm-8 mb-4 mt-5 sticky-top">
                <h4>CONSECUTIVO</h4> 
                <div class=" table-container ml-3 md-3 table-responsive" >
                    <table id="miTabla" class="table table-striped table-hover sticky-top">
                        <thead>
                            <tr>
                                <th>Consecutivo</th>
                                <th>#.Remision</th>   

                                <th>Referencia</th>
                                <th>Lote</th>
                                <th>Fecha</th>
                                <th>Fecha Prod</th>
                                <th>Cant Material</th>                           
                                <th>Auxiliar</th>                                                                         
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Consecutivo> Lista = (List<Consecutivo>) request.getAttribute("listaConsecutivo");
                                for (Consecutivo consecutivo : Lista) {%>
                            <tr>
                                <%--<td><%= consecutivo.getIdconsecutivo()%></td>--%>
                                <td class="text-center"><%= String.format("%04d", consecutivo.getIdconsecutivo())%></td>
                                <td><%= consecutivo.getNroRemision()%></td> 

                                <td><%= DaoProductos.obtreferenciacliente(consecutivo.getIdEspecificaciones())%></td> 
                                <td><%= consecutivo.getLote()%></td> 
                                <td><%= consecutivo.getFechaCertificado()%></td>
                                <td><%= consecutivo.getFechaProduccion()%></td>
                                <td><%= consecutivo.getCantidadMaterial()%></td>
                                <td><%= DaoUsuarios.obtenerNombreUsuario(consecutivo.getIdUsuarios())%></td>  
                                <td>
                                    <div class="btn-group" role="group" aria-label="Acciones">
                                        <a href="ControladorConsecutivo?accion=eliminar&id=<%= consecutivo.getIdconsecutivo()%>"
                                           class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este Reporte?')">
                                            <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            <%--a href="#" class="btn btn-danger btn-sm" onclick="eliminarConsecutivo(<%= consecutivo.getIdconsecutivo()%>)">
                                                <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                                            </a--%>
                                            <a href="ControladorConsecutivo?accion=editarConsecutivo&id=<%= consecutivo.getIdconsecutivo()%>" class="btn btn-primary btn-sm">
                                                <i class="fas fa-pencil-alt"></i> <!-- Ícono de lápiz -->
                                            </a>                                               
                                    </div>
                                </td>

                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
                <%--
    <!-- Boton para ira al inicio de la tabla -->
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
       <div class="form-group text-center" style="border: none; margin-top: -45px;">
    <a href="ControladorConsecutivo?accion=Listar2" class="btn btn-primary"> 
        <i class="fas fa-list"></i> Listar</a>
    <!--a href="./index3.jsp" class="btn btn-warning">
        <i class="bi bi-arrow-left-square-fill text-dark"></i> Inicio</a-->
</div>--%>
            </div>
        </div>
    </div>
</div>

<h1>${mensaje}</h1>
</div>


<!-- Agrega este modal al final de tu formulario -->
<div class="modal fade" id="calculadoraModal" tabindex="-1" role="dialog" aria-labelledby="calculadoraModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="calculadoraModalLabel">Calculadora</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!-- Agrega estos botones al cuerpo del modal -->
            <div class="modal-body">
                <label for="numero1">Cantidad Material:</label>
                <input type="text" id="numero1" placeholder="Ingrese cantidad Material en kg" class="form-control" />

                <label for="numero2">Divisor:</label>
                <input type="text" placeholder="Ingrese Peso Saco (25 Kg)." id="numero2" class="form-control" />
                <!--label for="numero2">Numeros(Separados por comas):</label>
                <input type="text" placeholder="Numeros" id="numeros" class="form-control" /-->

                <div class="mt-3">
                    <button type="button" class="btn btn-primary" onclick="calcular('sumar')">Sumar</button>
                    <button type="button" class="btn btn-primary" onclick="calcular('restar')">Restar</button>
                    <button type="button" class="btn btn-primary" onclick="calcular('multiplicar')">Multiplicar</button>
                    <button type="button" class="btn btn-warning" onclick="calcular('dividir')"><b>Dividir</b></button>
                </div>
            </div>

            <!--div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div-->
        </div>
    </div>
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

<script src="./js/FunsionConcecut.js" type="text/javascript"></script>

<script>
                        function validarFormulario() {
                            var camposObligatorios = [
                                "idUsuarios", "nroRemision", "idespecificaciones",
                                "fechaCertificado", "lote", "fechaProduccion", "cantidadMaterial"
                            ];
                            for (var i = 0; i < camposObligatorios.length; i++) {
                                var input = document.getElementById(camposObligatorios[i]);
                                if (input.tagName.toLowerCase() === "select") {
                                    validarCampoCombo(input);
                                } else {
                                    validarCampo(input);
                                }
                            }

                            var camposInvalidos = camposObligatorios.some(function (campo) {
                                var input = document.getElementById(campo);
                                return input.classList.contains("campo-invalido");
                            });
                            if (camposInvalidos) {
                                alert("Por favor, complete todos los campos obligatorios.");
                                return false;
                            }

                            return true;
                        }

</script>



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
                                "scrollX": true // Habilita el desplazamiento horizontal
                            });
                        });
</script>



<style>
    #miTabla {
        table-layout: fixed;
        width: 100%;

    }
    .dataTables_info {
        font-family: 'Roboto', sans-serif;
        font-weight: 700;
        position: absolute;
        bottom: -10%;
        right:  0%;
        transform: translateX(-50%);
        margin-bottom: 15px; /* Ajusta según sea necesario */
        color: #09f;
    }
    /* Con la propiedad bottom y letf controlo l aubicacion de la info */
    .dataTables_paginate {
        font-family: 'Roboto', sans-serif;
        padding: 10px  10px;
        bottom: auto;
        left:  auto;

    }

    /* CSS personalizado para DataTables */
    .dataTables_wrapper {
        font-family: 'Roboto', sans-serif;
        color: green;
    }
    /* Alinear botones de paginación a la derecha */
    .dataTables_paginate ul.pagination {
        font-family: 'Roboto', sans-serif;
        float:left;
    }
    .dataTables_filter {
        float: left !important; /* Establece la barra de búsqueda a la izquierda */
    }
    .dataTables_info {
        float: right !important; /* Establece la información a la izquierda */
    }


</style>



</body>
</html>
