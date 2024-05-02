
package Persistencia;

import Modelo.Productos;
import Modelo.TipoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTipoProducto {
   
    
     static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    //static Perfil perfil = new Perfil();

    public static boolean registrar(TipoProducto tipoProducto) {

        try {

            con = dao.conectar();
            String sql = "INSERT INTO tipoproducto(tipo) VALUES (?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoProducto.getTipo());
           
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoProducto.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
            cerrarRecursos();
        }
        return false;
        

    }

    public static List<TipoProducto> listar() {
        List<TipoProducto> listap = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM tipoproducto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                TipoProducto tipoProducto = new TipoProducto();
                
                tipoProducto.setIdtipoProducto(rs.getInt("idtipoProducto"));
                tipoProducto.setTipo(rs.getString("tipo"));
            
                listap.add(tipoProducto);
            }
        } catch (Exception e) {
        }finally {
            cerrarRecursos();
        }
        return listap;
    }

    public static String obtenerNombreTipoProd(int id) {
        try {
            con = dao.conectar();
            String sql = "SELECT tipo FROM tipoproducto WHERE idtipoProducto=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            cerrarRecursos();
        }
        return "--";
    }  
     
    public static boolean eliminar(int idtipoProducto) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM tipoproducto WHERE idtipoProducto=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idtipoProducto);

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
