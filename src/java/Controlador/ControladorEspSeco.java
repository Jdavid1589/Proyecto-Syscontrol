package Controlador;

import Modelo.Consecutivo;

import Modelo.Especificaciones;
import Modelo.EspecificacionesSeco;


import Persistencia.DaoEspecificaciones;
import Persistencia.DaoEspecificacionesSeco;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import util.Generarpdf;

public class ControladorEspSeco extends HttpServlet {

    EspecificacionesSeco Esp = new EspecificacionesSeco();
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
                request.getRequestDispatcher("Vistas/RegistroEspSeco.jsp").forward(request, response);
                break;

            case "registrar":
                registrarEspecificaciones(request, response);
                break;

            case "listar":
                listarEspecificaciones(request, response);
                break;

            case "editarEspecif":
                request.setAttribute("idEditar", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/EditarEspSeco.jsp").forward(request, response);
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

                break;
        }
    }

//Metodo Registrar
    private void registrarEspecificaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productos = Integer.parseInt(request.getParameter("idProductos"));
            int cliente = Integer.parseInt(request.getParameter("idclientes"));
            String variableesp1 = request.getParameter("variableEsp1");
            String variableesp2 = request.getParameter("variableEsp2");
            String variableesp3 = request.getParameter("variableEsp3");
            String variableesp4 = request.getParameter("variableEsp4");
            String variableesp5 = request.getParameter("variableEsp5");
            String variableesp6 = request.getParameter("variableEsp6");
            String variableesp7 = request.getParameter("variableEsp7");
            String variableesp8 = request.getParameter("variableEsp8");
            String rango1 = request.getParameter("rango1");
            String rango2 = request.getParameter("rango2");
            String rango3 = request.getParameter("rango3");
            String rango4 = request.getParameter("rango4");
            String rango5 = request.getParameter("rango5");
            String rango6 = request.getParameter("rango6");
            String rango7 = request.getParameter("rango7");
            String rango8 = request.getParameter("rango8");

            EspecificacionesSeco especific = new EspecificacionesSeco();

            especific.setIdProductos(productos);
            especific.setIdclientes(cliente);
            especific.setVariableEsp1(variableesp1);
            especific.setVariableEsp2(variableesp2);
            especific.setVariableEsp3(variableesp3);
            especific.setVariableEsp4(variableesp4);
            especific.setVariableEsp5(variableesp5);
            especific.setVariableEsp6(variableesp6);
            especific.setVariableEsp7(variableesp7);
            especific.setVariableEsp8(variableesp8);

            especific.setRango1(rango1);
            especific.setRango2(rango2);
            especific.setRango3(rango3);
            especific.setRango4(rango4);
            especific.setRango5(rango5);
            especific.setRango6(rango6);
            especific.setRango7(rango7);
            especific.setRango8(rango8);

            if (DaoEspecificacionesSeco.grabarEsp(especific)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            listarEspecificaciones(request, response);
            /* List<EspecificacionesSeco> lt = DaoEspecificacionesSeco.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspSeco.jsp").forward(request, response);*/

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
            List<EspecificacionesSeco> lt = DaoEspecificacionesSeco.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListarEspSeco.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
           request.getRequestDispatcher("Vistas/ListarEspSeco.jsp").forward(request, response);
        }
    }

    //Metodo Listar PAra Eidtar
    private void editarEspecific(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener el ID del parámetro de solicitud y almacenarlo en la variable de instancia
            ide = Integer.parseInt(request.getParameter("id"));
            EspecificacionesSeco E = DaoEspecificacionesSeco.obtenerEspecificPorId(ide);
            request.setAttribute("idEditar", E);

            /* List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);*/
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
            /* // Utilizar la variable de instancia para obtener el ID
            EspecificacionesSeco E = DaoEspecificacionesSeco.obtenerEspecificPorId(ide);
            request.setAttribute("idEditar", E);*/

            // Recuperar parámetros del formulario
            int idEspecificaciones = Integer.parseInt(request.getParameter("idEspecificaciones")); // No serequiere
            int productos = Integer.parseInt(request.getParameter("idProductos"));
            int cliente = Integer.parseInt(request.getParameter("idclientes"));
            String variableesp1 = request.getParameter("variableEsp1");
            String variableesp2 = request.getParameter("variableEsp2");
            String variableesp3 = request.getParameter("variableEsp3");
            String variableesp4 = request.getParameter("variableEsp4");
            String variableesp5 = request.getParameter("variableEsp5");
            String variableesp6 = request.getParameter("variableEsp6");
            String variableesp7 = request.getParameter("variableEsp7");
            String variableesp8 = request.getParameter("variableEsp8");
            String rango1 = request.getParameter("rango1");
            String rango2 = request.getParameter("rango2");
            String rango3 = request.getParameter("rango3");
            String rango4 = request.getParameter("rango4");
            String rango5 = request.getParameter("rango5");
            String rango6 = request.getParameter("rango6");
            String rango7 = request.getParameter("rango7");
            String rango8 = request.getParameter("rango8");

            EspecificacionesSeco especific = new EspecificacionesSeco();

            especific.setIdProductos(productos);
            especific.setIdclientes(cliente);
            especific.setVariableEsp1(variableesp1);
            especific.setVariableEsp2(variableesp2);
            especific.setVariableEsp3(variableesp3);
            especific.setVariableEsp4(variableesp4);
            especific.setVariableEsp5(variableesp5);
            especific.setVariableEsp6(variableesp6);
            especific.setVariableEsp7(variableesp7);
            especific.setVariableEsp8(variableesp8);

            especific.setRango1(rango1);
            especific.setRango2(rango2);
            especific.setRango3(rango3);
            especific.setRango4(rango4);
            especific.setRango5(rango5);
            especific.setRango6(rango6);
            especific.setRango7(rango7);
            especific.setRango8(rango8);

            especific.setIdespecificaciones(idEspecificaciones);

            boolean actualizacionExitosa = DaoEspecificacionesSeco.editar(especific);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }
            listarEspecificaciones(request, response);

            /* List<Especificaciones> lt = DaoEspecificaciones.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListaEspecificaciones.jsp").forward(request, response);*/
        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarEspecificaciones(request, response);
        }
    }

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

                new Generarpdf().genPdf(producto_Seco, Esp, consecutivo);
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
            boolean reporteEnUso = DaoEspecificacionesSeco.usuarioEnUso(idespecific);

            if (reporteEnUso) {
                request.setAttribute("mensaje", "El reporte está siendo usado y no puede ser eliminado");
            } else {
                if (DaoEspecificacionesSeco.eliminar(idespecific)) {
                    request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
                } else {
                    request.setAttribute("mensaje", "No se pudo eliminar el Reporte");
                }
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
