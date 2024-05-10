<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menú MI</title>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

        <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
        <link href="Vistas/Estilos_css/EstilosBarra.css" rel="stylesheet" type="text/css"/>

    </head>
    <body id="body">

        <header>
            <div class="icon__menu">
                <i class="fas fa-bars" id="btn_open"></i>
            </div>
        </header>

        <div class="menu__side" id="menu_side">

            <div class="name__page">
                <%--  <i class="fab fa-youtube"></i>--%>
                <i class="fa-solid fa-circle-minus"></i>
                <h4>Menu</h4>
            </div>

            <div class="options__menu">	


                <a href="ControladorPL?accion=listar"   target="_blank">
                    <div class="option">
                        <i class="far fa-file" title="Portafolio"></i>
                        <h4>Lodos</h4>
                    </div>
                </a>

                <a href="ControladorPs?accion=listar"   target="_blank">
                    <div class="option">
                        <i class="far fa-file" title="Portafolio"></i>
                        <h4>Seco</h4>
                    </div>
                </a>

                <a  href="ControladorConsecutivo?accion=Listar2">
                    <div class="option">
                        <i class="far fa-sticky-note" title="Blog"></i>
                        <h4>Consecutivo</h4>
                    </div>
                </a>

                <li class="nav-item dropdown"> 

                    <i class="far fa-sticky-note" title="Blog"></i>
                    <a class="btn btn-outline-light dropdown-toggle  "                     
                       href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Registros  
                    </a>

                    <ul class="dropdown-menu " aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="ControladorProductos?accion=listar">Productos</a></li>                                       
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="ControladorClientes?accion=listar">Clientes</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="ControladorUsuarios?accion=listar">Usuarios</a></li>
                        <li><hr class="dropdown-divider"></li>                           
                        <li><a class="dropdown-item" href="ControladorRegModal?accion=listar">Otros Registro</a></li>
                    </ul>
                </li>


            </div>

        </div>

        <main>
            <div class="row">
                <div class="col-md-12">
                    <div id="cuadro2">
                        <img src="Vistas/Imagenes/MI.jpg" alt=""/>
                        <h1 >BIENVENIDOS A SYSCONTROL MI</h1>
                    </div>
                </div>
            </div>
        </main>


        <script src="js/scrip.js" type="text/javascript"></script>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>

