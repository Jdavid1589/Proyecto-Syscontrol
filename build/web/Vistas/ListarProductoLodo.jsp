
<%@page import="Modelo.ControlLodo"%>
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
        <title>Lista Producto Lodos</title>

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
        <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet"-->

        <link href="Vistas/css4/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css4/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <link href="Vistas/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">     

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">

        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/css_tablas.css" rel="stylesheet" type="text/css"/>

    </head>
    <body> 

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-lg navbar-darkborder-3 fixed-top border-bottom " >
            <div class="container-fluid ">
                <img src="./Vistas/Imagenes/MI.jpg" alt="Logo" style="float: left; width: 90px;" />
                <button 
                    class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>               

                <!-- Botones de exportación -->
                <div class="botones-export">
                    <!-- Aquí va tu código HTML para los botones -->
                </div>
                <div class="collapse navbar-collapse  " id="navbarSupportedContent">  
                    <ul class="navbar-nav ml-3 me-auto">  
                        <form class="navbar-nav ms-auto ml-auto" action="ControladorPL" method="post" class="custom-form" role="search">
                            <input class="form-control " type="search" name="txtbuscar" placeholder="Aux, Fecha, Lote, Ref" aria-label="Buscar">
                            <button  type="submit" name="accion" value="buscar" style="background:  rgb(212, 173, 17)" class="btn  bt-sm ml-1">Buscar</button>
                        </form>

                    </ul>
                    <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span>
                                    REGISTRO PRODUCTO LODO
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
                            <a class="nav-link active" aria-current="page" href="ControladorPL?accion=listar">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-list"></i> <b>Listar</b></span>
                            </a>
                        </li>
                    </ul>
                    <span onclick="location.reload()" class="btn btn-outline-light text-center"  style="font-size: 20px; color: #ffcd39; margin-left: 25px; border:none" >
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
            <br> 

            <!--h1 class="mt-3">lodos</h1-->
            <%--  <div class=" mt-5 mx-auto">
                <a href="ControladorPL?accion=add" 
                   class=" btn btn-warning text-primary ml-3 mb-2 float-start">           
                    <i class="fas fa-plus"></i>
                </a>
            </div>--%>
            <div class=" mt-5 mx-auto">
                <a href="ControladorPL?accion=add2" 
                   class=" btn btn-primary text-warning ml-3 mb-2 float-start">           
                    <i class="fas fa-plus"></i>
                </a>
            </div>

            <div class="table-container ml-3 md-3 table-responsive pagination-container" id="paginationContainer">
                <table id="miTabla" class="table table-striped table-hover sticky-top">
                    <!-- Contenido de la tabla -->         

                    <thead >
                        <tr>
                            <th style="width: 20%;"> ID </th>
                            <th style="width: 40%;">Fecha</th>
                            <th>Referencia</th>
                            <th>Tanque</th>
                            <th>Lote</th>
                            <th>Seguimiento</th>
                            <th>Cant Kg</th>                            
                            <th>Solidos</th>          
                            <th>Humedad</th>
                            <th>R.325</th>
                            <th>Abs.A</th>
                            <th> pH Directo</th>                          
                            <th> Visc Ku </th>                          
                            <th> Visc Cp </th>  
                            <th>Brigh</th>
                            <th> Wh </th> 
                            <th>Dv(50)</th>
                            <th>Dv(90)</th>
                            <th>Kg Agua</th>
                            <th>Dispersante</th>
                            <th>Sln Espesante</th>
                            <th>Lt. Biocidad</th>
                            <th>% Biocidad</th>
                            <th>Auxiliar</th>

                            <th style="background:  #ffcd39">
                                <b style="color:  #0000ff; font-family: Arial; font-size: 14px; ">
                                    # Consecutivo</b>
                            </th>
                            <th style="background:  #ffcd39">
                                <b style="color:  #0000ff; font-family: Arial; font-size: 14px; ">
                                    Referencia </b>
                            </th>
                            <th style="background:  #ffcd39">
                                <b style="color:  #0000ff; font-family: Arial; font-size: 14px; ">
                                    Cliente </b>
                            </th>


                            <th>Comentarios</th>
                            <th>Observación</th>
                            <th><b>Acciones</b></th>

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<ControlLodo> ControlLodo = (List<ControlLodo>) request.getAttribute("listaProducLodo");
                            for (ControlLodo terminadoseco : ControlLodo) {%>
                        <tr class="negrita">

                            <td ><%= terminadoseco.getIdControlCalidad()%></td>
                            <td><%= terminadoseco.getFecha()%></td>                          
                            <td><strong><%= DaoProductos.obtenerNombreProducto(terminadoseco.getIdProductos())%></strong></td>
                            <td><%= terminadoseco.getNumeroTanque()%></td>
                            <td><%= terminadoseco.getLote()%></td>
                            <td><%=DaoSeguimientos.obtenerNombreVariable(terminadoseco.getIdSeguimiento())%></td>
                            <td><%= terminadoseco.getCantiKgLodo()%></td>
                            <td><%= terminadoseco.getSolidos()%></td>
                            <td><%= terminadoseco.getHumedad()%></td>
                            <td><%= terminadoseco.getRetenido325()%></td>
                            <td><%= terminadoseco.getAbs_Aceite()%></td>
                            <td><%= terminadoseco.getPH()%></td>
                            <td><%= terminadoseco.getViscosidadKu()%></td>
                            <td><%= terminadoseco.getViscosidadCp()%></td>
                            <td><%= terminadoseco.getBrigh()%></td>
                            <td><%= terminadoseco.getWhitness()%></td>
                            <td><%= terminadoseco.getDv50()%></td>
                            <td><%= terminadoseco.getDv90()%></td>
                            <td><%= terminadoseco.getLtAgua()%></td>
                            <td><%= terminadoseco.getDispersante()%></td>
                            <td><%= terminadoseco.getLtNatrosol()%></td>
                            <td><%= terminadoseco.getLtBiocidad()%></td>
                            <td><%= terminadoseco.getBiocidadPorcentaje()%></td>
                            <td><%= DaoUsuarios.obtenerNombreUsuario(terminadoseco.getIdUsuarios())%></td> 
                            <td>
                                <b style=" font-family: Arial; font-size: 14px;">
                                    <%= String.format("%04d", terminadoseco.getIdConsecutivo())%></b>
                            </td>
                            <%--  <td class="text-center"><%= String.format("%04d", terminadoseco.getIdConsecutivo())%></td>--%>
                            <td><strong><%= DaoProductoSeco.obtenerProductoFinal(terminadoseco.getIdControlCalidad())%></strong></td>
                            <td><strong><%= DaoProductoSeco.obtenerclienteFinal(terminadoseco.getIdControlCalidad())%></strong></td>

                            <td><%= terminadoseco.getComentarios()%></td>
                            <td><%= terminadoseco.getObservacion()%></td>                        
                            <td>
                                <div class="btn-group" role="group" aria-label=" Acciones ">


                                    <%--    <a href="ControladorPL?accion=editar_pl&id=<%= terminadoseco.getIdControlCalidad()%>" 
                                       class="btn   btn-sm ms-1">
                                        <i class="fas fa-pencil-alt mb-2"style="font-size: 20px; color: #0000ff"></i> <!-- Ícono de lápiz -->
                                    </a>--%>
                                    <a href="ControladorPL?accion=editar2&id=<%= terminadoseco.getIdControlCalidad()%>" 
                                       class="btn   btn-sm ms-1">
                                        <i class="fas fa-pencil-alt mb-2" style="font-size: 20px; color: #09f"></i> <!-- Ícono de lápiz -->
                                    </a>
                                    <a href="ControladorPL?accion=pdf&id=<%= terminadoseco.getIdControlCalidad()%>" 
                                       class="btn  btn-sm   ms-1 "  >
                                        <i class="bi bi-file-pdf" style="font-size: 22px; color: red"></i> <!-- Ícono pdf más grande -->
                                    </a>
                                    <a href="ControladorPL?accion=eliminar2&id=<%=terminadoseco.getIdControlCalidad()%>"
                                       class="btn  btn-sm  ms-1" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?')">
                                        <i id="mipapelera" class="fas fa-trash "  ></i> <!-- Ícono de papelera -->
                                    </a>  

                                </div>
                            </td>


                        </tr>
                        <% }%>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th style="width: 20%;"> ID </th>
                            <th style="width: 40%;">Fecha</th>
                            <th>Referencia</th>
                            <th>Tanque</th>
                            <th>Lote</th>
                            <th>Seguimiento</th>
                            <th>Cant Kg</th>                            
                            <th>Solidos</th>          
                            <th>Humedad</th>
                            <th>R.325</th>
                            <th>Abs.A</th>
                            <th> pH Directo</th>                          
                            <th> Visc Ku </th>                          
                            <th> Visc Cp </th>  
                            <th>Brigh</th>
                            <th> Wh </th> 
                            <th>Dv(50)</th>
                            <th>Dv(90)</th>
                            <th>Kg Agua</th>
                            <th>Dispersante</th>
                            <th>Sln Espesante</th>
                            <th>Lt. Biocidad</th>
                            <th>% Biocidad</th>
                            <th>Auxiliar</th>

                            <th>
                                <b style="color:  #0000ff; font-family: Arial; font-size: 12px; ">
                                    # Consecutivo</b>
                            </th>
                            <th>
                                <b style="color:  #0000ff; font-family: Arial; font-size: 12px; ">
                                    Referencia </b>
                            </th>
                            <th>
                                <b style="color:  #0000ff; font-family: Arial; font-size: 12px; ">
                                    Cliente </b>
                            </th>


                            <th>Comentarios</th>
                            <th>Observación</th>
                            <th><b>Acciones</b></th>

                        </tr>
                    </tfoot>
                </table>

                <div  class="dataTable_bottom">  
                    <div class="dataTables_info"></div>
                    <div class="dataTables_paginate"></div>
                </div>



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

                <div class="form-group text-right  ml-1 mt-3 mb-2  mg-2">
                    <a href="ControladorProductoSeco?accion=listar" class="btn btn-success ml-2">
                        <!-- Icono Pagina Inicio -->
                        <i class="fas fa-list"></i> </a>

                    <!-- Icono Listar -->
                    <a href="index3.jsp" class="btn btn-warning">
                        <i class="bi bi-arrow-left-square-fill text-dark"></i> </a>
                </div>
            </div>

            <!-- Styles particular para Lista Lodos-->
            <style>
                .dataTables_info {
                    position: absolute;
                    bottom: -13%;
                    left: 30%;
                    transform: translateX(-50%);
                    margin-bottom: 15px; /* Ajusta según sea necesario */
                }
                /* Con la propiedad bottom y letf controlo la aubicacion de la info */
                .dataTables_paginate {
           
                    bottom: -15%;
                    left:  100%;
                    margin-bottom: 5px; /* Ajusta según sea necesario */
                }

                /* Move the buttons below the table */

                /*  .dataTables_wrapper .dt-buttons {
                      position: absolute;
                      bottom: -50px;
                      left: 50%;
                      transform: translateX(-60%);
                      margin-bottom: 20px; /* Ajusta según sea necesario 
                  }*/

                /* Estilos redondeados para los btn */

                .btn {
                    border-radius: 20px; /* Redondear los botones */
                }
                #paginationContainer {
                    float: right
                }
                a #mipapelera{
                    font-size: 25px;
                    color: #66ff66;
                    transition: 0.3s;

                }
                a #mipapelera:hover{

                    color: #FF0000;
                    box-shadow: 3px 0px 30px rgba(246, 78, 60, 1.5);

                }


            </style>
            
            <!-- JQuery -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" 
                    integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" 
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>

          

            <!-- JQuery -->
            <script
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
                integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
                crossorigin="anonymous"
                referrerpolicy="no-referrer"
            ></script>
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
            <script src="./js/JS_PL.js" type="text/javascript"></script>      




    </body>
</html>
