package Persistencia;

import Modelo.Especificaciones;
import Modelo.EspecificacionesComun;
import Modelo.EspecificacionesLodos;
import Modelo.EspecificacionesSeco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEspecificacionesLodos {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static EspecificacionesLodos especificacionesLodo = new EspecificacionesLodos();

    public static boolean grabarEsp(EspecificacionesLodos especificLodo) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO especificaciones(idProductos, idclientes, variableEsp1, rango1," //4
                    + "variableEsp2, rango2, variableEsp3, rango3, variableEsp4, rango4, variableEsp5, rango5," //8
                    + "variableEsp6, rango6, variableEsp7, rango7, variableEsp8, rango8, variableEsp9, rango9," //8
                    + "variableEsp10, rango10, variableEsp11, rango11, metodo1, metodo2, metodo3, metodo4, metodo5, metodo6," //10
                    + "metodo7, metodo8, metodo9, metodo10, metodo11) " // 5      = 35    
                    + "VALUES(?,?,?,?,?,?," //6
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," // 16
                    + "?,?,?,?,?,?," // 6
                    + "?,?,?,?,?,?,?);"; // 7 =35
            ps = con.prepareStatement(sql);

            ps.setInt(1, especificLodo.getIdProductos());
            ps.setInt(2, especificLodo.getIdclientes());
            ps.setString(3, especificLodo.getVariableEsp1());
            ps.setString(4, especificLodo.getRango1());
            ps.setString(5, especificLodo.getVariableEsp2());
            ps.setString(6, especificLodo.getRango2());
            ps.setString(7, especificLodo.getVariableEsp3());
            ps.setString(8, especificLodo.getRango3());
            ps.setString(9, especificLodo.getVariableEsp4());
            ps.setString(10, especificLodo.getRango4());
            ps.setString(11, especificLodo.getVariableEsp5());
            ps.setString(12, especificLodo.getRango5());
            ps.setString(13, especificLodo.getVariableEsp6());
            ps.setString(14, especificLodo.getRango6());
            ps.setString(15, especificLodo.getVariableEsp7());
            ps.setString(16, especificLodo.getRango7());
            ps.setString(17, especificLodo.getVariableEsp8());
            ps.setString(18, especificLodo.getRango8());
            ps.setString(19, especificLodo.getVariableEsp9());
            ps.setString(20, especificLodo.getRango9());
            ps.setString(21, especificLodo.getVariableEsp10());
            ps.setString(22, especificLodo.getRango10());
            ps.setString(23, especificLodo.getVariableEsp11());
            ps.setString(24, especificLodo.getRango11());

            ps.setString(25, especificLodo.getMetodo1());
            ps.setString(26, especificLodo.getMetodo2());
            ps.setString(27, especificLodo.getMetodo3());
            ps.setString(28, especificLodo.getMetodo4());
            ps.setString(29, especificLodo.getMetodo5());
            ps.setString(30, especificLodo.getMetodo6());
            ps.setString(31, especificLodo.getMetodo7());
            ps.setString(32, especificLodo.getMetodo8());
            ps.setString(33, especificLodo.getMetodo9());
            ps.setString(34, especificLodo.getMetodo10());
            ps.setString(35, especificLodo.getMetodo11());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(DaoEspecificacionesLodos.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

//Se le paso como parametro el modelo Cosnsecutivo
    public static List<EspecificacionesLodos> listar() {
        List<EspecificacionesLodos> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "   SELECT  E.* "
                    + "FROM especificaciones E "
                    + "JOIN productos prod ON "
                    + " E.idProductos = prod.idProductos "
                    + "JOIN tipoproducto tp ON "
                    + " prod.idTipoProducto = tp.idTipoProducto "
                    + "WHERE tp.idTipoProducto = 2;";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                EspecificacionesLodos espe = new EspecificacionesLodos();

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
                espe.setVariableEsp9(rs.getString("variableEsp9"));
                espe.setVariableEsp10(rs.getString("variableEsp10"));
                espe.setVariableEsp11(rs.getString("variableEsp11"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));
                espe.setRango9(rs.getString("rango9"));
                espe.setRango10(rs.getString("rango10"));
                espe.setRango11(rs.getString("rango11"));

                espe.setMetodo1(rs.getString("metodo1"));
                espe.setMetodo2(rs.getString("metodo2"));
                espe.setMetodo3(rs.getString("metodo3"));
                espe.setMetodo4(rs.getString("metodo4"));
                espe.setMetodo5(rs.getString("metodo5"));
                espe.setMetodo6(rs.getString("metodo6"));
                espe.setMetodo7(rs.getString("metodo7"));
                espe.setMetodo8(rs.getString("metodo8"));
                espe.setMetodo9(rs.getString("metodo9"));
                espe.setMetodo10(rs.getString("metodo10"));
                espe.setMetodo11(rs.getString("metodo11"));

                lista.add(espe);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    //Nota:Se debe manejar el mismo orden tanto en la asentencia Sql como en el ps
 public static boolean editar(EspecificacionesLodos especificLodo) {
    try {
        con = dao.conectar();
        String sql = "UPDATE especificaciones SET idProductos = ?, idclientes = ?, " + 
                     "variableEsp1 = ?, rango1 = ?, metodo1 = ?, " + 
                     "variableEsp2 = ?, rango2 = ?, metodo2 = ?, " +
                     "variableEsp3 = ?, rango3 = ?, metodo3 = ?, " +
                     "variableEsp4 = ?, rango4 = ?, metodo4 = ?, " +
                     "variableEsp5 = ?, rango5 = ?, metodo5 = ?, " +
                     "variableEsp6 = ?, rango6 = ?, metodo6 = ?, " +
                     "variableEsp7 = ?, rango7 = ?, metodo7 = ?, " +
                     "variableEsp8 = ?, rango8 = ?, metodo8 = ?, " +
                     "variableEsp9 = ?, rango9 = ?, metodo9 = ?, " +
                     "variableEsp10 = ?, rango10 = ?, metodo10 = ?, " +
                     "variableEsp11 = ?, rango11 = ?, metodo11 = ? " +
                     "WHERE idespecificaciones = ?";

        ps = con.prepareStatement(sql);

        // Asignación de parámetros
        ps.setInt(1, especificLodo.getIdProductos());
        ps.setInt(2, especificLodo.getIdclientes());
        ps.setString(3, especificLodo.getVariableEsp1());
        ps.setString(4, especificLodo.getRango1());
        ps.setString(5, especificLodo.getMetodo1());
        ps.setString(6, especificLodo.getVariableEsp2());
        ps.setString(7, especificLodo.getRango2());
        ps.setString(8, especificLodo.getMetodo2());
        ps.setString(9, especificLodo.getVariableEsp3());
        ps.setString(10, especificLodo.getRango3());
        ps.setString(11, especificLodo.getMetodo3());
        ps.setString(12, especificLodo.getVariableEsp4());
        ps.setString(13, especificLodo.getRango4());
        ps.setString(14, especificLodo.getMetodo4());
        ps.setString(15, especificLodo.getVariableEsp5());
        ps.setString(16, especificLodo.getRango5());
        ps.setString(17, especificLodo.getMetodo5());
        ps.setString(18, especificLodo.getVariableEsp6());
        ps.setString(19, especificLodo.getRango6());
        ps.setString(20, especificLodo.getMetodo6());
        ps.setString(21, especificLodo.getVariableEsp7());
        ps.setString(22, especificLodo.getRango7());
        ps.setString(23, especificLodo.getMetodo7());
        ps.setString(24, especificLodo.getVariableEsp8());
        ps.setString(25, especificLodo.getRango8());
        ps.setString(26, especificLodo.getMetodo8());
        ps.setString(27, especificLodo.getVariableEsp9());
        ps.setString(28, especificLodo.getRango9());
        ps.setString(29, especificLodo.getMetodo9());
        ps.setString(30, especificLodo.getVariableEsp10());
        ps.setString(31, especificLodo.getRango10());
        ps.setString(32, especificLodo.getMetodo10());
        ps.setString(33, especificLodo.getVariableEsp11());
        ps.setString(34, especificLodo.getRango11());
        ps.setString(35, especificLodo.getMetodo11());
        ps.setInt(36, especificLodo.getIdespecificaciones());

        // Ejecutar la consulta de actualización
        int rowsAffected = ps.executeUpdate();

        // Verificar si se actualizó algún registro
        if (rowsAffected > 0) {
            return true; // La actualización fue exitosa
        }

    } catch (SQLException ex) {
        Logger.getLogger(DaoEspecificacionesLodos.class.getName()).log(Level.SEVERE, null, ex);
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

    public static List<EspecificacionesLodos> listarEspecporIdControl(int idControlCalidad) {
        List<EspecificacionesLodos> lista = new ArrayList<>();
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

                EspecificacionesLodos espe = new EspecificacionesLodos();

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

    public static List<EspecificacionesLodos> listarEspPDF(int idControlCalidad) {
        List<EspecificacionesLodos> lista = new ArrayList<>();
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

                EspecificacionesLodos espe = new EspecificacionesLodos();

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
                espe.setVariableEsp9(rs.getString("variableEsp9"));
                espe.setVariableEsp10(rs.getString("variableEsp10"));
                espe.setVariableEsp11(rs.getString("variableEsp11"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));
                espe.setRango9(rs.getString("rango9"));
                espe.setRango10(rs.getString("rango10"));
                espe.setRango11(rs.getString("rango11"));

                espe.setMetodo1(rs.getString("metodo1"));
                espe.setMetodo2(rs.getString("metodo2"));
                espe.setMetodo3(rs.getString("metodo3"));
                espe.setMetodo4(rs.getString("metodo4"));
                espe.setMetodo5(rs.getString("metodo5"));
                espe.setMetodo6(rs.getString("metodo6"));
                espe.setMetodo7(rs.getString("metodo7"));
                espe.setMetodo8(rs.getString("metodo8"));
                espe.setMetodo9(rs.getString("metodo9"));
                espe.setMetodo10(rs.getString("metodo10"));
                espe.setMetodo11(rs.getString("metodo11"));

                lista.add(espe);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error para el registro
        } finally {
            cerrarRecursos();
        }
        return lista;
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
    public static EspecificacionesLodos obtenerEspecificPorId(int id) {
        EspecificacionesLodos espe = null;

        String sql = "SELECT * FROM especificaciones WHERE idespecificaciones =?";

        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    espe = new EspecificacionesLodos();

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
                    espe.setVariableEsp9(rs.getString("variableEsp9"));
                    espe.setVariableEsp10(rs.getString("variableEsp10"));
                    espe.setVariableEsp11(rs.getString("variableEsp11"));

                    espe.setRango1(rs.getString("rango1"));
                    espe.setRango2(rs.getString("rango2"));
                    espe.setRango3(rs.getString("rango3"));
                    espe.setRango4(rs.getString("rango4"));
                    espe.setRango5(rs.getString("rango5"));
                    espe.setRango6(rs.getString("rango6"));
                    espe.setRango7(rs.getString("rango7"));
                    espe.setRango8(rs.getString("rango8"));
                    espe.setRango9(rs.getString("rango9"));
                    espe.setRango10(rs.getString("rango10"));
                    espe.setRango11(rs.getString("rango11"));

                    espe.setMetodo1(rs.getString("metodo1"));
                    espe.setMetodo2(rs.getString("metodo2"));
                    espe.setMetodo3(rs.getString("metodo3"));
                    espe.setMetodo4(rs.getString("metodo4"));
                    espe.setMetodo5(rs.getString("metodo5"));
                    espe.setMetodo6(rs.getString("metodo6"));
                    espe.setMetodo7(rs.getString("metodo7"));
                    espe.setMetodo8(rs.getString("metodo8"));
                    espe.setMetodo9(rs.getString("metodo9"));
                    espe.setMetodo10(rs.getString("metodo10"));
                    espe.setMetodo11(rs.getString("metodo11"));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecificacionesLodos.class.getName()).log(Level.SEVERE, null, ex);
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

    public static List<EspecificacionesLodos> buscarEspecif(String texto) {
        List<EspecificacionesLodos> listaEspecifi = new ArrayList<>();

        try {
            con = dao.conectar();

            String sql = "SELECT * FROM idespecificaciones WHERE metodoAnalisis LIKE ? OR especificaciones LIKE ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                EspecificacionesLodos espe = new EspecificacionesLodos();

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
                espe.setVariableEsp9(rs.getString("variableEsp9"));
                espe.setVariableEsp10(rs.getString("variableEsp10"));
                espe.setVariableEsp11(rs.getString("variableEsp111"));
                espe.setRango1(rs.getString("rango1"));
                espe.setRango2(rs.getString("rango2"));
                espe.setRango3(rs.getString("rango3"));
                espe.setRango4(rs.getString("rango4"));
                espe.setRango5(rs.getString("rango5"));
                espe.setRango6(rs.getString("rango6"));
                espe.setRango7(rs.getString("rango7"));
                espe.setRango8(rs.getString("rango8"));
                espe.setRango9(rs.getString("rango9"));
                espe.setRango10(rs.getString("rango10"));
                espe.setRango11(rs.getString("rango11"));

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
