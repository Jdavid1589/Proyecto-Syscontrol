package Controlador;

import Modelo.Seguimientos;
import Persistencia.DaoSeguimientos;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorVariables_Calidad extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("registrar")) {
            String VariablesCalidad = request.getParameter("Variables_calidad");
            Seguimientos variables = new Seguimientos();
            variables.setNumSeguimiento(VariablesCalidad);

            if (DaoSeguimientos.grabar(variables)) {
                request.setAttribute("Mensaje", " Seguimiento Registrado Con Exito");
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            } else {
                request.setAttribute("mensaje", "el perfil no fue registrado");
                //  acceso = registrar;
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

                List<Seguimientos> lt = DaoSeguimientos.listar();
                request.setAttribute("listaVariables", lt);
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("listar")) {
            List<Seguimientos> lt = DaoSeguimientos.listar();
            request.setAttribute("listaVariables", lt);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            
        } else if (action.equalsIgnoreCase("eliminar")) {

            int idvariablescalidad = Integer.parseInt(request.getParameter("id"));

            if (DaoSeguimientos.eliminar(idvariablescalidad)) {
                request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el Reporte Control ");
            }
            // Redirige a la página correcta
            List<Seguimientos> lt = DaoSeguimientos.listar();
            request.setAttribute("listaVariables", lt);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
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
