package Controlador;

import Modelo.Consecutivo;
import Modelo.ControlSeco;

import Modelo.Especificaciones;

import Persistencia.DaoEspecificaciones;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import util.Generarpdf;

public class ControladorEspecificaciones extends HttpServlet {

    Especificaciones Esp = new Especificaciones();
    int ide;  // Variable de instancia para almacenar el ID

    //La variable serialVersionUID se utiliza en Java para asignar una versión única 
    //a una clase Serializable.
    //En este contexto, private static final long serialVersionUID = 1L; simplemente está estableciendo 
    //el serialVersionUID de la clase ControladorConsecutivo
    private static final long serialVersionUID = 1L;

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
                request.getRequestDispatcher("Vistas/RegistroEspecificaciones.jsp").forward(request, response);
                break;

            case "registrar":
                registrarEspecificaciones(request, response);
                break;

            case "listar":
                listarEspecificaciones(request, response);
                break;

            case "editarEspecif":
                editarEspecific(request, response);
                break;

            case "editarpdf_Esp":
                editarpdf(request, response);
                break;

            case "Modificar":
                actualizarEspecifi(request, response);
                break;
            case "genpdf":
                crearpdf(request, response);
                break;

            case "eliminar":
                eliminarEspecific(request, response);
                break;

            default:
                // Handle any other actions or provide a default behavior
                break;
        }
    }
    
//Metodo Registrar

    private void registrarEspecificaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productos = Integer.parseInt(request.getParameter("idProductos"));
            int cliente = Integer.parseInt(request.getParameter("idclientes"));
            String variableesp = request.getParameter("variablesEspecificacion");
            String valoresp = request.getParameter("valorEspecific");
            String metodos = request.getParameter("metodoAnalisis");

            Especificaciones especific = new Especificaciones();

            especific.setIdProductos(productos);
            especific.setIdclientes(cliente);
            especific.setVariablesEspecificacion(variableesp);
            especific.setValorEspecific(valoresp);
            especific.setMetodoAnalisis(metodos);

            if (DaoEspecificaciones.grabarEsp(especific)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            //  listarEspecificaciones(request, response);
            List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar  la Especificacion");
            listarEspecificaciones(request, response);
        }
    }

    //Metodo Listar
    private void listarEspecificaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);
        }
    }

    //Metodo Listar PAra Eidtar
    private void editarEspecific(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener el ID del parámetro de solicitud y almacenarlo en la variable de instancia
            ide = Integer.parseInt(request.getParameter("id"));
            Especificaciones E = DaoEspecificaciones.obtenerEspecificPorId(ide);
            request.setAttribute("Espec", E);

            List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al editar el Consecutivo");
            listarEspecificaciones(request, response);
        }
    }

    //Metodo Modificar
    private void actualizarEspecifi(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Utilizar la variable de instancia para obtener el ID
            Especificaciones E = DaoEspecificaciones.obtenerEspecificPorId(ide);
            request.setAttribute("Espec", E);

            // Recuperar parámetros del formulario
            // int idEspecificaciones = Integer.parseInt(request.getParameter("idEspecificaciones"));
            int productosId = Integer.parseInt(request.getParameter("idProductos"));
            int clientesId = Integer.parseInt(request.getParameter("idclientes"));
            String variablesEspecificacion = request.getParameter("variablesEspecificacion");
            String valorEspecificacion = request.getParameter("valorEspecific");
            String metodoAnalisis = request.getParameter("metodoAnalisis");

            Especificaciones especifi = new Especificaciones();

            // lógica para guardar en la base de datos
            especifi.setIdespecificaciones(ide);
            especifi.setIdProductos(productosId);
            especifi.setIdclientes(clientesId);
            especifi.setVariablesEspecificacion(variablesEspecificacion);
            especifi.setValorEspecific(valorEspecificacion);
            especifi.setMetodoAnalisis(metodoAnalisis);

            boolean actualizacionExitosa = DaoEspecificaciones.editar(especifi);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }
            //  listarEspecificaciones(request, response);
            List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarEspecificaciones(request, response);
        }
    }

    //Metodo Crearpdf
    ControlSeco producto_Seco = new ControlSeco();

    private void crearpdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // Recuperar parámetros del formulario
            int idEspecificaciones = Integer.parseInt(request.getParameter("idespecificaciones"));
            int productosId = Integer.parseInt(request.getParameter("idProductos"));
            int clientesId = Integer.parseInt(request.getParameter("idclientes"));
            String variablesEspecificacion = request.getParameter("variablesEspecificacion");
            String valorEspecificacion = request.getParameter("valorEspecific");
            String metodoAnalisis = request.getParameter("metodoAnalisis");

            Especificaciones especifi = new Especificaciones();
            Consecutivo consecutivo = new Consecutivo();

            // lógica para guardar en la base de datos
            especifi.setIdProductos(productosId);
            especifi.setIdclientes(clientesId);
            especifi.setVariablesEspecificacion(variablesEspecificacion);
            especifi.setValorEspecific(valorEspecificacion);
            especifi.setMetodoAnalisis(metodoAnalisis);
            especifi.setIdespecificaciones(idEspecificaciones);

           /* try {

                new Generarpdf().genPdf(producto_Seco, especifi, consecutivo);
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }*/

            boolean actualizacionExitosa = DaoEspecificaciones.editar(especifi);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }
            //  listarEspecificaciones(request, response);
            List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarEspecificaciones(request, response);
        }
    }

    //Metodo Modificar PDF
    private void editarpdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idpdf", request.getParameter("id"));
        request.getRequestDispatcher("Vistas/EditarPdf.jsp").forward(request, response);

    }

    private void eliminarEspecific(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idespecific = Integer.parseInt(request.getParameter("id"));

            if (DaoEspecificaciones.eliminar(idespecific)) {
                request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el Reporte");
            }

            listarEspecificaciones(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarEspecificaciones(request, response);
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
    }

}
