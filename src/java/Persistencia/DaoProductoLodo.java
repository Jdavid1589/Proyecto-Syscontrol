package Persistencia;

import Modelo.ControlLodo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProductoLodo {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static ControlLodo controllodo1 = new ControlLodo();

    public static boolean grabar(ControlLodo controlLodo) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dao.conectar();
            String sql = "INSERT INTO controlcalidad(fecha, lote," //2               
                    + "retenido325, pH, abs_Aceite, Brigh, " //4
                    + "Whitness, Dv50, Dv90, observacion, " //4              
                    + "idProductos, idUsuarios, idConsecutivo, " //3  / = 13.

                    + "humedad, viscosidadKu, viscosidadCp, " //3
                    + "ltAgua, dispersante, kgCarbonatoSosio, " //3
                    + "ltNatrosol, ltBiocidad, biocidadPorcentaje, " //3
                    + "cantiKgLodo, numeroTanque, solidos, comentarios, idSeguimiento)  " //5   = 14         Total = 27                    
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "; // 27 placeholders

            ps = con.prepareStatement(sql);

            ps.setString(1, controlLodo.getFecha());
            ps.setString(2, controlLodo.getLote());
            ps.setDouble(3, controlLodo.getRetenido325());
            ps.setDouble(4, controlLodo.getPH());
            ps.setDouble(5, controlLodo.getAbs_Aceite());
            ps.setDouble(6, controlLodo.getBrigh());
            ps.setDouble(7, controlLodo.getWhitness());
            ps.setDouble(8, controlLodo.getDv50());
            ps.setDouble(9, controlLodo.getDv90());
            ps.setString(10, controlLodo.getObservacion());
            ps.setInt(11, controlLodo.getIdProductos());
            ps.setInt(12, controlLodo.getIdUsuarios());
            ps.setInt(13, controlLodo.getIdConsecutivo());

            ps.setDouble(14, controlLodo.getHumedad()); //Nuevo
            ps.setDouble(15, controlLodo.getViscosidadKu()); //Nuevo
            ps.setDouble(16, controlLodo.getViscosidadCp()); //Nuevo
            ps.setInt(17, controlLodo.getLtAgua()); //Nuevo
            ps.setDouble(18, controlLodo.getDispersante()); //Nuevo
            ps.setDouble(19, controlLodo.getKgCarbonatoSosio()); //Nuevo
            ps.setInt(20, controlLodo.getLtNatrosol()); //Nuevo
            ps.setInt(21, controlLodo.getLtBiocidad()); //Nuevo
            ps.setDouble(22, controlLodo.getBiocidadPorcentaje()); //Nuevo
            ps.setDouble(23, controlLodo.getCantiKgLodo()); //Nuevo         
            ps.setString(24, controlLodo.getNumeroTanque()); //Nuevo
            ps.setDouble(25, controlLodo.getSolidos()); //Nuevo
            ps.setString(26, controlLodo.getComentarios()); //Cambiar a 26
            ps.setInt(27, controlLodo.getIdSeguimiento()); //Cambiar a 27

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace(); // Imprime el seguimiento de la pila para depuración
        } finally {
            // Close resources in a finally block
            cerrarRecursos();
        }
        return false;
    }

    public static List<ControlLodo> listar() {
        List<ControlLodo> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT  cc.* "
                    + "FROM controlcalidad cc "
                    + "JOIN productos prod ON "
                    + " cc.idProductos = prod.idProductos "
                    + "JOIN tipoproducto tp ON "
                    + " prod.idTipoProducto = tp.idTipoProducto "
                    + "WHERE tp.idTipoProducto = 2;";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ControlLodo controllodo1 = new ControlLodo();

                controllodo1.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controllodo1.setLote(rs.getString("lote"));
                controllodo1.setIdProductos(rs.getInt("idProductos"));
                controllodo1.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controllodo1.setIdUsuarios(rs.getInt("idUsuarios"));
                controllodo1.setFecha(rs.getString("fecha"));
                controllodo1.setPH(rs.getDouble("pH"));
                controllodo1.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controllodo1.setBrigh(rs.getDouble("Brigh"));
                controllodo1.setWhitness(rs.getDouble("Whitness"));
                controllodo1.setDv50(rs.getDouble("Dv50"));
                controllodo1.setDv90(rs.getDouble("Dv90"));
                controllodo1.setObservacion(rs.getString("observacion"));
                controllodo1.setRetenido325(rs.getDouble("retenido325"));// 14

                controllodo1.setCantiKgLodo(rs.getDouble("cantiKgLodo"));
                controllodo1.setNumeroTanque(rs.getString("numeroTanque"));
                controllodo1.setSolidos(rs.getDouble("solidos"));
                controllodo1.setHumedad(rs.getDouble("humedad"));
                controllodo1.setViscosidadKu(rs.getDouble("viscosidadKu"));
                controllodo1.setViscosidadCp(rs.getDouble("viscosidadCp"));
                controllodo1.setLtAgua(rs.getInt("ltAgua"));
                controllodo1.setDispersante(rs.getDouble("dispersante"));
                controllodo1.setKgCarbonatoSosio(rs.getDouble("kgCarbonatoSosio"));
                controllodo1.setLtNatrosol(rs.getInt("ltNatrosol"));
                controllodo1.setLtBiocidad(rs.getInt("ltBiocidad"));
                controllodo1.setBiocidadPorcentaje(rs.getDouble("biocidadPorcentaje"));
                controllodo1.setIdSeguimiento(rs.getInt("idSeguimiento"));
                controllodo1.setComentarios(rs.getString("comentarios"));//14

                lista.add(controllodo1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar Recursos
            cerrarRecursos();
        }
        return lista;
    }

    //Nota:Se debe manejar el mismo orden tanto en la sentencia Sql como en el modelo
   public static boolean editar(ControlLodo controlLodo) {
    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = dao.conectar();

        String sql = "UPDATE controlcalidad SET fecha=?, lote=?, " //2               
                + "retenido325=?, pH=?, abs_Aceite=?, Brigh=?, " //4
                + "Whitness=?, Dv50=?, Dv90=?, observacion=?, " //5              
                + "idProductos=?, idUsuarios=?, idConsecutivo=?, " //3  / = 13.
                + "humedad=?, viscosidadKu=?, viscosidadCp=?, " //3
                + "ltAgua=?, dispersante=?, kgCarbonatoSosio=?, " //3
                + "ltNatrosol=?, ltBiocidad=?, biocidadPorcentaje=?, " //3
                + "cantiKgLodo=?, numeroTanque=?, solidos=?, comentarios=?, idSeguimiento=? " //4   = 13         Total = 26                    
                + "WHERE idControlCalidad = ?";

        ps = con.prepareStatement(sql);

        ps.setString(1, controlLodo.getFecha());
        ps.setString(2, controlLodo.getLote());
        ps.setDouble(3, controlLodo.getRetenido325());
        ps.setDouble(4, controlLodo.getPH());
        ps.setDouble(5, controlLodo.getAbs_Aceite());
        ps.setDouble(6, controlLodo.getBrigh());
        ps.setDouble(7, controlLodo.getWhitness());
        ps.setDouble(8, controlLodo.getDv50());
        ps.setDouble(9, controlLodo.getDv90());
        ps.setString(10, controlLodo.getObservacion());
        ps.setInt(11, controlLodo.getIdProductos());
        ps.setInt(12, controlLodo.getIdUsuarios());
        ps.setInt(13, controlLodo.getIdConsecutivo());
        ps.setDouble(14, controlLodo.getHumedad());
        ps.setDouble(15, controlLodo.getViscosidadKu());
        ps.setDouble(16, controlLodo.getViscosidadCp());
        ps.setInt(17, controlLodo.getLtAgua());
        ps.setDouble(18, controlLodo.getDispersante());
        ps.setDouble(19, controlLodo.getKgCarbonatoSosio());
        ps.setInt(20, controlLodo.getLtNatrosol());
        ps.setInt(21, controlLodo.getLtBiocidad());
        ps.setDouble(22, controlLodo.getBiocidadPorcentaje());
        ps.setDouble(23, controlLodo.getCantiKgLodo());
        ps.setString(24, controlLodo.getNumeroTanque());
        ps.setDouble(25, controlLodo.getSolidos());
        ps.setString(26, controlLodo.getComentarios());
        ps.setInt(27, controlLodo.getIdSeguimiento());
        ps.setInt(28, controlLodo.getIdControlCalidad());

        // Ejecutar la consulta de actualización
        int rowsAffected = ps.executeUpdate();

        // Verificar si se actualizó algún registro
        if (rowsAffected > 0) {
            return true; // La actualización fue exitosa
        }
    } catch (SQLException ex) {
        Logger.getLogger(DaoProductoLodo.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close resources in a finally block
        cerrarRecursos();
    }
    return false;
}


    /* este metodo (listarAtributos2) sirve para listar todos los atributos de ProductoLodo dependiendo el id
    del PL para poder editarlos */
    public static ControlLodo  listarAtributos2(int id) {

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

               controllodo1.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controllodo1.setLote(rs.getString("lote"));
                controllodo1.setIdProductos(rs.getInt("idProductos"));
                controllodo1.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controllodo1.setIdUsuarios(rs.getInt("idUsuarios"));
                controllodo1.setFecha(rs.getString("fecha"));
                controllodo1.setPH(rs.getDouble("pH"));
                controllodo1.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controllodo1.setBrigh(rs.getDouble("Brigh"));
                controllodo1.setWhitness(rs.getDouble("Whitness"));
                controllodo1.setDv50(rs.getDouble("Dv50"));
                controllodo1.setDv90(rs.getDouble("Dv90"));
                controllodo1.setObservacion(rs.getString("observacion"));
                controllodo1.setRetenido325(rs.getDouble("retenido325"));// 14

                controllodo1.setCantiKgLodo(rs.getDouble("cantiKgLodo"));
                controllodo1.setNumeroTanque(rs.getString("numeroTanque"));
                controllodo1.setSolidos(rs.getDouble("solidos"));
                controllodo1.setHumedad(rs.getDouble("humedad"));
                controllodo1.setViscosidadKu(rs.getDouble("viscosidadKu"));
                controllodo1.setViscosidadCp(rs.getDouble("viscosidadCp"));
                controllodo1.setLtAgua(rs.getInt("ltAgua"));
                controllodo1.setDispersante(rs.getDouble("dispersante"));
                controllodo1.setKgCarbonatoSosio(rs.getDouble("kgCarbonatoSosio"));
                controllodo1.setLtNatrosol(rs.getInt("ltNatrosol"));
                controllodo1.setLtBiocidad(rs.getInt("ltBiocidad"));
                controllodo1.setBiocidadPorcentaje(rs.getDouble("biocidadPorcentaje"));
                controllodo1.setIdSeguimiento(rs.getInt("idSeguimiento"));
                controllodo1.setComentarios(rs.getString("comentarios"));//14
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return controllodo1;
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
    
  // pte ajuste
    public static ControlLodo listarpdf(int id) {

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

                 controllodo1.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controllodo1.setLote(rs.getString("lote"));
                controllodo1.setIdProductos(rs.getInt("idProductos"));
                controllodo1.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controllodo1.setIdUsuarios(rs.getInt("idUsuarios"));
                controllodo1.setFecha(rs.getString("fecha"));
                controllodo1.setPH(rs.getDouble("pH"));
                controllodo1.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controllodo1.setBrigh(rs.getDouble("Brigh"));
                controllodo1.setWhitness(rs.getDouble("Whitness"));
                controllodo1.setDv50(rs.getDouble("Dv50"));
                controllodo1.setDv90(rs.getDouble("Dv90"));
                controllodo1.setObservacion(rs.getString("observacion"));
                controllodo1.setRetenido325(rs.getDouble("retenido325"));// 14

                controllodo1.setCantiKgLodo(rs.getDouble("cantiKgLodo"));
                controllodo1.setNumeroTanque(rs.getString("numeroTanque"));
                controllodo1.setSolidos(rs.getDouble("solidos"));
                controllodo1.setHumedad(rs.getDouble("humedad"));
                controllodo1.setViscosidadKu(rs.getDouble("viscosidadKu"));
                controllodo1.setViscosidadCp(rs.getDouble("viscosidadCp"));
                controllodo1.setLtAgua(rs.getInt("ltAgua"));
                controllodo1.setDispersante(rs.getDouble("dispersante"));
                controllodo1.setKgCarbonatoSosio(rs.getDouble("kgCarbonatoSosio"));
                controllodo1.setLtNatrosol(rs.getInt("ltNatrosol"));
                controllodo1.setLtBiocidad(rs.getInt("ltBiocidad"));
                controllodo1.setBiocidadPorcentaje(rs.getDouble("biocidadPorcentaje"));
                controllodo1.setIdSeguimiento(rs.getInt("idSeguimiento"));
                controllodo1.setComentarios(rs.getString("comentarios"));//14
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }

        return controllodo1;
    }
    
    
     public static List<ControlLodo> Buscar4(String Texto) {
        List<ControlLodo> lista = new ArrayList<>();
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
                //ControlSeco controlseco1 = new ControlSeco();

                controllodo1.setIdControlCalidad(rs.getInt("idControlCalidad"));
                controllodo1.setLote(rs.getString("lote"));
                controllodo1.setIdProductos(rs.getInt("idProductos"));
                controllodo1.setIdConsecutivo(rs.getInt("idConsecutivo"));
                controllodo1.setIdUsuarios(rs.getInt("idUsuarios"));
                controllodo1.setFecha(rs.getString("fecha"));
                controllodo1.setPH(rs.getDouble("pH"));
                controllodo1.setAbs_Aceite(rs.getDouble("abs_Aceite"));
                controllodo1.setBrigh(rs.getDouble("Brigh"));
                controllodo1.setWhitness(rs.getDouble("Whitness"));
                controllodo1.setDv50(rs.getDouble("Dv50"));
                controllodo1.setDv90(rs.getDouble("Dv90"));
                controllodo1.setObservacion(rs.getString("observacion"));
                controllodo1.setRetenido325(rs.getDouble("retenido325"));// 14

                controllodo1.setCantiKgLodo(rs.getDouble("cantiKgLodo"));
                controllodo1.setNumeroTanque(rs.getString("numeroTanque"));
                controllodo1.setSolidos(rs.getDouble("solidos"));
                controllodo1.setHumedad(rs.getDouble("humedad"));
                controllodo1.setViscosidadKu(rs.getDouble("viscosidadKu"));
                controllodo1.setViscosidadCp(rs.getDouble("viscosidadCp"));
                controllodo1.setLtAgua(rs.getInt("ltAgua"));
                controllodo1.setDispersante(rs.getDouble("dispersante"));
                controllodo1.setKgCarbonatoSosio(rs.getDouble("kgCarbonatoSosio"));
                controllodo1.setLtNatrosol(rs.getInt("ltNatrosol"));
                controllodo1.setLtBiocidad(rs.getInt("ltBiocidad"));
                controllodo1.setBiocidadPorcentaje(rs.getDouble("biocidadPorcentaje"));
                controllodo1.setIdSeguimiento(rs.getInt("idSeguimiento"));
                controllodo1.setComentarios(rs.getString("comentarios"));//14

                lista.add(controllodo1);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    public static boolean eliminar(int idControl_Calidad) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM control_calidad_lodos WHERE idControl_Calidad =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idControl_Calidad);

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
