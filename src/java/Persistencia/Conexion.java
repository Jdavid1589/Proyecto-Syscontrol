

package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final String DATABASE_NAME = "syscontrol4";
    private static final String URL = "jdbc:mysql://localhost:3306/"; 
    private static final String USERNAME = "root";
    private static final String PASSWORD = "jdproot123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // si la version es 8 se pone cj si es 5 se quita cj

    public Connection conectar() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
            System.out.println("Conexion Exitosa a la BD: " + DATABASE_NAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Error en connect to the database");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    }

   /* public static void main(String[] args) {
        Conexion dao = new Conexion();
        dao.conectar();
    }
    
    
    /*
public class Conexion {
    private static final String DATABASE_NAME = "syscontrol4";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "jdproot123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;

    // Método privado para crear la conexión
    private static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
    }

    // Método público para obtener la conexión
    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = createConnection();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
*/



    
    
    
    





