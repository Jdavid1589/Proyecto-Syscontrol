package Controlador;

import Modelo.Clientes;
import Persistencia.DaoClientes;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorClientes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            List<Clientes> lt = DaoClientes.listar();
            request.setAttribute("listaClientes", lt);
            request.getRequestDispatcher("Vistas/Listar_Clientes.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("Vistas/Registro_Clientes.jsp").forward(request, response);

            // <editor-fold defaultstate="collapsed" desc="1. Accion Registrar">
        } else if (action.equalsIgnoreCase("registrar")) {

          /*  String razon_Social = request.getParameter("razonSocial");
            String nombres_apellido = request.getParameter("nombres");
            int documento_idDocumento = Integer.parseInt(request.getParameter("idDocumento"));
            String numero_Documento = request.getParameter("numDocumento");
            String direccion = request.getParameter("direccion");
            String numeroTelefono = request.getParameter("numTelefono");
            String correo = request.getParameter("correo");*/

            Clientes clientes = new Clientes();

            clientes.setRazon_Social( request.getParameter("razonSocial"));
            clientes.setNombres_apellidos( request.getParameter("nombres"));
            clientes.setIdDocumento(Integer.parseInt(request.getParameter("idDocumento")));
            clientes.setNumero_Documento( request.getParameter("numDocumento"));
            clientes.setDireccion( request.getParameter("direccion"));
            clientes.setNumero_Telefono( request.getParameter("numTelefono"));
            clientes.setCorreo(request.getParameter("correo"));

            if (DaoClientes.grabar(clientes)) {
                request.setAttribute("mensaje", "el usuario fue registrado");
            } else {
                request.setAttribute("mensaje", "el usuario no fue registrado, validar campos ingresados");

            }
            List<Clientes> lt = DaoClientes.listar();
            request.setAttribute("listaClientes", lt);
            request.getRequestDispatcher("Vistas/Listar_Clientes.jsp").forward(request, response);
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc="2. Accion buscar">
            
        } else if (action.equalsIgnoreCase("buscar")) {
            String texto = request.getParameter("txtbuscar");
            List<Clientes> lt = DaoClientes.buscarClientes(texto);
            request.setAttribute("listaClientes", lt);
            request.getRequestDispatcher("Vistas/Listar_Clientes.jsp").forward(request, response);
            
        } // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="3. Accion Editar">
        
        else if (action.equalsIgnoreCase("editarclientes")) {
            request.setAttribute("idEditar", request.getParameter("id"));
            request.getRequestDispatcher("Vistas/Editar_Clientes.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("EditCliente")) {

           /* String razon_Social = request.getParameter("razon_Social");
            String nombres_apellido = request.getParameter("nombres_apellidos");
            int documento_idDocumento = Integer.parseInt(request.getParameter("idDocumento"));
            String numero_Documento = request.getParameter("numero_Documento");
            String direccion = request.getParameter("direccion");
            String numeroTelefono = request.getParameter("numero_Telefono");
            String correo = request.getParameter("correo");
            int txtid = Integer.parseInt(request.getParameter("txtid"));*/

            Clientes clientes = new Clientes();

            clientes.setRazon_Social( request.getParameter("razonSocial"));
            clientes.setNombres_apellidos( request.getParameter("nombres"));
            clientes.setIdDocumento(Integer.parseInt(request.getParameter("idDocumento")));
            clientes.setNumero_Documento( request.getParameter("numDocumento"));
            clientes.setDireccion( request.getParameter("direccion"));
            clientes.setNumero_Telefono( request.getParameter("numTelefono"));
            clientes.setCorreo(request.getParameter("correo"));
            clientes.setIdclientes( Integer.parseInt(request.getParameter("txtid")));

            DaoClientes.editar(clientes);

            List<Clientes> lt = DaoClientes.listar();
            request.setAttribute("listaClientes", lt);
            request.getRequestDispatcher("Vistas/Listar_Clientes.jsp").forward(request, response);

            // </editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="4. Accion Eliminar">
        } else if (action.equalsIgnoreCase("eliminar")) {
            int idclientes = Integer.parseInt(request.getParameter("id"));

            if (DaoClientes.eliminar(idclientes)) {
                request.setAttribute("mensaje", "El Usuario fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el usuario");
            }

            List<Clientes> lt = DaoClientes.listar();
            request.setAttribute("listaClientes", lt);
            request.getRequestDispatcher("Vistas/Listar_Clientes.jsp").forward(request, response);
        } // </editor-fold>
        

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
