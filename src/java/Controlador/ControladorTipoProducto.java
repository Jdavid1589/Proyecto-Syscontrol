
package Controlador;

import Modelo.Productos;
import Modelo.TipoProducto;
import Persistencia.DaoTipoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUAN DAVID
 */
public class ControladorTipoProducto extends HttpServlet {

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
            String TipoProduc = request.getParameter("tipo");

            TipoProducto tipoproducto = new TipoProducto();

            tipoproducto.setTipo(TipoProduc);

            if (DaoTipoProducto.registrar(tipoproducto)) {
                request.setAttribute("Mensaje", " Producto Registrado Con Exito");
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            } else {
                request.setAttribute("mensaje", "el perfil no fue registrado");
                //  acceso = registrar;
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

                List<TipoProducto> lt = DaoTipoProducto.listar();
                request.setAttribute("listaTipoProducto", lt);
                request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("listar")) {
            List<TipoProducto> lt = DaoTipoProducto.listar();
            request.setAttribute("listaTipoProducto", lt);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

        } else if (action.equalsIgnoreCase("eliminar")) {

            int idtipoProducto = Integer.parseInt(request.getParameter("id"));

            if (DaoTipoProducto.eliminar(idtipoProducto)) {
                request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }
            // Redirige a la página correcta
            List<TipoProducto> lt = DaoTipoProducto.listar();
            request.setAttribute("listaTipoProducto", lt);
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
