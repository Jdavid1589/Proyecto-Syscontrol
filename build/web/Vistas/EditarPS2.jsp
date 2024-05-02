
<%@page import="Modelo.ControlSeco"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.Productos"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="Persistencia.DaoProductoSeco"%>
<%@page import="Persistencia.DaoSeguimientos"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Seguimientos"%>
<%@page import="Modelo.Usuarios"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Calidad-Tdo Seco</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

        <link href="Vistas/Estilos_css/EstilosPL2.css" rel="stylesheet" type="text/css"/>


    </head>

    <body>
        <%
            int id = Integer.parseInt((String) request.getAttribute("idEditar_ps"));
            ControlSeco controlSeco = DaoProductoSeco.listarAtributos2(id);

        %>

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"></a>
                <img src="./Vistas/Imagenes/MI.jpg"  alt="Logo" width="110"/>
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
                                <span  style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</b></span>
                            </a>
                        </li><li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ControladorPs?accion=listar">
                                <span style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i <i class="fas fa-list"></i><b>  Listar</b>
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>

        <main>
            <div class="container-fluid text-center" style="position: relative; top: -22px;">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <br>
                        <h4 class="text-primary elegant-font mt-5"><b>EDITAR  PRODUCTO SECO</b></h4>

                    </div>
                </div>
            </div>


            <!-- Grupo: ID -->
            <div  class="formulario__grupo" id="grupo__Id">
                <label for="id">ID Registro</label>
                <input type="text" class="form-control col-md-3" readonly="" id="idControlCalidad" 
                       value="<%=controlSeco.getIdControlCalidad()%>" name="idCt">
            </div>
            <!-- Incio Formulario -->
            <form class="formulario" id="formulario" action="ControladorPS" method="post">

                <!-- Grupo: Referencia -->
                <div class="formulario__grupo" id="grupo__producto">
                    <label class="formulario__label" for="idProductos"> Referencia</label>
                    <select class="form-control" id="idProductos" style="border: 2px solid #ffdf7e;" 
                            value="<%=controlSeco.getIdProductos()%>" name="idProductos" >
                        <option value="0">Seleccione Referencia</option>
                        <% for (Productos pr : DaoProductos.listarPS()) { %>
                        <% if (pr != null) {%>
                        <option value="<%= pr.getIdProductos()%>"><%= DaoProductos.obtenerNombreProducto(pr.getIdProductos())%></option>
                        <% } %>
                        <% }%>
                    </select>
                </div> 

                <!-- Grupo: Fecha -->
                <div class="formulario__grupo" id="grupo__fecha">
                    <label class="formulario__label" for="fecha">Fecha</label>
                    <div class="formulario__grupo-input">
                        <input type="date" class="formulario__input" id="fecha"  value="<%=controlSeco.getFecha()%>" name="fecha" placeholder="%Solidos">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                </div>


                <!-- Grupo: Lote -->
                <div class="formulario__grupo" id="grupo__lote">
                    <label for="lote" class="formulario__label">Lote</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="lote"  value="<%=controlSeco.getLote()%>"
                               id="lote" placeholder="% lote">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>               
                    <!-- Grupo: Cant Kg NC-->
                    <div class="formulario__grupo" id="grupo__cant_nc">
                        <label for="cant_nc" class="formulario__label">Cantidad NC</label>
                        <div class="formulario__grupo-input">
                            <input type="text" class="formulario__input" name="cant_noconf"  value="<%=controlSeco.getCant_noconf()%>"
                                   id="cant_nc" placeholder="% cant_nc">
                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                        </div>
                        <!-- Grupo: Auxiliar -->
                        <div class="formulario__grupo" id="grupo__Usuario">
                            <label  class="formulario__label" for="Usuarios"> Auxiliar</label>
                            <select class="formulario__input" class="form-control" id="Usuarios" 
                                    name="idUsuarios">
                                <option value="0">Seleccione Aux</option>
                                <% for (Usuarios usuarios : DaoUsuarios.listar()) {
                                        if (usuarios != null) {%>
                                <option  value="<%=usuarios.getIdUsuarios()%>"><%=usuarios.getNombres_apellido()%></option>
                                <%  }
                                    }%>
                            </select>
                        </div>
                       

                        <!-- Grupo: Causas -->
                        <div class="formulario__grupo" id="grupo__Causas">
                            <label for="Causas" class="formulario__label">Causas</label>
                            <div class="formulario__grupo-input">
                                <input type="text" class="formulario__input" name="Causas"  value="<%=controlSeco.getCausas()%>"
                                       id="Causas" placeholder="% Causas">
                                <i class="formulario__validacion-estado fas fa-times-circle"></i>
                            </div>





                            <div class="formulario__grupo formulario__grupo-btn-enviar">
                                <input type="hidden" name="txtid_ps" value="<%=controlSeco.getIdControlCalidad()%>">
                                <button type="submit" name="accion" value="registrarEdicion2"  class="formulario__btn">Actualizar</button>   
                                <p class="formulario__mensaje-exito" id="formulario__mensaje-exito">Formulario enviado exitosamente!</p>
                            </div>              


                            </form>
                            </main>


                            <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
                            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
                            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


                            <script src="./js/ValidacionPL.js" type="text/javascript"></script>
                            <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>

                            </body>      
                            </body>
                            </html>
