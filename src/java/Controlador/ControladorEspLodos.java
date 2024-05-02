package Controlador;

import Modelo.Consecutivo;

import Modelo.Especificaciones;
import Modelo.EspecificacionesLodos;
import Modelo.EspecificacionesSeco;

import Persistencia.DaoEspecificaciones;
import Persistencia.DaoEspecificacionesLodos;
import Persistencia.DaoEspecificacionesSeco;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import util.Generarpdf;

public class ControladorEspLodos extends HttpServlet {

    EspecificacionesLodos Esp = new EspecificacionesLodos();
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
                request.getRequestDispatcher("Vistas/RegistroEspLodos.jsp").forward(request, response);
                break;

            case "registrar":
                registrarEspecificaciones(request, response);
                break;

            case "listar":
                listarEspecificaciones(request, response);
                break;

            case "editarEspecif":
                request.setAttribute("idEditar", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/EditarEspLodos.jsp").forward(request, response);
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
            String variableesp9 = request.getParameter("variableEsp9");
            String variableesp10 = request.getParameter("variableEsp10");
            String variableesp11 = request.getParameter("variableEsp11");
            String rango1 = request.getParameter("rango1");
            String rango2 = request.getParameter("rango2");
            String rango3 = request.getParameter("rango3");
            String rango4 = request.getParameter("rango4");
            String rango5 = request.getParameter("rango5");
            String rango6 = request.getParameter("rango6");
            String rango7 = request.getParameter("rango7");
            String rango8 = request.getParameter("rango8");
            String rango9 = request.getParameter("rango9");
            String rango10 = request.getParameter("rango10");
            String rango11 = request.getParameter("rango11");

            String metodo1 = request.getParameter("metodo1");
            String metodo2 = request.getParameter("metodo2");
            String metodo3 = request.getParameter("metodo3");
            String metodo4 = request.getParameter("metodo4");
            String metodo5 = request.getParameter("metodo5");
            String metodo6 = request.getParameter("metodo6");
            String metodo7 = request.getParameter("metodo7");
            String metodo8 = request.getParameter("metodo8");
            String metodo9 = request.getParameter("metodo9");
            String metodo10 = request.getParameter("metodo10");
            String metodo11 = request.getParameter("metodo11");

            EspecificacionesLodos especific = new EspecificacionesLodos();

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
            especific.setVariableEsp9(variableesp9);
            especific.setVariableEsp10(variableesp10);
            especific.setVariableEsp11(variableesp11);

            especific.setRango1(rango1);
            especific.setRango2(rango2);
            especific.setRango3(rango3);
            especific.setRango4(rango4);
            especific.setRango5(rango5);
            especific.setRango6(rango6);
            especific.setRango7(rango7);
            especific.setRango8(rango8);
            especific.setRango9(rango9);
            especific.setRango10(rango10);
            especific.setRango11(rango11);

            especific.setMetodo1(metodo1);
            especific.setMetodo2(metodo2);
            especific.setMetodo3(metodo3);
            especific.setMetodo4(metodo4);
            especific.setMetodo5(metodo5);
            especific.setMetodo6(metodo6);
            especific.setMetodo7(metodo7);
            especific.setMetodo8(metodo8);
            especific.setMetodo9(metodo9);
            especific.setMetodo10(metodo10);
            especific.setMetodo11(metodo11);

            if (DaoEspecificacionesLodos.grabarEsp(especific)) {
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
            List<EspecificacionesLodos> lt = DaoEspecificacionesLodos.listar();
            request.setAttribute("listaEspcif", lt);
            request.getRequestDispatcher("Vistas/ListarEspLodos.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
            request.getRequestDispatcher("Vistas/ListarEspLodos.jsp").forward(request, response);
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
       
            EspecificacionesLodos especific = new EspecificacionesLodos();

            especific.setIdProductos(Integer.parseInt(request.getParameter("idProductos")));
            especific.setIdclientes(Integer.parseInt(request.getParameter("idclientes")));
            especific.setVariableEsp1(request.getParameter("variableEsp1"));
            especific.setVariableEsp2(request.getParameter("variableEsp2"));
            especific.setVariableEsp3(request.getParameter("variableEsp3"));
            especific.setVariableEsp4(request.getParameter("variableEsp4"));
            especific.setVariableEsp5(request.getParameter("variableEsp5"));
            especific.setVariableEsp6(request.getParameter("variableEsp6"));
            especific.setVariableEsp7(request.getParameter("variableEsp7"));
            especific.setVariableEsp8(request.getParameter("variableEsp8"));
            especific.setVariableEsp9(request.getParameter("variableEsp9"));
            especific.setVariableEsp10(request.getParameter("variableEsp10"));
            especific.setVariableEsp11(request.getParameter("variableEsp11"));

            especific.setRango1(request.getParameter("rango1"));
            especific.setRango2(request.getParameter("rango2"));
            especific.setRango3(request.getParameter("rango3"));
            especific.setRango4(request.getParameter("rango4"));
            especific.setRango5(request.getParameter("rango5"));
            especific.setRango6(request.getParameter("rango6"));
            especific.setRango7(request.getParameter("rango7"));
            especific.setRango8(request.getParameter("rango8"));
            especific.setRango9(request.getParameter("rango9"));
            especific.setRango10(request.getParameter("rango10"));
            especific.setRango11(request.getParameter("rango11"));

            especific.setMetodo1(request.getParameter("metodo1"));
            especific.setMetodo2(request.getParameter("metodo2"));
            especific.setMetodo3(request.getParameter("metodo3"));
            especific.setMetodo4(request.getParameter("metodo4"));
            especific.setMetodo5(request.getParameter("metodo5"));
            especific.setMetodo6(request.getParameter("metodo6"));
            especific.setMetodo7(request.getParameter("metodo7"));
            especific.setMetodo8(request.getParameter("metodo8"));
            especific.setMetodo9(request.getParameter("metodo9"));
            especific.setMetodo10(request.getParameter("metodo10"));
            especific.setMetodo11(request.getParameter("metodo11"));

            especific.setIdespecificaciones( Integer.parseInt(request.getParameter("idEspecificaciones")));

            boolean actualizacionExitosa = DaoEspecificacionesLodos.editar(especific);

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
