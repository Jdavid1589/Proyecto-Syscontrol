package Persistencia;


import Modelo.EspecificacionesSeco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEspecificacionesSeco {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static boolean grabarEsp(EspecificacionesSeco especificSeco) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO especificaciones(idProductos, idclientes, variableEsp1, rango1," //4
                    + "variableEsp2, rango2, variableEsp3, rango3, variableEsp4, rango4, variableEsp5, rango5," //8
                    + "variableEsp6, rango6, variableEsp7, rango7, variableEsp8, rango8) " // 6       = 18     
                    + "VALUES(?,?,?,?,?,?," //6
                    + "?,?,?,?,?,?," // 6
                    + "?,?,?,?,?,?);"; // 6 =18
            ps = con.prepareStatement(sql);

            ps.setInt(1, especificSeco.getIdProductos());
            ps.setInt(2, especificSeco.getIdclientes());
            ps.setString(3, especificSeco.getVariableEsp1());
            ps.setString(4, especificSeco.getRango1());
            ps.setString(5, especificSeco.getVariableEsp2());
            ps.setString(6, especificSeco.getRango2());
            ps.setString(7, especificSeco.getVariableEsp3());
            ps.setString(8, especificSeco.getRango3());
            ps.setString(9, especificSeco.getVariableEsp4());
            ps.setString(10, especificSeco.getRango4());
            ps.setString(11, especificSeco.getVariableEsp5());
            ps.setString(12, especificSeco.getRango5());
            ps.setString(13, especificSeco.getVariableEsp6());
            ps.setString(14, especificSeco.getRango6());
            ps.setString(15, especificSeco.getVariableEsp7());
            ps.setString(16, especificSeco.getRango7());
            ps.setString(17, especificSeco.getVariableEsp8());
            ps.setString(18, especificSeco.getRango8());

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
    public static List<EspecificacionesSeco> listar() {
        List<EspecificacionesSeco> lista = new ArrayList<>();
        try {
            con = dao.conectar();
           String sql = "   SELECT  E.* "
                    + "FROM especificaciones E "
                    + "JOIN productos prod ON "
                    + " E.idProductos = prod.idProductos "
                    + "JOIN tipoproducto tp ON "
                    + " prod.idTipoProducto = tp.idTipoProducto "
                    + "WHERE tp.idTipoProducto = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                EspecificacionesSeco espe = new EspecificacionesSeco();

                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariableEsp1(rs.getString("variableEsp1"));
                espe.setVariableEsp2(rs.getString("variableEsp2"));
                espe.setVariableEsp3(rs.getString("variableEsp3"));
                espe.setVariableEsp4(rs.getString("variableEsp4"));
                espe.setVariableEsp5(rs.getString("variableEsp5"));
                espe.setVariableEsp6(rs.getString("variableEsp6"));
                espe.setVariableEsp7(rs.getString("variableEsp7"));
                espe.setVariableEsp8(rs.getString("variableEsp8"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));

                lista.add(espe);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }
    
      public static List<EspecificacionesSeco> listarPS_PL() {
        List<EspecificacionesSeco> lista = new ArrayList<>();
        try {
            con = dao.conectar();
           String sql = "   SELECT  E.* "
                    + "FROM especificaciones E "
                    + "JOIN productos prod ON "
                    + " E.idProductos = prod.idProductos "
                    + "JOIN tipoproducto tp ON "
                    + " prod.idTipoProducto = tp.idTipoProducto "
                    + "WHERE tp.idTipoProducto;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                EspecificacionesSeco espe = new EspecificacionesSeco();

                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariableEsp1(rs.getString("variableEsp1"));
                espe.setVariableEsp2(rs.getString("variableEsp2"));
                espe.setVariableEsp3(rs.getString("variableEsp3"));
                espe.setVariableEsp4(rs.getString("variableEsp4"));
                espe.setVariableEsp5(rs.getString("variableEsp5"));
                espe.setVariableEsp6(rs.getString("variableEsp6"));
                espe.setVariableEsp7(rs.getString("variableEsp7"));
                espe.setVariableEsp8(rs.getString("variableEsp8"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));

                lista.add(espe);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    //Nota:Se debe manejar el mismo orden tanto en la asentencia Sql como en el ps
    public static boolean editar(EspecificacionesSeco especific) {
        try {
            con = dao.conectar();
            String sql = "UPDATE especificaciones SET  idProductos= ?, idclientes= ?, "
                    + " variableEsp1= ?, rango1= ?, variableEsp2= ?, rango2= ?, variableEsp3= ?, "
                    + "rango3= ?, variableEsp4= ?, rango4= ?, variableEsp5= ?, rango5= ?, "
                    + "variableEsp6= ?, rango6= ?, variableEsp7= ?, rango7= ?, variableEsp8= ?, rango8= ?"
                    + "WHERE idespecificaciones = ?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, especific.getIdProductos());
            ps.setInt(2, especific.getIdclientes());
            ps.setString(3, especific.getVariableEsp1());
            ps.setString(4, especific.getRango1());
            ps.setString(5, especific.getVariableEsp2());
            ps.setString(6, especific.getRango2());
            ps.setString(7, especific.getVariableEsp3());
            ps.setString(8, especific.getRango3());
            ps.setString(9, especific.getVariableEsp4());
            ps.setString(10, especific.getRango4());
            ps.setString(11, especific.getVariableEsp5());
            ps.setString(12, especific.getRango5());
            ps.setString(13, especific.getVariableEsp6());
            ps.setString(14, especific.getRango6());
            ps.setString(15, especific.getVariableEsp7());
            ps.setString(16, especific.getRango7());
            ps.setString(17, especific.getVariableEsp8());
            ps.setString(18, especific.getRango8());
            ps.setInt(19, especific.getIdespecificaciones());

            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificacionesSeco.class.getName()).log(Level.SEVERE, null, ex);
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

    public static List<EspecificacionesSeco> listarEspecporIdControl(int idControlCalidad) {
        List<EspecificacionesSeco> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT E.* "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON E.idespecificaciones = cs.idespecificaciones "
                    + "INNER JOIN productos pr ON pr.idProductos = E.idProductos "
                    + "WHERE C.idControlCalidad = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idControlCalidad);
            rs = ps.executeQuery();
            while (rs.next()) {

                EspecificacionesSeco espe = new EspecificacionesSeco();

                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariableEsp1(rs.getString("variableEsp1"));
                espe.setVariableEsp2(rs.getString("variableEsp2"));
                espe.setVariableEsp3(rs.getString("variableEsp3"));
                espe.setVariableEsp4(rs.getString("variableEsp4"));
                espe.setVariableEsp5(rs.getString("variableEsp5"));
                espe.setVariableEsp6(rs.getString("variableEsp6"));
                espe.setVariableEsp7(rs.getString("variableEsp7"));
                espe.setVariableEsp8(rs.getString("variableEsp8"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));

                lista.add(espe);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static List<EspecificacionesSeco> listarEspPDF(int idControlCalidad) {
        List<EspecificacionesSeco> lista = new ArrayList<>();
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
                EspecificacionesSeco espe = new EspecificacionesSeco();
                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariableEsp1(rs.getString("variableEsp1"));
                espe.setVariableEsp2(rs.getString("variableEsp2"));
                espe.setVariableEsp3(rs.getString("variableEsp3"));
                espe.setVariableEsp4(rs.getString("variableEsp4"));
                espe.setVariableEsp5(rs.getString("variableEsp5"));
                espe.setVariableEsp6(rs.getString("variableEsp6"));
                espe.setVariableEsp7(rs.getString("variableEsp7"));
                espe.setVariableEsp8(rs.getString("variableEsp8"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));

                lista.add(espe);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error para el registro
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static String obtReferenciaCliente(int idEspecificacion) {
    try {
        con = dao.conectar();
        String sql = "SELECT CONCAT(pr.nombres_Productos, '_', cl.razon_Social) AS referencia "
                + "FROM especificaciones E "
                + "JOIN clientes cl ON cl.idClientes = E.idClientes "
                + "JOIN productos pr ON pr.idProductos = E.idProductos "
                + "WHERE E.idespecificaciones = ?"; // Agregado el WHERE para filtrar por ID

        ps = con.prepareStatement(sql);
        ps.setInt(1, idEspecificacion);

        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("referencia");
        } else {
            return "--";
        }
    } catch (SQLException ex) {
        Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        return "--";
    } finally {
        cerrarRecursos();
    }
}


    public static List<String> obtenerProductoyCliente2(int tipoProducto) {
        List<String> resultados = new ArrayList<>();

        try {
            con = dao.conectar();

            // Consulta SQL con un parámetro
            String sql = "SELECT E.idespecificaciones, CONCAT(pr.nombres_Productos, ' - ', c.razon_Social) AS producto_cliente "
                    + "FROM productos pr "
                    + "JOIN especificaciones E ON pr.idProductos = E.idProductos "
                    + "JOIN clientes c ON E.idclientes = c.idclientes "
                    + "WHERE pr.idTipoProducto = ?";  // Usar '?' como marcador de posición para el parámetro

            ps = con.prepareStatement(sql);
            ps.setInt(1, tipoProducto);  // Configurar el valor del parámetro

            rs = ps.executeQuery();
            while (rs.next()) {
                String productoCliente = rs.getString("producto_cliente");
                resultados.add(productoCliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificaciones.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return resultados;
    }

    public static String obtenerNombreEspecif(int id) {

        try {
            con = dao.conectar();
            String sql = "SELECT variablesEspecificacion FROM especificaciones WHERE idespecificaciones=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("variablesEspecificacion");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificaciones.class.getName()).log(Level.SEVERE, null, ex);
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

// Metodo para hacer la consulta de Producto y tipo 
    public static String obtrRef_y_TipoProducto2(int id) {
        try {
            con = dao.conectar();

            // Consulta SQL para obtener Nombre_producto desde el id de Especificacciones
            String sql = "SELECT PR.idProductos, PR.nombres_Productos "
                    + "FROM especificaciones E "
                    + "INNER JOIN productos PR ON E.idProductos = PR.idProductos "
                    + "WHERE E.idespecificaciones = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {

                // Devolvemos una cadena que contiene el nombre del producto y el tipo de producto                
                //return rs.getString("nombres_Productos") + " - " + rs.getString("tipo");   // Funsiona OK
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

    public static String obtenerNombreclientes(int id) {
        /*Metodo que sirve para obtener el nombre y poderlo listar en las tablas relacionadas
        Ejemplo: Tabla Listar Productos_Secos 
        <td><%= DaoUsuarios.obtenerNombreClientes(terminadoseco.getUsuarios_idUsuarios())%></td> */
        try {
            con = dao.conectar();
            String sql = "SELECT razon_Social FROM clientes WHERE idclientes=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("razon_Social");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

// Metodo Refactorizado para listar y editar 
    public static EspecificacionesSeco obtenerEspecificPorId(int id) {
        EspecificacionesSeco espe = null;

        String sql = "SELECT * FROM especificaciones WHERE idespecificaciones =?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    espe = new EspecificacionesSeco();

                    espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                    espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                    espe.setIdProductos(rs.getInt("idProductos"));
                    espe.setIdclientes(rs.getInt("idclientes"));
                    espe.setVariableEsp1(rs.getString("variableEsp1"));
                    espe.setVariableEsp2(rs.getString("variableEsp2"));
                    espe.setVariableEsp3(rs.getString("variableEsp3"));
                    espe.setVariableEsp4(rs.getString("variableEsp4"));
                    espe.setVariableEsp5(rs.getString("variableEsp5"));
                    espe.setVariableEsp6(rs.getString("variableEsp6"));
                    espe.setVariableEsp7(rs.getString("variableEsp7"));
                    espe.setVariableEsp8(rs.getString("variableEsp8"));
                    espe.setRango1(rs.getString("rango1"));
                    espe.setRango2(rs.getString("rango2"));
                    espe.setRango3(rs.getString("rango3"));
                    espe.setRango4(rs.getString("rango4"));
                    espe.setRango5(rs.getString("rango5"));
                    espe.setRango6(rs.getString("rango6"));
                    espe.setRango7(rs.getString("rango7"));
                    espe.setRango8(rs.getString("rango8"));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificacionesSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return espe;
    }

    public static boolean usuarioEnUso(int id) {

        try {
            con = dao.conectar();

            // Consulta para verificar si el usuario está siendo utilizado en alguna parte del sistema
            String query = "SELECT COUNT(*) AS count FROM consecutivo WHERE idUsuarios = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones
        } finally {
            cerrarRecursos(); // Cerrar recursos
        }

        return false; // Si ocurre una excepción o no se encuentra el usuario, retornamos false
    }

    public static List<EspecificacionesSeco> buscarEspecif(String texto) {
        List<EspecificacionesSeco> listaEspecifi = new ArrayList<>();

        try {
            con = dao.conectar();

            String sql = "SELECT * FROM idespecificaciones WHERE metodoAnalisis LIKE ? OR especificaciones LIKE ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                EspecificacionesSeco espe = new EspecificacionesSeco();

                espe.setIdespecificaciones(rs.getInt("idespecificaciones"));
                espe.setIdProductos(rs.getInt("idProductos"));
                espe.setIdclientes(rs.getInt("idclientes"));
                espe.setVariableEsp1(rs.getString("variableEsp1"));
                espe.setVariableEsp2(rs.getString("variableEsp2"));
                espe.setVariableEsp3(rs.getString("variableEsp3"));
                espe.setVariableEsp4(rs.getString("variableEsp4"));
                espe.setVariableEsp5(rs.getString("variableEsp5"));
                espe.setVariableEsp6(rs.getString("variableEsp6"));
                espe.setVariableEsp7(rs.getString("variableEsp7"));
                espe.setVariableEsp8(rs.getString("variableEsp8"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));

                listaEspecifi.add(espe);
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
