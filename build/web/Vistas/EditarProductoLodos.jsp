
<%@page import="Persistencia.DaoProductoLodo"%>
<%@page import="Modelo.ControlLodo"%>
<%@page import="Modelo.ControlSeco"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.Document"%>


<%@page import="java.util.List"%>
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
            int id = Integer.parseInt((String) request.getAttribute("idEditarPL"));
            ControlLodo controlLodo = DaoProductoLodo.listarAtributos2(id);
        %>


        <div class="container-fluid text-center mt-3">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <h1 class="mt-3">EDITAR PRODUCTOS LODOS</h1>

                    <form action="ControladorPL" method="POST" class="custom-form">

                        <div class="form-group text-left">                            

                            <button type="submit" name="accion" value="registrarEdicion" class="btn btn-primary">                                
                                <i class="fas fa-sync"></i>Actulizar</button>

                            <a href="ControladorPL?accion=listar" class="btn btn-secondary"><span >
                                    <i class="fas fa-times dan"></i> Cancelar</span></a>

                            <div class="form-group text-left mt-2">
                                <label for="id">ID Registro</label>
                                <input type="text" class="form-control col-md-3" readonly="" id="idControlCalidad" 
                                       value="<%=controlLodo.getIdControlCalidad()%>" name="idCt">
                            </div>

                        </div>

                        <div class="row">

                            <div class="col-md-6">


                                <div class="form-group text-left">
                                    <label for="fecha">Fecha</label>
                                    <input type="date" class="form-control"  value="<%=controlLodo.getFecha()%>" id="fecha" name="fecha"
                                           placeholder="Ingrese fecha">
                                </div>
                                <div class="form-group text-left">
                                    <label for="idUsuarios"> Auxiliar</label>
                                    <select class="form-control" value="<%=controlLodo.getIdUsuarios()%>" id="idUsuarios" style="border: 2px solid #ffdf7e;"  
                                            name="idUsuarios">
                                        <option value="0">Seleccione Aux</option>
                                        <%
                                            for (Usuarios usuarios : DaoUsuarios.listar()) {
                                                if (usuarios != null) {
                                        %>
                                        <option  value="<%=usuarios.getIdUsuarios()%>"><%=usuarios.getNombres_apellido()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>

                                <div class="form-group text-left">
                                    <label for="idProductos"> Referencia</label>
                                    <select     value="<%=controlLodo.getIdProductos()%>" class="form-control" id="idProductos" 
                                                style="border: 2px solid #ffdf7e;"   name="idProductos">
                                        <option value="0">Seleccione Referencia</option>
                                        <% for (Productos pr : DaoProductos.listar()) { %>
                                        <% if (pr != null) {%>
                                        <option value="<%= pr.getIdProductos()%>"><%= DaoProductos.obtenerNombreProducto(pr.getIdProductos())%></option>
                                        <% } %>
                                        <% }%>
                                    </select>
                                </div>

                                <div class="form-group text-left">
                                    <label for="idSeguimiento"> Segumiento</label>
                                    <select class="form-control" id="idSeguimiento"  value="<%=controlLodo.getIdSeguimiento()%>" style="border: 2px solid #ffdf7e;"  
                                            name="txtSto">
                                        <option value="0">Seleccione Sto</option>
                                        <%
                                            for (Seguimientos sto : DaoSeguimientos.listar()) {
                                                if (sto != null) {
                                        %>
                                        <option  value="<%=sto.getIdSeguimientos()%>"><%=sto.getNumSeguimiento()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>

                                <div class="form-group text-left">
                                    <label for="txtTanque">Tanque</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getNumeroTanque()%>" id="txtTanque" name="txtTanque"
                                           placeholder="Ingrese # TQ" >
                                </div>

                                <div class="form-group text-left">
                                    <label for="lotes">Lote</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getLote()%>" id="lotes" name="lote"
                                           placeholder="Ingrese Lote" >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtCantkg">Cantidad Kg</label>
                                    <input type="text"  class="form-control"  value="<%=controlLodo.getCantiKgLodo()%>" id="txtCantkg" name="txtCantkg" 
                                           placeholder="Ingrese Cantidad">
                                </div>

                                <div class="form-group text-left">
                                    <label for="txtHumedad" style="color: #1e7e34"><b>% Solidos</b></label>
                                    <input onkeyup="calcularHumedad(this);"  value="<%=controlLodo.getSolidos()%>" style="background:  #9fcdff"
                                           type="number" step="0.01" class="form-control".
                                           id="Solidos" name="txtSolidos" 
                                           placeholder="Ingrese % Sol">
                                </div>

                                <div class="form-group text-left">
                                    <label for="Humedad" style="color: #1e7e34"><b>Humedad</b></label>
                                    <input type="number" value="<%=controlLodo.getHumedad()%>"  class="form-control" id="Humedad" 
                                           name="txtHumedad" placeholder="Humedad" readonly="" 
                                           onkeyup="calcularPromedioHum(this);"  >
                                </div>

                                <div class="form-group text-left">
                                    <label for="r325">%R325</label>
                                    <input type="number"  value="<%=controlLodo.getRetenido325()%>" 
                                           step="0.01" class="form-control" id="r325" name="retenido325"
                                           placeholder="Ingrese R325"  >
                                </div>


                                <div class="form-group text-left">
                                    <label for="txtpH">pH</label>
                                    <input type="number" value="<%=controlLodo.getpH()%>" step="0.01" class="form-control" id="txtpH"
                                           name="txtpH"
                                           placeholder="Ingrese pH"  >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtku">Visc Ku</label>
                                    <input type="number" step="0.01" value="<%=controlLodo.getViscosidadKu()%>" class="form-control" id="txtku"
                                           name="txtku"
                                           placeholder="Ingrese pH"  >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtcP">Visc cP</label>
                                    <input type="number" step="0.01" class="form-control" value="<%=controlLodo.getViscosidadCp()%>" id="txtcP"
                                           name="txtcP"
                                           placeholder="Ingrese pH"  >
                                </div>



                                <div class="form-group text-left">
                                    <label for="valor4">Dv(50)</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getDv50()%>" id="dtp" name="Dv50"
                                           placeholder="Ingrese DTP"  >
                                </div>

                            </div>

                            <div class="col-md-6">



                                <div class="form-group text-left">
                                    <label for="valor4">Dv(90</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getDv90()%>" id="dtp1" name="Dv90"
                                           placeholder="Ingrese DTP"  >
                                </div>
                                <div class="form-group text-left">
                                    <label for="valor4">Abs.Aceite</label>
                                    <input type="text" class="form-control" id="AA" value="<%=controlLodo.getAbs_Aceite()%>" name="abs_Aceite"
                                           placeholder="Ingrese AA"  >
                                </div>
                                <div class="form-group text-left">
                                    <label for="valor4">Brigh</label>
                                    <input type="text" class="form-control" id="BR" value="<%=controlLodo.getBrigh()%>" name="Brigh"
                                           placeholder="Ingrese BR"  >
                                </div>

                                <div class="form-group text-left">
                                    <label for="valor4">Whitness</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getWhitness()%>" id="Wh" name="Whitness"
                                           placeholder="Ingrese BR" >
                                </div>

                                <div class="form-group text-left">
                                    <label for="txtkgAgua">Kg Agua</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getLtAgua()%>" id="txtkgAgua" name="txtkgAgua"
                                           placeholder=" Kg Agua" >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtkgDisp">Dispersante</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getDispersante()%>" id="txtkgDisp" name="txtkgDisp"
                                           placeholder=" Kg Disp" >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtkgEsp">Sln Espes</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getLtNatrosol()%>" id="txtkgEsp" name="txtkgEsp"
                                           placeholder=" Kg Disp" >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtLtBio">Lt Biocidad</label>
                                    <input type="text" class="form-control"  value="<%=controlLodo.getLtBiocidad()%>" id="txtLtBio" name="txtLtBio"
                                           placeholder=" Lt Bioic" >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtPorBio">% Biocidad</label>
                                    <input type="text" class="form-control" id="txtPorBio" value="<%=controlLodo.getBiocidadPorcentaje()%>" name="txtPorBio"
                                           placeholder=" % Bioic" >
                                </div>
                                <div class="form-group text-left">
                                    <label for="txtSodio">Kg C.Sodio</label>
                                    <input type="text" class="form-control"  value="<%=controlLodo.getKgCarbonatoSosio()%>"
                                           id="txtSodio" name="txtSodio"
                                           placeholder=" kg Sodio" >
                                </div>

                                <div class="form-group text-left">
                                    <label for="comentarios">Comentarios</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getComentarios()%>" id="Comentarios" name="comentarios"
                                           placeholder="Ingrese comentario"  >
                                </div>

                                <div class="form-group text-left">
                                    <label for="valor4">Observacion</label>
                                    <input type="text" class="form-control" value="<%=controlLodo.getObservacion()%>" id="obs" name="observacion" 
                                           placeholder="Ingrese Obs"  >
                                </div>
                                <div class="form-group text-left">
                                    <label  style="color: #34ce57" for="valor4"><b># CONSECUTIVO</b></label>
                                    <input  type="number" class="form-control"  style="background:  #ffdf7e" 
                                            value="<%=controlLodo.getIdConsecutivo()%>" id="idConsecutivo" name="idConsecutivo" 
                                            placeholder="Ingrese idConsecutivo"  >
                                </div>




                            </div>
                        </div>

                        <div class="form-group text-right">

                            <input type="hidden" name="txtid_pl" value="<%=controlLodo.getIdControlCalidad()%>">

                            <button type="submit" name="accion" value="registrarEdicion" class="btn btn-primary">
                                <i class="fas fa-sync"></i>Actulizar
                            </button>
                            <button type="submit" name="accion" value="generarpdf" class="btn btn-primary">
                                <i class="fas fa-sync"></i>pdf
                            </button>
                            <a href="ControladorPL?accion=listar" class="btn btn-secondary "><span >
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
