
<%-- 
    Document   : login
    Created on : 5/09/2023, 10:06:02 p. m.
    Author     : cesar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <!-- Incluye Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <style>
        body {
            background-color: #f5f5f5;
        }

        .container {
            margin-top: 100px;
        }

        .card {
            border: none;
            border-radius: 15px;
            box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: #007bff;
            border-radius: 15px 15px 0 0;
            text-align: center;
        }

        .card-header h3 {
            color: #fff;
        }

        .card-body {
            padding: 30px;
        }

        .form-control {
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            border-radius: 5px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
    
    
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="text-center">Inicio de Sesión</h3>
                        </div>
                        <div class="card-body">
                            <form action="ControladorLogin?accion=verificar" method="post">


                                <div> 
                                    <label>Username:</label>
                                    <input type="text" name="txtUsername" class="form-control" placeholder="Ingrese  Usuario" required>
                                </div>
                                <div> 
                                    <label>Clave</label>
                                    <input type="password" name="txtPasword" class="form-control" placeholder="*****" required>

                                </div>
                                <input type="submit" name="accion" class="btn btn-primary btn-block mt-3" value="Validar">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Incluye Bootstrap JS y jQuery (opcional) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
