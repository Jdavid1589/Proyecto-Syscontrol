package Persistencia;

import Modelo.Perfil;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProductos {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Productos productos = new Productos();

    public static boolean registrar(Productos productos) {

        try {

            con = dao.conectar();
            String sql = "INSERT INTO productos(nombres_Productos, idTipoProducto)"
                    + "VALUES (?, ?);";

            ps = con.prepareStatement(sql);

            ps.setString(1, productos.getNombres_Productos());
            ps.setInt(2, productos.getTipoProducto_idtipoProducto());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;

    }

    public static List<Productos> listar() {
        List<Productos> listap = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM productos ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos1 = new Productos();

                productos1.setIdProductos(rs.getInt("idProductos"));
                productos1.setNombres_Productos(rs.getString("nombres_Productos"));
                productos1.setTipoProducto_idtipoProducto(rs.getInt("idTipoProducto"));

                listap.add(productos1);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return listap;
    }

    public static List<Productos> listarPS() {
        List<Productos> listap = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM productos "
                    + "WHERE idTipoProducto = 1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos1 = new Productos();

                productos1.setIdProductos(rs.getInt("idProductos"));
                productos1.setNombres_Productos(rs.getString("nombres_Productos"));
                productos1.setTipoProducto_idtipoProducto(rs.getInt("idTipoProducto"));

                listap.add(productos1);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while listing products: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error while listing products: " + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarRecursos(); // Assuming this method is defined elsewhere to close the resources
        }
        return listap;
    }

    public static List<Productos> listarPL() {
        List<Productos> listap = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs2 = null;
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM productos WHERE idTipoProducto = 2";
            ps = con.prepareStatement(sql);
            rs2 = ps.executeQuery();

            while (rs2.next()) {
                Productos productos1 = new Productos();

                productos1.setIdProductos(rs2.getInt("idProductos"));
                productos1.setNombres_Productos(rs2.getString("nombres_Productos"));
                productos1.setTipoProducto_idtipoProducto(rs2.getInt("idTipoProducto"));

                listap.add(productos1);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while listing products: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error while listing products: " + e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarRecursos(); // Assuming this method is defined elsewhere to close the resources
        }
        return listap;
    }

    //Nota:Se debe manejar el mismo orden tanto en la sentencia Sql como en el modelo
    public static boolean editar(Productos productos) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dao.conectar();

            String sql = "UPDATE productos SET nombres_Productos = ?, idTipoProducto = ?"
                    + " WHERE idProductos = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, productos.getNombres_Productos());
            ps.setInt(2, productos.getTipoProducto_idtipoProducto());

            ps.setInt(3, productos.getIdProductos());

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources in a finally block
            cerrarRecursos();
        }
        return false;
    }

    /* este metodo (listarAtributos) sirve para listar todos los atributos de ProductoSeco dependiendo el id
    del PS para poder editarlos */
    public static Productos listarAtributos(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dao.conectar();
            String sql = "SELECT * FROM productos WHERE idProductos = ?"
                    + " AND idProductos IS NOT NULL";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                productos.setIdProductos(rs.getInt("idProductos"));
                productos.setNombres_Productos(rs.getString("nombres_Productos"));
                productos.setTipoProducto_idtipoProducto(rs.getInt("idTipoProducto"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return productos;
    }

    public static String obtreferenciacliente(int id) {

        try {
            con = dao.conectar();
            String sql = "SELECT CONCAT(pr.nombres_Productos, '_', cl.razon_Social) AS nombres_Productos "
                    + "FROM especificaciones E "
                    + "JOIN clientes cl ON cl.idClientes = E.idClientes "
                    + "JOIN productos pr ON pr.idProductos = E.idProductos "
                    + "WHERE E.idespecificaciones = ?"; // Agregado el WHERE para filtrar por ID

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_Productos"); // Se cambia a referencia
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    public static String obtenerNombreProducto(int id) {
        try {
            con = dao.conectar();
            String sql = "SELECT nombres_Productos FROM productos WHERE idProductos=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_Productos");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    public static String obtenerTipoProducto(int id) {
        try {
            con = dao.conectar();

            String sql = "SELECT PR.tipoProducto_idtipoProducto, TP.tipo "
                    + "FROM productosref PR "
                    + "INNER JOIN tipoproducto TP ON PR.tipoProducto_idtipoProducto = TP.idtipoProducto "
                    + "WHERE PR.idProductos=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                // Devolvemos solo el nombre del tipo de producto
                return rs.getString("tipo");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    public static boolean eliminar(int idProductos) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM productos WHERE idProductos=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProductos);

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

    // Agrega este método para cerrar las conexiones y recursos
    public static void cerrarRecursos() {
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
