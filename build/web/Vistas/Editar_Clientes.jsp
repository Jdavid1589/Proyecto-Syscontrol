
<%@page import="Modelo.Clientes"%>

<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Modelo.Documento"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
     <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

        <title>Editar_Clientes</title>   

    </head>
    <body>

        <style>

            #cuadro {
                /* Estilos para tu cuadro de formulario */
                max-width: 600px;
                margin: 50px auto;
                background-color: rgba(255, 255, 255, 0.8); /* el 0.6 es el grado de transparencia/* Fondo semitransparente para que la imagen de fondo sea visible */
                padding: 20px;

                border-radius: 10px;

                background-color: #ffcc0; /* Cambia #ffcc00 por el color que desees */
                padding: 20px; /* Ajusta el relleno según sea necesario */


            }
        </style>
        <div class="container text-center mt-3">
            <div class="row">
                <div class="col-md-6  mx-auto">

                    <h1 class="mt-3">EDITAR CLIENTES</h1>

                    <%-- 
                          ide = Integer.parseInt(request.getParameter("id"));
                          Usuarios u = DaoUsuarios.obtenerUsuarioPorId(ide);
                          request.setAttribute("User", u);                                   
                    --%>
                    <%--                          
                         /// Esto es la vista editar normal
                            request.setAttribute("idEditar", request.getParameter("id"));
                    --%>

                    <%
                        int id = Integer.parseInt((String) request.getAttribute("idEditar"));
                        Clientes clientes = DaoClientes.obtenerClientePorId(id);
                    %>

                    <form action="ControladorClientes" method="post" class="custom-form">

                        <div class="form-group text-left ">
                            <a href="./index3.jsp"class="btn  btn-block">Pagina Inicio</a>

                          
                        </div>
                        <div class="form-group text-left">
                          <label for="txtid">ID</label>
                            <input type="text" class="form-control col-md-3" readonly=""
                                   id="txtid"
                                   value="<%=clientes.getIdclientes()%>" name="txtid">

                        </div>
                        <div class="row">
                            <div class="col-md-6">


                                <div class="form-group text-left">
                                    <label for="razon_Social" class="text-left">Empresa</label>
                                    <input type="text" class="form-control" id="razon_Social" value="<%=clientes.getRazon_Social()%>"
                                           name="razonSocial" placeholder="Ingrese Empresa">
                                </div>                           

                                <div class="form-group text-left">
                                    <label for="idDocumento">Nombres</label>
                                    <input type="text" class="form-control" id="idDocumento" value="<%=clientes.getNombres_apellidos()%>" 
                                           name="nombres" placeholder="Ingrese Nombres">
                                </div>



                                <div class="form-group text-left">
                                    <label for="idDocumento">Tipo Doc</label>
                                    <select class="form-control" id="idDocumento" name="idDocumento">
                                        <!--option value="0">Seleccione Referencia</option-->
                                        <%
                                            for (Documento documento : DaoDocumento.listar()) {
                                                if (documento != null) {
                                        %>
                                        <option value="<%=documento.getIdDocumento()%>"><%=documento.getTipo_documento()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                                    
                                <div class="form-group text-left">
                                    <label for="numDocumento"># Documento</label>
                                    <input type="text" class="form-control" id="numDocumento" value="<%=clientes.getNumero_Documento()%>" 
                                           name="numDocumento" placeholder="Ingrese docum">
                                </div>

                            </div>


                            <div class="col-md-6"> 

                                <div class="form-group text-left">
                                    <label for="direccion">Direccion</label>
                                    <input type="text" class="form-control" id="direccion" value="<%=clientes.getDireccion()%>" 
                                           name="direccion" placeholder="Ingrese Direccion">
                                </div>

                                <div class="form-group text-left">
                                    <label for="numTelefono">Telefono</label>
                                    <input type="text" class="form-control" id="numTelefono" value="<%=clientes.getNumero_Telefono()%>" 
                                           name="numTelefono" placeholder="Ingrese Telefono">
                                </div>

                                <div class="form-group text-left">
                                    <label for="correo">Correo</label>
                                    <input type="email" class="form-control" id="correo" value="<%=clientes.getCorreo()%>" 
                                           name="correo" placeholder="Ingrese Correo">
                                </div>
                            </div>
                        </div>

                        <!--div id ="cuadro"-->
                        <div class="col-md-12 mt-5 ms-auto"> 
                            <div class="form-group text-right ">
                                <input type="hidden" name="cli2" value="<%=clientes.getIdclientes()%>">
                                <button type="submit" name="accion" value="EditCliente" class="btn btn-primary"> 
                                    <i class="fas fa-sync"></i>ACTUALIZAR</button>

                                <a href="ControladorClientes?accion=listar" class="btn  btn-secondary"> <span class="text-center">
                                        <i class="fas fa-times dan"></i>CANCELAR</span></a>
                            </div>
                        </div>

                    </form>

                    <h1> ${mensaje}</h1>

                    <!-- Bootstrap CSS y JavaScript -->
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
                    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


                    </body>
                    </html>
