package Persistencia;

import Modelo.Consecutivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoConsecutivo {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Consecutivo consecutivo = new Consecutivo();

    public static boolean grabarConsecutivo(Consecutivo consecutivo) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO consecutivo(nroRemision, idespecificaciones, "
                    + "fechaCertificado, fechaProduccion, cantidadMaterial, idUsuarios, lote) "
                    + "VALUES(?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);

            ps.setString(1, consecutivo.getNroRemision());
            ps.setInt(2, consecutivo.getIdEspecificaciones());
            ps.setString(3, consecutivo.getFechaCertificado());
            ps.setString(4, consecutivo.getFechaProduccion());
            ps.setInt(5, consecutivo.getCantidadMaterial());
            ps.setInt(6, consecutivo.getIdUsuarios());
            ps.setString(7, consecutivo.getLote());

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
    //Se le paso como parametro el modelo Cosnsecutivo

    public static List<Consecutivo> listar() {
        List<Consecutivo> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM consecutivo;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consecutivo consec = new Consecutivo();

                consec.setIdconsecutivo(rs.getInt("idconsecutivo"));
                consec.setIdEspecificaciones(rs.getInt("idEspecificaciones"));
                consec.setNroRemision(rs.getString("nroRemision"));

                consec.setFechaCertificado(rs.getString("fechaCertificado"));
                consec.setFechaProduccion(rs.getString("fechaProduccion"));
                consec.setCantidadMaterial(rs.getInt("cantidadMaterial"));
                consec.setLote(rs.getString("lote"));
                consec.setIdUsuarios(rs.getInt("idUsuarios")); // 9

                lista.add(consec);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static List<Consecutivo> listarConsPDF(int idconsecutivo) {
        List<Consecutivo> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT cs.* FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON C.idConsecutivo = cs.idconsecutivo "
                    + "WHERE C.idControlCalidad = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idconsecutivo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consecutivo consec = new Consecutivo();

                consec.setIdconsecutivo(rs.getInt("idconsecutivo"));
                consec.setIdEspecificaciones(rs.getInt("idEspecificaciones"));
                consec.setNroRemision(rs.getString("nroRemision"));

                consec.setFechaCertificado(rs.getString("fechaCertificado"));
                consec.setFechaProduccion(rs.getString("fechaProduccion"));
                consec.setCantidadMaterial(rs.getInt("cantidadMaterial"));
                consec.setLote(rs.getString("lote"));
                consec.setIdUsuarios(rs.getInt("idUsuarios"));

                lista.add(consec);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error para el registro
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static List<Consecutivo> listarConsecporIdControl(int idControlCalidad) {
        List<Consecutivo> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT cs.* "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON E.idespecificaciones = cs.idespecificaciones "
                    + "INNER JOIN productos pr ON pr.idProductos = E.idProductos "
                    + "WHERE C.idControlCalidad = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idControlCalidad);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consecutivo consec = new Consecutivo();

                consec.setIdconsecutivo(rs.getInt("idconsecutivo"));
                consec.setIdEspecificaciones(rs.getInt("idEspecificaciones"));
                consec.setNroRemision(rs.getString("nroRemision"));

                consec.setFechaCertificado(rs.getString("fechaCertificado"));
                consec.setFechaProduccion(rs.getString("fechaProduccion"));
                consec.setCantidadMaterial(rs.getInt("cantidadMaterial"));
                consec.setLote(rs.getString("lote"));
                consec.setIdUsuarios(rs.getInt("idUsuarios"));

                lista.add(consec);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error para el registro
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static int obtenerUltimoValorNroConsecutivo() {
        int ultimoConsecutivo = 0;
        String sql = "SELECT MAX(nroConsecutivo) AS maxConsecutivo FROM consecutivo";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                ultimoConsecutivo = rs.getInt("maxConsecutivo");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        } finally {
            cerrarRecursos();
        }

        return ultimoConsecutivo;
    }

// Metodo Refactorizado para listar y editar 
    public static Consecutivo obtenerConsecutivoPorId(int id) {
        Consecutivo consecutivo = null;

        String sql = "SELECT * FROM consecutivo WHERE idconsecutivo =?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    consecutivo = new Consecutivo();

                    consecutivo.setIdconsecutivo(rs.getInt("idconsecutivo"));
                    consecutivo.setIdEspecificaciones(rs.getInt("idEspecificaciones"));
                    consecutivo.setNroRemision(rs.getString("nroRemision"));

                    consecutivo.setFechaCertificado(rs.getString("fechaCertificado"));
                    consecutivo.setFechaProduccion(rs.getString("fechaProduccion"));
                    consecutivo.setCantidadMaterial(rs.getInt("cantidadMaterial"));
                    consecutivo.setLote(rs.getString("lote"));
                    consecutivo.setIdUsuarios(rs.getInt("idUsuarios"));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoConsecutivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return consecutivo;
    }

    //Nota:Se debe manejar el mismo orden tanto en la asentencia Sql como en el ps
    public static boolean editar(Consecutivo consecutivo) {
        try {
            con = dao.conectar();
            String sql = "UPDATE consecutivo SET nroRemision = ?, "
                    + "idEspecificaciones = ?, fechaCertificado = ?, fechaProduccion = ?,"
                    + "cantidadMaterial= ?, idUsuarios= ?, lote= ? "
                    + "WHERE idconsecutivo = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, consecutivo.getNroRemision());

            ps.setInt(2, consecutivo.getIdEspecificaciones());
            ps.setString(3, consecutivo.getFechaCertificado());
            ps.setString(4, consecutivo.getFechaProduccion());
            ps.setInt(5, consecutivo.getCantidadMaterial());
            ps.setInt(6, consecutivo.getIdUsuarios());
            ps.setString(7, consecutivo.getLote());
            ps.setInt(8, consecutivo.getIdconsecutivo());

            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsecutivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static boolean eliminar(int idconsecutivo) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM consecutivo WHERE idconsecutivo=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idconsecutivo);

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
    
    
    public static boolean canDelete(int idconsecutivo) {
    try (Connection con = dao.conectar();
         PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM controlcalidad WHERE idconsecutivo =?")) {
        ps.setInt(1, idconsecutivo);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) == 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Maneja las excepciones de mejor manera, por ejemplo, lanzando una excepción personalizada.
        return false;
    }
}

public static boolean eliminar2(int idconsecutivo) {
    try (Connection con = dao.conectar();
         PreparedStatement ps = con.prepareStatement("DELETE FROM consecutivo WHERE idconsecutivo =?")) {
        ps.setInt(1, idconsecutivo);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Maneja las excepciones de mejor manera, por ejemplo, lanzando una excepción personalizada.
        return false;
    }
}
    
    

    public static List<Consecutivo> buscarConsecutivo(String texto) {
        List<Consecutivo> listaconsecutivo = new ArrayList<>();

        try {
            con = dao.conectar();

            String sql = "SELECT * FROM consecutivo "
                    + "WHERE nroRemision LIKE ?"
                    + " OR nroConsecutivo LIKE ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Consecutivo consec = new Consecutivo();

                consec.setIdconsecutivo(rs.getInt("idconsecutivo"));
                consec.setIdEspecificaciones(rs.getInt("idEspecificaciones"));
                consec.setNroRemision(rs.getString("nroRemision"));
          
                consec.setFechaCertificado(rs.getString("fechaCertificado"));
                consec.setFechaProduccion(rs.getString("fechaProduccion"));
                consec.setCantidadMaterial(rs.getInt("cantidadMaterial"));
                consec.setLote(rs.getString("lote"));
                consec.setIdUsuarios(rs.getInt("idUsuarios"));

                listaconsecutivo.add(consec);
            }
        } catch (SQLException e) {
            // Manejo adecuado de la excepción (log, imprimir, etc.)
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar los recursos (ResultSet, PreparedStatement, Connection)
            cerrarRecursos();
        }

        return listaconsecutivo;
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
