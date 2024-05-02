package Persistencia;

import Modelo.ReportePdfSeco;
import Modelo.Variable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReportePdfSeco {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static boolean grabar(ReportePdfSeco reportePdfSeco) {
        try {
            con = dao.conectar();

            String sql = "INSERT INTO certificadopdfseco(producto, fechaCertificado, cliente, numCertificado, fechaProduccion, CantidadSacos, "
                    + " lote, humedad, pH ,  retenido325, AA, Br,  Wh,  Yell,  Dv50,  Auxiliar,  variableEsp1, variableEsp2,  variableEsp3, "
                    + " variableEsp4 , variableEsp5 , variableEsp6 ,  variableEsp7 ,  variableEsp8 ,  rango1 ,  rango2 , rango3 , rango4 ,  rango5 , "
                    + "rango6 , rango7, rango8) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?," //12
                    + "?,?,?,?,?,?,?,?,?,?,?,?," // 12
                    + "?,?,?,?,?,?,?,?);"; //8 Total:32

            ps = con.prepareStatement(sql);

            ps.setString(1, reportePdfSeco.getProducto());
            ps.setString(2, reportePdfSeco.getFechaCertificado());
            ps.setString(3, reportePdfSeco.getCliente());
            ps.setString(4, reportePdfSeco.getNumCertificado());
            ps.setString(5, reportePdfSeco.getFechaProduccion());
            ps.setString(6, reportePdfSeco.getCantidadSacos());
            ps.setString(7, reportePdfSeco.getLote());
            ps.setString(8, reportePdfSeco.getHumedad()); // Corregido a 7
            ps.setString(9, reportePdfSeco.getpH());
            ps.setString(10, reportePdfSeco.getRetenido325());
            ps.setString(11, reportePdfSeco.getAA());
            ps.setString(12, reportePdfSeco.getBr());
            ps.setString(13, reportePdfSeco.getWh());
            ps.setString(14, reportePdfSeco.getYell());
            ps.setString(15, reportePdfSeco.getDv50());
            ps.setString(16, reportePdfSeco.getAuxiliar());

            List<Variable> variables = reportePdfSeco.getVariables();

            // Establecer los valores de las variables y sus rangos dinámicamente
            for (int i = 0; i < variables.size(); i++) {
                Variable variable = variables.get(i);
                ps.setString(17 + i * 2, variable.getTipo());
                ps.setString(17 + i * 2 + 1, variable.getRango());
            }

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

    public static boolean grabar2(ReportePdfSeco reportePdfSeco) {
        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(crearSQL())) {

            // Establecer los parámetros de la declaración SQL
            setParametros(ps, reportePdfSeco);

            // Ejecutar la consulta SQL
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar adecuadamente la excepción en tu aplicación
        }
        return false;
    }

    private static String crearSQL() {
        return "INSERT INTO certificadopdfseco(producto, fechaCertificado, cliente, numCertificado, fechaProduccion, CantidadSacos, "
                + " lote, humedad, pH ,  retenido325, AA, Br,  Wh,  Yell,  Dv50,  Auxiliar,  variableEsp1, variableEsp2,  variableEsp3, "
                + " variableEsp4 , variableEsp5 , variableEsp6 ,  variableEsp7 ,  variableEsp8 ,  rango1 ,  rango2 , rango3 , rango4 ,  rango5 , "
                + "rango6 , rango7, rango8) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?," //12
                + "?,?,?,?,?,?,?,?,?,?,?,?," // 12
                + "?,?,?,?,?,?,?,?);"; //8 Total:32
    }

    private static void setParametros(PreparedStatement ps, ReportePdfSeco reportePdfSeco) throws SQLException {
        ps.setString(1, reportePdfSeco.getProducto());
        ps.setString(2, reportePdfSeco.getFechaCertificado());
        ps.setString(3, reportePdfSeco.getCliente());
        ps.setString(4, reportePdfSeco.getNumCertificado());
        ps.setString(5, reportePdfSeco.getFechaProduccion());
        ps.setString(6, reportePdfSeco.getCantidadSacos());
        ps.setString(7, reportePdfSeco.getLote());
        ps.setString(8, reportePdfSeco.getHumedad());
        ps.setString(9, reportePdfSeco.getpH());
        ps.setString(10, reportePdfSeco.getRetenido325());
        ps.setString(11, reportePdfSeco.getAA());
        ps.setString(12, reportePdfSeco.getBr());
        ps.setString(13, reportePdfSeco.getWh());
        ps.setString(14, reportePdfSeco.getYell());
        ps.setString(15, reportePdfSeco.getDv50());
        ps.setString(16, reportePdfSeco.getAuxiliar());

        List<Variable> variables = reportePdfSeco.getVariables();

        // Establecer los valores de las variables y sus rangos dinámicamente
        for (int i = 0; i < variables.size(); i++) {
            Variable variable = variables.get(i);
            ps.setString(17 + i * 2, variable.getTipo());
            ps.setString(17 + i * 2 + 1, variable.getRango());
        }
    }

//Se le paso como parametro el modelo Cosnsecutivo
    public static List<ReportePdfSeco> listar() {
        List<ReportePdfSeco> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM certificadopdfseco;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                ReportePdfSeco reportePdfSeco = new ReportePdfSeco();

                reportePdfSeco.setIdCertificadoSeco(rs.getInt("idCertificadoSeco"));
                reportePdfSeco.setProducto(rs.getString("producto"));
                reportePdfSeco.setFechaCertificado(rs.getString("fechaCertificado"));
                reportePdfSeco.setCliente(rs.getString("cliente"));
                reportePdfSeco.setNumCertificado(rs.getString("numCertificado"));
                reportePdfSeco.setFechaProduccion(rs.getString("fechaProduccion"));
                reportePdfSeco.setCantidadSacos(rs.getString("CantidadSacos"));
                reportePdfSeco.setLote(rs.getString("lote"));
                reportePdfSeco.setHumedad(rs.getString("humedad"));
                reportePdfSeco.setpH(rs.getString("pH"));
                reportePdfSeco.setRetenido325(rs.getString("retenido325"));
                reportePdfSeco.setAA(rs.getString("AA"));
                reportePdfSeco.setBr(rs.getString("Wh"));
                reportePdfSeco.setWh(rs.getString("AA"));
                reportePdfSeco.setYell(rs.getString("Yell"));
                reportePdfSeco.setDv50(rs.getString("Dv50"));
                reportePdfSeco.setAuxiliar(rs.getString("Auxiliar"));

                // Recuperar las variables y sus rangos
                List<Variable> variables = new ArrayList<>();
                for (int i = 1; i <= 8; i++) { // Suponiendo que tienes hasta 8 pares de variables y rangos
                    String tipo = rs.getString("variableEsp" + i);
                    String rango = rs.getString("rango" + i);
                    if (tipo != null && rango != null) {
                        Variable variable = new Variable(tipo, rango);
                        variables.add(variable);
                    }
                }
                reportePdfSeco.setVariables(variables);

                lista.add(reportePdfSeco);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    //Nota:Se debe manejar el mismo orden tanto en la asentencia Sql como en el ps
    public static boolean editarpte(ReportePdfSeco reportePdfSeco) {
        try {
            con = dao.conectar();

            String sql = "UPDATE certificadopdfseco SET producto= ?, fechaCertificado= ?, cliente= ?, numCertificado= ?, fechaProduccion= ?, CantidadSacos= ?, "
                    + "lote= ?, humedad= ?, pH = ?,  retenido325= ?, AA= ?, Br= ?,  Wh= ?,  Yell= ?,  Dv50= ?,  Auxiliar= ?,  variableEsp1= ?, variableEsp2= ?,  variableEsp3= ?, "
                    + "variableEsp4 = ?, variableEsp5= ?, variableEsp6 = ?,  variableEsp7 = ?,  variableEsp8= ?,  rango1= ?,  rango2= ?, rango3= ?, rango4= ?,  rango5= ?, "
                    + "rango6 = ?, rango7= ?, rango8= ?"
                    + "WHERE idCertificadoSeco = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, reportePdfSeco.getProducto());
            ps.setString(2, reportePdfSeco.getFechaCertificado());
            ps.setString(3, reportePdfSeco.getCliente());
            ps.setString(4, reportePdfSeco.getNumCertificado());
            ps.setString(5, reportePdfSeco.getFechaProduccion());
            ps.setString(6, reportePdfSeco.getCantidadSacos());
            ps.setString(7, reportePdfSeco.getLote());
            ps.setString(8, reportePdfSeco.getHumedad()); // Corregido a 7
            ps.setString(9, reportePdfSeco.getpH());
            ps.setString(10, reportePdfSeco.getRetenido325());
            ps.setString(11, reportePdfSeco.getAA());
            ps.setString(12, reportePdfSeco.getBr());
            ps.setString(13, reportePdfSeco.getWh());
            ps.setString(14, reportePdfSeco.getYell());
            ps.setString(15, reportePdfSeco.getDv50());
            ps.setString(16, reportePdfSeco.getAuxiliar());

            /*  ps.setString(17, reportePdfSeco.getVariableEsp1());
            ps.setString(18, reportePdfSeco.getRango1());
            ps.setString(19, reportePdfSeco.getVariableEsp2());
            ps.setString(20, reportePdfSeco.getRango2());
            ps.setString(21, reportePdfSeco.getVariableEsp3());
            ps.setString(22, reportePdfSeco.getRango3());
            ps.setString(23, reportePdfSeco.getVariableEsp4());
            ps.setString(24, reportePdfSeco.getRango4());
            ps.setString(25, reportePdfSeco.getVariableEsp5());
            ps.setString(26, reportePdfSeco.getRango5());
            ps.setString(27, reportePdfSeco.getVariableEsp6());
            ps.setString(28, reportePdfSeco.getRango6());
            ps.setString(29, reportePdfSeco.getVariableEsp7());
            ps.setString(30, reportePdfSeco.getRango7());
            ps.setString(31, reportePdfSeco.getVariableEsp8());
            ps.setString(32, reportePdfSeco.getRango8());*/
            ps.setInt(33, reportePdfSeco.getIdCertificadoSeco());

            ps.executeUpdate();

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoReportePdfSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    //Editar modificado
    public static boolean editar(ReportePdfSeco reportePdfSeco) {
        try {
            con = dao.conectar();

            String sql = "UPDATE certificadopdfseco SET producto= ?, fechaCertificado= ?, cliente= ?, numCertificado= ?, fechaProduccion= ?, CantidadSacos= ?, "
                    + "lote= ?, humedad= ?, pH = ?,  retenido325= ?, AA= ?, Br= ?,  Wh= ?,  Yell= ?,  Dv50= ?,  Auxiliar= ?,  variableEsp1= ?, variableEsp2= ?,  variableEsp3= ?, "
                    + "variableEsp4 = ?, variableEsp5= ?, variableEsp6 = ?,  variableEsp7 = ?,  variableEsp8= ?,  rango1= ?,  rango2= ?, rango3= ?, rango4= ?,  rango5= ?, "
                    + "rango6 = ?, rango7= ?, rango8= ? "
                    + "WHERE idCertificadoSeco = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, reportePdfSeco.getProducto());
            ps.setString(2, reportePdfSeco.getFechaCertificado());
            ps.setString(3, reportePdfSeco.getCliente());
            ps.setString(4, reportePdfSeco.getNumCertificado());
            ps.setString(5, reportePdfSeco.getFechaProduccion());
            ps.setString(6, reportePdfSeco.getCantidadSacos());
            ps.setString(7, reportePdfSeco.getLote());
            ps.setString(8, reportePdfSeco.getHumedad());
            ps.setString(9, reportePdfSeco.getpH());
            ps.setString(10, reportePdfSeco.getRetenido325());
            ps.setString(11, reportePdfSeco.getAA());
            ps.setString(12, reportePdfSeco.getBr());
            ps.setString(13, reportePdfSeco.getWh());
            ps.setString(14, reportePdfSeco.getYell());
            ps.setString(15, reportePdfSeco.getDv50());
            ps.setString(16, reportePdfSeco.getAuxiliar());

            List<Variable> variables = reportePdfSeco.getVariables();

            for (int i = 0; i < variables.size(); i++) {
                Variable variable = variables.get(i);
                ps.setString(17 + i * 2, variable.getTipo());
                ps.setString(17 + i * 2 + 1, variable.getRango());
            }

            ps.setInt(33, reportePdfSeco.getIdCertificadoSeco());

            // Ejecutar la consulta de actualización
            int rowsAffected = ps.executeUpdate();

            // Verificar si se actualizó algún registro
            if (rowsAffected > 0) {
                return true; // La actualización fue exitosa
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoReportePdfSeco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarRecursos();
        }
        return false;
    }

    public static boolean eliminar(int id) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM certificadopdfseco WHERE idCertificadoSeco=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

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
