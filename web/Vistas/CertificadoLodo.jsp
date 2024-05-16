
<%@page import="Persistencia.DaoEspecificacionesLodos"%>
<%@page import="Modelo.EspecificacionesLodos"%>
<%@page import="Persistencia.DaoProductoLodo"%>
<%@page import="Modelo.ControlLodo"%>
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
        <!-- Etilos CSS -->  
        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>




        <title>Editar_PS</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt((String) request.getAttribute("idpdf"));
            ControlLodo controlLodo = DaoProductoLodo.listarpdf(id);
            List<Consecutivo> listaConsecutivos = DaoConsecutivo.listarConsPDF(controlLodo.getIdControlCalidad());
            List<EspecificacionesLodos> listaEsp = DaoEspecificacionesLodos.listarEspPDF(controlLodo.getIdControlCalidad());
        %>

        <!--Barra de Navegacion -->
        <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
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

                    <ul class="navbar-nav mx-auto text-center" >   
                        <li class="nav-item" >
                            <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                                <span >
                                    Datos Certificado de Calidad
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


                </div>
            </div>
        </nav>
        <style>
            #h4_{
                color: rgb(66, 196, 66);
                font-family: Tahoma;
                text-align: center;
                margin-top: -20px;
                font-weight: bold;
                font-size: 22px;
                border-radius: 10px;

            }
        </style>

        <!--Barra de Navegacion -->

        <%--  readonly=""   sirve para bloquear   --%>


        <div class="container-fluid col-md-12 mt-5 mg-2">  
            <br>
            <div class="row mt-2">  
                <div class="card col-md-5 my-3 mb-4 mt-2 sticky-top ">
                    <%--  Formulario   --%>
                    <form id="MYFormulario" action="ControladorReporteLodo" method="POST" class="custom-form">
                        <h4  id="h4_" class="text-primary text-center elegant-font">TERMINADO</h4> 

                        <div class="row"  >
                            <div class="col-md-6">     

                                <div class="form-group text-left">
                                    <label for="Solidos">% Solidos</label>
                                    <input type="text" class="form-control" id="Solidos" value="<%=controlLodo.getSolidos()%>" 
                                           name="Solidos" onkeyup="calcularDensidades(this);" onblur="validarSolidos(this);">
                                </div>

                                <div class="form-group text-left">
                                    <label for="humedad">% Humedad</label>
                                    <input type="text" class="form-control" readonly="" id="humedad" value="<%=controlLodo.getHumedad()%>" 
                                           name="humedad"  >                             
                                </div>
                                <div class="form-group text-left">
                                    <label for="densidadg">Densidad g/L</label>
                                    <input type="text" class="form-control" id="densidadg" 
                                           readonly=""  name="densidadg">
                                </div>
                                <div class="form-group text-left">
                                    <label for="densidadkggal">Densidad Kg/gal</label>
                                    <input type="text" class="form-control" id="densidadkggal" 
                                           readonly=""     name="densidadkggal"  >                             
                                </div>
                                <div class="form-group text-left">
                                    <label for="densidadkggal">UFC</label>
                                    <input type="text" class="form-control" id="densidadkggal" 
                                           name="ufc" value="<100" >                             
                                </div>

                                <div class="form-group text-left">
                                    <label for="retenido325"> % Ret 325 </label>
                                    <input type="text" class="form-control" 
                                           id="fecha" value="<%=controlLodo.getRetenido325()%>" 
                                           name="retenido325" 
                                           placeholder="Ingrese ">
                                </div>
                                <div class="form-group text-left">
                                    <label for="pH"> pH </label>
                                    <input type="text" class="form-control" 
                                           id="pH" value="<%=controlLodo.getpH()%>" 
                                           name="pH" 
                                           placeholder="Ingrese ">
                                </div>

                                <div class="form-group text-left">
                                    <label for="viscosidadCp"> Visicosidad cP </label>
                                    <input type="text" class="form-control" 
                                           id="viscosidadCp" value="<%=controlLodo.getViscosidadCp()%>" 
                                           name="viscosidadCp" 
                                           placeholder="Ingrese ">
                                </div>



                            </div>
                            <div class="col-md-6">     



                                <div class="form-group text-left">
                                    <label for="viscosidadKu"> Visicosidad Ku </label>
                                    <input type="text" class="form-control" 
                                           id="viscosidadKu" value="<%=controlLodo.getViscosidadKu()%>" 
                                           name="viscosidadKu" 
                                           placeholder="Ingrese ">
                                </div>
                                <!-- Titulo 1 -->
                                <h6 style="background: #ffdf7e; font-size: 11px">Color</h6>
                                <div class="form-group text-left">
                                    <label for="Br"> Br </label>
                                    <input type="text" class="form-control" id="Br" 
                                           value="<%=controlLodo.getBrigh()%>" name="Br" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="Wh"> Wh </label>
                                    <input type="text" class="form-control" id="Wh" 
                                           value="<%=controlLodo.getWhitness()%>" name="Wh" placeholder="Ingrese Dato">
                                </div>

                                <!-- Titulo 2 -->
                                <h6 style="background: #ffdf7e; font-size: 11px">Tamaño Particula</h6>

                                <div class="form-group text-left">
                                    <label for="Dv50"> Dv(50)</label>
                                    <input type="text" class="form-control" id="Dv50" 
                                           value="<%=controlLodo.getDv50()%>" name="Dv50" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="Dv90"> Dv(90)</label>
                                    <input type="text" class="form-control" id="Dv90" 
                                           value="<%=controlLodo.getDv90()%>" name="Dv90" placeholder="Ingrese Dato">
                                </div>
                                <div class="form-group text-left">
                                    <label for="AA"> % AA </label>
                                    <input type="text" class="form-control" 
                                           id="AA" value="<%=controlLodo.getAbs_Aceite()%>" 
                                           name="AA" 
                                           placeholder="Ingrese ">
                                </div>

                                <div class="form-group text-left">
                                    <label for="idConsecutivo">ID Consecutivo</label>
                                    <input type="text" class="form-control" id="idConsecutivo" readonly="" value="<%=controlLodo.getIdConsecutivo()%>"
                                           name="idConsecutivo" placeholder="Ingrese Dato">
                                </div>
                            </div>
                        </div>
                </div>



                <%-- ********** Consecutivo **************** --%>


                <div class="card col-sm-6 my-3 mb-4 mt-2 sticky-top" >

                    <% for (Consecutivo consecutivo : listaConsecutivos) {%>

                    <div class="row mt-2">  

                        <h4  id="h4_2" class="text-primary text-center elegant-font">CONSECUTIVO</h4> 

                        <div class="col-md-6">

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
                            <div class="form-group text-left">
                                <label for="abs_Aceite"> Num Remision</label>
                                <input readonly="" type="text" class="form-control" id="AA" value="<%=consecutivo.getNroRemision()%>"
                                       name="numRemision" placeholder="Ingrese Dato">
                            </div>


                        </div>
                        <div class="col-md-6">

                            <div class="form-group text-left">
                                <label for="CantidadSacos"> Cant Kg </label>
                                <input readonly="" type="text" class="form-control" id="AA" value="<%=consecutivo.getCantidadMaterial()%>"
                                       name="CantidadKg" placeholder="Ingrese Dato">
                            </div>


                            <div class="form-group text-left">
                                <label  style=" background: #ffdf7e" for="productos">Referencia</label>
                                <input  readonly="" type="text" id="productos" name="productos" class="form-control" 
                                        value="<%= DaoProductoSeco.obtenerProductoFinal(controlLodo.getIdControlCalidad())%>">
                            </div>
                            <div class="form-group text-left">
                                <label  style=" background: #ffdf7e" for="cliente">Cliente</label>
                                <input   type="text" id="cliente" name="cliente" class="form-control" 
                                         value="<%= DaoProductoSeco.obtenerclienteFinal(controlLodo.getIdControlCalidad())%>">
                            </div>

                            <%-- <div class="form-group text-left">
                    <label style=" background: #DBDBDB"  for="IdClientes">Cliente</label>
                    <select style=" background: #ffdf7e; color: #0000ff; font-weight: bold; font-family: Arial, sans-serif;"
                            class="form-control" id="idclientes" name="cliente">
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
                                <label   for="Auxiliar">Usuario</label>
                                <input readonly="" type="text" id="Auxiliar" name="Auxiliar" class="form-control" 
                                       value="<%= DaoProductoSeco.obtenerUserFinal(controlLodo.getIdControlCalidad())%>">
                            </div>

                        </div>
                    </div>
                    <% }%>

                    <br>

                    <%-- ********** Especificaciones **************** --%>


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

                    <h4 class="text-primary text-center elegant-font">
                        <b style="color: #000; background: #ffdf7e">ESPECIFICACIONES</b></h4>
                    <hr>
                    <!-- Titulo 2 -->

                    <p style="background: #ffdf7e; font-size: 14px; padding: 5px;">En este espacio se carga la información de Especificaciones.</p>


                    <% for (EspecificacionesLodos especificaciones : listaEsp) {%>

                    <div class="row">
                        <div  class="col-md-6" >

                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp1" class="text-left"><b style="color: #28a745;">Variable # 1</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp1" name="variableEsp1" value="<%=especificaciones.getVariableEsp1()%>"   
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango1" class="text-left">Rango # 1</label>
                                <input type="hidden" type="text" class="form-control" id="rango1" name="rango1" value="<%=especificaciones.getRango1()%>"
                                       placeholder="Ingrese Rango">
                            </div>   

                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo1" class="text-left">Metodo # 1 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo1" name="metodo1" value="<%=especificaciones.getMetodo1()%>"
                                       placeholder="Ingrese Rango">
                            </div>        

                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp2" class="text-left"><b style="color: #28a745;">Variable # 2</b></label>
                                <input  type="hidden" type="text" class="form-control" id="variableEsp2" name="variableEsp2" value="<%=especificaciones.getVariableEsp2()%>" 
                                        placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango2" class="text-left">Rango # 2</label>
                                <input type="hidden" type="text" class="form-control" id="rango2" name="rango2" value="<%=especificaciones.getRango2()%>"
                                       placeholder="Ingrese Rango">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo2" class="text-left">Metodo # 2 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo2" name="metodo2" value="<%=especificaciones.getMetodo2()%>"
                                       placeholder="Ingrese Rango">
                            </div>    

                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp3" class="text-left"><b style="color: #28a745;">Variable # 3</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp3" name="variableEsp3" value="<%=especificaciones.getVariableEsp3()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango3" class="text-left">Rango # 3</label>
                                <input type="hidden" type="text" class="form-control" id="rango3" name="rango3" value="<%=especificaciones.getRango3()%>"
                                       placeholder="Ingrese Rango">
                            </div> 
                            <div class="form-group text-left">
                                <label  style="display: none;" for="metodo3" class="text-left">Metodo # 3 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo3" name="metodo3" value="<%=especificaciones.getMetodo3()%>"
                                       placeholder="Ingrese Rango">
                            </div>       

                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp4" class="text-left"><b style="color: #28a745;">Variable # 4</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp4" name="variableEsp4" value="<%=especificaciones.getVariableEsp4()%>"
                                       placeholder="Ingrese Variable">
                            </div> 

                            <div class="form-group text-left">
                                <label style="display: none;" for="rango4" class="text-left">Rango # 4</label>
                                <input type="hidden" type="text" class="form-control" id="rango4" name="rango4" value="<%=especificaciones.getRango4()%>"
                                       placeholder="Ingrese Rango">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo4" class="text-left">Metodo # 4 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo4" name="metodo4" value="<%=especificaciones.getMetodo4()%>"
                                       placeholder="Ingrese Rango">
                            </div>       

                            <div class="form-group text-left">
                                <label  style="display: none;" for="variableEsp5" class="text-left"><b style="color: #28a745;">Variable # 5</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp5" name="variableEsp5" value="<%=especificaciones.getVariableEsp5()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango5" class="text-left">Rango # 5</label>
                                <input type="hidden" type="text" class="form-control" id="rango5" name="rango5" value="<%=especificaciones.getRango5()%>"
                                       placeholder="Ingrese Rango">
                            </div> 

                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo5" class="text-left">Metodo # 5 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo5" name="metodo5" value="<%=especificaciones.getMetodo5()%>"
                                       placeholder="Ingrese Rango">
                            </div>      
                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp6" class="text-left"><b style="color: #28a745;">Variable # 6</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp6" name="variableEsp6" value="<%=especificaciones.getVariableEsp6()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango6" class="text-left">Rango # 6</label>
                                <input type="hidden" type="text" class="form-control" id="rango6" name="rango6" value="<%=especificaciones.getRango6()%>"
                                       placeholder="Ingrese Rango">
                            </div> 

                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo6" class="text-left">Metodo # 6 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo6" name="metodo6" value="<%=especificaciones.getMetodo6()%>"
                                       placeholder="Ingrese Rango">
                            </div>       
                        </div>

                        <%-- *************  Inicio Columna 2  **********---%>  

                        <div class="col-md-6"> 



                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp7" class="text-left"><b style="color: #28a745;">Variable # 7</b></label>
                                <input  type="hidden"  type="text" class="form-control" id="variableEsp7" name="variableEsp7" value="<%=especificaciones.getVariableEsp7()%>"
                                        placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango7" class="text-left">Rango # 7</label>
                                <input type="hidden" type="text" class="form-control" id="rango7" name="rango7" value="<%=especificaciones.getRango7()%>"
                                       placeholder="Ingrese Rango">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;"  for="metodo7" class="text-left">Metodo # 7 </label>
                                <input type="hidden"  type="text" class="form-control" id="metodo7" name="metodo7" value="<%=especificaciones.getMetodo7()%>"
                                       placeholder="Ingrese Rango">
                            </div>   

                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp8" class="text-left"><b style="color: #28a745;">Variable # 8</b></label>
                                <input type="hidden" type="hidden" type="text" class="form-control" id="variableEsp8" name="variableEsp8" value="<%=especificaciones.getVariableEsp8()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango8" class="text-left">Rango # 8</label>
                                <input type="hidden" type="text" class="form-control" id="rango8" name="rango8" value="<%=especificaciones.getRango8()%>"  
                                       placeholder="Ingrese Rango">
                            </div> 

                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo8" class="text-left">Metodo # 8 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo8" name="metodo8" value="<%=especificaciones.getMetodo8()%>"
                                       placeholder="Ingrese Rango">
                            </div>   
                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp9" class="text-left"><b style="color: #28a745;">Variable # 9</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp9" name="variableEsp9" value="<%=especificaciones.getVariableEsp9()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango9" class="text-left">Rango # 9</label>
                                <input type="hidden" type="text" class="form-control" id="rango9" name="rango9" value="<%=especificaciones.getRango9()%>"  
                                       placeholder="Ingrese Rango">
                            </div> 
                            <div class="form-group text-left">
                                <label  style="display: none;" for="metodo9" class="text-left">Metodo # 9 </label>
                                <input type="hidden"< type="text" class="form-control" id="metodo9" name="metodo9" value="<%=especificaciones.getMetodo9()%>"
                                       placeholder="Ingrese Rango">
                            </div>   

                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp10" class="text-left"><b style="color: #28a745;">Variable # 10</b></label>
                                <input type="hidden" type="text" class="form-control" id="variableEsp10" name="variableEsp10" value="<%=especificaciones.getVariableEsp10()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango10" class="text-left">Rango # 10</label>
                                <input type="hidden" type="text" class="form-control" id="rango10" name="rango10" value="<%=especificaciones.getRango10()%>"  
                                       placeholder="Ingrese Rango">
                            </div> 

                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo10" class="text-left">Metodo # 10 </label>
                                <input type="hidden" type="text" class="form-control" id="metodo10" name="metodo10" value="<%=especificaciones.getMetodo10()%>"
                                       placeholder="Ingrese Rango">
                            </div>   
                            <div class="form-group text-left">
                                <label style="display: none;" for="variableEsp11" class="text-left"><b style="color: #28a745;">Variable # 11</b></label>
                                <input type="hidden"  type="text" class="form-control" id="variableEsp11" name="variableEsp11" value="<%=especificaciones.getVariableEsp11()%>"
                                       placeholder="Ingrese Variable">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="rango11" class="text-left">Rango # 11</label>
                                <input type="hidden" type="text" class="form-control" id="rango11" name="rango11" value="<%=especificaciones.getRango11()%>"  
                                       placeholder="Ingrese Rango">
                            </div> 
                            <div class="form-group text-left">
                                <label style="display: none;" for="metodo11" class="text-left">Metodo # 11 </label>
                                <input type="hidden"  type="text" class="form-control" id="metodo11" name="metodo11" value="<%=especificaciones.getMetodo11()%>"
                                       placeholder="Ingrese Rango">
                            </div>       
                        </div>
                    </div>
                    <% }%>

                </div>

                </form>
            </div>
            <h1>${mensaje}</h1>
        </div>


        <%--Final  --%>


        <script>
            function calcularDensidades(solidosInput) {
                var valor = solidosInput.value;
                var densidadgInput = document.getElementById("densidadg");
                var densidadkggalInput = document.getElementById("densidadkggal");

                // Verificar si el valor ingresado es un número decimal válido
                var solidosDouble = parseFloat(valor); // Convertir a Double

                if (!isNaN(solidosDouble)) {
                    var densidadgDouble = (161.35 / (161.35 - solidosDouble));
                    var densidadkggalDouble = (densidadgDouble * 3.785); // Conversión a kg/gal
                    densidadgInput.value = densidadgDouble.toFixed(3); // Limitar a 3 decimales y asignar a Densidad g/L
                    densidadkggalInput.value = densidadkggalDouble.toFixed(3); // Limitar a 3 decimales y asignar a Densidad kg/gal
                } else {
                    densidadgInput.value = ''; // Limpiar el campo de "Densidad g/L" si Solidos no es un número válido
                    densidadkggalInput.value = ''; // Limpiar el campo de "Densidad kg/gal" si Solidos no es un número válido
                }
            }
        </script>

        <%--  <script>
            function validarSolidos(solidosInput) {
                var valor = parseFloat(solidosInput.value);

                if (isNaN(valor)) {
                    alert("Por favor, introduce un valor numérico para % Solidos.");
                    solidosInput.value = ''; // Limpiar el campo si no es un valor numérico
                    solidosInput.style.borderColor = 'initial'; // Restablecer el color del borde
                } else if (valor < 52.5 || valor > 53.8) {
                    alert("El valor de % Solidos debe estar entre 52.5 y 53.8.");
                    solidosInput.value = ''; // Limpiar el campo si está fuera del rango
                    solidosInput.style.backgroundColor = 'red'; // Cambiar el color de fondo a rojo
                } else {
                    solidosInput.style.backgroundColor = 'initial'; // Restablecer el color de fondo si es válido
                }
            }
        </script>--%>


        <%--
          <style>
                   .campo-invalido {
                       border: 1px solid red; /* Cambia el borde a rojo para resaltar el campo */
                       background-color: #ffcccc; /* Cambia el fondo a un tono rojo claro */
                   }
               </style>

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


        </style>--%>


        <!-- Bootstrap CSS y JavaScript -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
                crossorigin="anonymous">
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
