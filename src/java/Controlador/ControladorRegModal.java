package Controlador;

import Modelo.Seguimientos;
import Modelo.Documento;
import Modelo.Perfil;
import Modelo.Productos;
import Modelo.TipoProducto;

import Persistencia.DaoSeguimientos;
import Persistencia.DaoDocumento;
import Persistencia.DaoPerfil;
import Persistencia.DaoProductos;
import Persistencia.DaoTipoProducto;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorRegModal extends HttpServlet {

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
                request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);
                break;

            case "registrarVariables":
                registrarSeguimiento(request, response);
                break;
            case "registrarProducto":
                registrarreferencia(request, response);
                break;

            case "registrarDocumento":
                registrarTipoDoc(request, response);
                break;

            case "registrarPerfil":
                registrarTipoPerfil(request, response);
                break;

            case "registrarTipoProducto":
                grabartipoproducto(request, response);
                break;

            case "listar":
                listarMetodos(request, response);
                break;

            case "eliminar":
                eliminarperfil(request, response);
                break;

            case "eliminar2":
                eliminarproducto(request, response);
                break;

            case "eliminar3":
                eliminarVariable(request, response);
                break;

            case "eliminar4":
                eliminarTipoDoc(request, response);
                break;

            case "eliminar5":
                eliminarTipoProducto(request, response);
                break;

            case "editarPerfil":
                request.setAttribute("idEditar_perfil", request.getParameter("id"));
                request.getRequestDispatcher("./Vistas/Editar_RegistrosModal.jsp").forward(request, response);
                break;
                
             case "registrarEdicion_perf":
                actualizarPerfil(request, response);
                break;

            /*   

            case "editarpdf_Esp":
                editarpdf(request, response);
                break;

            case "Modificar":
                actualizarEspecifi(request, response);
                break;
            case "genpdf":
                crearpdf(request, response);
                break;

             */
            default:
                // Handle any other actions or provide a default behavior
                break;
        }
    }

    // 1. Metodos Registrar
    private void registrarSeguimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //3. Stos Analisis                
            String variablesCalidad = request.getParameter("Variables_calidad");

            Seguimientos seguimientos = new Seguimientos();

            seguimientos.setNumSeguimiento(variablesCalidad);

            if (DaoSeguimientos.grabar(seguimientos)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            listarMetodos(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar  la Especificacion");
            listarMetodos(request, response);
        }
    }

    private void registrarTipoDoc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //1. Docuemnto
            String tipoDocumento = request.getParameter("documento");

            Documento documento = new Documento();

            documento.setTipo_documento(tipoDocumento);

            if (DaoDocumento.registrar(documento)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            listarMetodos(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar  la Especificacion");
            listarMetodos(request, response);
        }
    }

    private void registrarTipoPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //2. Perfil
            String nombrePerfil = request.getParameter("perfil");

            Perfil perfil = new Perfil();

            perfil.setTipo_Perfil(nombrePerfil);

            if (DaoPerfil.registrar(perfil)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            listarMetodos(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar  la Especificacion");
            listarMetodos(request, response);
        }
    }

    private void grabartipoproducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //5. Tipo Producto
            String tipoproductos = request.getParameter("tipo");

            TipoProducto tipop = new TipoProducto();

            tipop.setTipo(tipoproductos);

            if (DaoTipoProducto.registrar(tipop)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            listarMetodos(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar  la Especificacion");
            listarMetodos(request, response);
        }
    }

    private void registrarreferencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //4. Productos
            String productos = request.getParameter("nombres_Productos");
            int TProd = Integer.parseInt(request.getParameter("tipoProducto_idtipoProducto"));

            Productos producto = new Productos();

            producto.setNombres_Productos(productos);

            producto.setTipoProducto_idtipoProducto(TProd);

            if (DaoProductos.registrar(producto)) {
                request.setAttribute("mensaje", "Registro Fue Exitoso");
            } else {
                request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
            }
            listarMetodos(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar  la Especificacion");
            listarMetodos(request, response);
        }
    }

    //2.  Metodos Listar 
    private void listarMetodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Seguimientos> listaVariables = DaoSeguimientos.listar();
            List<Perfil> listaPerfiles = DaoPerfil.listar();
            List<Documento> listaDocumentos = DaoDocumento.listar();
            List<Productos> listaProductos = DaoProductos.listar();
            List<TipoProducto> listaTipoP = DaoTipoProducto.listar();

            request.setAttribute("listaVariables", listaVariables);
            request.setAttribute("listaPerfil", listaPerfiles);
            request.setAttribute("listaDocumento", listaDocumentos);
            request.setAttribute("listaProductos", listaProductos);
            request.setAttribute("listaTipoProducto", listaTipoP);
            request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar");
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);
            request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);
        }
    }
    
    
    private void actualizarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

          String tipo_Perfil = request.getParameter("tipo_Perfil");
            int txtid = Integer.parseInt(request.getParameter("txtid"));

            Perfil perfil = new Perfil();

            perfil.setTipo_Perfil(tipo_Perfil);
            perfil.setIdperfil(txtid);
            

            boolean actualizacionExitosa = DaoPerfil.editar(perfil);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Perfil actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Perfil");
            }
            //  listarEspecificaciones(request, response);
            listarMetodos(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el reporte: " + ex.getMessage());
            listarMetodos(request, response);
        }
    }

    //3.  Metodos Eliminar 
    private void eliminarperfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idperfil = Integer.parseInt(request.getParameter("id"));
            if (DaoPerfil.eliminar(idperfil)) {
                request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el Reporte Control ");
            }

            listarMetodos(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarMetodos(request, response);
        }
    }

    private void eliminarTipoDoc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idDocumento = Integer.parseInt(request.getParameter("id"));
            if (DaoDocumento.eliminar(idDocumento)) {
                request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }

            listarMetodos(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarMetodos(request, response);
        }
    }

    private void eliminarproducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idproductos = Integer.parseInt(request.getParameter("id"));
            if (DaoProductos.eliminar(idproductos)) {
                request.setAttribute("Mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }

            listarMetodos(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarMetodos(request, response);
        }
    }

    private void eliminarVariable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idvariablescalidad = Integer.parseInt(request.getParameter("id"));
            if (DaoSeguimientos.eliminar(idvariablescalidad)) {
                request.setAttribute("Mensaje", "Referencia fue Eliminada Correctamente");
            } else {
                request.setAttribute("Mensaje", "No se pudo eliminar el Reporte Control ");
            }

            listarMetodos(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarMetodos(request, response);
        }
    }

    private void eliminarTipoProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idtipoproducto = Integer.parseInt(request.getParameter("id"));
            if (DaoTipoProducto.eliminar(idtipoproducto)) {
                request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el Reporte Control ");
            }

            listarMetodos(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarMetodos(request, response);
        }
    }

    /*} else if ("editar".equals(action)) {
            request.setAttribute("idEditar", request.getParameter("id"));
            //request.getRequestDispatcher("Vistas/EditarUsuarios.jsp").forward(request, response);

            // else if (action.equalsIgnoreCase("editarDocumento"))                  
        } else if ("editarDocumento".equals(action)) {

            String tipodoc = request.getParameter("tipodocumento");
            int txtid = Integer.parseInt(request.getParameter("txtid"));

            Documento documento = new Documento();

            documento.setTipo_documento(tipodoc);
            documento.setIdDocumento(txtid);

            DaoDocumento.editar(documento);

            List<Documento> listaDocumentos = DaoDocumento.listar();
            request.setAttribute("listaDocumento", listaDocumentos);

            request.getRequestDispatcher("Vistas/RegistrosModal.jsp").forward(request, response);

         
        }
        // 
     
       

      

       

       

        
        } else if (action.equalsIgnoreCase("eliminar5")) {
            
            // Redirige a la página correcta
            List<TipoProducto> ltTipoProducto = DaoTipoProducto.listar();
            request.setAttribute("listaTipoProducto", ltTipoProducto);
            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);

            //Metodo para Editar
        } else if (action.equalsIgnoreCase("Editar_perfil")) {
            request.setAttribute("idEditar_perfil", request.getParameter("id"));
            request.getRequestDispatcher("./Vistas/Editar_RegistrosModal.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("registrarEdicion_perf")) {

            String tipo_Perfil = request.getParameter("tipo_Perfil");
            int txtid = Integer.parseInt(request.getParameter("txtid"));

            Perfil perfil = new Perfil();

            perfil.setTipo_Perfil(tipo_Perfil);
            perfil.setIdperfil(txtid);

            DaoPerfil.editar(perfil);

            List<Documento> listaDocumentos = DaoDocumento.listar();
            List<Perfil> listaPerfiles = DaoPerfil.listar();
            List<Seguimientos> listaVariables = DaoSeguimientos.listar();
            List<Productos> listaProductos = DaoProductos.listar();

            request.setAttribute("listaDocumento", listaDocumentos);
            request.setAttribute("listaPerfil", listaPerfiles);
            request.setAttribute("listaVariables", listaVariables);
            request.setAttribute("listaProductos", listaProductos);

            request.getRequestDispatcher("ControladorRegModal?accion=listar").forward(request, response);*/
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
