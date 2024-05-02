
package Persistencia;

import Modelo.Seguimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoSeguimientos {
    static Conexion dao = new Conexion();
       static Connection con;
       static PreparedStatement ps;
       static  ResultSet rs;
       //static Perfil perfil = new Perfil();
    public static boolean grabar(Seguimientos  seguimiento){
       
           try {               
               con = dao.conectar();
               String sql = "INSERT INTO seguimientos(numSeguimiento) VALUES (?);";
               ps = con.prepareStatement(sql);
               ps.setString(1, seguimiento.getNumSeguimiento());
               if(ps.executeUpdate()>0){
                   return true;
               }else{
                   return false;
               }
           } catch (SQLException ex) {
               Logger.getLogger(DaoSeguimientos.class.getName()).log(Level.SEVERE, null, ex);
           }
           return false;
       
    }
    
    public static List<Seguimientos> listar() {
    List<Seguimientos> listaV = new ArrayList<>();
    try {
        con = dao.conectar();
        String sql = "SELECT * FROM seguimientos"; 
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Seguimientos variables = new Seguimientos();
            variables.setIdSeguimientos(rs.getInt("idSeguimientos"));
            variables.setNumSeguimiento(rs.getString("numSeguimiento")); 

            listaV.add(variables);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DaoSeguimientos.class.getName()).log(Level.SEVERE, null, ex);
    }
    return listaV;
}
    
    public static String obtenerNombreVariable(int id){
        try {
            con = dao.conectar();
            String sql = "SELECT numSeguimiento FROM seguimientos WHERE idSeguimientos=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getString("numSeguimiento");
            }else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSeguimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "--";
    }
    
    
    // Metodo Refactorizado para listar y editar 
    public static Seguimientos LIstarStoporID(int id) {
        Seguimientos seguimientos = null;

        String sql = "SELECT * FROM seguimientos WHERE idSeguimientos=?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    seguimientos.setIdSeguimientos(rs.getInt("idSeguimientos"));
                    seguimientos.setNumSeguimiento(rs.getString("numSeguimiento"));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSeguimientos.class.getName()).log(Level.SEVERE, "Error al acceder a la base de datos", ex);
            // O bien, lanza la excepción para que sea manejada en un nivel superior
            throw new RuntimeException("Error al acceder a la base de datos", ex);
        }finally {
            cerrarRecursos();
        }

        return seguimientos;
    }

     public static boolean editar(Seguimientos seguimientos) {
        try {
            con = dao.conectar();
            String sql = "UPDATE seguimientos SET numSeguimiento = ? WHERE idSeguimientos =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, seguimientos.getNumSeguimiento());
            ps.setInt(2, seguimientos.getIdSeguimientos());
            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoSeguimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }
    
    
    public static boolean eliminar(int idSeguimientos) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM seguimientos WHERE idSeguimientos=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSeguimientos);

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
