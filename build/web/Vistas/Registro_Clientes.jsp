
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Modelo.Documento"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>


<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

        <!-- Estilos para los botones  -->
        <link href="Vistas/Estilos_css/StyleBotones.css" rel="stylesheet" type="text/css"/>
        <!-- 
        Estilos para los botones Formualario 
        Link estilos4.css        -->

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <title>Clientes</title>   

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
                                <span  style="margin-left: 10px; border:none; font-size: 16px" class="btn btn-outline-light">
                                    <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</span>
                            </a></b>

                        </li><li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ControladorClientes?accion=listar">
                                <span  style="margin-left: 10px; border:none; font-size: 16px" class="btn btn-outline-light">
                                    <i <i class="fas fa-list"></i><b>
                                        Listar
                                </span>
                            </a></b>

                        </li>

                    </ul>
                </div>
            </div>

        </nav>

        <style>

            .formulario h1{

            
                margin-bottom:  40px;
                margin-top:   0px;
                background: none;

                color: #09f;
                font-size: 36px;
                font-weight: bold;
                text-align: center;
                    font-family: 'Roboto', sans-serif;
                font-weight: bold;
               
            }
        </style>

        <!--Barra de Navegacion -->

        <div class="container-fluid">
            <div class="col-sm-8 mb-4">
                <br>

                <form  class="formulario" action="ControladorClientes" method="post" class="custom-form">

                    <h1> REGISTRO CLIENTE</h1>

                    <div class="Container centrado">
                        <div class="row">
                            <div class="col-md-6 ">

                                <div class="form-group text-left">
                                    <label for="razonSocial" class="text-left">Cliente</label>
                                    <input type="text" class="form-control" id="razonSocial" name="razonSocial" 
                                           placeholder="Ingrese Empreza">
                                </div>                           

                                <div class="form-group text-left">
                                    <label for="nombres">Nombres</label>
                                    <input type="text" class="form-control" id="nombres" name="nombres" 
                                           placeholder="Ingrese Nombres">
                                </div>

                                <div class="form-group text-left">
                                    <label for="idDocumento"> Tipo_Doc</label>
                                    <select class="form-control" id="idDocumento" name="idDocumento">
                                        <option value="0">Seleccione Cliente</option>
                                        <%
                                            for (Documento documento : DaoDocumento.listar()) {
                                                if (documento != null) {
                                        %>
                                        <option  value="<%=documento.getIdDocumento()%>"><%=documento.getTipo_documento()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group text-left">
                                    <label for="numDocumento"># Documento</label>
                                    <input type="text" class="form-control" id="numDocumento" name="numDocumento" 
                                           placeholder="Ingrese Docum">
                                </div>

                            </div>
                            <div class="col-md-6"> 

                                <div class="form-group text-left">
                                    <label for="direccion">Direccion</label>
                                    <input type="text" class="form-control" id="direccion" name="direccion" 
                                           placeholder="Ingrese direccion">
                                </div>

                                <div class="form-group text-left">
                                    <label for="numTelefono">Telefono</label>
                                    <input type="text" class="form-control" id="numTelefono" name="numTelefono" 
                                           placeholder="Ingrese Telefono">
                                </div>

                                <div class="form-group text-left">
                                    <label for="correo">Correo</label>
                                    <input type="email" class="form-control" id="correo" name="correo"
                                           placeholder="Ingrese Correo">
                                </div>


                            </div>
                        </div>
                    </div>

                    <div class="formulario__grupo formulario__grupo-btn-enviar">     

                        <button    type="submit" name="accion" value="registrar"   class="btn btn-success" >
                            Registrar   
                            <i class="fas fa-save " style="color: #000;"></i>
                        </button> 

                        <!--button type="button" onclick="mostrarAlerta()" class="btn btn-outline-primary">
                            <i class="fas fa-save"></i> Guardar Registro
                        </button-->

                    </div>    
                </form>

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

        <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>
     


    </body>
</html>
