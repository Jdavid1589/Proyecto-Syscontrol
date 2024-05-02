<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Modelo.Especificaciones"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="Modelo.Productos"%>
<%@page import="Persistencia.DaoConsecutivo"%>
<%@page import="Modelo.Consecutivo"%>
<%@page import="Modelo.Clientes"%>

<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="java.util.List"%>

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

        <title>Editar_Especificaciones</title>   

    </head>
    <body>


        <div class="container text-center mt-3">
            <div class="row">
                <div class="col-md-6  mx-auto">

                    <h1 class="mt-3">EDITAR ESPECIFICACIONES</h1>

                    <%
                        int id = Integer.parseInt((String) request.getAttribute("idEditar"));
                        Especificaciones especific = DaoEspecificaciones.obtenerEspecificPorId(id);
                    %>

                    <form action="ControladorEspecificaciones" method="POST" class="custom-form">

                        <div class="form-group text-left ">
                            <a href="./index3.jsp"class="btn  btn-block">Pagina Inicio</a>

                            <label for="idespecificaciones">ID</label>
                            <input type="text" class="form-control col-md-3" readonly="" id="idespecificaciones"
                                   value="<%=especific.getIdespecificaciones()%>" name="txtid">
                        </div>

                        <div class="row">
                            <div class="col-md-6">




                                <div class="form-group text-left">
                                    <label for="productos_idProductos">Referencia</label>
                                    <select class="form-control" id="productos_idProductos" name="productos_idProductos">
                                        <!--option value="0">Seleccione Referencia</option-->
                                        <%
                                            for (Productos productos : DaoProductos.listar()) {
                                                if (productos != null) {
                                        %>
                                        <option value="<%=productos.getIdProductos()%>"><%=productos.getNombres_Productos()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>




                                <div class="form-group text-left">
                                    <label for="clientes_idclientes">Referencia</label>
                                    <select class="form-control" id="clientes_idclientes" name="clientes_idclientes">
                                        <!--option value="0">Seleccione Referencia</option-->
                                        <%
                                            for (Clientes clientes : DaoClientes.listar()) {
                                                if (clientes != null) {
                                        %>
                                        <option value="<%=clientes.getIdclientes()%>"><%=clientes.getRazon_Social()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>

                            </div>


                            <div class="col-md-6"> 

                                <div class="form-group text-left">
                                    <label for="variablesEspecificacion">Caracteristicas</label>
                                    <input type="text" class="form-control" id="fechaCertificado" value="<%=especific.getVariablesEspecificacion()%>" 
                                           name="variablesEspecificacion" placeholder="Ingrese Variable">
                                </div>

                                <div class="form-group text-left">
                                    <label for="valorEspecific">Cant Material</label>
                                    <input type="text" class="form-control" id="valorEspecific" value="<%=especific.getValorEspecific()%>" 
                                           name="valorEspecific" placeholder="Ingrese Valor">
                                </div>

                                <div class="form-group text-left">
                                    <label for="metodoAnalisis">Fecha Prod</label>
                                    <input type="text" class="form-control" id="metodoAnalisis" value="<%=especific.getMetodoAnalisis()%>" 
                                           name="metodoAnalisis" placeholder="Ingrese metodo">
                                </div>


                            </div>
                        </div>


                        <div class="col-md-12 mt-5 ms-auto"> 
                            <div class="form-group text-right ">
                                <input type="hidden" name="idEspecificaciones" value="<%=especific.getIdespecificaciones()%>">
                                <button type="submit" name="accion" value="Modificar" class="btn btn-primary">                                   
                                    <i class="fas fa-sync"></i>ACTUALIZAR</button>

                                <!-- El value: EditCliente tiene que ser diferente (cambiar letras  al nombre que se tiene en  
                                else if (action.equalsIgnoreCase("editarclientes")) { -->

                                <a href="ControladorEspecificaciones?accion=listar" class="btn  btn-secondary"> <span class="text-center">
                                        <i class="fas fa-times dan"></i>CANCELAR</span></a>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            </div>


            <h1> ${mensaje}</h1>

            <!-- Bootstrap CSS y JavaScript -->
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


    </body>
</html>

