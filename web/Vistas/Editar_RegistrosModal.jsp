<%-- 
    Document   : Editar_RegistrosModal
    Created on : 7/11/2023, 03:31:09 PM
    Author     : JUAN DAVID
--%>

<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
       <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <!-- Formulario de Editar de Perfil -->
        <%
            int id = Integer.parseInt((String) request.getAttribute("idEditar_perfil"));
            Perfil perfil = DaoPerfil.listarAtributosperfil(id);
        %>

        <div class="container-fluid text-center mt-3">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <h1 class="mt-3">EDITAR REGISTROS</h1>

                    <form action="ControladorRegModal" method="post" class="custom-form">


                        <div class="row">
                            <div class="col-md-6">
                                <!--div class="form-group text-left">
                                    <label for="id">ID</label>
                                    <input type="text" class="form-control" readonly="" id="idperfil" value="<%=perfil.getIdperfil()%>" name="idperfil">
                                </div-->                             

                                <div class="form-group text-left">
                                    <label for="tipoperfil">2.Perfil</label>
                                    <input type="text" class="form-control" id="tipo_Perfil" value="<%=perfil.getTipo_Perfil()%>" name="tipo_Perfil" placeholder="Ingrese Lote">
                                </div>                            

                            </div>
                        </div>
                        <span  class=" btn btn-primary ml-3 mb-2 float-start" data-toggle="modal" data-target="#registroModalPerfil2">
                            <i class="fas fa-plus"></i> 
                        </span>

                        <div class="form-group text-right">
                            <input type="hidden" name="txtid" value="<%=perfil.getIdperfil()%>">
                            <button type="submit" name="accion" value="registrarEdicion_perf" class="btn btn-primary">
                                <i class="fas fa-sync"></i>Actulizar</button>
                            <a href="ControladorRegModal?accion=listar" class="btn btn-secondary"><span >
                                    <i class="fas fa-times dan"></i> Cancelar</span></a>

                        </div>
                    </form>

                    <!-- Modal de Registro de Perfil -->
                    <div class="modal fade" id="registroModalPerfil2" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content" style="background-color: #F2F2F2;"> <!-- Cambia el color de fondo aquí -->
                                <div class="modal-header">
                                    <h5 class="modal-title" id="registroModalLabel">EDITAR TIPO PERFIL</h5>
                                    <!-- Botón de cerrar estático -->
                                    <button type="button" class="close"  data-dismiss="modal" aria-label="Close" style="position: static;">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">

                                    <!-- Formulario de Registro de Perfil -->

                                    <form action="ControladorRegModal" method="post" class="custom-form">


                                        <div class="row">
                                            <div class="col-md-6">
                                                <%--div class="form-group text-left">
                                                    <label for="id">ID</label>
                                                    <input type="text" class="form-control" readonly="" id="idperfil" value="<%=perfil.getIdperfil()%>" name="idperfil">
                                                </div--%>                             

                                                <div class="form-group text-left">
                                                    <label for="tipoperfil">2.Perfil</label>
                                                    <input type="text" class="form-control" id="tipo_Perfil" value="<%=perfil.getTipo_Perfil()%>" name="perfil" placeholder="Ingrese Lote">
                                                </div>                            

                                            </div>
                                        </div>


                                        <div class="form-group text-right">
                                            <input type="hidden" name="txtid" value="<%=perfil.getIdperfil()%>">
                                            <button type="submit" name="accion" value="registrarEdicion_perf" class="btn btn-primary">
                                                <i class="fas fa-sync"></i>Actulizar</button>
                                            <a href="ControladorRegModal?accion=listar" class="btn btn-secondary"><span >
                                                    <i class="fas fa-times dan"></i> Cancelar</span></a>

                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>


                    </body>


                    <!-- Bootstrap CSS y JavaScript -->
                    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                    crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
                            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                    crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
                            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                    crossorigin="anonymous"></script>
                    </body>


                    </html>
