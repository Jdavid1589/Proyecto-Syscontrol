

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
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Calidad-Tdo Seco</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

      <link href="Vistas/Estilos_css/EstilosPL2.css" rel="stylesheet" type="text/css"/>


    </head>

    <body>

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



        <main>



            <div class="container-fluid text-center" style="position: relative; top: -22px;">

                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <br>
                        <h4 class="text-primary elegant-font mt-5"><b>REGISTRAR PRODUCTO LODO</b></h4>

                    </div>
                </div>
            </div>

            <!-- Incio Formulario -->
           <form class="formulario" id="formulario" action="ControladorPL" method="post">

             

                <!-- Grupo: Referencia -->
                <div class="formulario__grupo" id="grupo__producto">
                    <label class="formulario__label" for="idProductos"> Referencia</label>
                    <select   class="formulario__input"   id="producto" style="border: 2px solid #ffdf7e;" 
                              name="producto">
                        <option value="0">Seleccione Referencia</option>
                        <% for (Productos pr : DaoProductos.listar()) { %>
                        <% if (pr != null) {%>
                        <option value="<%= pr.getIdProductos()%>"><%= DaoProductos.obtenerNombreProducto(pr.getIdProductos())%></option>
                        <% } %>
                        <% }%>
                    </select>
                </div> 
                    
                <!-- Grupo: Fecha -->
                <div class="formulario__grupo" id="grupo__fecha">
                    <label class="formulario__label" for="fecha">Fecha</label>
                    <div class="formulario__grupo-input">
                        <input type="date" class="formulario__input" id="fecha" name="fecha" placeholder="%Solidos">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                </div>

                <!-- Grupo: Seguimiento -->
                <div class="formulario__grupo" id="grupo__seguimiento">
                    <label class="formulario__label" for="idSeguimiento"> Segumiento</label>
                    <select  class="formulario__input" class="form-control" id="idSeguimiento" style="border: 2px solid #ffdf7e;"  name="txtSto">
                        <option value="0">Seleccione Sto</option>
                        <%  for (Seguimientos sto : DaoSeguimientos.listar()) {
                                if (sto != null) {
                        %>
                        <option  value="<%=sto.getIdSeguimientos()%>"><%=sto.getNumSeguimiento()%></option>
                        <% }
                            }
                        %>
                    </select>
                </div>

                <!-- Grupo: Tanque -->
                <div class="formulario__grupo" id="grupo__tanque">
                    <label for="tanque" class="formulario__label">Tanque #</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="tanque" id="tanque" placeholder="% tanque">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>               
                </div>

                <!-- Grupo: Lote -->
                <div class="formulario__grupo" id="grupo__lote">
                    <label for="lote" class="formulario__label">Lote</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="lote" id="lote" placeholder="% lote">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>               
                </div>

                <!-- Grupo: Cant Kg -->
                <div class="formulario__grupo" id="grupo__Cantidadkg">
                    <label for="Cantidadkg" class="formulario__label">Cantidad_Kg</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="Cantidadkg" id="Cantidadkg" placeholder="% Cantidadkg">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>               
                </div>
                <!-- Grupo: Solidos -->
                <div class="formulario__grupo" id="grupo__solidos">
                    <label for="solidos" class="formulario__label">% Solidos</label>
                    <div class="formulario__grupo-input">
                        <input onkeyup="calcularHumedad(this);"  type="text" class="formulario__input" name="solidos" id="solidos" placeholder="%Solidos">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error">El % Solidos debe estar entre 52-54</p>
                </div>

                <!-- Grupo: Cant Humedad -->
                <div class="formulario__grupo" id="grupo__humedad">
                    <label for="humedad" class="formulario__label">Humedad</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="humedad" id="humedad" readonly="" placeholder="% humedad">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>               
                </div>


                <!-- Grupo: pH -->
                <div class="formulario__grupo" id="grupo__pH">
                    <label for="pH" class="formulario__label">pH</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="pH" id="pH" placeholder="% pH">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error error" id="error_pH">El pH debe estar entre 6.9 - 8.7</p>
                </div>
                <!-- Grupo: R325 -->
                <div class="formulario__grupo" id="grupo__r325">
                    <label for="r325" class="formulario__label">R325</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="r325" id="r325" placeholder="% r325">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error error" id="error_r325">El r325 debe estar 0.1-0.3</p>
                </div>
                <!-- Grupo: KU -->
                <div class="formulario__grupo" id="grupo__ku">
                    <label for="ku" class="formulario__label">Ku</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="ku" id="ku" placeholder="% ku">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error error" id="error_ku">El ku debe estar entre 70-80</p>
                </div>
                <!-- Grupo: cP -->
                <div class="formulario__grupo" id="grupo__cP">
                    <label for="cP" class="formulario__label">cP</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="cP" id="cP" placeholder="% cP">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error error" id="error_cP">El cP debe estar entre 300-590</p>
                </div>
                <!-- Grupo: Dv50 -->
                <div class="formulario__grupo" id="grupo__Dv50">
                    <label for="Dv50" class="formulario__label">Dv50</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="Dv50" id="Dv50" placeholder="% Dv50">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_Dv50">El Dv50 debe estar entre </p>              
                </div>

                <!-- Grupo: Dv90 -->
                <div class="formulario__grupo" id="grupo__Dv90">
                    <label for="Dv90" class="formulario__label">Dv90</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="Dv90" id="Dv90" placeholder="% Dv90">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_Dv90">El Dv90 debe estar entre </p>              
                </div>
                <!-- Grupo: Brigh -->
                <div class="formulario__grupo" id="grupo__Brigh">
                    <label for="Brigh" class="formulario__label">Brigh</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="Brigh" id="Brigh" placeholder="% Brigh">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_Brigh">El Brigh debe estar entre </p>              
                </div>

                <!-- Grupo: Wh -->
                <div class="formulario__grupo" id="grupo__Wh">
                    <label for="Wh" class="formulario__label">Wh</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="Wh" id="Wh" placeholder="% Wh">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_Wh">El Wh debe estar entre </p>              
                </div>

                <!-- Grupo: AbsAceite -->
                <div class="formulario__grupo" id="grupo__AbsAceite">
                    <label for="AbsAceite" class="formulario__label">Abs_Aceite</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="AbsAceite" id="AbsAceite" placeholder="% AbsAceite">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_AbsAceite">El AbsAceite debe estar entre </p>              
                </div>

                <!-- Grupo: kgAgua -->
                <div class="formulario__grupo" id="grupo__kgAgua">
                    <label for="kgAgua" class="formulario__label">Kg_Agua</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="kgAgua" id="kgAgua" placeholder="% kgAgua">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_kgAgua">El kgAgua debe estar entre </p>              
                </div>
                <!-- Grupo: dispersante -->
                <div class="formulario__grupo" id="grupo__dispersante">
                    <label for="dispersante" class="formulario__label">Dispersante</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="dispersante" id="dispersante" placeholder="% dispersante">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_dispersante">El dispersante debe estar entre </p>              
                </div>
                <!-- Grupo: espesante -->
                <div class="formulario__grupo" id="grupo__espesante">
                    <label for="espesante" class="formulario__label">Espesante</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="espesante" id="espesante" placeholder="% espesante">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_espesante">El espesante debe estar entre </p>              
                </div>
                <!-- Grupo: Biocidad -->
                <div class="formulario__grupo" id="grupo__Biocidad">
                    <label for="Biocidad" class="formulario__label">Biocidad (Lt)</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="Biocidad" id="Biocidad" placeholder="% Biocidad">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_Biocidad">El Biocidad debe estar entre </p>              
                </div>
                <!-- Grupo: %Biocidad -->
                <div class="formulario__grupo" id="grupo__dosisBiocidad">
                    <label for="dosisBiocidad" class="formulario__label">%Biocidad</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="dosisBiocidad" id="dosisBiocidad" placeholder="% dosisBiocidad">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_dosisBiocidad">El dosisBiocidad debe estar entre </p>              
                </div>
                <!-- Grupo: kgSodio -->
                <div class="formulario__grupo" id="grupo__kgSodio">
                    <label for="kgSodio" class="formulario__label">Kg_Sodio</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="kgSodio" id="kgSodio" placeholder="% kgSodio">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_kgSodio">El kgSodio debe estar entre </p>              
                </div>
                <!-- Grupo: comentarios -->
                <div class="formulario__grupo" id="grupo__comentarios">
                    <label for="comentarios" class="formulario__label">Comentarios</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="comentarios" id="comentarios" placeholder="% comentarios">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_comentarios">El comentarios debe estar entre </p>              
                </div>
                <!-- Grupo: observacion -->
                <div class="formulario__grupo" id="grupo__observacion">
                    <label for="observacion" class="formulario__label">Observacion</label>
                    <div class="formulario__grupo-input">
                        <input type="text" class="formulario__input" name="observacion" id="observacion" placeholder="% observacion">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div> 
                    <p class="formulario__input-error error" id="error_observacion">El observacion debe estar entre </p>              
                </div>

                <!-- Grupo: CONSECUTIVO -->
                <div class="formulario__grupo" id="grupo__Consecutivo">
                    <label  style="color: #34ce57" for="Consecutivo" class="formulario__label"> # CONSECUTIVO</label>
                    <div class="formulario__grupo-input">
                        <input  style="background:  #ffdf7e"  type="text" class="formulario__input" name="Consecutivo" id="Consecutivo" placeholder="% Consecutivo">
                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                    </div>
                    <p class="formulario__input-error error" id="error_Consecutivo">El cP debe estar entre 300-590</p>
                </div>
                <!-- Grupo: Auxiliar -->
                <div class="formulario__grupo" id="grupo__Usuario">
                    <label  class="formulario__label" for="idUsuarios"> Auxiliar</label>
                    <select class="formulario__input" class="form-control" id="Usuarios" style="border: 2px solid #ffdf7e;"  
                            name="idUsuarios">
                        <option value="0">Seleccione Aux</option>
                        <% for (Usuarios usuarios : DaoUsuarios.listar()) {
                                if (usuarios != null) {%>
                        <option  value="<%=usuarios.getIdUsuarios()%>"><%=usuarios.getNombres_apellido()%></option>
                        <%  }
                            }%>
                    </select>
                </div>

        

                <div class="formulario__grupo formulario__grupo-btn-enviar">
                  <button type="submit" name="accion" value="registrar3"  class="formulario__btn">Registrar</button>   
                    <p class="formulario__mensaje-exito" id="formulario__mensaje-exito">Formulario enviado exitosamente!</p>
                </div>              


            </form>
        </main>


        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


        <script src="./js/ValidacionPL.js" type="text/javascript"></script>


    </body>
    <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>

</html>
