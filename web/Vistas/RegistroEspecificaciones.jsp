
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="Modelo.Productos"%>
<%@page import="java.util.List"%>

<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
               <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <title>Registro Esp Lodos</title>   

    </head>
    <body>


        <!--Barra de Navegacion -->
           <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"></a>
                <img src="./Vistas/Imagenes/MI.jpg"  alt="Logo" width="110px"/>
                <button 
                    class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse  " id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-3 mb-lg-0">   

                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="./index3.jsp">
                                <span  class=" btn btn-primary ">
                                    <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</span>
                            </a></b>

                        </li><li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ControladorEspecificaciones?accion=listar">
                                <span  class=" btn btn-primary ">
                                    <i <i class="fas fa-list"></i><b>
                                        Listar
                                </span>
                            </a></b>

                        </li>

                    </ul>
                </div>
            </div>

        </nav>

        <!--Barra de Navegacion -->


        <div class="container  mt-5 "> 
            <h1 class=" elegant-font text-primary">REGISTRO ESPECIFICACIONES</h1>

            <form action="ControladorEspecificaciones" autocomplete="off" method="POST" class="custom-form">         

                <div class="Container centrado">
                    <div class="row">
                        <div class="col-md-6 ">
                           <div class="form-group text-left">
                                <label for="productos_idProductos"> Referencia</label>
                                <select class="form-control" id="productos_idProductos" name="productos_idProductos">
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
                                <label for="clientes_idclientes"> Cliente</label>
                                <select class="form-control" id="clientes_idclientes" name="clientes_idclientes">
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

                            <div class="form-group text-left">
                                <label for="variablesEspecificacion" class="text-left">Caracteristicas</label>
                                <input type="text" class="form-control" id="variablesEspecificacion" name="variablesEspecificacion" 
                                       placeholder="Ingrese Variable">
                            </div> 

                        </div>
                        <div class="col-md-6"> 

                            <div class="form-group text-left">
                                <label for="valorEspecificacion" class="text-left">Especificacion</label>
                                <input type="text" class="form-control" id="valorEspecificacion" name="valorEspecific" 
                                       placeholder="Ingrese Valor">
                            </div>                           
                            <div class="form-group text-left">
                                <label for="metodoAnalisis" class="text-left">Metodo Analisis</label>
                                <input type="text" class="form-control" id="metodoAnalisis" name="metodoAnalisis" 
                                       placeholder="Ingrese Metodo">
                            </div> 


                            <div class="form-group text-right ">
                                <button type="submit" name="accion" value="registrar" class="btn btn-outline-primary">
                                    <i class="fas fa-save "></i> Guardar</button>

                                <!--button type="button" onclick="mostrarAlerta()" class="btn btn-outline-primary">
                                    <i class="fas fa-save"></i> Guardar Registro
                                </button-->
                                <a href="./index3.jsp"class="btn  btn-outline-success"> <span class="text-warning">Inicio</span></a>
                            </div>    
                            </form>

                        </div> 
                    </div> 
                </div> 
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
                <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><%--lo de las alertas--%>




                </body>
                </html>
