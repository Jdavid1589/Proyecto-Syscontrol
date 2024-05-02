package Persistencia;

import Modelo.Especificaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEspecificaciones {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Especificaciones especificaciones = new Especificaciones();

    public static boolean grabarEsp(Especificaciones especific) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO especificaciones(idProductos, idclientes, "
                    + "variablesEspecificacion, valorEspecific, metodoAnalisis)"
                    + "VALUES(?,?,?,?,?);";
            ps = con.prepareStatement(sql);

            ps.setInt(1, especific.getIdProductos());
            ps.setInt(2, especific.getIdclientes());
            ps.setString(3, especific.getVariablesEspecificacion());
            ps.setString(4, especific.getValorEspecific());
            ps.setString(5, especific.getMetodoAnalisis());

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

    public static List<Especificaciones> listarEspPDF(int idControlCalidad) {
        List<Especificaciones> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT "
                    + "E.* "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON "
                    + "C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON "
                    + "E.idespecificaciones = cs.idespecificaciones "
                    + "WHERE C.idControlCalidad = ?;";

            ps = con.prepareStatement(sql);
            ps.setInt(1, idControlCalidad);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especificaciones espe = new Especificaciones();
                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariablesEspecificacion(rs.getString("variablesEspecificacion"));
                espe.setValorEspecific(rs.getString("valorEspecific"));
                espe.setMetodoAnalisis(rs.getString("metodoAnalisis"));

                lista.add(espe);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error para el registro
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

//Se le paso como parametro el modelo Cosnsecutivo
    public static List<Especificaciones> listar() {
        List<Especificaciones> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM especificaciones;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especificaciones espe = new Especificaciones();
                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariablesEspecificacion(rs.getString("variablesEspecificacion"));
                espe.setValorEspecific(rs.getString("valorEspecific"));
                espe.setMetodoAnalisis(rs.getString("metodoAnalisis"));

                lista.add(espe);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static Especificaciones listarAtributospdf(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dao.conectar();
            String sql = "SELECT * FROM especificaciones WHERE idespecificaciones = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                especificaciones.setIdespecificaciones(rs.getInt("idespecificaciones"));
                especificaciones.setIdProductos(rs.getInt("idProductos"));
                especificaciones.setIdclientes(rs.getInt("idclientes"));
                especificaciones.setVariablesEspecificacion(rs.getString("variablesEspecificacion"));
                especificaciones.setValorEspecific(rs.getString("valorEspecific"));
                especificaciones.setMetodoAnalisis(rs.getString("metodoAnalisis"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return especificaciones;
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

  

   

    public static String obtenerTipoProducto(int id) {
        try {
            con = dao.conectar();

            String sql = "SELECT PR.idTipoProducto, TP.tipo "
                    + "FROM producto PR "
                    + "INNER JOIN tipoproducto TP ON PR.idTipoProducto = TP.idtipoProducto "
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




 

// Metodo Refactorizado para listar y editar 
    public static Especificaciones obtenerEspecificPorId(int id) {
        Especificaciones especific = null;

        String sql = "SELECT * FROM especificaciones WHERE idespecificaciones =?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    especific = new Especificaciones();

                    especific.setIdespecificaciones(rs.getInt("idespecificaciones"));
                    especific.setIdProductos(rs.getInt("idProductos"));
                    especific.setIdclientes(rs.getInt("idclientes"));
                    especific.setVariablesEspecificacion(rs.getString("variablesEspecificacion"));
                    especific.setValorEspecific(rs.getString("valorEspecific"));
                    especific.setMetodoAnalisis(rs.getString("metodoAnalisis"));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificaciones.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return especific;
    }

    //Nota:Se debe manejar el mismo orden tanto en la asentencia Sql como en el ps
    public static boolean editar(Especificaciones especific) {
        try {
            con = dao.conectar();
            String sql = "UPDATE especificaciones SET  idProductos= ?, idclientes= ?,"
                    + "variablesEspecificacion = ?, valorEspecific = ?, metodoAnalisis= ?"
                    + "WHERE idespecificaciones = ?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, especific.getIdProductos());
            ps.setInt(2, especific.getIdclientes());
            ps.setString(3, especific.getVariablesEspecificacion());
            ps.setString(4, especific.getValorEspecific());
            ps.setString(5, especific.getMetodoAnalisis());
            ps.setInt(6, especific.getIdespecificaciones());

            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificaciones.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static boolean eliminar(int idespecificaciones) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM especificaciones WHERE idespecificaciones=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idespecificaciones);

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

    public static List<Especificaciones> buscarEspecif(String texto) {
        List<Especificaciones> listaEspecifi = new ArrayList<>();

        try {
            con = dao.conectar();

            String sql = "SELECT * FROM idespecificaciones WHERE metodoAnalisis LIKE ? OR especificaciones LIKE ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Especificaciones especificaciones = new Especificaciones();

                especificaciones.setIdespecificaciones(rs.getInt("idespecificaciones"));
                especificaciones.setValorEspecific(rs.getString("valorEspecific"));
                especificaciones.setIdProductos(rs.getInt("idProductos"));
                especificaciones.setIdclientes(rs.getInt("idclientes"));
                especificaciones.setVariablesEspecificacion(rs.getString("variablesEspecificacion"));
                especificaciones.setMetodoAnalisis(rs.getString("metodoAnalisis"));

                listaEspecifi.add(especificaciones);
            }
        } catch (SQLException e) {
            // Manejo adecuado de la excepción (log, imprimir, etc.)
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar los recursos (ResultSet, PreparedStatement, Connection)
            cerrarRecursos();
        }

        return listaEspecifi;
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

}
