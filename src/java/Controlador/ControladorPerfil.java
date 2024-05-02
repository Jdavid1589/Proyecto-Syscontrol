package Controlador;

import Modelo.Perfil;
import Persistencia.DaoPerfil;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorPerfil extends HttpServlet {
    // String registrar = "Vistas/RegistrarPerfil.jsp";

    String registrar = "ControladorRegModal?accion=listar";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";

        if (action.equalsIgnoreCase("add")) {
            acceso = registrar;
            request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("registrar")) {
            String nombre = request.getParameter("perfil");
            Perfil perfil = new Perfil();
            perfil.setTipo_Perfil(nombre);

            if (DaoPerfil.registrar(perfil)) {
                request.setAttribute("mensaje", "REGISTRRO VARIABLE EXITOSO");
                //  acceso = registrar;
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            } else {
                request.setAttribute("mensaje", "el perfil no fue registrado");
                //acceso = registrar;
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

                // List<Perfil> lt = DaoPerfil.listar();
                //request.setAttribute("listaPerfil", lt);
                acceso = registrar;
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("listar")) {
            List<Perfil> lt = DaoPerfil.listar();
            request.setAttribute("listaPerfil", lt);
            acceso = registrar;
            // request.getRequestDispatcher( "ControladorRegModal?accion=listar").forward(request, response);
        } else if (action.equalsIgnoreCase("eliminar")) {

            int idperfil = Integer.parseInt(request.getParameter("id"));

            if (DaoPerfil.eliminar(idperfil)) {
                request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }
            // Redirige a la página correcta
            List<Perfil> lt = DaoPerfil.listar();
            request.setAttribute("listaPerfil", lt);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

        } else if (action.equalsIgnoreCase("Editar_perfil")) {

            request.setAttribute("idEditar_perfil", request.getParameter("id"));
            request.getRequestDispatcher("./Vistas/Editar_RegistrosModal.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("registrarEdicion_perfil")) {
            try {
                int txtid_perfil = Integer.parseInt(request.getParameter("idperfil"));
                String tipoperfil = request.getParameter("tipo_Perfil");

                Perfil perfil = new Perfil();

                perfil.setIdperfil(txtid_perfil);
                perfil.setTipo_Perfil(tipoperfil);

                List<Perfil> lt = DaoPerfil.listar();
                request.setAttribute("listaPerfil", lt);
                  request.getRequestDispatcher("./Vistas/RegistrosModal.jsp").forward(request, response);
            } catch (NumberFormatException e) {

                // Handle NumberFormatException
                String errorMessage = "Error: One or more fields contain invalid numeric values.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            } catch (Exception e) {

                // Handle other exceptions
                e.printStackTrace(); // Log the exception for debugging
                String errorMessage = "An unexpected error occurred.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
