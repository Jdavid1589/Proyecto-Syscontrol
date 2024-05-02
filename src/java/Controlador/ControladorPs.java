package Controlador;


import Modelo.ControlSeco;

import Persistencia.DaoProductoSeco;
import java.io.IOException;


import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorPs extends HttpServlet {

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
                request.getRequestDispatcher("Vistas/RegistroProductoSeco.jsp").forward(request, response);
                break;

            case "registrar2":
                //   registrarPS(request, response);
                break;
            case "registrar3":
                registrarPS2(request, response);
                break;

            case "listar":
                listarPS(request, response);
                break;

            case "editar_ps":
                request.setAttribute("idEditar_ps", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/Editar_prod_seco.jsp").forward(request, response);
                break;
            case "editar_ps2":
                request.setAttribute("idEditar_ps", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/EditarPS2.jsp").forward(request, response);
                break;

            case "registrarEdicion":
                actualizarPS(request, response);
                break;
            case "registrarEdicion2":
                actualizarPS2(request, response);
                break;

            case "pdf":
                request.setAttribute("idpdf", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/CertificadoSeco.jsp").forward(request, response);
                break;

            case "buscar":
                buscarReporte(request, response);
                break;

            case "eliminar2":
                eliminarPS(request, response);
                break;

            default:

                break;
        }
    }

    private void registrarPS2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ControlSeco controlseco = new ControlSeco();

            // Establecer los valores de los campos fijos
            controlseco.setFecha(request.getParameter("fecha"));
            controlseco.setCant_noconf(Double.valueOf(request.getParameter("cant_noconf")));
            controlseco.setCausas(request.getParameter("causas"));
            controlseco.setLote(request.getParameter("lote"));
            controlseco.setRetenido325(Double.parseDouble(request.getParameter("retenido325")));
            controlseco.setPH(Double.parseDouble(request.getParameter("pH")));
            controlseco.setpH_2(Double.valueOf(request.getParameter("pH_2")));
            controlseco.setpH_3(Double.valueOf(request.getParameter("pH_3")));
            controlseco.setpH_promedio(Double.valueOf(request.getParameter("pH_promedio")));
            controlseco.setHumedad_promedio(Double.valueOf(request.getParameter("sol_promedio")));
            controlseco.setAbs_Aceite(Double.parseDouble(request.getParameter("abs_Aceite")));
            controlseco.setBrigh(Double.parseDouble(request.getParameter("Brigh")));
            controlseco.setWhitness(Double.parseDouble(request.getParameter("Whitness")));
            controlseco.setDv50(Double.parseDouble(request.getParameter("Dv50")));
            controlseco.setDv90(Double.parseDouble(request.getParameter("Dv90")));
            controlseco.setComentarios(request.getParameter("comentarios"));
            controlseco.setObservacion(request.getParameter("observacion"));
            controlseco.setIdProductos(Integer.parseInt(request.getParameter("idProductos")));
            controlseco.setIdUsuarios(Integer.parseInt(request.getParameter("idUsuarios")));
            controlseco.setIdConsecutivo(Integer.parseInt(request.getParameter("idConsecutivo")));

            // Recoger los valores de los campos de humedad dinámicamente
            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
                String paramName = entry.getKey();
                String[] paramValues = entry.getValue();
                for (String paramValue : paramValues) {
                    System.out.println("Nombre del parámetro: " + paramName + ", Valor: " + paramValue);
                }
                if (paramName.startsWith("humedad_")) {
                    // Extraer el índice de la humedad del nombre del parámetro
                    int index = Integer.parseInt(paramName.substring("humedad_".length()));
                    // Asignar el valor de la humedad al objeto ControlSeco
                    double humedad = Double.parseDouble(paramValues[0]);
                    controlseco.setHumedad(index, humedad);
                }/* else if (paramName.equals("humedad_promedio")) {
                    // Procesar el campo de humedad promedio
                    double humedadPromedio = Double.parseDouble(paramValues[0]);
                    controlseco.setHumedad_promedio(humedadPromedio);
                }*/
            }

            // Grabar en la base de datos
            if (DaoProductoSeco.grabar4(controlseco)) {
                request.setAttribute("mensaje", "Registro Exitoso");
            } else {
                request.setAttribute("mensaje", "Error, el reporte no fue registrado");
            }
            listarPS(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar la Especificacion");
            listarPS(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar la Especificacion");
            listarPS(request, response);
        }
    }


    private void listarPS(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<ControlSeco> lt = DaoProductoSeco.listar();
            request.setAttribute("listaProducSeco", lt);
            request.getRequestDispatcher("Vistas/Listarproductoseco.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
            request.getRequestDispatcher("Vistas/Listarproductoseco.jsp").forward(request, response);
        }
    }

    private void actualizarPS(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ControlSeco controlseco = new ControlSeco();

            // Establecer los valores de los campos fijos
            controlseco.setFecha(request.getParameter("fecha"));
            controlseco.setCant_noconf(Double.valueOf(request.getParameter("cant_noconf")));
            controlseco.setCausas(request.getParameter("causas"));
            controlseco.setLote(request.getParameter("lote"));
            controlseco.setRetenido325(Double.parseDouble(request.getParameter("retenido325")));
            controlseco.setPH(Double.parseDouble(request.getParameter("pH")));
            controlseco.setpH_2(Double.valueOf(request.getParameter("pH_2")));
            controlseco.setpH_3(Double.valueOf(request.getParameter("pH_3")));
            controlseco.setpH_promedio(Double.valueOf(request.getParameter("pH_promedio")));
            controlseco.setHumedad_promedio(Double.valueOf(request.getParameter("sol_promedio")));
            controlseco.setAbs_Aceite(Double.parseDouble(request.getParameter("abs_Aceite")));
            controlseco.setBrigh(Double.parseDouble(request.getParameter("Brigh")));
            controlseco.setWhitness(Double.parseDouble(request.getParameter("Whitness")));
            controlseco.setDv50(Double.parseDouble(request.getParameter("Dv50")));
            controlseco.setDv90(Double.parseDouble(request.getParameter("Dv90")));
            controlseco.setComentarios(request.getParameter("comentarios"));
            controlseco.setObservacion(request.getParameter("observacion"));
            controlseco.setIdProductos(Integer.parseInt(request.getParameter("idProductos")));
            controlseco.setIdUsuarios(Integer.parseInt(request.getParameter("idUsuarios")));
            controlseco.setIdConsecutivo(Integer.parseInt(request.getParameter("idConsecutivo")));
            controlseco.setIdControlCalidad(Integer.parseInt(request.getParameter("txtid_ps")));

            // Recoger los valores de los campos de humedad dinámicamente
            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
                String paramName = entry.getKey();
                String[] paramValues = entry.getValue();
                for (String paramValue : paramValues) {
                    System.out.println("Nombre del parámetro: " + paramName + ", Valor: " + paramValue);
                }
                if (paramName.startsWith("humedad_")) {
                    // Extraer el índice de la humedad del nombre del parámetro
                    int index = Integer.parseInt(paramName.substring("humedad_".length()));
                    // Asignar el valor de la humedad al objeto ControlSeco
                    double humedad = Double.parseDouble(paramValues[0]);
                    controlseco.setHumedad(index, humedad);
                }
         
              
            }

          
            boolean actualizacionExitosa = DaoProductoSeco.editar2(controlseco);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }
            //  listarEspecificaciones(request, response);
            List<ControlSeco> lt = DaoProductoSeco.listar();
            request.setAttribute("listaProducSeco", lt);
            request.getRequestDispatcher("Vistas/Listarproductoseco.jsp").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarPS(request, response);
        }
    }
    
    private void actualizarPS2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ControlSeco controlseco = new ControlSeco();

            // Establecer los valores de los campos fijos
            controlseco.setFecha(request.getParameter("fecha"));
            controlseco.setCant_noconf(Double.valueOf(request.getParameter("cant_noconf")));
            controlseco.setCausas(request.getParameter("causas"));
            controlseco.setLote(request.getParameter("lote"));
            controlseco.setRetenido325(Double.parseDouble(request.getParameter("retenido325")));
            controlseco.setPH(Double.parseDouble(request.getParameter("pH")));
            controlseco.setpH_2(Double.valueOf(request.getParameter("pH_2")));
            controlseco.setpH_3(Double.valueOf(request.getParameter("pH_3")));
            controlseco.setpH_promedio(Double.valueOf(request.getParameter("pH_promedio")));
            controlseco.setHumedad_promedio(Double.valueOf(request.getParameter("sol_promedio")));
            controlseco.setAbs_Aceite(Double.parseDouble(request.getParameter("abs_Aceite")));
            controlseco.setBrigh(Double.parseDouble(request.getParameter("Brigh")));
            controlseco.setWhitness(Double.parseDouble(request.getParameter("Whitness")));
            controlseco.setDv50(Double.parseDouble(request.getParameter("Dv50")));
            controlseco.setDv90(Double.parseDouble(request.getParameter("Dv90")));
            controlseco.setComentarios(request.getParameter("comentarios"));
            controlseco.setObservacion(request.getParameter("observacion"));
            controlseco.setIdProductos(Integer.parseInt(request.getParameter("idProductos")));
            controlseco.setIdUsuarios(Integer.parseInt(request.getParameter("idUsuarios")));
            controlseco.setIdConsecutivo(Integer.parseInt(request.getParameter("idConsecutivo")));
            controlseco.setIdControlCalidad(Integer.parseInt(request.getParameter("txtid_ps")));

            // Recoger los valores de los campos de humedad dinámicamente
            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
                String paramName = entry.getKey();
                String[] paramValues = entry.getValue();
                for (String paramValue : paramValues) {
                    System.out.println("Nombre del parámetro: " + paramName + ", Valor: " + paramValue);
                }
                if (paramName.startsWith("humedad_")) {
                    // Extraer el índice de la humedad del nombre del parámetro
                    int index = Integer.parseInt(paramName.substring("humedad_".length()));
                    // Asignar el valor de la humedad al objeto ControlSeco
                    double humedad = Double.parseDouble(paramValues[0]);
                    controlseco.setHumedad(index, humedad);
                }
         
              
            }

          
            boolean actualizacionExitosa = DaoProductoSeco.editar2(controlseco);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }
            //  listarEspecificaciones(request, response);
            List<ControlSeco> lt = DaoProductoSeco.listar();
            request.setAttribute("listaProducSeco", lt);
            request.getRequestDispatcher("Vistas/Listarproductoseco.jsp").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarPS(request, response);
        }
    }

    private void buscarReporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String texto = request.getParameter("txtbuscar");
            List<ControlSeco> lt = DaoProductoSeco.Buscar3(texto);
            request.setAttribute("listaProducSeco", lt);
            request.getRequestDispatcher("Vistas/Listarproductoseco.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al buscar los Consecutivos");
            request.getRequestDispatcher("Vistas/Listarproductoseco.jsp").forward(request, response);
        }
    }

    private void eliminarPS(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idControlCalidad = Integer.parseInt(request.getParameter("id"));

            if (DaoProductoSeco.eliminar(idControlCalidad)) {
                request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }

            listarPS(request, response);

            // listarPS(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarPS(request, response);
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
