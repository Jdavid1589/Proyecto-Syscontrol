package Persistencia;

import Modelo.ControlSeco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProductoSeco {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    static ControlSeco controlseco = new ControlSeco();

    public static boolean grabar3(ControlSeco controlSeco) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dao.conectar();
            String sql = "INSERT INTO controlcalidad(fecha, cant_noconf, causas, lote, humedad_1, humedad_2, humedad_3," //7
                    + " humedad_4, humedad_5, humedad_6, humedad_7, " //4
                    + "humedad_8, humedad_9, humedad_10, humedad_promedio,"//4
                    + "retenido325, pH, pH_2, pH_3, pH_promedio, abs_Aceite, Brigh, " //7
                    + "Whitness, Dv50, Dv90, observacion, comentarios," //5              
                    + "idProductos, idUsuarios, idConsecutivo ) " //3 Total= 30
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"//14
                    + " ?, ?, ?, ?, ?, ?, ?,"//7
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?)";//9  Total= 30

            ps = con.prepareStatement(sql);

            ps.setString(1, controlSeco.getFecha());

            ps.setDouble(2, controlSeco.getCant_noconf());
            ps.setString(3, controlSeco.getCausas());
            ps.setString(4, controlSeco.getLote());

            /*  ps.setDouble(5, controlSeco.getHumedad_1());
            ps.setDouble(6, controlSeco.getHumedad_2());
            ps.setDouble(7, controlSeco.getHumedad_3());
            ps.setDouble(8, controlSeco.getHumedad_4());
            ps.setDouble(9, controlSeco.getHumedad_5());
            ps.setDouble(10, controlSeco.getHumedad_6());
            ps.setDouble(11, controlSeco.getHumedad_7());

            ps.setDouble(12, controlSeco.getHumedad_8());
            ps.setDouble(13, controlSeco.getHumedad_9());
            ps.setDouble(14, controlSeco.getHumedad_10());*/
            ps.setDouble(15, controlSeco.getHumedad_promedio());

            ps.setDouble(16, controlSeco.getRetenido325());
            ps.setDouble(17, controlSeco.getPH());
            ps.setDouble(18, controlSeco.getpH_2());
            ps.setDouble(19, controlSeco.getpH_3());
            ps.setDouble(20, controlSeco.getpH_promedio());
            ps.setDouble(21, controlSeco.getAbs_Aceite());
            ps.setDouble(22, controlSeco.getBrigh());
            ps.setDouble(23, controlSeco.getWhitness());
            ps.setDouble(24, controlSeco.getDv50());
            ps.setDouble(25, controlSeco.getDv90());
            ps.setString(26, controlSeco.getObservacion());
            ps.setString(27, controlSeco.getComentarios());
            ps.setInt(28, controlSeco.getIdProductos()); //Nuevo
            ps.setInt(29, controlSeco.getIdUsuarios()); //Nuevo
            ps.setInt(30, controlSeco.getIdConsecutivo()); //Nuevo
            //ps.setDouble(31, controlSeco.getHumedad_11()); //Nuevo

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {

        } finally {
            // Close resources in a finally block
            cerrarRecursos();
        }
        return false;
    }

    public static boolean grabar4(ControlSeco controlSeco) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dao.conectar();
            StringBuilder sqlBuilder = new StringBuilder("INSERT INTO controlcalidad (fecha, cant_noconf, causas, lote");
            StringBuilder valuesBuilder = new StringBuilder("VALUES (?, ?, ?, ?");
            List<Double> humedades = new ArrayList<>();

            // Construir la consulta SQL y los valores para la inserción dinámicamente
            for (int i = 1; i <= 30; i++) {
                sqlBuilder.append(", humedad_").append(i);
                valuesBuilder.append(", ?");
                Double humedad = controlSeco.getHumedad(i);
                if (humedad != null) {
                    humedades.add(humedad);
                } else {
                    humedades.add(null);
                }
            }

            // Añadir el resto de los campos a la consulta SQL
            sqlBuilder.append(", humedad_promedio, retenido325, pH, pH_2, pH_3, pH_promedio, abs_Aceite, Brigh, Whitness, Dv50, Dv90, observacion, comentarios, idProductos, idUsuarios, idConsecutivo) ");
            valuesBuilder.append(", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sqlBuilder.append(valuesBuilder.toString());

            // Preparar la declaración SQL
            ps = con.prepareStatement(sqlBuilder.toString());

            // Establecer los parámetros de la declaración SQL
            ps.setString(1, controlSeco.getFecha());
            ps.setDouble(2, controlSeco.getCant_noconf());
            ps.setString(3, controlSeco.getCausas());
            ps.setString(4, controlSeco.getLote());

            // Establecer los valores de humedad
            int index = 5;
            for (Double humedad : humedades) {
                ps.setObject(index++, humedad);
            }

            // Establecer los demás campos
            ps.setDouble(index++, controlSeco.getHumedad_promedio());
            ps.setDouble(index++, controlSeco.getRetenido325());
            ps.setDouble(index++, controlSeco.getPH());
            ps.setDouble(index++, controlSeco.getpH_2());
            ps.setDouble(index++, controlSeco.getpH_3());
            ps.setDouble(index++, controlSeco.getpH_promedio());
            ps.setDouble(index++, controlSeco.getAbs_Aceite());
            ps.setDouble(index++, controlSeco.getBrigh());
            ps.setDouble(index++, controlSeco.getWhitness());
            ps.setDouble(index++, controlSeco.getDv50());
            ps.setDouble(index++, controlSeco.getDv90());
            ps.setString(index++, controlSeco.getObservacion());
            ps.setString(index++, controlSeco.getComentarios());
            ps.setInt(index++, controlSeco.getIdProductos());
            ps.setInt(index++, controlSeco.getIdUsuarios());
            ps.setInt(index, controlSeco.getIdConsecutivo());

            // Ejecutar la consulta SQL
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar adecuadamente la excepción en tu aplicación
        } finally {
            cerrarRecursos(); // Método para cerrar recursos como la conexión, el PreparedStatement y el ResultSet
        }
        return false;
    }

    public static List<ControlSeco> listar() {
        List<ControlSeco> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT  cc.* "
                    + "FROM controlcalidad cc "
                    + "JOIN productos prod ON "
                    + " cc.idProductos = prod.idProductos "
                    + "JOIN tipoproducto tp ON "
                    + " prod.idTipoProducto = tp.idTipoProducto "
                    + "WHERE tp.idTipoProducto = 1;";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ControlSeco controlSeco = new ControlSeco();

                // Setear los campos comunes
                controlSeco.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controlSeco.setIdProductos(rs.getInt("idProductos"));
                controlSeco.setIdUsuarios(rs.getInt("idUsuarios"));
                controlSeco.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controlSeco.setFecha(rs.getString("fecha"));
                controlSeco.setLote(rs.getString("lote"));
                controlSeco.setCant_noconf(rs.getDouble("cant_noconf"));
                controlSeco.setCausas(rs.getString("causas"));
                controlSeco.setHumedad_promedio(rs.getDouble("humedad_promedio"));
                controlSeco.setRetenido325(rs.getDouble("retenido325"));
                controlSeco.setPH(rs.getDouble("pH"));
                controlSeco.setpH_2(rs.getDouble("pH_2"));
                controlSeco.setpH_3(rs.getDouble("pH_3"));
                controlSeco.setpH_promedio(rs.getDouble("pH_promedio"));
                controlSeco.setDv50(rs.getDouble("Dv50"));
                controlSeco.setDv90(rs.getDouble("Dv90"));
                controlSeco.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controlSeco.setBrigh(rs.getDouble("Brigh"));
                controlSeco.setWhitness(rs.getDouble("Whitness"));
                controlSeco.setObservacion(rs.getString("observacion"));
                controlSeco.setComentarios(rs.getString("comentarios"));

                // Setear las humedades dinámicamente
                for (int i = 1; i <= 30; i++) {
                    Double humedad = rs.getDouble("humedad_" + i);
                    if (!rs.wasNull()) {
                        controlSeco.setHumedad(i, humedad);
                    }
                }

                lista.add(controlSeco);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Manejar adecuadamente la excepción en tu aplicación
        } finally {
            cerrarRecursos(); // Método para cerrar recursos como la conexión, el PreparedStatement y el ResultSet
        }
        return lista;
    }

    public static ControlSeco listarpdf(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dao.conectar();
            String sql = "SELECT * FROM controlcalidad WHERE idControlCalidad = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                controlseco.setIdControlCalidad(rs.getInt("idControlCalidad"));

                controlseco.setIdProductos(rs.getInt("idProductos"));
                controlseco.setIdUsuarios(rs.getInt("idUsuarios"));
                controlseco.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controlseco.setFecha(rs.getString("fecha"));
                controlseco.setLote(rs.getString("lote"));
                controlseco.setCant_noconf(rs.getDouble("cant_noconf"));
                controlseco.setCausas(rs.getString("causas"));
                controlseco.setHumedad_promedio(rs.getDouble("humedad_promedio"));
                controlseco.setRetenido325(rs.getDouble("retenido325"));
                controlseco.setPH(rs.getDouble("pH"));
                controlseco.setpH_2(rs.getDouble("pH_2"));
                controlseco.setpH_3(rs.getDouble("pH_3"));
                controlseco.setpH_promedio(rs.getDouble("pH_promedio"));
                controlseco.setDv50(rs.getDouble("Dv50"));
                controlseco.setDv90(rs.getDouble("Dv90"));
                controlseco.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controlseco.setBrigh(rs.getDouble("Brigh"));
                controlseco.setWhitness(rs.getDouble("Whitness"));
                controlseco.setObservacion(rs.getString("observacion"));
                controlseco.setComentarios(rs.getString("comentarios"));
                // Setear las humedades dinámicamente
                for (int i = 1; i <= 30; i++) {
                    Double humedad = rs.getDouble("humedad_" + i);
                    if (!rs.wasNull()) {
                        controlseco.setHumedad(i, humedad);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return controlseco;
    }

    public static boolean editar2(ControlSeco controlSeco) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dao.conectar();

            StringBuilder sqlBuilder = new StringBuilder("UPDATE controlcalidad SET fecha = ?, lote = ?, cant_noconf = ?, "
                    + "causas = ?, humedad_promedio = ?");

            List<Object> values = new ArrayList<>();
            values.add(controlSeco.getFecha());
            values.add(controlSeco.getLote());
            values.add(controlSeco.getCant_noconf());
            values.add(controlSeco.getCausas());
            values.add(controlSeco.getHumedad_promedio());

            int numCamposHumedad = 30;

            // Agregar solo los campos de humedad que tienen valores
            for (int i = 1; i <= numCamposHumedad; i++) {
                Double humedad = controlSeco.getHumedad(i);
                if (humedad != null) {
                    sqlBuilder.append(", humedad_").append(i).append(" = ?");
                    values.add(humedad);
                }
            }

            sqlBuilder.append(", retenido325 = ?, pH = ?, pH_2 = ?, pH_3 = ?, pH_promedio = ?, abs_Aceite = ?, "
                    + "Brigh = ?, Whitness = ?, Dv50 = ?, Dv90 = ?, observacion = ?, comentarios = ?, idProductos = ?, "
                    + "idUsuarios = ?, idConsecutivo = ? WHERE idControlCalidad = ?");
            ps = con.prepareStatement(sqlBuilder.toString());

            int index = 1;
            for (Object value : values) {
                ps.setObject(index++, value);
            }

            ps.setDouble(index++, controlSeco.getRetenido325());
            ps.setDouble(index++, controlSeco.getPH());
            ps.setDouble(index++, controlSeco.getpH_2());
            ps.setDouble(index++, controlSeco.getpH_3());
            ps.setDouble(index++, controlSeco.getpH_promedio());
            ps.setDouble(index++, controlSeco.getAbs_Aceite());
            ps.setDouble(index++, controlSeco.getBrigh());
            ps.setDouble(index++, controlSeco.getWhitness());
            ps.setDouble(index++, controlSeco.getDv50());
            ps.setDouble(index++, controlSeco.getDv90());
            ps.setString(index++, controlSeco.getObservacion());
            ps.setString(index++, controlSeco.getComentarios());
            ps.setInt(index++, controlSeco.getIdProductos());
            ps.setInt(index++, controlSeco.getIdUsuarios());
            ps.setInt(index++, controlSeco.getIdConsecutivo());
            ps.setInt(index, controlSeco.getIdControlCalidad());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    //Nota:Se debe manejar el mismo orden tanto en la sentencia Sql como en el modelo
    public static boolean editar(ControlSeco controlSeco) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dao.conectar();

            String sql = "UPDATE controlcalidad SET fecha = ?,"
                    + " lote = ?, cant_noconf = ?, causas = ?,"
                    + " humedad_1 = ?, humedad_2 = ?, humedad_3 = ?, humedad_4 = ?, humedad_5 = ?,"
                    + " humedad_6 =?, humedad_7 = ?, humedad_8 = ?, humedad_9 = ?, humedad_10 = ?, humedad_promedio = ?,"
                    + " retenido325 = ?, pH = ?, pH_2 = ?, pH_3 = ?, pH_promedio = ?, "
                    + "abs_Aceite = ?, Brigh = ?, Whitness = ?, Dv50 = ?, Dv90 = ?,"
                    + " observacion = ?, comentarios = ?,"
                    + "idProductos = ?, idUsuarios = ?, idConsecutivo = ? "
                    + " WHERE idControlCalidad = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, controlSeco.getFecha());
            ps.setString(2, controlSeco.getLote());
            ps.setDouble(3, controlSeco.getCant_noconf());
            ps.setString(4, controlSeco.getCausas());

            /*   ps.setDouble(5, controlSeco.getHumedad_1());
            ps.setDouble(6, controlSeco.getHumedad_2());
            ps.setDouble(7, controlSeco.getHumedad_3());
            ps.setDouble(8, controlSeco.getHumedad_4());
            ps.setDouble(9, controlSeco.getHumedad_5());
            ps.setDouble(10, controlSeco.getHumedad_6());
            ps.setDouble(11, controlSeco.getHumedad_7());
            ps.setDouble(12, controlSeco.getHumedad_8());
            ps.setDouble(13, controlSeco.getHumedad_9());
            ps.setDouble(14, controlSeco.getHumedad_10());*/
            ps.setDouble(15, controlSeco.getHumedad_promedio());

            ps.setDouble(16, controlSeco.getRetenido325());
            ps.setDouble(17, controlSeco.getPH());
            ps.setDouble(18, controlSeco.getpH_2());
            ps.setDouble(19, controlSeco.getpH_3());
            ps.setDouble(20, controlSeco.getpH_promedio());

            ps.setDouble(21, controlSeco.getAbs_Aceite());
            ps.setDouble(22, controlSeco.getBrigh());
            ps.setDouble(23, controlSeco.getWhitness());
            ps.setDouble(24, controlSeco.getDv50());
            ps.setDouble(25, controlSeco.getDv90());

            ps.setString(26, controlSeco.getObservacion());
            ps.setString(27, controlSeco.getComentarios());
            ps.setInt(28, controlSeco.getIdProductos()); //Nuevo
            ps.setInt(29, controlSeco.getIdUsuarios()); //Nuevo
            ps.setInt(30, controlSeco.getIdConsecutivo()); //Nuevo
            ps.setInt(31, controlSeco.getIdControlCalidad());

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources in a finally block
            cerrarRecursos();
        }
        return false;
    }

    /* este metodo (listarAtributos2) sirve para listar todos los atributos de ProductoSeco dependiendo el id
    del PS para poder editarlos */
    public static ControlSeco listarAtributos2(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dao.conectar();
            String sql = "SELECT * FROM controlcalidad WHERE idControlCalidad = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                // Setear los campos comunes
                controlseco.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controlseco.setIdProductos(rs.getInt("idProductos"));
                controlseco.setIdUsuarios(rs.getInt("idUsuarios"));
                controlseco.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controlseco.setFecha(rs.getString("fecha"));
                controlseco.setLote(rs.getString("lote"));
                controlseco.setCant_noconf(rs.getDouble("cant_noconf"));
                controlseco.setCausas(rs.getString("causas"));
                controlseco.setHumedad_promedio(rs.getDouble("humedad_promedio"));
                controlseco.setRetenido325(rs.getDouble("retenido325"));
                controlseco.setPH(rs.getDouble("pH"));
                controlseco.setpH_2(rs.getDouble("pH_2"));
                controlseco.setpH_3(rs.getDouble("pH_3"));
                controlseco.setpH_promedio(rs.getDouble("pH_promedio"));
                controlseco.setDv50(rs.getDouble("Dv50"));
                controlseco.setDv90(rs.getDouble("Dv90"));
                controlseco.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controlseco.setBrigh(rs.getDouble("Brigh"));
                controlseco.setWhitness(rs.getDouble("Whitness"));
                controlseco.setObservacion(rs.getString("observacion"));
                controlseco.setComentarios(rs.getString("comentarios"));

                // Setear las humedades dinámicamente
                for (int i = 1; i <= 30; i++) {
                    Double humedad = rs.getDouble("humedad_" + i);
                    if (!rs.wasNull()) {
                        controlseco.setHumedad(i, humedad);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return controlseco;
    }

    public static String obtenerNombreprod(int id) {

        try {
            con = dao.conectar();
            String sql = "SELECT pr.nombres_Productos "
                    + "FROM especificaciones E "
                    + "JOIN productosref pr "
                    + "ON pr.idProductos = E.productos_idProductos "
                    + "WHERE E.idespecificaciones = ?"; // Agregado el WHERE para filtrar por ID

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_Productos");
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

    public static String obtenerNombreproducto(int idEspecificaciones) {

        try {
            con = dao.conectar();
            String sql = "SELECT  pr.nombres_Productos  "
                    + "FROM  productosref pr "
                    + "JOIN especificaciones E "
                    + "ON pr.idProductos = E.productos_idProductos "
                    + "JOIN  clientes c "
                    + "ON E.clientes_idclientes = c.idclientes "
                    + "WHERE E.idespecificaciones = ?"; // Agregado el WHERE para filtrar por ID

            ps = con.prepareStatement(sql);
            ps.setInt(1, idEspecificaciones);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_Productos");
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

    public static String obtenerNombrecliente(int idEspecificaciones) {

        try {
            con = dao.conectar();
            String sql = "SELECT  c.razon_Social "
                    + "FROM  productos pr "
                    + "JOIN especificaciones E "
                    + "ON pr.idProductos = E.idProductos "
                    + "JOIN  clientes c "
                    + "ON E.idclientes = c.idclientes "
                    + "WHERE E.idespecificaciones = ?"; // Agregado el WHERE para filtrar por ID

            ps = con.prepareStatement(sql);
            ps.setInt(1, idEspecificaciones);
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

    public static String obtenerTipoProducto(int id) {
        try {
            con = dao.conectar();

            String sql = "SELECT PR.tipoProducto_idtipoProducto, TP.tipo "
                    + "FROM productos PR "
                    + "INNER JOIN tipoproducto TP ON PR.idTipoProducto = TP.idTipoProducto "
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
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    public static String obtenerUsuario(int id) {
        try {
            con = dao.conectar();

            String sql = "SELECT "
                    + "u.nombres_apellido "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON "
                    + "C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON "
                    + "E.idespecificaciones = cs.idespecificaciones "
                    + "INNER JOIN usuarios u  ON "
                    + "u.idUsuarios= cs.idUsuarios "
                    + "WHERE C.idControlCalidad = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                // Devolvemos solo el nombre del tipo de Usu
                return rs.getString("nombres_apellido");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    //El que Funsiona
    public static String obtenerclienteFinal(int id) {
        try {
            con = dao.conectar();

            String sql = "select "
                    + "cl.razon_Social "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON "
                    + "C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON "
                    + "E.idespecificaciones = cs.idespecificaciones "
                    + "INNER JOIN clientes cl ON "
                    + "cl.idclientes = E.idclientes "
                    + "WHERE C.idControlCalidad = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("razon_Social");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    //El que Funsiona
    public static String obtenerProductoFinal(int id) {
        try {
            con = dao.conectar();

            String sql = "SELECT "
                    + "pr.nombres_Productos "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON "
                    + "C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON "
                    + "E.idespecificaciones = cs.idespecificaciones "
                    + "INNER JOIN productos pr ON "
                    + "pr.idProductos= E.idProductos "
                    + "WHERE C.idControlCalidad = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_Productos");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    //El que Funsiona
    public static String obtenerUserFinal(int id) {
        try {
            con = dao.conectar();

            String sql = "SELECT "
                    + "u.nombres_apellido "
                    + "FROM controlcalidad C "
                    + "INNER JOIN consecutivo cs ON "
                    + "C.idConsecutivo = cs.idconsecutivo "
                    + "INNER JOIN especificaciones E ON "
                    + "E.idespecificaciones = cs.idespecificaciones "
                    + "INNER JOIN usuarios u  ON "
                    + "u.idUsuarios= cs.idUsuarios "
                    + "WHERE C.idControlCalidad = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombres_apellido");
            } else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return "--";
    }

    public static List<ControlSeco> Buscar3(String Texto) {
        List<ControlSeco> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT cc.* "
                    + "FROM controlcalidad cc "
                    + "INNER JOIN usuarios u "
                    + "ON cc.idUsuarios = u.idUsuarios "
                    + "INNER JOIN productos pr "
                    + "ON cc.idProductos = pr.idProductos "
                    + "where nombres_Productos LIKE ? "
                    + "OR u.nombres_apellido LIKE ? "
                    + "OR cc.lote LIKE ? "
                    + "OR cc.fecha LIKE ?;";

            ps = con.prepareStatement(sql);

            String parametroBusqueda = "%" + Texto + "%";

            ps.setString(1, parametroBusqueda);
            ps.setString(2, parametroBusqueda);
            ps.setString(3, parametroBusqueda);
            ps.setString(4, parametroBusqueda);

            rs = ps.executeQuery();

            while (rs.next()) {
                ControlSeco controlseco1 = new ControlSeco();

                // Setear los campos comunes
                controlseco.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controlseco.setIdProductos(rs.getInt("idProductos"));
                controlseco.setIdUsuarios(rs.getInt("idUsuarios"));
                controlseco.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controlseco.setFecha(rs.getString("fecha"));
                controlseco.setLote(rs.getString("lote"));
                controlseco.setCant_noconf(rs.getDouble("cant_noconf"));
                controlseco.setCausas(rs.getString("causas"));
                controlseco.setHumedad_promedio(rs.getDouble("humedad_promedio"));
                controlseco.setRetenido325(rs.getDouble("retenido325"));
                controlseco.setPH(rs.getDouble("pH"));
                controlseco.setpH_2(rs.getDouble("pH_2"));
                controlseco.setpH_3(rs.getDouble("pH_3"));
                controlseco.setpH_promedio(rs.getDouble("pH_promedio"));
                controlseco.setDv50(rs.getDouble("Dv50"));
                controlseco.setDv90(rs.getDouble("Dv90"));
                controlseco.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controlseco.setBrigh(rs.getDouble("Brigh"));
                controlseco.setWhitness(rs.getDouble("Whitness"));
                controlseco.setObservacion(rs.getString("observacion"));
                controlseco.setComentarios(rs.getString("comentarios"));

                // Setear las humedades dinámicamente
                for (int i = 1; i <= 30; i++) {
                    Double humedad = rs.getDouble("humedad_" + i);
                    if (!rs.wasNull()) {
                        controlseco.setHumedad(i, humedad);
                    }
                }

                lista.add(controlseco1);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static boolean eliminar(int idControlCalidad) {
        try (Connection con = dao.conectar(); PreparedStatement ps = con.prepareStatement("DELETE FROM controlcalidad WHERE idControlCalidad=?")) {
            ps.setInt(1, idControlCalidad);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Aquí puedes lanzar una excepción personalizada si lo prefieres
        } finally {
            cerrarRecursos();

        }
        return false;
    }

// Método para cerrar conexiones y recursos
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
