
<%@page import="Persistencia.DaoProductos"%>
<%@page import="Persistencia.DaoTipoProducto"%>
<%@page import="Modelo.TipoProducto"%>
<%@page import="Modelo.TipoProducto"%>

<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>


<%@page import="java.util.List"%>
<%@page import="Modelo.Productos"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
       <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

        <title>Editar_PS</title>
    </head>
    <body>
        <%-- Optenemos el ID del Producto y se lo pasamos al metodo de listar para editar --%>
        <%
            int id = Integer.parseInt((String) request.getAttribute("idEditarPr"));
            Productos productos = DaoProductos.listarAtributos(id);
        %>

        <div class="container-fluid text-center mt-3">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <h1 class="mt-3">EDITAR PRODUCTOS </h1>

                    <form action="ControladorProductos" method="POST" class="custom-form">

                        <div class="form-group text-left">                        

                            <div class="form-group text-left mt-2">
                                <label for="id">ID Producto</label>
                                <input type="text" class="form-control col-md-3" readonly="" id="idControlCalidad" 
                                       value="<%=productos.getIdProductos()%>" name="idProductos2">
                            </div>

                        </div>

                        <div class="row">

                            <div class="col-md-6">

                                <div class="form-group text-left"> 
                                    <label for="variablesEspecificacion" class="text-left"> <b style="color: #00008B; font-family: Century Gothic;">REFERENCIA</b></label>
                                    <input  style="color: #00008B; background: #7abaff; font-family: Century Gothic ; font-size: 18PX;" 
                                            <input type="text" class="form-control" id="referencia"   
                                            value="<%=productos.getNombres_Productos()%>" name="referencia" 
                                            placeholder="Ingrese Producto">                           
                                </div> 

                                <div class="form-group text-left">
                                    <label for="tipoProducto">Tipo</label>
                                    <select class="form-control" id="tipoPerfil" value="<%=productos.getTipoProducto_idtipoProducto()%>" name="idtipo">
                                        <option value="0">Seleccione Tipo</option>
                                        <% List<TipoProducto> tipopro = DaoTipoProducto.listar();
                                            if (tipopro != null) {
                                                for (TipoProducto tipoproducto : tipopro) {
                                                    if (tipoproducto != null) {%>
                                        <option value="<%=tipoproducto.getIdtipoProducto()%>"><%=tipoproducto.getTipo()%></option>
                                        <% }
                                                }
                                            }%>
                                    </select>
                                </div>


                            </div>

                            <div class="form-group text-right">
                                <input type="hidden" name="txtidProducto" value="<%=productos.getIdProductos()%>">

                                <button type="submit" name="accion" value="registrarEdicion" class="btn btn-primary">
                                    <i class="fas fa-sync"></i>Actulizar
                                </button>

                                <a href="ControladorProductos?accion=listar" class="btn btn-secondary "><span >
                                        <i class="fas fa-times dan"></i> Cancelar </span></a>

                            </div>
                    </form>

                    <h1>${mensaje}</h1>
                </div>
            </div>
        </div>



        <!-- Bootstrap CSS y JavaScript -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
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
