

<%@page import="Persistencia.DaoProductos"%>
<%@page import="Modelo.Productos"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Modelo.Especificaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear PDF</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        
        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
        
        <!--link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"> <!-- Para los Iconos-->

    </head>

    <body>

        <%
            int id = Integer.parseInt((String) request.getAttribute("idpdf"));
            Especificaciones Esp = DaoEspecificaciones.listarAtributospdf(id);
        %>
        <div class="row">
            <div class="card col-sm-12 mb-4  mt-5 sticky-top">
                <form action="ControladorEspecificaciones" method="post" class="custom-form">

                    <div class="row">
                        <div class="col-md-6 ">

                            <div class="form-group text-left mt-2">
                                <label for="id">ID Registro</label>
                                <input type="text" class="form-control col-md-3" readonly="" id="idespecificaciones" 
                                       value="<%=Esp.getIdespecificaciones()%>" name="idespecificaciones">
                            </div>

                            <div class="form-group text-left">
                                <label for="lotes">VariablesEspecifi</label>
                                <input type="text" class="form-control" id="lotes" value="<%=Esp.getVariablesEspecificacion()%>"
                                       name="variablesEspecificacion" placeholder="Ingrese Lote">
                            </div>

                            <div class="form-group text-left">
                                <label for="lotes">ValorEspc</label>
                                <input type="text" class="form-control" id="lotes" value="<%=Esp.getValorEspecific()%>" 
                                       name="valorEspecific" placeholder="Ingrese Lote">
                            </div>

                        </div>
                        <div class="col-md-6 ">

                            <div class="form-group text-left">
                                <label for="lotes">Metodo</label>
                                <input type="text" class="form-control" id="lotes" value="<%=Esp.getMetodoAnalisis()%>" 
                                       name="metodoAnalisis" placeholder="Ingrese Lote">
                            </div>

                            <div class="form-group text-left">
                                <label for="nombresProductos">Referencia</label>
                                <select class="form-control" id="nombresProductos" name="productos_idProductos">
                                    <option value="0">Seleccione Referencia</option>
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
                                <label for="tipoUsuario">Clientes</label>
                                <select class="form-control" id="tipoUsuario" name="clientes_idclientes">
                                    <option value="0">Seleccione Cliente</option>
                                    <% for (Clientes clientes : DaoClientes.listar()) {
                                            if (clientes != null) {%>
                                    <option value="<%=clientes.getIdclientes()%>"><%=clientes.getRazon_Social()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                        </div>

                        <div class="form-group text-right">
                            <input type="hidden" name="txtid_Esp" value="<%=Esp.getIdespecificaciones()%>">


                            <button type="submit" name="accion" value="genpdf" class="btn btn-danger">
                                <i class="bi bi-file-pdf bi-lg"></i>
                            </button>
                            <a href="ControladorEspecificaciones?accion=listar" class="btn btn-secondary "><span >
                                    <i class="fas fa-times dan"></i> Cancelar </span></a>

                        </div>
                    </div>
                </form>
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
