package Persistencia;

import Modelo.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoClientes {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Clientes clientes = new Clientes();

    public static boolean grabar(Clientes clientes) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO clientes(razon_Social, nombres_apellidos, idDocumento, "
                    + "numero_Documento, direccion, numero_Telefono, correo) "
                    + "VALUES(?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);

            ps.setString(1, clientes.getRazon_Social());
            ps.setString(2, clientes.getNombres_apellidos());
            ps.setInt(3, clientes.getIdDocumento());
            ps.setString(4, clientes.getNumero_Documento());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getNumero_Telefono());
            ps.setString(7, clientes.getCorreo());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static List<Clientes> listar() {
        List<Clientes> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM clientes;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes clientes = new Clientes();

                clientes.setIdclientes(rs.getInt("idclientes"));
                clientes.setRazon_Social(rs.getString("razon_Social"));
                clientes.setNombres_apellidos(rs.getString("nombres_apellidos"));
                clientes.setIdDocumento(rs.getInt("idDocumento"));
                clientes.setNumero_Documento(rs.getString("numero_Documento"));
                clientes.setDireccion(rs.getString("direccion"));
                clientes.setNumero_Telefono(rs.getString("numero_Telefono"));
                clientes.setCorreo(rs.getString("correo"));

                lista.add(clientes);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

// Metodo Refactorizado para listar y editar 
    public static Clientes obtenerClientePorId(int id) {
        Clientes clientes = null;

        String sql = "SELECT * FROM clientes WHERE idclientes =?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes = new Clientes();
                    clientes.setIdclientes(rs.getInt("idclientes"));
                    clientes.setRazon_Social(rs.getString("razon_Social"));
                    clientes.setNombres_apellidos(rs.getString("nombres_apellidos"));
                    clientes.setIdDocumento(rs.getInt("idDocumento"));
                    clientes.setNumero_Documento(rs.getString("numero_Documento"));
                    clientes.setDireccion(rs.getString("direccion"));
                    clientes.setNumero_Telefono(rs.getString("numero_Telefono"));
                    clientes.setCorreo(rs.getString("correo"));
                }
            }
        } catch (SQLException ex) {
             Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return clientes;
    }

    //Nota:Se debe manejar el mismo orden tanto en la asentencia Sql como en el ps
    public static boolean editar(Clientes clientes) {
        try {
            con = dao.conectar();
            String sql = "UPDATE clientes SET razon_Social = ?, nombres_apellidos = ?, idDocumento = ?,"
                    + "numero_Documento = ?, direccion = ?, numero_Telefono = ?, correo = ?"
                    + "WHERE idclientes = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getRazon_Social());
            ps.setString(2, clientes.getNombres_apellidos());
            ps.setInt(3, clientes.getIdDocumento());
            ps.setString(4, clientes.getNumero_Documento());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getNumero_Telefono());
            ps.setString(7, clientes.getCorreo());
            ps.setInt(8, clientes.getIdclientes());

            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           cerrarRecursos();
        }
        return false;
    }

    public static boolean eliminar(int idclientes) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM clientes WHERE idclientes=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idclientes);

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de mejor manera, por ejemplo, lanzando una excepción personalizada.
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static String obtenerNombreclientes(int id) {
        /*Metodo que sirve para obtener el nombre y poderlo listar en las tablas relacionadas
        Ejemplo: Tabla Listar Productos_Secos 
        <td><%= DaoUsuarios.obtenerNombreClientes(terminadoseco.getUsuarios_idUsuarios())%></td> */
        try {
            con = dao.conectar();
            String sql = "SELECT razon_Social FROM clientes WHERE idclientes=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("razon_Social");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        } return "--";
    }
    
    
    public static List<Clientes> buscarClientes(String texto) {
        List<Clientes> listaClientes = new ArrayList<>();

        try {
            con = dao.conectar();

            String sql = "SELECT * FROM clientes WHERE nombres_apellidos LIKE ? OR razon_Social LIKE ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Clientes cliente = new Clientes();

                cliente.setIdclientes(rs.getInt("idclientes"));
                cliente.setRazon_Social(rs.getString("razon_Social"));
                cliente.setNombres_apellidos(rs.getString("nombres_apellidos"));
                cliente.setIdDocumento(rs.getInt("idDocumento"));
                cliente.setNumero_Documento(rs.getString("numero_Documento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setNumero_Telefono(rs.getString("numero_Telefono"));
                cliente.setCorreo(rs.getString("correo"));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            // Manejo adecuado de la excepción (log, imprimir, etc.)
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar los recursos (ResultSet, PreparedStatement, Connection)
            closeResources();
        }

        return listaClientes;
    }
    

// Agrega este método para cerrar las conexiones y recursos
    private static void cerrarRecursos() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
