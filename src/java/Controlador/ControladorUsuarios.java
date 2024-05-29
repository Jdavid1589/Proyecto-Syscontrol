package Controlador;

import Modelo.Usuarios;
import Persistencia.DaoUsuarios;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorUsuarios extends HttpServlet {

    Usuarios user = new Usuarios();
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
        processRequest(request, response);

        String action = request.getParameter("accion");

        switch (action) {
            case "add":
                request.getRequestDispatcher("Vistas/RegistrarUsuarios.jsp").forward(request, response);
                break;

            case "registrar":
                registrarUsuario(request, response);
                break;

            case "listar":
                listarUsuarios(request, response);
                break;

            case "editarUsu":
                editarUsuarios(request, response);
                break;

            case "actualizar":
                actualizarUsuario(request, response);
                break;

            case "buscar":
                buscarUsuario(request, response);
                break;

            /* case "eliminar":
                eliminarUsuario(request, response);
                break;*/
            case "eliminar2":
                eliminarUsuarios2(request, response);
                break;
            case "canDelete":
                ValidarCanDelete(request, response);
                break;

            default:
                // Handle any other actions or provide a default behavior
                break;
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombres_apellido = request.getParameter("nombres_apellido");
            String numeroTelefono = request.getParameter("numeroTelefono");
            String correo = request.getParameter("correo");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            int perfilIdperfil = Integer.parseInt(request.getParameter("perfil_idperfil")); // Aquí obtenemos el valor del atributo "data-id"

            Usuarios usuarios = new Usuarios();

            usuarios.setNombres_apellido(nombres_apellido);
            usuarios.setNumero_Telefono(numeroTelefono);
            usuarios.setCorreo(correo);
            usuarios.setUsuario(usuario);
            usuarios.setClave(clave);
            usuarios.setPerfil_idperfil(perfilIdperfil); // Aquí establecemos el valor del ID del perfil obtenido

            if (DaoUsuarios.grabar(usuarios)) {
                request.setAttribute("mensaje", "el usuario fue registrado");
            } else {
                request.setAttribute("mensaje", "el usuario no fue registrado, validar campos ingresados");
            }

            List<Usuarios> lt = DaoUsuarios.listar();
            request.setAttribute("listaUsuarios", lt);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al registrar el Consecutivo");
            listarUsuarios(request, response);
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Usuarios> lt = DaoUsuarios.listar();
            request.setAttribute("listaUsuarios", lt);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
        }
    }

    private void editarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener el ID del parámetro de solicitud y almacenarlo en la variable de instancia
            ide = Integer.parseInt(request.getParameter("id"));
            Usuarios u = DaoUsuarios.obtenerUsuarioPorId(ide);
            request.setAttribute("User", u);

            List<Usuarios> lt = DaoUsuarios.listar();
            request.setAttribute("listaUsuarios", lt);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al editar el Consecutivo");
            listarUsuarios(request, response);
        }
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Utilizar la variable de instancia para obtener el ID
            Usuarios u = DaoUsuarios.obtenerUsuarioPorId(ide);
            request.setAttribute("User", u);

            // Resto del código para actualizar el User
            String nombres_apellido = request.getParameter("nombres_apellido");
            String numeroTelefono = request.getParameter("numeroTelefono");
            String correo = request.getParameter("correo");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            int Perfilidperfil = Integer.parseInt(request.getParameter("perfil_idperfil"));
            //int txtid = Integer.parseInt(request.getParameter("txtid")); // Aca no se requiere esto

            Usuarios usuarios = new Usuarios();

            usuarios.setNombres_apellido(nombres_apellido);
            usuarios.setNumero_Telefono(numeroTelefono);
            usuarios.setCorreo(correo);
            usuarios.setUsuario(usuario);
            usuarios.setClave(clave);
            usuarios.setPerfil_idperfil(Perfilidperfil);
            usuarios.setIdUsuarios(ide); // El id se le pasa directamentecon la variable que ya capturo el id

            boolean actualizacionExitosa = DaoUsuarios.editar(usuarios);

            if (actualizacionExitosa) {
                request.setAttribute("mensaje", "Consecutivo actualizado correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo actualizar el Consecutivo");
            }

            List<Usuarios> lt = DaoUsuarios.listar();
            request.setAttribute("listaUsuarios", lt);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("mensaje", "Error al actualizar el Consecutivo: " + ex.getMessage());
            listarUsuarios(request, response);
        }
    }

    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String texto = request.getParameter("txtbuscar");
            List<Usuarios> lt = DaoUsuarios.Buscar(texto);
            request.setAttribute("listaUsuarios", lt);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al buscar los Consecutivos");
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
        }
    }

    /*private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idUsuarios = Integer.parseInt(request.getParameter("id"));

            if (DaoUsuarios.eliminar(idUsuarios)) {
                request.setAttribute("mensaje", "El Usuario fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el usuario");
            }

            List<Usuarios> lt = DaoUsuarios.listar();
            request.setAttribute("listaUsuarios", lt);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Consecutivo");
            listarUsuarios(request, response);
        }
    }*/
    private void eliminarUsuarios2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int iduser = Integer.parseInt(request.getParameter("id"));

            if (DaoUsuarios.canDelete(iduser)) {
                if (DaoUsuarios.eliminar(iduser)) {
                    request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
                } else {
                    request.setAttribute("mensaje", "No se pudo eliminar el Reporte");
                }
            } else {
                request.setAttribute("mensaje", "El Reporte no se puede eliminar porque está en uso");
            }

            listarUsuarios(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Consecutivo");
            listarUsuarios(request, response);
        }
    }

    private void ValidarCanDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del registro a verificar desde la petición HTTP
        int iduser = Integer.parseInt(request.getParameter("id"));

        // Llamar al método canDelete del DAO para verificar si se puede eliminar el registro
        boolean canDelete = DaoUsuarios.canDelete(iduser);

        // Establecer el tipo de contenido de respuesta en JSON
        response.setContentType("application/json");

        // Obtener el objeto PrintWriter para enviar la respuesta como un objeto JSON
        PrintWriter out = response.getWriter();

        // Escribir el valor booleano canDelete como un objeto JSON
        out.print(canDelete);

        // Asegurarse de que la respuesta se envíe al cliente
        out.flush();
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
