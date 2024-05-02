/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoDocumento {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
  static Documento documento = new Documento();

    public static boolean registrar(Documento documento) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO documento(tipo_documento) VALUES(?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getTipo_documento());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static List< Documento> listar() {
        List< Documento> listaD = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM documento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDocumento(rs.getInt("idDocumento"));
                documento.setTipo_documento(rs.getString("tipo_Documento"));
                listaD.add(documento);
            }
        } catch (Exception e) {
        }
        return listaD;
    }

    public static String obtenerTipoDocumento(int id) {
        try {
            con = dao.conectar();
            String sql = "SELECT tipo_documento FROM documento WHERE idDocumento=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo_documento");
            } else {
                return "error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "error";
    }

    public static boolean editar(Documento documento) {
        try {
            con = dao.conectar();
            String sql = "UPDATE documento SET tipo_documento = ? WHERE idDocumento =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getTipo_documento());
            ps.setInt(2, documento.getIdDocumento());
            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos (conexión, declaración, etc.) en el bloque "finally"
            // para garantizar que se cierren incluso si ocurre una excepción.
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejar errores al cerrar recursos
            }
        }
        return false;
    }

    public static boolean eliminar(int idDocumento) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM documento WHERE idDocumento=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDocumento);

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
    
      public static Documento listarAtributos(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dao.conectar();
            String sql = "SELECT * FROM documento WHERE idDocumento = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                documento.setIdDocumento(rs.getInt("idDocumento"));               
                documento.setTipo_documento(rs.getString("tipo_documento"));
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           cerrarRecursos();
        }

        return documento;
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
