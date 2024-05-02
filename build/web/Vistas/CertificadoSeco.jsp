
<%@page import="Persistencia.DaoEspecificacionesSeco"%>
<%@page import="Modelo.EspecificacionesSeco"%>
<%@page import="Persistencia.DaoConsecutivo"%>
<%@page import="Modelo.Consecutivo"%>
<%@page import="Persistencia.DaoEspecificaciones"%>
<%@page import="Modelo.Especificaciones"%>
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
        <%
            int id = Integer.parseInt((String) request.getAttribute("idpdf"));
            ControlSeco controlSeco = DaoProductoSeco.listarpdf(id);
            List<Consecutivo> listaConsecutivos = DaoConsecutivo.listarConsPDF(controlSeco.getIdControlCalidad());
            List<EspecificacionesSeco> listaEsp = DaoEspecificacionesSeco.listarEspPDF(controlSeco.getIdControlCalidad());
        %>

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-lg navbar-dark bg-primary border-3 fixed-top border-bottom " id="menu">
            <div class="container-fluid ">
                <a class="navbar-brand  " href="#"></a>
                <img src="./Vistas/Imagenes/MI.jpg" alt="Logo" style="float: left; width: 90px;" />

                <button 
                    class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse  " id="navbarSupportedContent">  

                    <ul class="navbar-nav mx-auto">   
                        <li class="nav-item">
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span class="text-dark elegant-font"" 
                                      style="font-size: 30px; color: darkblue;">
                                    <b>  REFERENCIAS   </b>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav mb-3 mb-lg-0 float-start">

                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="./index3.jsp">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</span>
                            </a></b>
                        </li>

                        <li class="nav-item ">
                            <a class="nav-link active" aria-current="page" href="ControladorPs?accion=listar">
                                <span   style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                    <i class="fas fa-list"></i> <b>Listar</b></span>
                            </a>
                        </li>
                    </ul>
                    <span onclick="location.reload()" class="btn btn-primary text-center" style="font-size: 2em;">
                        <i class="bi bi-arrow-clockwise"></i>
                    </span>

                </div>
            </div>
        </nav>

        <!--Barra de Navegacion -->

        <%--  readonly=""   sirve para bloquear   --%>


        <div class="container-fluid col-md-12 mt-5 mg-2">  
            <hr>


            <div class="row mt-5">  
                <h4 class="text-primary elegant-font">

                    <b > CERTIFICADO CALIDAD</b></h4>

                <div class="card col-sm-6 mb-4  mt-2 sticky-top ">

                    <h4 class="text-primary elegant-font"><b style="color:  #00008B">CONTROL CALIDAD SECO</b></h4> 

                    <%--  Formulario   --%>

                    <form action="ControladorReporteSeco" method="POST" class="custom-form">

                        <div class="row"  >
                            <div class="col-md-6">     

                                <div class="form-group text-left">
                                    <label for="humedad">% Humedad</label>
                                    <input type="text" class="form-control" id="humedad" value="<%=controlSeco.getHumedad_promedio()%>" 
                                           name="humedad"  >                             
                                </div>

                                <div class="form-group text-left">
                                    <label for="pH"> pH </label>
                                    <input type="text" class="form-control" 
                                           id="pH" value="<%=controlSeco.getpH_promedio()%>" 
                                           name="pH" 
                                           placeholder="Ingrese ">
                                </div>

                                <div class="form-group text-left">
                                    <label for="retenido325"> % Ret 325 </label>
                                    <input type="text" class="form-control" 
                                           id="fecha" value="<%=controlSeco.getRetenido325()%>" 
                                           name="retenido325" 
                                           placeholder="Ingrese ">
                                </div>
                                <div class="form-group text-left">
                                    <label for="AA"> % AA </label>
                                    <input type="text" class="form-control" 
                                           id="AA" value="<%=controlSeco.getAbs_Aceite()%>" 
                                           name="AA" 
                                           placeholder="Ingrese ">
                                </div>




                            </div>
                            <div class="col-md-6">     


                                <!-- Titulo 1 -->
                                <h6 style="background: #ffdf7e; font-size: 11px">Color</h6>

                                <div class="form-group text-left">
                                    <label for="Br"> Br </label>
                                    <input type="text" class="form-control" id="Br" 
                                           value="<%=controlSeco.getBrigh()%>" name="Br" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="Wh"> Wh </label>
                                    <input type="text" class="form-control" id="Wh" 
                                           value="<%=controlSeco.getWhitness()%>" name="Wh" placeholder="Ingrese Dato">
                                </div>

                                <!-- Titulo 2 -->
                                <h6 style="background: #ffdf7e; font-size: 11px">Tamaño Particula</h6>

                                <div class="form-group text-left">
                                    <label for="Dv50"> Dv(50)</label>
                                    <input type="text" class="form-control" id="Yell" 
                                           value="<%=controlSeco.getDv50()%>" name="Dv50" placeholder="Ingrese Dato">
                                </div>


                                <div class="form-group text-left">
                                    <label for="idConsecutivo">ID Consecutivo</label>
                                    <input type="text" class="form-control" id="idConsecutivo" readonly="" value="<%=controlSeco.getIdConsecutivo()%>"  name="idConsecutivo" placeholder="Ingrese Dato">
                                </div>

                                <%--  <div class="form-group text-left">
                                <label style=" background: #ffdf7e" f for="IdClientes">Usuario</label>
                                <input readonly="" type="text" id="idProductos" name="idProductos" class="form-control" 
                                       value="<%= DaoProductoSeco.obtenerUserFinal(controlSeco.getIdControlCalidad())%>">
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
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>--%>


                            </div>
                        </div>
                </div>



                <%-- ********** Consecutivo **************** --%>


                <div class="card col-sm-6 mb-4 mt-2 sticky-top" >

                    <% for (Consecutivo consecutivo : listaConsecutivos) {%>

                    <div class="row"  style="background: #ffcccc">
                        <h4 class="text-black elegant-font">
                            <b> CONSECUTIVO</b></h4>
                        <div class="col-md-6">

                            <div class="form-group text-left">
                                <label for="pH">Fecha Produc</label>
                                <input  type="text" class="form-control"
                                        id="fp" value="<%=consecutivo.getFechaProduccion()%>" 
                                        name="fechaProduccion" placeholder="Ingrese Dato">
                            </div>
                            <div class="form-group text-left">
                                <label for="pH">Fecha Certificado</label>
                                <input  type="text" class="form-control"
                                        id="fp" value="<%=consecutivo.getFechaCertificado()%>"
                                        name="fechaCertificado" placeholder="Ingrese Dato">
                            </div>

                            <div class="form-group text-left">
                                <label for="Dv50"> Lote</label>
                                <input type="text" class="form-control" id="dv50" 
                                       value="<%=consecutivo.getLote()%>" name="lote"
                                       placeholder="Ingrese Dato">
                            </div>
                            <div class="form-group text-left">
                                <label for="Brigh"> Num Consecutivo </label>
                                <input type="text" class="form-control" id="br"
                                       value="<%=consecutivo.getIdconsecutivo()%>"
                                       name="numCertificado" placeholder="Ingrese Dato">
                            </div>

                        </div>
                        <div class="col-md-6">

                            <div class="form-group text-left">
                                <label for="abs_Aceite"> Num Remision</label>
                                <input readonly="" type="text" class="form-control" id="AA" value="<%=consecutivo.getNroRemision()%>"
                                       name="abs_Aceite" placeholder="Ingrese Dato">
                            </div>
                            <div class="form-group text-left">
                                <label for="CantidadSacos"> Cant Sacos </label>
                                <input readonly="" type="text" class="form-control" id="AA" value="<%=consecutivo.getCantidadMaterial()%>"
                                       name="CantidadSacos" placeholder="Ingrese Dato">
                            </div>

                            <%--  <div class="form-group text-left">
                            <label for="IdProductos"> Referencia</label>
                            <input type="text" class="form-control" id="AA"
                                   value="<%=DaoProductos.obtreferenciacliente(consecutivo.getIdEspecificaciones())%>"
                                   name="abs_Aceite" placeholder="Ingrese Dato">
                        </div>--%>

                            <div class="form-group text-left">
                                <label  style=" background: #ffdf7e" for="IdProductos">Referencia</label>
                                <input  readonly="" type="text" id="idProductos" name="productos" class="form-control" 
                                        value="<%= DaoProductoSeco.obtenerProductoFinal(controlSeco.getIdControlCalidad())%>">
                            </div>
                            <div class="form-group text-left">
                                <label style=" background: #DBDBDB"  for="IdClientes">Cliente</label>
                                <input style=" background: #0dcaf0" type="text" id="idProductos" name="cliente" class="form-control" 
                                       value="<%= DaoProductoSeco.obtenerclienteFinal(controlSeco.getIdControlCalidad())%>">
                            </div>
                            <div class="form-group text-left">
                                <label   for="Auxiliar">Usuario</label>
                                <input readonly="" type="text" id="Auxiliar" name="Auxiliar" class="form-control" 
                                       value="<%= DaoProductoSeco.obtenerUserFinal(controlSeco.getIdControlCalidad())%>">
                            </div>


                        </div>
                    </div>
                    <% }%>

                    <br>


                    <div class="form-group text-left">     

                        <div   class="col-6 ">                     
                            <input class="form-check-input btn-success " type="checkbox" id="invalidCheck" required>
                            <label style="color: #00008B; margin-left: 5px;" class="form-check-label mb-4 " for="invalidCheck">
                                <b>CONFIRMAR</b>
                            </label>
                            <div class="invalid-feedback">
                                Debes confirmar antes de enviar.                       
                            </div>
                        </div>            

                        <button type="submit" name="accion" value="registrar" class="btn btn-danger ">
                            <i class="bi bi-file-earmark-pdf-fill "></i> GENERAR PDF
                        </button>
                        <%---Imput para checkbox  antes de enviar el formulario  ---%>
                    </div>
                    <%-- ********** Especificaciones **************** --%>


                    <h4 class="text-primary elegant-font">
                        <b style="color: #000; background: #ffdf7e">ESPECIFICACIONES</b></h4>

                    <% for (EspecificacionesSeco especificaciones : listaEsp) {%>

                    <div class="row">


                        <div  class="col-md-6" >

                            <%--  <div class="form-group text-left">
                                <label for="idProductos"> 
                                    <b style="color: #00008B; font-family: Century Gothic;"> Referencia</b></label>
                                <select style="color: #000; font-family: Century Gothic ; font-size: 18PX;"
                                        class="form-control" id="idProductos" name="idProductos" value="<%=especificaciones.getIdProductos()%>"  >
                                    <option value="0">Seleccione Referencia</option>
                                    <%
                                        for (Productos productos : DaoProductos.listar()) {
                                            if (productos != null) {
                                    %>
                                    <option  value="<%=productos.getIdProductos()%>"><%=productos.getNombres_Productos()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>--%>

                            <%--  <div class="form-group text-left">
                                 <label for="idclientes"> Cliente</label>
                                 <select class="form-control" id="idclientes" name="idclientes" value="<%=especificaciones.getIdclientes()%>"  >
                                     <option value="0">Seleccione Cliente</option>
                                     <%
                                         for (Clientes clientes : DaoClientes.listar()) {
                                             if (clientes != null) {
                                     %>
                                     <option  value="<%=clientes.getIdclientes()%>"><%=clientes.getRazon_Social()%></option>
                                     <%
                                             }
                                         }
                                     %>
                                 </select>
                             </div>--%>
                            <div class="form-group text-left">
                                <label for="variableEsp1" class="text-left"><b style="color: #28a745;">Variable # 1</b></label>
                                <input  type="text" class="form-control" id="variableEsp1" name="variableEsp1" value="<%=especificaciones.getVariableEsp1()%>"   
                                        placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango1" class="text-left">Rango # 1</label>
                                <input type="text" class="form-control" id="rango1" name="rango1" value="<%=especificaciones.getRango1()%>"
                                       placeholder="Ingrese Rango">
                            </div>                            

                            <div class="form-group text-left">
                                <label for="variableEsp2" class="text-left"><b style="color: #28a745;">Variable # 2</b></label>
                                <input type="text" class="form-control" id="variableEsp2" name="variableEsp2" value="<%=especificaciones.getVariableEsp2()%>" 
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango2" class="text-left">Rango # 2</label>
                                <input type="text" class="form-control" id="rango2" name="rango2" value="<%=especificaciones.getRango2()%>"
                                       placeholder="Ingrese Rango">
                            </div> 


                            <div class="form-group text-left">
                                <label for="variableEsp3" class="text-left"><b style="color: #28a745;">Variable # 3</b></label>
                                <input type="text" class="form-control" id="variableEsp3" name="variableEsp3" value="<%=especificaciones.getVariableEsp3()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango3" class="text-left">Rango # 3</label>
                                <input type="text" class="form-control" id="rango3" name="rango3" value="<%=especificaciones.getRango3()%>"
                                       placeholder="Ingrese Rango">
                            </div> 


                            <div class="form-group text-left">
                                <label for="variableEsp4" class="text-left"><b style="color: #28a745;">Variable # 4</b></label>
                                <input type="text" class="form-control" id="variableEsp4" name="variableEsp4" value="<%=especificaciones.getVariableEsp4()%>"
                                       placeholder="Ingrese Variable">
                            </div> 




                        </div>

                        <%-- *************  Inicio Columna 2  **********---%>  

                        <div class="col-md-6"> 

                            <div class="form-group text-left">
                                <label for="rango4" class="text-left">Rango # 4</label>
                                <input type="text" class="form-control" id="rango4" name="rango4" value="<%=especificaciones.getRango4()%>"
                                       placeholder="Ingrese Rango">
                            </div> 


                            <div class="form-group text-left">
                                <label for="variableEsp5" class="text-left"><b style="color: #28a745;">Variable # 5</b></label>
                                <input type="text" class="form-control" id="variableEsp5" name="variableEsp5" value="<%=especificaciones.getVariableEsp5()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango5" class="text-left">Rango # 5</label>
                                <input type="text" class="form-control" id="rango5" name="rango5" value="<%=especificaciones.getRango5()%>"
                                       placeholder="Ingrese Rango">
                            </div> 

                            <div class="form-group text-left">
                                <label for="variableEsp6" class="text-left"><b style="color: #28a745;">Variable # 6</b></label>
                                <input type="text" class="form-control" id="variableEsp6" name="variableEsp6" value="<%=especificaciones.getVariableEsp6()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango6" class="text-left">Rango # 6</label>
                                <input type="text" class="form-control" id="rango6" name="rango6" value="<%=especificaciones.getRango6()%>"
                                       placeholder="Ingrese Rango">
                            </div> 

                            <div class="form-group text-left">
                                <label for="variableEsp7" class="text-left"><b style="color: #28a745;">Variable # 7</b></label>
                                <input type="text" class="form-control" id="variableEsp7" name="variableEsp7" value="<%=especificaciones.getVariableEsp7()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango7" class="text-left">Rango # 7</label>
                                <input type="text" class="form-control" id="rango7" name="rango7" value="<%=especificaciones.getRango7()%>"
                                       placeholder="Ingrese Rango">
                            </div> 


                            <div class="form-group text-left">
                                <label for="variableEsp8" class="text-left"><b style="color: #28a745;">Variable # 8</b></label>
                                <input type="text" class="form-control" id="variableEsp8" name="variableEsp8" value="<%=especificaciones.getVariableEsp8()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label for="rango8" class="text-left">Rango # 8</label>
                                <input type="text" class="form-control" id="rango8" name="rango8" value="<%=especificaciones.getRango8()%>"  
                                       placeholder="Ingrese Rango">
                            </div> 
                        </div>
                    </div>
                    <% }%>


                    <div class="form-group text-right">
                        <%----<input type="hidden" name="txtid_ps" value="<%=controlSeco.getIdControlCalidad()%>">

                <button type="submit" name="accion" value="registrarEdicion" class="btn btn-primary">
                    <i class="fas fa-sync"></i>Actulizar
                </button>
               
                <a href="ControladorPs?accion=listar" class="btn btn-secondary "><span >
                        <i class="fas fa-times dan"></i> Cancelar </span></a> --%>

                    </div>
                </div>

            </div>
        </form>

        <h1>${mensaje}</h1>


    </div>
</div>

<%--Final  --%>

<style>
    #cuadro {
        max-width: 110px; /* Ampliado el ancho para acomodar el checkbox y el título */
        margin: 15px auto;
        background-size: cover;
        background-position: inherit;
        padding: 5px;
        border-radius: 2px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.7); /* Agregado sombreado al cuadro */
        display: flex;
        align-items: center; /* Cambiado a center */
        justify-content: space-between; /* Alinear elementos a los extremos */
    }

    #cuadro h1 {
        color: #000066;
        margin: 0; /* Corregido el margen */
        font-family: 'Lucida Console', sans-serif; /* Cambiado a Arial, puedes usar otras fuentes como 'Georgia', 'Times New Roman', etc. */
        text-shadow: 2px 2px 4px rgba(0, 255, 255, 0.9);
        font-weight: bold; /* Agregado negrita */
        font-size: 24px; /* Ajustado el tamaño de letra */
    }


</style>
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
