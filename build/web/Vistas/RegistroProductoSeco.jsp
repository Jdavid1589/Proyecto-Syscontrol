
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">


        <link href="Vistas/Estilos_css/EstilosPL2.css" rel="stylesheet" type="text/css"/>

        <title>Calidad-Tdo Seco</title>


    </head>



    <!--Barra de Navegacion -->
    <nav class="navbar  navbar-expand-md navbar-dark border-3 fixed-top border-bottom ">
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


                <ul class="navbar-nav mx-auto text-center" >   
                    <li class="nav-item" >
                        <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                            <span >
                                REGISTRO TERMINADO SECO
                            </span>
                        </a>
                    </li>
                </ul>

                <ul class="navbar-nav mb-3 mb-lg-0 float-start ">   
                    <li class="nav-item ">
                        <a class="nav-link active" aria-current="page" href="./index3.jsp">
                            <span  style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</span>
                        </a></b>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="ControladorPs?accion=listar">
                            <span style="margin-left: 10px; border:none" class="btn btn-outline-light">
                                <i <i class="fas fa-list"></i><b>
                                    Listar
                            </span>
                        </a></b>
                    </li>

                </ul>
            </div>
        </div>

    </nav>

    <style>
        .campo-invalido {
            border: 1px solid red; /* Cambia el borde a rojo para resaltar el campo */
            background-color: #ffcccc; /* Cambia el fondo a un tono rojo claro */
        }
        .form-container {
            margin: 5rem 0;
        }
        hr{
            border: 2px solid #9fcdff;

        }

    </style>


    <!--Barra de Navegacion -->

    <main>

        <div class="container-fluid text-center" style="position: relative; top: -22px;">

            <div class="row">
                <div class="col-md-12 mx-auto">
                    <br>
                    <h4 class="text-primary elegant-font mt-5"><b>REGISTRO</b></h4>
                </div>
            </div>
        </div>



        <!-- Incio Formulario -->
        <form action="ControladorPs"   onsubmit="return validarFormulario();" autocomplete="off" method="post" class="formulario" id="formulario" >


            <!-- Grupo: Fecha -->
            <div class="formulario__grupo" id="grupo__fecha">
                <label class="formulario__label" for="fecha">Fecha</label>
                <input  type="date" class="form-control" id="fecha" name="fecha"
                        placeholder="Ingrese fecha">
            </div>
            <!-- Grupo: Auxiliar -->
            <div class="formulario__grupo" id="grupo__User">   
                <label class="formulario__label" for="idUsuarios"> Auxiliar</label>
                <select  class="formulario__input" class="form-control" id="idUsuarios" style="border: 2px solid #ffdf7e;"  
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

            <!-- Grupo: Referencia -->
            <div class="formulario__grupo" id="grupo__User">   
                <label class="formulario__label" for="idProductos"> Referencia</label>
                <select class="formulario__input" id="idProductos" style="border: 2px solid #ffdf7e;" 
                        name="idProductos">
                    <option value="0">Seleccione Referencia</option>
                    <% for (Productos pr : DaoProductos.listar()) { %>
                    <% if (pr != null) {%>
                    <option value="<%= pr.getIdProductos()%>"><%= DaoProductos.obtenerNombreProducto(pr.getIdProductos())%></option>
                    <% } %>
                    <% }%>
                </select>
            </div>
            <!-- Grupo: Cantidad NC -->
            <div class="formulario__grupo" id="grupo__cantNC">   
                <label  class="formulario__label" for="cant_noconf">Cant-N.C</label>
                <input type="text" class="form-control " 
                       id="cant_noconf" name="cant_noconf"
                       placeholder="Ingrese Cant"  >
            </div>

            <!-- Grupo: Causas-->
            <div class="formulario__grupo" id="grupo__causas">   
                <label  class="formulario__label" for="causas">Causas</label>
                <input type="text" class="form-control" id="causas" name="causas"
                       placeholder="Ingrese Causas" >
            </div>

            <!-- Grupo: Lote -->
            <div class="formulario__grupo" id="grupo__lote">  
                <label  class="formulario__label" for="lotes">Lote</label>
                <input type="text" class="form-control" id="lotes" name="lote"
                       placeholder="Ingrese Lote" >
            </div>
            <!-- Grupo: Campos Humedad-->
            <div class="formulario__grupo"  id="campos-humedad">
                <!-- Aquí se agregarán dinámicamente los campos de humedad -->
            </div>
            <!-- Grupo: nuevoscampos -->
            <div class="formulario__grupo" id="grupo__nuevocampos">  
                <!-- Boton de humedad -->
                <button class="btn btn-sm btn-primary" type="button" onclick="agregarCampoHumedad()">
                    <i class="fas fa-plus"></i>
                </button>
            </div>

            <!--   onchange="calcularPromedioHum()"     onkeyup="calcularPromedioHumedad2();"-->

            <!-- Grupo: Humedad promedio -->
            <div class="formulario__grupo" id="grupo__humedad_promedio">  
                <label   class="formulario__label"  for="sol_promedio" style="color: #1e7e34"><b>Hum-Promedio</b></label>
                <input type="number" step="0.01"  style="background:  #9fcdff" class="form-control" id="sol_promedio" 
                       name="sol_promedio" placeholder="Calculo promedio Hum" readonly=""
                       onkeyup="calcularPromedioHumedad2();" >
            </div>
            <!-- Titulo 1 -->



            <!-- Grupo: Humedad promedio -->
            <div class="formulario__grupo" id="grupo__r325">  
                <label class="formulario__label"  for="r325">%R325</label>
                <input type="number"  step="0.01" class="form-control" id="r325" name="retenido325"
                       placeholder="Ingrese R325"  >
            </div>


            <!-- Grupo: pH1 -->
            <div class="formulario__grupo" id="grupo__ph1">  
                <label  class="formulario__label" for="pH_1">pH-1</label>
                <input type="number" step="0.01" class="form-control" id="pH_1" name="pH"
                       placeholder="Ingrese pH"  >
            </div>
            <!-- Grupo: pH2 -->
            <div class="formulario__grupo" id="grupo__ph2">  
                <label  class="formulario__label" for="pH_2">pH-2</label>
                <input type="number" step="0.01" class="form-control" id="pH_2" name="pH_2"
                       placeholder="Ingrese pH"  >
            </div>
            <!-- Grupo: pH3 -->
            <div class="formulario__grupo" id="grupo__ph3">  
                <label  class="formulario__label" for="pH_3">pH-3</label>
                <input type="number" step="0.01" class="form-control" id="pH_3" name="pH_3"
                       placeholder="Ingrese pH"  >
            </div>

            <!-- Grupo: pH_promedio -->
            <div class="formulario__grupo" id="grupo__pH_promedio">  
                <label  class="formulario__label" for="pH_promedio" style="color: #1e7e34"><b>pH-Promedio</b></label>
                <input   type="number"  step="0.01" style="background:  #9fcdff" class="form-control" 
                         readonly="" id="pH_promedio" name="pH_promedio"
                         placeholder="Calculo Promedio" onkeyup="calcularPromedioPH(this);" >
            </div>
            <!-- Grupo: Dv50 -->
            <div class="formulario__grupo" id="grupo__Dv50">  
                <label  class="formulario__label" for="valor4">Dv(50)</label>
                <input type="text" class="form-control" id="dtp" name="Dv50"
                       placeholder="Ingrese DTP"  >
            </div>
            <!-- Grupo: Dv90 -->
            <div class="formulario__grupo" id="grupo__Dv90">  
                <label  class="formulario__label"  for="valor4">Dv(90</label>
                <input type="text" class="form-control" id="dtp1" name="Dv90"
                       placeholder="Ingrese DTP"  >
            </div>
            <!-- Grupo: Abs_aceite -->
            <div class="formulario__grupo" id="grupo__Abs_aceite">  
                <label  class="formulario__label" for="valor4">Abs.Aceite</label>
                <input type="text" class="form-control" id="AA" name="abs_Aceite"
                       placeholder="Ingrese AA"  >
            </div>
            <!-- Grupo: Br -->
            <div class="formulario__grupo" id="grupo__Br">  
                <label  class="formulario__label" for="valor4">Brigh</label>
                <input type="text" class="form-control" id="BR" name="Brigh"
                       placeholder="Ingrese BR"  >
            </div>

            <!-- Grupo: Wh-->
            <div class="formulario__grupo" id="grupo__Wh">  
                <label  class="formulario__label" for="valor4">Whitness</label>
                <input type="text" class="form-control" id="Wh" name="Whitness"
                       placeholder="Ingrese BR" >
            </div>

            <!-- Grupo: Comentarios -->
            <div class="formulario__grupo" id="grupo__comentarios">  
                <label  class="formulario__label" for="Comentarios">Comentarios</label>
                <input type="text" class="form-control" id="Comentarios" name="comentarios"
                       placeholder="Ingrese comentario"  >
            </div>

            <!-- Grupo: Observacion -->
            <div class="formulario__grupo" id="grupo__observacion">  
                <label  class="formulario__label" for="obs">Observacion</label>
                <input type="text" class="form-control" id="obs" name="observacion" 
                       placeholder="Ingrese Obs"  >
            </div>
            <!-- Grupo: Consecutivo -->
            <div class="formulario__grupo" id="grupo__consecutivo">  
                <label  class="formulario__label" style="color: #1ed12d; font-family: sans-serif; font-weight: bold" for="idConsecutivo"># CONSECUTIVO</label>
                <input     type="number"  step="0.01" style="background:  #ffdf7e; font-weight: bold" type="number" class="form-control" id="idConsecutivo" name="idConsecutivo" 
                           placeholder="Ingrese Consecutivo"  >
            </div>



            <!-- Fila de botones -->

            <div class="formulario__grupo formulario__grupo-btn-enviar">
                <button  class="formulario__btn" type="submit" name="accion" value="registrar3" >
                    <i class="fas fa-save "></i> AGREGAR
                </button>
                <button  class="formulario__btn_cancelar" >
                    <a  href="ControladorPs?accion=listar" > 
                        <i class="fas fa-times dan"></i> CANCELAR</a>
                </button>
            </div> 

                


        </form>
        <!-- Fila de botones -->

        <h1>${mensaje}</h1>  


        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>


        <script>


                             function calcularPromedioHumedad2() {
                                 const camposHumedad = document.querySelectorAll('[id^="humedad_"]');
                                 let totalHumedad = 0;
                                 let numCamposValidos = 0;

                                 camposHumedad.forEach(campo => {
                                     const valorCampo = parseFloat(campo.value);
                                     if (!isNaN(valorCampo)) { // Verificar si el valor es un número válido
                                         totalHumedad += valorCampo;
                                         numCamposValidos++;
                                     }
                                 });

                                 const promedioHumedad = numCamposValidos > 0 ? totalHumedad / numCamposValidos : 0;
                                 document.getElementById('sol_promedio').value = promedioHumedad.toFixed(2); // Actualizar el valor del campo de humedad promedio
                             }


        </script>


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
                crossorigin="anonymous"  >

        </script>

        <script src="./js/FunsionCondicionalPS.js" type="text/javascript"></script>

        <script src="./js/Funsion_Campos_Hum.js" type="text/javascript"></script>

    </body>

</html>
