/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Documento;
import Persistencia.DaoDocumento;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ControladorDocumento", urlPatterns = {"/ControladorDocumento"})
public class ControladorDocumento extends HttpServlet {

    //String add = "Vistas/RegistrarDocumento.jsp";
    String add = "Vistas.RegistrosModal.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";

        if (action.equalsIgnoreCase("add")) {
            acceso = add;
            request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("registrar")) {
            String tipoDocumento = request.getParameter("documento");
            Documento documento = new Documento();
            documento.setTipo_documento(tipoDocumento);

            if (DaoDocumento.registrar(documento)) {
                request.setAttribute("mensaje", "Registro Tipo Documento Exitoso");
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            } else {
                request.setAttribute("mensaje", "Error Documento Registro");
                request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);

                List<Documento> lt = DaoDocumento.listar();
                request.setAttribute("listaDocumento", lt);
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("listar")) {
            List<Documento> lt = DaoDocumento.listar();
            request.setAttribute("listaDocumento", lt);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
        } else if (action.equalsIgnoreCase("eliminar")) {

            int idDocumento = Integer.parseInt(request.getParameter("id"));

            if (DaoDocumento.eliminar(idDocumento)) {
                request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }
            // Redirige a la página correcta
            List<Documento> lt = DaoDocumento.listar();
            request.setAttribute("listaDocumento", lt);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idEditar_ps", request.getParameter("id"));
            //request.getRequestDispatcher("Vistas/Editar_prod_seco.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("registrarEdicion")) {
            try {
                String tipoDocumento = request.getParameter("documento");

                Documento documento = new Documento();
                documento.setTipo_documento(tipoDocumento);

                //  producto_Seco.setIdProducto_Seco(txtid_ps);
                List<Documento> lt = DaoDocumento.listar();
                request.setAttribute("listaDocumento", lt);
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

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
