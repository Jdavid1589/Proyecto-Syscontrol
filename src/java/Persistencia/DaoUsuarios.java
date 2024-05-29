package Persistencia;

import Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Persistencia.Encriptador;


public class DaoUsuarios {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Usuarios usuarios = new Usuarios();

    public static boolean grabar(Usuarios usuarios) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO usuarios(nombres_apellido, numero_Telefono, correo, "
                    + "usuario, clave, idperfil) "
                    + "VALUES(?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);

            ps.setString(1, usuarios.getNombres_apellido());
            ps.setString(2, usuarios.getNumero_Telefono());
            ps.setString(3, usuarios.getCorreo());
            ps.setString(4, usuarios.getUsuario());
            ps.setString(5, usuarios.getClave());
            ps.setInt(6, usuarios.getPerfil_idperfil());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    
    //metodo jasypt para encriptar contraseña
    public Usuarios validarUsuario(String usuario, String clave) {
        Usuarios user = null;
        Encriptador en = new Encriptador();

        String sql = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            //  ps.setString(2, hashClave(clave)); // Utiliza una función hash para almacenar las contraseñas de manera segura            
            ps.setString(2, (en.desencriptar(clave)));
           // ps.setString(2, clave);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Usuarios();
                    user.setIdUsuarios(rs.getInt("idUsuarios"));
                //    user.setNombres_apellido(rs.getString("nombres_apellido"));
               //     user.setNumero_Telefono(rs.getString("numero_Telefono"));
                //    user.setCorreo(rs.getString("correo"));
                    user.setUsuario(rs.getString("usuario"));
                    user.setClave(rs.getString("clave")); // No es recomendable devolver la contraseña en el objeto Usuarios, pero lo mantengo por coherencia con tu código original
                    user.setPerfil_idperfil(rs.getInt("idperfil"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Puedes agregar un mensaje de error adicional si es necesario
        } finally {
            cerrarRecursos(); // Asegúrate de cerrar los recursos de manera correcta
        }
        return user;

    }
    
    

    public static List<Usuarios> listar() {
        List<Usuarios> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM usuarios;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));
                usuarios.setNombres_apellido(rs.getString("nombres_apellido"));
                usuarios.setNumero_Telefono(rs.getString("numero_Telefono"));
                usuarios.setCorreo(rs.getString("correo"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setClave(rs.getString("clave"));
                usuarios.setPerfil_idperfil(rs.getInt("idperfil"));

                lista.add(usuarios);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static List<Usuarios> Buscar(String Texto) {
        List<Usuarios> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM usuarios WHERE  nombres_apellido LIKE ? ";

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Texto + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));
                usuarios.setNombres_apellido(rs.getString("nombres_apellido"));

                usuarios.setNumero_Telefono(rs.getString("numero_Telefono"));
                usuarios.setCorreo(rs.getString("correo"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setClave(rs.getString("clave"));
                usuarios.setPerfil_idperfil(rs.getInt("idperfil"));

                lista.add(usuarios);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    // Metodo para validar usuario

// Metodo Refactorizado para listar y editar 
    public static Usuarios obtenerUsuarioPorId(int id) {
        Usuarios usuario = null;

        String sql = "SELECT * FROM usuarios WHERE idUsuarios=?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuario = new Usuarios();
                    usuario.setIdUsuarios(rs.getInt("idUsuarios"));
                    usuario.setNombres_apellido(rs.getString("nombres_apellido"));
                    usuario.setNumero_Telefono(rs.getString("numero_Telefono"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setClave(rs.getString("clave"));
                    usuario.setPerfil_idperfil(rs.getInt("idperfil"));

                }
            }
        } catch (SQLException ex) {
            // Registra el error sin mostrar detalles al usuario
            Logger.getLogger(DaoUsuarios.class
                    .getName()).log(Level.SEVERE, "Error al acceder a la base de datos", ex);

        }

        return usuario;
    }

    //Nota:Se debe manejar el mismo orden tanto en l asentencia Sql como en el ps
    public static boolean editar(Usuarios usuarios) {
        try {
            con = dao.conectar();
            String sql = "UPDATE usuarios SET nombres_apellido = ?, "
                    + "numero_Telefono =?, correo =?, usuario =?, "
                    + "clave =?, idperfil =? WHERE idUsuarios =?";

            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios.getNombres_apellido());
            ps.setString(2, usuarios.getNumero_Telefono());
            ps.setString(3, usuarios.getCorreo());
            ps.setString(4, usuarios.getUsuario());
            ps.setString(5, usuarios.getClave());
            ps.setInt(6, usuarios.getPerfil_idperfil());
            ps.setInt(7, usuarios.getIdUsuarios());

            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa

            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos (conexión, declaración, etc.) en el bloque "finally"
            // para garantizar que se cierren incluso si ocurre una excepción.
            cerrarRecursos();
        }
        return false;
    }

    public static boolean eliminar(int idUsuarios) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM usuarios WHERE idUsuarios=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuarios);

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
    
    
    
   public static boolean canDelete(int iduser) {
    String query = "SELECT COUNT(*) " +
                   "FROM (" +
                   "    SELECT idUsuarios FROM controlcalidad WHERE idUsuarios = ? " +
                   "    UNION " +
                   "    SELECT idUsuarios FROM consecutivo WHERE idUsuarios = ? " +
                   ") AS combined";
    
    try (Connection con = dao.conectar();
         PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, iduser);
        ps.setInt(2, iduser);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) == 0;
        }
        return false;
    } catch (SQLException e) {
        e.printStackTrace(); // Considera mejorar el manejo de excepciones, por ejemplo, lanzando una excepción personalizada.
        return false;
    }
}

    
public static boolean eliminar2(int iduser) {
    try (Connection con = dao.conectar();
         PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE idUsuarios=?")) {
        ps.setInt(1, iduser);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Maneja las excepciones de mejor manera, por ejemplo, lanzando una excepción personalizada.
        return false;
    }   
}
    

    public static String obtenerNombreUsuario(int id) {
        /*Metodo que sirve para obtener el nombre y poderlo listar en las tablas relacionadas
        Ejemplo: Tabla Listar Productos_Secos 
        <td><%= DaoUsuarios.obtenerNombreUsuario(terminadoseco.getUsuarios_idUsuarios())%></td> */
        try {
            con = dao.conectar();
            String sql = "SELECT nombres_apellido FROM usuarios WHERE idUsuarios=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_apellido");
            } else {
                return "--";

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSeguimientos.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
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
            Logger.getLogger(DaoPerfil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return "--";
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
