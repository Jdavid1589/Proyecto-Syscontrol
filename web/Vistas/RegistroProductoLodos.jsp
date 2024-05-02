


<%@page import="Persistencia.DaoSeguimientos"%>
<%@page import="Modelo.Seguimientos"%>
<%@page import="java.util.Map"%>
<%@page import="Modelo.ControlSeco"%>
<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Modelo.Especificaciones"%>
<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>
<%@page import="java.util.List"%>

<%@page import="Persistencia.DaoProductoSeco"%>

<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.Productos"%>
<%@page import="Persistencia.DaoProductos"%>


<%@page import="Persistencia.DaoUsuarios"%>


<%@page import="Modelo.Usuarios"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

        <title>Calidad-Tdo Seco</title>


    </head>



    <!--Barra de Navegacion -->
    <nav class="navbar  navbar-expand-md navbar-dark bg-primary border-3 fixed-top border-bottom " id="menu">
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
                            <span  style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</b></span>
                        </a>

                    </li><li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="ControladorPL?accion=listar">
                            <span style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                <i <i class="fas fa-list"></i><b>  Listar</b>
                            </span>
                        </a>

                    </li>

                </ul>
            </div>
        </div>

    </nav>

    <!--Barra de Navegacion -->

    <!-- Fila de botones -->
    <!-- Contenedor principal centrado -->
    <div class="container-fluid text-center mt-3">
        <div class="row">
            <div class="col-md-12 mx-auto">
                <br>
                <h1 class="text-primary elegant-font mt-5"><b>REGISTRAR PRODUCTOS LODOS</b></h1>

            </div>
        </div>
    </div>


    <!-- Incio Formulario -->
    <form  onsubmit="return validarFormulario();" autocomplete="off" action="ControladorPL" method="post" class="custom-form">

        <div class="container  "> 
            <div class="row">
                <div class="col-md-6">

                    <div class="form-group text-left">
                        <label for="fecha">Fecha</label>
                        <input type="date" class="form-control" id="fecha" name="fecha"
                               placeholder="Ingrese fecha">
                    </div>
                    <div class="form-group text-left">
                        <label for="idUsuarios"> Auxiliar</label>
                        <select class="form-control" id="idUsuarios" style="border: 2px solid #ffdf7e;"  
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
                        <select class="form-control" id="idProductos" style="border: 2px solid #ffdf7e;" 
                                name="idProductos">
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
                        <select class="form-control" id="idSeguimiento" style="border: 2px solid #ffdf7e;"  
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
                        <input type="text" class="form-control" id="txtTanque" name="txtTanque"
                               placeholder="Ingrese # TQ" >
                    </div>

                    <div class="form-group text-left">
                        <label for="lotes">Lote</label>
                        <input type="text" class="form-control" id="lotes" name="lote"
                               placeholder="Ingrese Lote" >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtCantkg">Cantidad Kg</label>
                        <input type="text"  class="form-control" id="txtCantkg" name="txtCantkg" 
                               placeholder="Ingrese Cantidad">
                    </div>

                    <div class="form-group text-left">
                        <label for="txtHumedad" style="color: #1e7e34"><b>% Solidos</b></label>
                        <input onkeyup="calcularHumedad(this);"  style="background:  #9fcdff"
                               type="number" step="0.01" class="form-control".
                               id="Solidos" name="txtSolidos" 
                               placeholder="Ingrese % Sol">
                    </div>

                    <div class="form-group text-left">
                        <label for="Humedad" style="color: #1e7e34"><b>Humedad</b></label>
                        <input  type="number"   class="form-control" id="Humedad" 
                                name="txtHumedad" placeholder="Humedad" readonly="" 
                                onkeyup="calcularPromedioHum(this);"  >
                    </div>

                    <div class="form-group text-left">
                        <label for="r325">%R325</label>
                        <input type="number"  step="0.01" class="form-control" id="r325" name="retenido325"
                               placeholder="Ingrese R325"  >
                    </div>


                    <div class="form-group text-left">
                        <label for="txtpH">pH</label>
                        <input type="number" step="0.01" class="form-control" id="txtpH"
                               name="txtpH"
                               placeholder="Ingrese pH"  >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtku">Visc Ku</label>
                        <input type="number" step="0.01" class="form-control" id="txtku"
                               name="txtku"
                               placeholder="Ingrese pH"  >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtcP">Visc cP</label>
                        <input type="number" step="0.01" class="form-control" id="txtcP"
                               name="txtcP"
                               placeholder="Ingrese pH"  >
                    </div>



                    <div class="form-group text-left">
                        <label for="valor4">Dv(50)</label>
                        <input type="text" class="form-control" id="dtp" name="Dv50"
                               placeholder="Ingrese DTP"  >
                    </div>

                </div>

                <div class="col-md-6">



                    <div class="form-group text-left">
                        <label for="valor4">Dv(90</label>
                        <input type="text" class="form-control" id="dtp1" name="Dv90"
                               placeholder="Ingrese DTP"  >
                    </div>
                    <div class="form-group text-left">
                        <label for="valor4">Abs.Aceite</label>
                        <input type="text" class="form-control" id="AA" name="abs_Aceite"
                               placeholder="Ingrese AA"  >
                    </div>
                    <div class="form-group text-left">
                        <label for="valor4">Brigh</label>
                        <input type="text" class="form-control" id="BR" name="Brigh"
                               placeholder="Ingrese BR"  >
                    </div>

                    <div class="form-group text-left">
                        <label for="valor4">Whitness</label>
                        <input type="text" class="form-control" id="Wh" name="Whitness"
                               placeholder="Ingrese BR" >
                    </div>

                    <div class="form-group text-left">
                        <label for="txtkgAgua">Kg Agua</label>
                        <input type="text" class="form-control" id="txtkgAgua" name="txtkgAgua"
                               placeholder=" Kg Agua" >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtkgDisp">Dispersante</label>
                        <input type="text" class="form-control" id="txtkgDisp" name="txtkgDisp"
                               placeholder=" Kg Disp" >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtkgEsp">Sln Espes</label>
                        <input type="text" class="form-control" id="txtkgEsp" name="txtkgEsp"
                               placeholder=" Kg Disp" >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtLtBio">Lt Biocidad</label>
                        <input type="text" class="form-control" id="txtLtBio" name="txtLtBio"
                               placeholder=" Lt Bioic" >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtPorBio">% Biocidad</label>
                        <input type="text" class="form-control" id="txtPorBio" name="txtPorBio"
                               placeholder=" % Bioic" >
                    </div>
                    <div class="form-group text-left">
                        <label for="txtSodio">Kg C.Sodio</label>
                        <input type="text" class="form-control" id="txtSodio" name="txtSodio"
                               placeholder=" kg Sodio" >
                    </div>

                    <div class="form-group text-left">
                        <label for="comentarios">Comentarios</label>
                        <input type="text" class="form-control" id="Comentarios" name="comentarios"
                               placeholder="Ingrese comentario"  >
                    </div>

                    <div class="form-group text-left">
                        <label for="valor4">Observacion</label>
                        <input type="text" class="form-control" id="obs" name="observacion" 
                               placeholder="Ingrese Obs"  >
                    </div>
                    <div class="form-group text-left">
                        <label  style="color: #34ce57" for="valor4"><b># CONSECUTIVO</b></label>
                        <input  type="number" class="form-control"  style="background:  #ffdf7e"  id="idConsecutivo" name="idConsecutivo" 
                                placeholder="Ingrese idConsecutivo"  >
                    </div>

                </div>

            </div>
        </div>
    </div>

    <!-- Fila de botones -->

    <div class="form-group mt-3 text-right" style="border: none; margin-right: 50px">
        <!-- Botones aquí -->
        <button type="submit" name="accion" value="registrar2"  class="btn btn-success">
            <i class="fas fa-save"></i> Registrar
        </button>
        <a href="ControladorPL?accion=listar" class="btn btn-secondary"><span >
                <i class="fas fa-times dan"></i> Cancelar</span></a>
        </a>
    </div>


</form>
<!-- Fila de botones -->
</div>
</div>
</div>
<h1>${mensaje}</h1>  

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>





<style>
    .campo-invalido {
        border: 1px solid red; /* Cambia el borde a rojo para resaltar el campo */
        background-color: #ffcccc; /* Cambia el fondo a un tono rojo claro */
    }
</style>

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

<script src="./js/FunsionCondicionalPS.js" type="text/javascript"></script>

<script src="./js/FuncionCondicionales.js" type="text/javascript"></script>

</body>


</html>
