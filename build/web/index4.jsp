
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Syscontrol-MI</title>

        <!-- Incluye los archivos CSS de Bootstrap -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link href="Vistas/estilofondo.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>   

     

<!-- Contenedor principal -->
    <div class="container-fluid">
        <div class="row">
            <!-- Menú desplegable -->
            <nav class="navbar navbar-dark bg-aqua">
                <div class="container-fluid">
                    <button class="navbar-toggler bg-dark" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </nav>
            <!-- Columna izquierda (con menú desplegable) -->
            <div class="col-2 separator">
                <div class="collapse" id="navbarToggleExternalContent">
                    <div class="bg-primary p-4">
                       <h5 class="text-dark text-left h4">COMPONENTES</h5>
                        <!--span>
                            <a class="nav-link active text-white" aria-current="page" href="./index3.jsp">Inicio</a>
                        </span-->

                        <div class="horizontal-menu">
                            <span>                   
                                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="bi bi-menu-down text-white"></i> <b>REPORTES</b>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                    <li><a class="dropdown-item text-success" href="ControladorControlCalidad?accion=add"><b><i class="bi bi-suit-diamond-fill"></i></i> TERMINADO LODO</b></a></li>
                                    <li><a class="dropdown-item text-left" href="ControladorControlCalidad?accion=listar"><i class="bi bi-suit-diamond-fill"></i></i><b> REPORTES LODOS</a></b></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <!--li><a class="dropdown-item text-success" href="ControladorProductoSeco?accion=add"><em><b><i class="bi bi-suit-diamond-fill"></i></i> Control Tdo Seco</b></em></a></li-->
                                    <li><a class="dropdown-item text-primary" href="ControladorProductoSeco?accion=listar"><b><i class="bi bi-suit-diamond-fill"></i></i> TERMINADO SECO</b></a></li>
                                     <li><a class="dropdown-item text-primary" href="ControladorRegModal?accion=listar"><b><i class="bi bi-suit-diamond-fill"></i></i> REGISTROS</b></a></li>
                                </ul>                   
                            </span>

                            <span>
                                <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="bi bi-list text-white"></i> <b>REGISTROS</b>
                                </a>
                                <ul class="dropdown-menu " aria-labelledby="navbarDropdown1">
                                    <li><a class="dropdown-item text-success" href="ControladorUsuarios?accion=add"><b><i class="bi bi-suit-diamond-fill"></i></i> REGISTRO USUARIOS</b></a></li>
                                    <li><a class="dropdown-item" href="ControladorUsuarios?accion=listar"><b><i class="bi bi-suit-diamond-fill"></i></i> LISTA USUARIOS</b></a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <!--li><a class="dropdown-item text-success" data-toggle="modal" data-target="#registroModalDocumento"><em><b><i class="bi bi-suit-diamond-fill"></i></i> Tipo Documento</b></em></a></li>
                                    <li><a class="dropdown-item" data-toggle="modal" data-target="#registroModalVariables"><em><i class="bi bi-suit-diamond-fill"></i></i>Tipo Variables</em></a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item text-success" data-toggle="modal" data-target="#registroModalPerfil"><b><em><i class="bi bi-suit-diamond-fill"></i></i> Tipo Perfil</em></b></a></li>
                                    <li><a class="dropdown-item" data-toggle="modal" data-target="#registroModalProductos"><em><i class="bi bi-suit-diamond-fill"></i></i> Tipo Rerefencias</em></a></li-->
                                    
                                </ul>
                            </span>

                        </div>
                    </div>
                </div>
            </div>
            <!-- Columna derecha -->
            <div class="col-10">
                <!-- Contenido principal aquí -->
                <div class="container">
                    <h1 class="mt-5">BIENVENIDOS A SYSCONTROL MI2</h1>
                </div>
            </div>
        </div>
    </div>
        
        
        
        
        


        <style>
            .modal-dialog-centered {
                display: flex;
                align-items: center;
                min-height: calc(100% - 3.5rem);
            }
             /* Haz que el menú desplegable ocupe todo el ancho disponible y sea fijo */
        .navbar {
            width: 100%;
            position: fixed;
            top: 0;
            z-index: 1000; /* Asegura que esté por encima de otros elementos */
        }
        /* Añade una línea para separar las dos columnas */
        .separator {
            border-right: 1px solid #ccc;
            height: 100vh; /* Haz que la línea sea del mismo alto que el contenido */
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
    </body>
</html>
