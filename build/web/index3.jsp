

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Syscontrol-MI</title>

        <!-- Incluye los archivos CSS de Bootstrap -->

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">


        <!-- Etilos CSS -->  
        <link href="Vistas/Estilos_css/StyleFondo.css" rel="stylesheet" type="text/css"/>
        <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

    </head>


    <body> 
        <div class="row">
            <div class="col-12"> 
                <nav class="navbar  navbar-expand-lg navbar-darkborder-3 fixed-top border-bottom " >
                    <div class="container-fluid">


                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a  style="" class="btn btn-outline-light etiqueta_a" 
                                        href="ControladorPL?accion=listar"  target="_blank" >Lodos</a>
                                </li>
                                <li class="nav-item" >
                                    <a style="" class="btn btn-outline-light etiqueta_a"
                                       href="ControladorPs?accion=listar"  target="_blank">Seco</a>
                                </li>


                                <!--target="_blank" esto sirve para abrir una pagina independiente -->
                                <li class="nav-item">
                                    <a style="" class="btn btn-outline-light etiqueta_a"
                                       href="ControladorConsecutivo?accion=Listar2"  >Consecutivo</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a style="" class="btn btn-outline-light dropdown-toggle etiqueta_a"
                                       href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Registros  
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li><a class="dropdown-item" href="ControladorProductos?accion=listar">Productos</a></li>                                       
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="ControladorClientes?accion=listar">Clientes</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="ControladorUsuarios?accion=listar">Usuarios</a></li>
                                        <li><hr class="dropdown-divider"></li>                           
                                        <li><a class="dropdown-item" href="ControladorRegModal?accion=listar">Otros Registro</a></li>
                                    </ul>
                                    <a  class="btn btn-outline-light dropdown-toggle etiqueta_a"
                                        href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Otros    
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

                                        <li><a class="dropdown-item" href="ControladorEspSeco?accion=listar">Especificaciones</a></li> 
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="ControladorEspLodos?accion=listar">Especificaciones-Lodo</a></li>                                       
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="ControladorReporteSeco?accion=listar">Certifiados Seco</a></li>                                 
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="ControladorReporteLodo?accion=listar">Certifiados Lodo</a></li>                                 

                                    </ul>
                                </li>                              

                            </ul>

                            <div class="dropdown">
                                <button   class="btn btn-sm btn-outline-light dropdown-toggle  input-field" 
                                          type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    ${usuario.getNombres_apellido()} Ingresó 
                                </button>
                                <ul class="dropdown-menu text-center" class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li>
                                        <a class="dropdown-item">
                                            <img src="Vistas/img/user.png" alt="40" width="40"/>
                                        </a>
                                    </li>
                                    <li><a class="dropdown-item" style="text-transform: uppercase; font-size: 14px;">${usuario.getUsuario()}</a></li>
                                    <li><a class="dropdown-item" style="text-transform: uppercase;">${usuario.getCorreo()}</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <form action="SVValidar" method="POST">
                                        <button name="accion" value="Salir" class="dropdown-item" href="#">SALIR</button>
                                    </form>
                                </ul>
                            </div>
                            <form action="SVValidar" method="POST">
                                <div class="ml-2">
                                    <!-- Botón de cierre de sesión -->              
                                    <button class="btn btn-outline-danger my-btn salir-btn " name="accion" value="Salir">Cerrar Sesión</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>   
        </div>
        <style>

        </style>

        <!-- Contenedor principal centrado -->

        <div class="row">
            <div class="col-md-12">
                <div id="cuadro">
                    <img src="Vistas/Imagenes/MI.jpg" alt=""/>
                    <h1 >BIENVENIDOS A SYSCONTROL MI</h1>
                </div>
            </div>
        </div>
        <h2 id="mensaje" ><b> ${mensaje}</b></h1>

        <!-- Script para temporizar el mensaje -->
        <script>
            // Función para mostrar el mensaje y luego ocultarlo después de cierto tiempo
            function temporizarMensaje() {
                console.log("Ejecutando temporización del mensaje...");
                // Selecciona el elemento del mensaje
                var mensaje = document.getElementById('mensaje');

                // Muestra el mensaje
                mensaje.style.display = 'block';

                // Oculta el mensaje después de 5 segundos (5000 milisegundos)
                setTimeout(function () {
                    mensaje.style.display = 'none';
                }, 2000); // 5000 milisegundos = 5 segundos
            }

            // Llama a la función para temporizar el mensaje cuando la página se carga
            window.onload = temporizarMensaje;
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
                crossorigin="anonymous"
        ></script>
</body>
</html>
