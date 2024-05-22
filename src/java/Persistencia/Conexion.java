
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




    
    
    
    





