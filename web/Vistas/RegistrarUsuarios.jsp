<%-- 
    Document   : RegistrarUsuarios
    Created on : 3/09/2023, 8:45:10 a. m.
    Author     : cesar
--%>

<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Modelo.Documento"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>


<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        
      
        
         <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>
       
        
        <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

        <title>Usuarios</title>   

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
                                <span  class=" btn btn-primary ">
                                    <i class="bi bi-arrow-left-square-fill text-dark"></i><b> Inicio</span>
                            </a></b>

                        </li><li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ControladorUsuarios?accion=listar">
                                <span  class=" btn btn-primary ">
                                    <i <i class="fas fa-list"></i><b>
                                        Listar
                                </span>
                            </a></b>

                        </li>


                    </ul>


                    <!--li class="nav-item ">
                        <a class="nav-link active my-menu-item"  aria-current="page" href="##">
                            <span class=" elegant-font"
                                  style=" text-align: center; font-size: 30px; color: darkblue;">
                                <b>REGISTROS</b>
                            </span>
                        </a>
                    </li-->





                    <!-- comment <ul class="navbar-nav ms-auto">  
                         <form class="navbar-nav ms-auto ml-auto" role="search">
                             <input class="form-control" type="search" name="txtbuscar" placeholder="Buscar" aria-label="Buscar">
                             <button  type="submit" name="accion" value="buscar" class="btn btn-outline-success">Buscar</button>
                         </form>
                     </ul>-->

                </div>
            </div>

        </nav>

        <!--Barra de Navegacion -->


        <div class="container  mt-5 "> 
            <h1 class=" elegant-font text-primary">REGISTRO USUARIOS</h1>



            <form action="ControladorUsuarios" method="POST" class="custom-form">

                <div class="row">
                    <div class="col-md-6 ">

                        <div class="form-group text-left">
                            <label for="nombres" class="text-left">1. Nombre Completo</label>
                            <input type="text" class="form-control" id="nombres" name="nombres_apellido" placeholder="Ingrese Nombres">
                        </div>                           

                        <div class="form-group text-left">
                            <label for="telefono">7. Número de Teléfono</label>
                            <input type="text" class="form-control" id="telefono" name="numeroTelefono" placeholder="Ingrese Telefono">
                        </div>

                        <div class="form-group text-left">
                            <label for="correo">8. Correo</label>
                            <input type="email" class="form-control" id="correo" name="correo" placeholder="Ingrese Correo">
                        </div>

                    </div>
                    <div class="col-md-6">        

                        <div class="form-group text-left">
                            <label for="usuario">9. Usuario</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Ingrese Usuario">
                        </div>

                        <div class="form-group text-left">
                            <label for="clave">10. Clave</label>
                            <input type="password" class="form-control" id="clave" name="clave" placeholder="Ingrese Clave">
                        </div>

                        <div class="form-group text-left">
                            <label for="tipoPerfil">11. Tipo de Perfil</label>
                            <select class="form-control" id="tipoPerfil" name="perfil_idperfil">
                                <option value="0">Seleccione perfil</option>
                                <% List<Perfil> perfiles = DaoPerfil.listar();
                                    if (perfiles != null) {
                                        for (Perfil perfil : perfiles) {
                                            if (perfil != null) {%>
                                <option value="<%=perfil.getIdperfil()%>"><%=perfil.getTipo_Perfil()%></option>
                                <% }
                                        }
                                    }%>
                            </select>

                        </div>
                    </div>
                </div>
                <div class="form-group text-right ">
                    <button type="submit" name="accion" value="registrar" class="btn btn-outline-primary">
                         <i class="fas fa-save "></i> Guardar Registro</button>
                    <a href="./index3.jsp"class="btn  btn-outline-success"> <span class="text-warning">  Pagina Inicio</span></a>
                </div>    
            </form>




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


    </body>
</html>
