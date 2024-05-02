

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
        <%
            int id = Integer.parseInt((String) request.getAttribute("idEditar_ps"));
            ControlSeco controlSeco = DaoProductoSeco.listarAtributos2(id);
        %>

        <div class="container-fluid text-center mt-3">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <h1 class="mt-3">EDITAR PRODUCTOS SECOS</h1>

                    <form onsubmit="return validarFormularioEditar();" action="ControladorPs" method="POST" class="custom-form">

                        <div class="form-group text-left">                            

                            <button type="submit" name="accion" value="registrarEdicion" class="btn btn-primary">                                
                                <i class="fas fa-sync"></i>Actulizar</button>

                            <a href="ControladorPs?accion=listar" class="btn btn-secondary"><span >
                                    <i class="fas fa-times dan"></i> Cancelar</span></a>

                            <div class="form-group text-left mt-2">
                                <label for="id">ID Registro</label>
                                <input type="text" class="form-control col-md-3" readonly="" id="idControlCalidad" 
                                       value="<%=controlSeco.getIdControlCalidad()%>" name="idControlCalidad">
                            </div>

                        </div>

                        <div class="row">

                            <div class="col-md-6">


                                <div class="form-group text-left">
                                    <label for="fecha"> Fecha </label>
                                    <input type="date" class="form-control" 
                                           id="fecha" value="<%=controlSeco.getFecha()%>" name="fecha" placeholder="Ingrese Fecha">
                                </div>
                                <div class="form-group text-left">
                                    <label for="idProductos"> Referencia</label>
                                    <select class="form-control" id="idProductos" style="border: 2px solid #ffdf7e;" 
                                            value="<%=controlSeco.getIdProductos()%>" name="idProductos" >
                                        <option value="0">Seleccione Referencia</option>
                                        <% for (Productos pr : DaoProductos.listar()) { %>
                                        <% if (pr != null) {%>
                                        <option value="<%= pr.getIdProductos()%>"><%= DaoProductos.obtenerNombreProducto(pr.getIdProductos())%></option>
                                        <% } %>
                                        <% }%>
                                    </select>
                                </div>

                                <div class="form-group text-left">
                                    <label for="idUsuarios"> Auxiliar</label>
                                    <select class="form-control" id="idUsuarios" style="border: 2px solid #ffdf7e;" 
                                            value="<%=controlSeco.getIdUsuarios()%>" name="idUsuarios">
                                        <option value="0">Seleccione Aux</option>
                                        <%
                                            for (Usuarios usuarios : DaoUsuarios.listar()) {
                                                if (usuarios != null) {
                                        %>
                                        <option  value="<%=usuarios.getIdUsuarios()%>"><%=usuarios.getNombres_apellido()%></option>
                                        <% }
                                            } %>
                                    </select>
                                </div>

                                <div class="form-group text-left">
                                    <label for="lotes">Lotes</label>
                                    <input type="text" class="form-control" id="lotes" value="<%=controlSeco.getLote()%>" name="lote" placeholder="Ingrese Lote">
                                </div>
                                <div class="form-group text-left">
                                    <label for="lotes">kg N.C</label>
                                    <input type="text" class="form-control" id="lotes" value="<%=controlSeco.getCant_noconf()%>" name="cant_noconf" placeholder="Ingrese Lote">
                                </div> 
                                <div class="form-group text-left">
                                    <label for="causas"> Causas</label>
                                    <input type="text" class="form-control" id="lotes" value="<%=controlSeco.getCausas()%>" 
                                           name="causas" placeholder="Ingrese Lote">
                                </div> 
                                <div class="form-group text-left">
                                    <label for="retenido325">% R325</label>
                                    <input type="text" class="form-control" id="r325" value="<%=controlSeco.getRetenido325()%>" name="retenido325" placeholder="Ingrese Dato">
                                </div>

                                <div class="form-group text-left">
                                    <label for="pH"> pH</label>
                                    <input type="text" class="form-control" id="pH_1" value="<%=controlSeco.getPH()%>" name="pH" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="pH"> pH </label>
                                    <input type="text" class="form-control" id="pH_2" value="<%=controlSeco.getpH_2()%>" name="pH_2" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="pH"> pH </label>
                                    <input type="text" class="form-control" id="pH_3" value="<%=controlSeco.getpH_3()%>" name="pH_3" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="pH">pH_Prome</label>
                                    <input style="border: 2px solid #ffdf7e; background: #80bdff"
                                           type="text" class="form-control" id="pH_promedio"
                                           value="<%=controlSeco.getpH_promedio()%>"
                                           name="pH_promedio" placeholder="Ingrese Dato"  onkeyup="calcularPromedioPH(this);"   >
                                </div>


                                <div class="form-group text-left">
                                    <label for="Dv50"> Dv(50)</label>
                                    <input type="text" class="form-control" id="dv50" value="<%=controlSeco.getDv50()%>" name="Dv50" placeholder="Ingrese Dato">
                                </div>

                                <div class="form-group text-left">
                                    <label for="dv90">Dv(90)</label>
                                    <input type="text" class="form-control" id="dv90" value="<%=controlSeco.getDv90()%>" name="Dv90" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="abs_Aceite"> Abs.A</label>
                                    <input type="text" class="form-control" id="AA" value="<%=controlSeco.getAbs_Aceite()%>" name="abs_Aceite" placeholder="Ingrese Dato">
                                </div>


                            </div> 


                            <div class="col-md-6">

                                <div class="form-group text-left">
                                    <label for="Brigh"> Br </label>
                                    <input type="text" class="form-control" id="br" value="<%=controlSeco.getBrigh()%>" name="Brigh" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="Whitness"> Wh </label>
                                    <input type="text" class="form-control" id="wh" value="<%=controlSeco.getWhitness()%>" name="Whitness" placeholder="Ingrese Dato">
                                </div>



                                <div class="form-group text-left">
                                    <label for="observacion">Observacion</label>
                                    <input type="text" class="form-control" id="obs" value="<%=controlSeco.getObservacion()%>" name="observacion" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="observacion">Comentario</label>
                                    <input type="text" class="form-control" id="comentarios" value="<%=controlSeco.getComentarios()%>" name="comentarios" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="idConsecutivo">ID Consecutivo</label>
                                    <input type="text" class="form-control" id="idConsecutivo" value="<%= String.format("%04d", controlSeco.getIdConsecutivo())%>" name="idConsecutivo" placeholder="Ingrese Dato">
                                </div>


                                <%
                                    // Definir el número de campos de humedad
                                    int numCamposHumedad = 30;

                                    // Iterar sobre los campos de humedad
                                    for (int i = 1; i <= numCamposHumedad; i++) {
                                        // Obtener el valor de humedad y convertirlo a String si es necesario
                                        String humedad = String.valueOf(controlSeco.getHumedad(i));
                                        // Verificar si el valor de humedad no es nulo ni está vacío
                                        if (humedad != null && !humedad.isEmpty()) {
                                            double valorHumedad = Double.parseDouble(humedad);
                                            if (valorHumedad != 0.0) {
                                %>
                                <div class="form-group text-left">
                                    <label for="Humedad_<%= i%>">% Hum <%= i%></label>
                                    <input type="text" class="form-control" id="Humedad_<%= i%>" value="<%= humedad%>" name="humedad_<%= i%>" placeholder="Ingrese Dato">
                                </div>
                                <%
                                            } // Fin de la verificación de humedad no nula ni vacía
                                        } // Fin del bucle for
                                    }
                                %>

                                <div class="form-group text-left">
                                    <label for="humedad_promedio">% Hum Prom</label>
                                    <input 
                                        style="border: 2px solid #ffdf7e; background: #80bdff"
                                        type="text" class="form-control" id="Humedad_Promedio" value="<%=controlSeco.getHumedad_promedio()%>" 
                                        name="sol_promedio" placeholder="Ingrese Dato" 
                                        onkeyup="calcularPromedioHum(this);" readonly="" 
                                        >
                                </div>

                            </div>

                            <div class="form-group text-right">
                                <input type="hidden" name="txtid_ps" value="<%=controlSeco.getIdControlCalidad()%>">

                                <button type="submit" name="accion" value="registrarEdicion" class="btn btn-primary">
                                    <i class="fas fa-sync"></i>Actulizar
                                </button>
                                <button type="submit" name="accion" value="generarpdf" class="btn btn-primary">
                                    <i class="fas fa-sync"></i>pdf
                                </button>
                                <a href="ControladorPs?accion=listar" class="btn btn-secondary "><span >
                                        <i class="fas fa-times dan"></i> Cancelar </span></a>

                            </div>
                    </form>

                    <h1>${mensaje}</h1>
                </div>
            </div>
        </div>


        <style>
            .campo-invalido {
                border: 1px solid red; /* Cambia el borde a rojo para resaltar el campo */
                background-color: #ffcccc; /* Cambia el fondo a un tono rojo claro */
            }
        </style>

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


        <script src="./js/FunsionEditarPS.js" type="text/javascript"></script>
    </body>
</html>
