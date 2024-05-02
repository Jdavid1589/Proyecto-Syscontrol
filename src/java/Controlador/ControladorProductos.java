package Controlador;

import Modelo.Productos;
import Persistencia.DaoProductos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorProductos extends HttpServlet {
    // String registrar = "RegistrosModal.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

        switch (action) {
            case "add":
                request.getRequestDispatcher("Vistas/RegistroReferencias.jsp").forward(request, response);
                break;

            case "registrar":
                registrarProducto(request, response);
                break;

            case "listar":
                listarProductos(request, response);
                break;

            case "editarProducto":
                request.setAttribute("idEditarPr", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/EditarProducto.jsp").forward(request, response);
                break;

            case "registrarEdicion":
                actualizarProducto(request, response);
                break;

            case "eliminar2":
                eliminarProducto(request, response);
                break;

            default:
                // Handle any other actions or provide a default behavior
                break;
        }
    }
    // Separate methods for each action

    private void registrarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String nombres_Pro = request.getParameter("nombres_Productos");
      //  int TProd = Integer.parseInt(request.getParameter("idTipoProducto"));
        
        

        Productos producto = new Productos();

        producto.setNombres_Productos(request.getParameter("referencia"));
        producto.setTipoProducto_idtipoProducto(Integer.parseInt(request.getParameter("idtipo")));
     

        if (DaoProductos.registrar(producto)) {
            request.setAttribute("Mensaje", " Producto Registrado Con Exito");
        } else {
            request.setAttribute("mensaje", "el perfil no fue registrado");
        }

        List<Productos> lt = DaoProductos.listar();
        request.setAttribute("listaProductos", lt);
        request.getRequestDispatcher("Vistas/ListarProductosRef.jsp").forward(request, response);
    }

       private void listarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Productos> ltListar = DaoProductos.listar();
        request.setAttribute("listaProductos", ltListar);
        request.getRequestDispatcher("Vistas/ListarProductosRef.jsp").forward(request, response);
    }
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

          //  String nombres_Pro = request.getParameter("referencia");
           // int TProd = Integer.parseInt(request.getParameter("idtipo"));
          //  int txtidProducto = Integer.parseInt(request.getParameter("txtidProducto"));
       
            Productos producto = new Productos();

            producto.setNombres_Productos( request.getParameter("referencia"));
            producto.setTipoProducto_idtipoProducto( Integer.parseInt(request.getParameter("idtipo")));          
            producto.setIdProductos(Integer.parseInt(request.getParameter("txtidProducto")));

            boolean actualizacionExitosa = DaoProductos.editar(producto);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }
            //  listarEspecificaciones(request, response);
            List<Productos> lt = DaoProductos.listar();
            request.setAttribute("listaProductos", lt);
            request.getRequestDispatcher("Vistas/ListarProductosRef.jsp").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarProductos(request, response);
        }
    }

 

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idproductos = Integer.parseInt(request.getParameter("id"));

        if (DaoProductos.eliminar(idproductos)) {
            request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
        } else {
            request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
        }

        List<Productos> ltEliminar = DaoProductos.listar();
        request.setAttribute("listaProductos", ltEliminar);
        request.getRequestDispatcher("Vistas/ListarProductosRef.jsp").forward(request, response);
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
