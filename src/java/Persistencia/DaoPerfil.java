/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoPerfil {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Perfil perfil = new Perfil();

    public static boolean registrar(Perfil perfil) {

        try {

            con = dao.conectar();
            String sql = "INSERT INTO perfil(tipo_Perfil) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, perfil.getTipo_Perfil());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static List<Perfil> listar() {
        List<Perfil> listaper = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM perfil";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Perfil perfil = new Perfil();
                perfil.setIdperfil(rs.getInt("idperfil"));

                perfil.setTipo_Perfil(rs.getString("tipo_Perfil"));
                listaper.add(perfil);
            }
        } catch (Exception e) {
        }
        return listaper;
    }

    public static String obtenerNombrePerfil(int id) {
        try {
            con = dao.conectar();
            String sql = "SELECT tipo_Perfil FROM perfil WHERE idperfil=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo_Perfil");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "--";
    }

    public static Perfil listarAtributosperfil(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dao.conectar();
            String sql = "SELECT * FROM perfil WHERE idperfil = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                perfil.setIdperfil(rs.getInt("idperfil"));

                perfil.setTipo_Perfil(rs.getString("tipo_Perfil"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources in a finally block
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
            } catch (SQLException ex) {
                Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return perfil;
    }

// Metodo Refactorizado para listar y editar 
    public static Perfil obtenerUsuarioPorId(int id) {
        Perfil perfil = null;

        String sql = "SELECT * FROM perfil WHERE idperfil=?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    perfil.setIdperfil(rs.getInt("idperfil"));
                    perfil.setTipo_Perfil(rs.getString("tipo_Perfil"));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, "Error al acceder a la base de datos", ex);
            // O bien, lanza la excepción para que sea manejada en un nivel superior
            throw new RuntimeException("Error al acceder a la base de datos", ex);
        }finally {
            cerrarRecursos();
        }

        return perfil;
    }

    public static boolean editar(Perfil perfil) {
        try {
            con = dao.conectar();
            String sql = "UPDATE perfil SET tipo_Perfil = ? WHERE idperfil =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, perfil.getTipo_Perfil());
            ps.setInt(2, perfil.getIdperfil());
            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static boolean eliminar(int idperfil) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM perfil WHERE idperfil=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idperfil);

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
