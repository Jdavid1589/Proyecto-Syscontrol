

<%@page import="Persistencia.DaoClientes"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Persistencia.DaoProductos"%>
<%@page import="Modelo.Productos"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Modelo.Documento"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>

<!-- required sirve para validar un campo que no se valla vacio -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <script src="./js/FuncionCondicionales.js" type="text/javascript"></script>
        
                <link href="Vistas/Estilos_css/estilo4.css" rel="stylesheet" type="text/css"/>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


        <title>Registro Consecutivos</title>   

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
                            <a class="nav-link active" aria-current="page" href="ControladorConsecutivo?accion=Listar2">
                                <span  class=" btn btn-primary ">
                                    <i <i class="fas fa-list"></i><b>
                                        Listar
                                </span>
                            </a></b>

                        </li>

                    </ul>
                </div>
            </div>

        </nav>

        <!--Barra de Navegacion -->



        <div class="container-fluid text-center mt-3">
            <div class="row">
                <div class="col-md-12 mx-auto">

                    <h1 class=" elegant-font text-primary">REGISTRO CONSECUTIVO</h1>
            

                </div>
            </div>
        </div>

        <!-- Contenedor principal centrado -->
        <div class="container-fluid text-center mt-3">
            <div class="row">
                <div class="col-6 mx-auto">

            
                    <form action="ControladorConsecutivo" method="post" autocomplete="off" onsubmit="return validarFormulario()">


                        <div class="row">
                            <div class="col-md-6 ">

                                <div class="form-group text-left">
                                    <label for="nroRemision" id="label-azul" class="text-left"># Remision</label>
                                    <input type="text" class="form-control" id="nroRemision" name="nroRemision" 
                                           placeholder="Ingrese ">
                                </div>                           



                                <div class="form-group text-left">
                                    <label for="productos_idProductos"> Referencia</label>
                                    <select class="form-control" id="productos_idProductos"  name="productos_idProductos" >
                                        <option value="0" >Seleccione Referencia</option>
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
                                </div>

                                <div class="form-group text-left">
                                    <label for="nroConsecutivo"># Consecutivo</label>
                                    <input type="text" class="form-control" id="nroConsecutivo" name="nroConsecutivo" 
                                           placeholder="Ingrese Nombres" >
                                </div>

                                <div class="form-group text-left">
                                    <label for="clientes_idclientes"> Cliente</label>
                                    <select class="form-control" id="clientes_idclientes" name="clientes_idclientes">
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
                                </div>

                            </div>
                            <div class="col-6"> 

                                <div class="form-group text-left">
                                    <label for="fechaCertificado">Fecha</label>
                                    <input type="date" class="form-control" id="fechaCertificado" name="fechaCertificado" 
                                           placeholder="Ingrese Fecha">
                                </div>

                                <div class="form-group text-left">
                                    <label for="fechaProduccion">Fecha Prod</label>
                                    <input type="date" class="form-control" id="fechaProduccion" name="fechaProduccion" 
                                           placeholder="Ingrese Fecha">
                                </div>

                                <!-- Agrega este campo de entrada específico -->
                                <div class="form-group text-left">
                                    <label for="cantidadMaterial">Cant Material</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="cantidadMaterial" name="cantidadMaterial" placeholder="Ingrese Cant">
                                        <div class="input-group-append">
                                            <button type="button" onclick="abrirCalculadora()" class="btn btn-outline-primary">
                                                <i class="fas fa-calculator"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group text-left">
                                    <label for="usuarios_idUsuarios"> Auxiliar</label>
                                    <select class="form-control" id="usuarios_idUsuarios" name="usuarios_idUsuarios">
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
                            </div>
                        </div>
                </div>

                <div class="container mt-5">
                    <hr>

                    <div class="row">
                        <div class="col-12 mb-3 ">
                            <div class="d-grid gap-2">
                                <button type="submit" name="accion" value="RegistrarConsecutivo" class="btn btn-outline-primary">
                                    <i class="fas fa-save"></i> Guardar
                                </button>

                                <a href="ControladorConsecutivo?accion=Listar2" class="btn btn-secondary">
                                    <i class="fas fa-times dan"></i> Cancelar
                                </a>
                            </div>  
                        </div>
                    </div>
                </div>

                </form>
            </div>
        </div>

        <!-- Elimina este div extra al principio -->
        <div>

            <!-- Agrega este modal al final de tu formulario -->
            <div class="modal fade" id="calculadoraModal" tabindex="-1" role="dialog" aria-labelledby="calculadoraModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="calculadoraModalLabel">Calculadora</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <!-- Agrega estos botones al cuerpo del modal -->
                        <div class="modal-body">
                            <label for="numero1">Cantidad Material:</label>
                            <input type="text" id="numero1" placeholder="Ingrese cantidad Material en kg" class="form-control" />

                            <label for="numero2">Divisor:</label>
                            <input type="text" placeholder="Ingrese Peso Saco (25 Kg)." id="numero2" class="form-control" />
                            <!--label for="numero2">Numeros(Separados por comas):</label>
                            <input type="text" placeholder="Numeros" id="numeros" class="form-control" /-->

                            <div class="mt-3">
                                <button type="button" class="btn btn-primary" onclick="calcular('sumar')">Sumar</button>
                                <button type="button" class="btn btn-primary" onclick="calcular('restar')">Restar</button>
                                <button type="button" class="btn btn-primary" onclick="calcular('multiplicar')">Multiplicar</button>
                                <button type="button" class="btn btn-warning" onclick="calcular('dividir')"><b>Dividir</b></button>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <!-- metodos split-->
        <!--script>
            function abrirCalculadora() {
                // Limpiar campos al abrir el modal
                limpiarCampos();
                // Muestra el modal con la calculadora
                $('#calculadoraModal').modal('show');
            }

            function limpiarCampos() {
                // Limpiar los valores de los campos
                document.getElementById('numero1').value = '';
                document.getElementById('numero2').value = '';
                document.getElementById('numeros').value = '';
                document.getElementById('cantidadMaterial').value = '';
            }

            function calcular(operacion) {
                // Obtén los valores de los campos de la calculadora
                var numero1 = parseFloat(document.getElementById('numero1').value) || 0;
                var numero2 = parseFloat(document.getElementById('numero2').value) || 0;
                var numeros = document.getElementById('numeros').value;

                // Realiza la operación seleccionada
                var resultado;
                switch (operacion) {
                    case 'sumar':
                        resultado = sumarNumeros(parseNumerosSeparadosPorComa(numeros));
                        break;
                    case 'restar':
                        resultado = restarNumeros(parseNumerosSeparadosPorComa(numeros));
                        break;
                    case 'multiplicar':
                        resultado = multiplicarNumeros(parseNumerosSeparadosPorComa(numeros));
                        break;
                    case 'dividir':
                        resultado = dividirNumeros(parseNumerosSeparadosPorComa(numeros));
                        break;
                    default:
                        resultado = 'Error: Operación no válida';
                }

                // Actualiza el campo de cantidadMaterial en el formulario principal
                document.getElementById('cantidadMaterial').value = resultado;

                // Cierra el modal
                $('#calculadoraModal').modal('hide');
            }

            // Función para sumar un array de números
            function sumarNumeros(numerosArray) {
                return numerosArray.reduce(function (acc, num) {
                    return acc + num;
                }, 0);
            }

            // Función para restar un array de números
            function restarNumeros(numerosArray) {
                if (numerosArray.length === 0) {
                    return 0; // Si el array está vacío, retornamos 0
                }

                // Utilizamos el primer elemento del array como valor inicial y restamos los demás
                return numerosArray.slice(1).reduce(function (acc, num) {
                    return acc - num;
                }, numerosArray[0]);
            }

            // Función para multiplicar un array de números
            function multiplicarNumeros(numerosArray) {
                return numerosArray.reduce(function (acc, num) {
                    return acc * num;
                }, 1);
            }

            // Función para dividir un array de números
            function dividirNumeros(numerosArray) {
                return numerosArray.reduce(function (acc, num) {
                    return acc / num;
                });
            }

            // Función para convertir números separados por comas en un array de números
            function parseNumerosSeparadosPorComa(numeros) {
                return numeros.split(',').map(function (num) {
                    return parseFloat(num.trim()) || 0;
                });
            }
        </script-->



        <!--MEtodo para calcaludar a partir de dos numeros -->
        <script>
            function abrirCalculadora() {
                // Limpiar campos al abrir el modal
                limpiarCampos();
                // Muestra el modal con la calculadora
                $('#calculadoraModal').modal('show');
            }

            function limpiarCampos() {
                // Limpiar los valores de los campos
                document.getElementById('numero1').value = '';
                document.getElementById('numero2').value = '';
                // document.getElementById('numeros').value = '';
                document.getElementById('cantidadMaterial').value = '';
            }


            function calcular(operacion) {
                // Obtén los valores de los campos de la calculadora
                var numero1 = parseFloat(document.getElementById('numero1').value);
                var numero2 = parseFloat(document.getElementById('numero2').value);



                // Realiza la operación seleccionada y entrega un Double
                /*var resultado;
                 switch (operacion) {
                 case 'sumar':
                 resultado = numero1 + numero2;
                 break;
                 case 'restar':
                 resultado = numero1 - numero2;
                 break;
                 case 'multiplicar':
                 resultado = numero1 * numero2;
                 break;
                 case 'dividir':
                 resultado = numero2 !== 0 ? numero1 / numero2 : 'Error: División por cero';
                 break;
                 default:
                 resultado = 'Error: Operación no válida';
                 }*/

                // Realiza la operación seleccionada y entrega un Int
                // 1. Math.round: sirve para redondear un  valor al mas cercano
                // 2. Math.trunc: sirve La función Math.trunc() en JavaScript se utiliza para truncar un número hacia su parte entera,
                //eliminando cualquier parte decimal
                //Ejemplo: var numero = 3.75;var resultado                        
                // Resultado  // Salida: 3
               
                // Realiza la operación seleccionada y entrega un Int
                switch (operacion) {
                    case 'sumar':
                        resultado = Math.trunc(numero1 + numero2);
                        break;
                    case 'restar':
                        resultado = Math.trunc(numero1 - numero2);
                        break;
                    case 'multiplicar':
                        resultado = Math.trunc(numero1 * numero2);
                        break;
                    case 'dividir':
                        resultado = numero2 !== 0 ? Math.trunc(numero1 / numero2) : 'Error: División por cero';
                        break;
                    default:
                        resultado = 'Error: Operación no válida';
                }


                // Actualiza el campo de cantidadMaterial en el formulario principal
                document.getElementById('cantidadMaterial').value = resultado;

                // Cierra el modal
                $('#calculadoraModal').modal('hide');
            }
        </script>





        <script>


            function validarFormulario() {
                // Obtener los valores de los campos
                var nroRemision = document.getElementById('nroRemision');
                var nroConsecutivo = document.getElementById('nroConsecutivo');
                var fechaCertificado = document.getElementById('fechaCertificado');
                var fechaProduccion = document.getElementById('fechaProduccion');
                var cantidadMaterial = document.getElementById('cantidadMaterial');

                // Verificar que los campos no estén vacíos
                if (!validarCampo(nroRemision) || !validarCampo(nroConsecutivo) ||
                        !validarCampo(fechaCertificado) || !validarCampo(fechaProduccion) ||
                        !validarCampo(cantidadMaterial)) {
                    alert('Por favor, complete todos los campos.');
                    return false; // Evitar que el formulario se envíe
                }

                // Agrega más validaciones si es necesario

                return true; // Permitir que el formulario se envíe
            }

            function validarCampo(campo) {
                // Eliminar espacios en blanco al inicio y al final
                var valor = campo.value.trim();

                // Verificar que el campo no esté vacío o sea nulo
                if (valor === '') {
                    campo.style.borderColor = 'red'; // Pintar el borde del campo de rojo

                    return false;
                } else {
                    campo.style.borderColor = ''; // Restablecer el color del borde
                    return true;
                }
            }
        </script>

        <style>
            input, select {
                border: 1px solid #ced4da; /* Color de borde por defecto */
                /* Otras propiedades de estilo según sea necesario */
            }
        </style>

        <!-- Bootstrap CSS y JavaScript -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><%--lo de las alertas--%>

        <!--script>
        function mostrarAlerta() {
            try {
                console.log("Función mostrarAlerta ejecutada");

                const result = await Swal.fire({
                    title: "¿Estás seguro?",
                        text: "Deseas Registrar este Cliente.",
                        icon: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#3085d6",
                        cancelButtonColor: "#d33",
                        confirmButtonText: "Sí, registrar",
                        cancelButtonText: "Cancelar"
                }
                );

                if (result.isConfirmed) {
                    console.log("Usuario confirmó la acción");
                    await enviarSolicitudAlControlador();
                    await mostrarAlertaRegistroExitoso();
                    redirigirUsuario();
                }
                else {
                    console.log("Usuario canceló la acción");
                }
            }
            catch (error) {
                manejarErrores(error);
            }
        }

        async function enviarSolicitudAlControlador() {
            try {
                console.log("Enviando solicitud al controlador");

                const form = document.getElementById('miFormulario');
                const formData = new FormData(form);

                const response = await fetch("ControladorClientes?accion=registrar",
                /* window.location.href = "ControladorClientes?accion=listar";*/{
                    method: 'POST',
                        body: formData,
                }
                );

                if (!response.ok) {
                    throw new Error('Error al enviar la solicitud al controlador');
                }
            }
            catch (error) {
                manejarErrores(error);
            }
        }

        function mostrarAlertaRegistroExitoso() {
            console.log("Mostrando alerta de registro exitoso");

            await Swal.fire({
                title: "Buen trabajo!",
                    text: "Registro Exitoso!",
                    icon: "success",
                    confirmButtonText: "OK",
            }
            );
        }

        function redirigirUsuario() {
            console.log("Redirigiendo al usuario");
            window.location.href = "ControladorClientes?accion=listar";
        }

        function manejarErrores(error) {
            console.error(error);
        }
        </script-->


    </body>
</html>
