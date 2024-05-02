

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Syscontrol-MI </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
        <link href="Vistas/estilosbarra.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>

        <style>

            #cuadro {
                max-width: 700px;
                margin: 50px auto;
                /*  background-image: url('MI.jpg');*/
                background-size: cover;
                background-color:  #f5f5f5;
                background-position: center;
                padding: 90px;
                border-radius: 20px;
                box-shadow: 0 0 10px rgba(149, 169, 219, 0.8 ); /* Agregado sombreado al cuadro */
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            #cuadro h1 {
                text-align: center;
                color: #000066;
                margin-top: 0;
                font-family: 'Lucida Console', sans-serif; /* Cambiado a Arial, puedes usar otras fuentes como 'Georgia', 'Times New Roman', etc. */
                text-shadow: 2px 2px 4px rgba(0, 255, 255, 0.5);
                margin: 2;
                font-weight: bold; /* Agregado negrita */
                font-size: 50px; /* Aumentado el tamaño de letra a 28px, ajusta según tus necesidades */
            }

            #cuadro img {
                max-width: 150px; /* Ajusta el ancho máximo del logo según sea necesario */
                height: auto;
                border-radius: 5px;
            }
        </style>

    </head>

    <body id="body">

        <header>

            <div class="icon__menu">
                <i class="fas fa-bars" id="btn_open"></i>
            </div>
        </header>

        <div class="menu__side" id="menu_side">

            <div class="name__page">
                <!--i class="fab fa-youtube"></i-->
                <h4>Minerales</h4>
            </div>

            <div class="options__menu">
                <!<!-- target="_blank": se usa para la pagina en una otra ventana -->
                <a href="https://www.youtube.com/" class="selected" target="_blank">
                    <div class="option">
                        <i class="fas fa-home" title="Inicio"></i>
                        <h4>Inicio</h4>
                    </div>
                </a>

                <a href="#">
                    <div class="option">
                        <i class="far fa-file" title="Portafolio"></i>
                        <h4>Portafolio</h4>
                    </div>
                </a>

                <a href="ControladorControlLodos?accion=listar" target="_blank">
                    <div class="option">
                        <!--i class="fas fa-video" title="Cursos"></i-->
                        <i class="bi bi-arrow-right-square-fill"></i>
                        <h4>Lodos</h4>
                    </div>
                </a>

                <a href="#">
                    <div class="option">
                        <i class="far fa-sticky-note" title="Blog"></i>
                        <h4>Blog</h4>
                    </div>
                </a>

                <a href="#">
                    <div class="option">
                        <i class="far fa-id-badge" title="Contacto"></i>
                        <h4>Contacto</h4>
                    </div>
                </a>

                <a href="#">
                    <div class="option">
                        <i class="far fa-address-card" title="Nosotros"></i>
                        <h4>Nosotros</h4>
                    </div>
                </a>

            </div>

        </div>

        <main>

            <!-- Contenedor principal centrado -->
            <div class="row">

                <div class="col-md-10 mx-auto">

                    <div id ="cuadro">
                        <h1 class="mt-5">BIENVENIDOS A SYSCONTROL MI</h1>

                    </div>
                </div>
            </div>
        </main>

        <script src="js/scrip.js"></script>

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

    </body>

</html>
