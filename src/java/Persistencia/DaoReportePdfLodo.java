package Persistencia;

import Modelo.ReportePdfLodo;
import Modelo.ReportePdfSeco;
import Modelo.Variable;
import Modelo.VariablesPL;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReportePdfLodo {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static ReportePdfSeco reportePdfSeco = new ReportePdfSeco();

    public static boolean grabar(ReportePdfLodo reportePdfLodo) {
        try {
            con = dao.conectar();

            String sql = "INSERT INTO certificadopdflodo(producto, fechaCertificado, cliente, numCertificado, numRemision, cantidadKg, " //6
                    + "lote, Solidos, humedad, pH, densidadg, densidadkggal, viscosidadCp, viscosidadKu, ufc, retenido325, AA, Br,  Wh,  Yell,  Dv50,  Auxiliar,  " //16
                    + "variableEsp1, variableEsp2,  variableEsp3, " //3
                    + "variableEsp4 , variableEsp5 , variableEsp6 ,  variableEsp7 ,  variableEsp8 , variableEsp9 , variableEsp10 , variableEsp11 ," //8
                    + "rango1 ,  rango2 , rango3 , rango4 ,  rango5 , " // 5
                    + "rango6 , rango7, rango8, rango9, rango10, rango11, " //6
                    + "metodo1, metodo2, metodo3, metodo4, metodo5, metodo6, metodo7, metodo8, " //8
                    + "metodo9, metodo10, metodo11) " //3   Total = 55
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?," //12
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," // 18
                    + "?,?,?,?,?,?,?,?,?,?,?," // 11
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?);"; //14 Total:55

            ps = con.prepareStatement(sql);

            ps.setString(1, reportePdfLodo.getProducto());
            ps.setString(2, reportePdfLodo.getFechaCertificado());
            ps.setString(3, reportePdfLodo.getCliente());
            ps.setString(4, reportePdfLodo.getNumCertificado());
            ps.setString(5, reportePdfLodo.getNumRemision());
            ps.setString(6, reportePdfLodo.getCantidadKg());
            ps.setString(7, reportePdfLodo.getLote());
            ps.setString(8, reportePdfLodo.getSolidos());
            ps.setString(9, reportePdfLodo.getHumedad()); // Corregido a 7      
            ps.setString(10, reportePdfLodo.getpH());
            ps.setString(11, reportePdfLodo.getDensidadg());
            ps.setString(12, reportePdfLodo.getDensidadkggal());
            ps.setString(13, reportePdfLodo.getViscosidadCp());
            ps.setString(14, reportePdfLodo.getViscosidadKu());
            ps.setString(15, reportePdfLodo.getUfc());
            ps.setString(16, reportePdfLodo.getRetenido325());
            ps.setString(17, reportePdfLodo.getAA());
            ps.setString(18, reportePdfLodo.getBr());
            ps.setString(19, reportePdfLodo.getWh());
            ps.setString(20, reportePdfLodo.getYell());
            ps.setString(21, reportePdfLodo.getDv50());
            ps.setString(22, reportePdfLodo.getAuxiliar());

            List<VariablesPL> variables = reportePdfLodo.getVariablesPL();

            // Establecer los valores de las variables y sus rangos dinámicamente
            // Establecer los valores de las variables, sus rangos y métodos dinámicamente
            for (int i = 0; i < variables.size(); i++) {
                VariablesPL variable = variables.get(i);
                int baseIndex = 23 + i * 3; // Índice base para la variable actual

                // Establecer el tipo de variable
                ps.setString(baseIndex, variable.getTipo());

                // Establecer el rango de la variable
                ps.setString(baseIndex + 1, variable.getRango());

                // Establecer el método de la variable
                ps.setString(baseIndex + 2, variable.getMetodo());
            }
            /* for (int i = 0; i < variables.size(); i++) {
                VariablesPL variable = variables.get(i);
                ps.setString(23 + i * 2, variable.getTipo());
                ps.setString(23 + i * 2 + 1, variable.getRango());
                ps.setString(23 + i * 2 + 2, variable.getMetodo());
            }*/

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
    public static List<ReportePdfLodo> listar() {
        List<ReportePdfLodo> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM certificadopdflodo;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                ReportePdfLodo reportePdfLodo = new ReportePdfLodo();

                reportePdfLodo.setIdCertificadoLodo(rs.getInt("idCertificadoLodo"));
                reportePdfLodo.setProducto(rs.getString("producto"));
                reportePdfLodo.setFechaCertificado(rs.getString("fechaCertificado"));
                reportePdfLodo.setCliente(rs.getString("cliente"));
                reportePdfLodo.setNumCertificado(rs.getString("numCertificado"));
                reportePdfLodo.setNumRemision(rs.getString("numRemision"));
                reportePdfLodo.setCantidadKg(rs.getString("CantidadKg"));
                reportePdfLodo.setLote(rs.getString("lote"));
                reportePdfLodo.setSolidos(rs.getString("solidos"));
                reportePdfLodo.setHumedad(rs.getString("humedad"));
                reportePdfLodo.setDensidadg(rs.getString("densidadg"));
                reportePdfLodo.setDensidadkggal(rs.getString("densidadkggal"));
                reportePdfLodo.setViscosidadCp(rs.getString("viscosidadCp"));
                reportePdfLodo.setViscosidadKu(rs.getString("viscosidadKu"));
                reportePdfLodo.setpH(rs.getString("pH"));
                reportePdfLodo.setRetenido325(rs.getString("retenido325"));
                reportePdfLodo.setUfc(rs.getString("ufc"));
                reportePdfLodo.setAA(rs.getString("AA"));
                reportePdfLodo.setBr(rs.getString("Wh"));
                reportePdfLodo.setWh(rs.getString("AA"));
                reportePdfLodo.setYell(rs.getString("Yell"));
                reportePdfLodo.setDv50(rs.getString("Dv50"));
                reportePdfLodo.setAuxiliar(rs.getString("Auxiliar"));

                // Recuperar las variables y sus rangos
                List<VariablesPL> variables = new ArrayList<>();
                for (int i = 1; i <= 11; i++) { // Suponiendo que tienes hasta 11 pares de variables y rangos
                    String tipo = rs.getString("variableEsp" + i);
                    String rango = rs.getString("rango" + i);
                    String metodo = rs.getString("metodo" + i);
                    if (tipo != null && rango != null && metodo != null) {
                        VariablesPL variable = new VariablesPL(tipo, rango, metodo);
                        variables.add(variable);
                    }
                }
                reportePdfLodo.setVariablesPL(variables);

                lista.add(reportePdfLodo);
            }
        } catch (Exception e) {
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

   
    //Editar modificado
    public static boolean editar(ReportePdfLodo reportePdfLodo) {
        try {
            con = dao.conectar();

            String sql = "UPDATE certificadopdflodo SET producto= ?, fechaCertificado= ?, cliente= ?, numCertificado= ?, numRemision= ?, CantidadKg= ?, "
                    + "lote= ?, humedad= ?, pH = ?,  retenido325= ?, AA= ?, Br= ?,  Wh= ?,  Yell= ?,  Dv50= ?,  Auxiliar= ?,  variableEsp1= ?, variableEsp2= ?,  variableEsp3= ?, "
                    + "variableEsp4 = ?, variableEsp5= ?, variableEsp6 = ?,  variableEsp7 = ?,  variableEsp8= ?,  rango1= ?,  rango2= ?, rango3= ?, rango4= ?,  rango5= ?, "
                    + "rango6 = ?, rango7= ?, rango8= ? "
                    + "WHERE idCertificadoLodo = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, reportePdfLodo.getProducto());
            ps.setString(2, reportePdfLodo.getFechaCertificado());
            ps.setString(3, reportePdfLodo.getCliente());
            ps.setString(4, reportePdfLodo.getNumCertificado());
            ps.setString(5, reportePdfLodo.getNumRemision());
            ps.setString(6, reportePdfLodo.getCantidadKg());
            ps.setString(7, reportePdfLodo.getLote());
            ps.setString(8, reportePdfLodo.getHumedad());
            ps.setString(9, reportePdfLodo.getpH());
            ps.setString(10, reportePdfLodo.getRetenido325());
            ps.setString(11, reportePdfLodo.getAA());
            ps.setString(12, reportePdfLodo.getBr());
            ps.setString(13, reportePdfLodo.getWh());
            ps.setString(14, reportePdfLodo.getYell());
            ps.setString(15, reportePdfLodo.getDv50());
            ps.setString(16, reportePdfLodo.getAuxiliar());

            List<VariablesPL> variables = reportePdfLodo.getVariablesPL();

            for (int i = 0; i < variables.size(); i++) {
                VariablesPL variable = variables.get(i);
                ps.setString(17 + i * 2, variable.getTipo());
                ps.setString(17 + i * 2 + 1, variable.getRango());
            }

            ps.setInt(33, reportePdfLodo.getIdCertificadoLodo());

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
