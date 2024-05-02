package Controlador;

import Modelo.CaracteristicasFisicas;
import Modelo.CaracteristicasFisicasPL;
import Modelo.CertificadoProductoLodo;
import Modelo.CertificadoProductoSeco;
import Modelo.Color;
import Modelo.ColorLodo;
import Modelo.ControlSeco;
import Modelo.Dtp;
import Modelo.DtpLodo;
import Modelo.ReportePdfLodo;

import Modelo.ReportePdfSeco;
import Modelo.Variable;
import Modelo.VariablesPL;
import Persistencia.DaoReportePdfLodo;

import Persistencia.DaoReportePdfSeco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GenerarPdf2;
import util.GenerarPdfLodo;

//import util.Generarpdf;
public class ControladorReporteLodo extends HttpServlet {

    ReportePdfSeco reportePdfSeco = new ReportePdfSeco();

    int ide;  // Variable de instancia para almacenar el ID

    //La variable serialVersionUID se utiliza en Java para asignar una versión única 
    //a una clase Serializable.
    //En este contexto, private static final long serialVersionUID = 1L; simplemente está estableciendo 
    //el serialVersionUID de la clase ControladorConsecutivo
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("accion");

        switch (action) {
            case "add":
                request.getRequestDispatcher("Vistas/RegistroReporteLodos.jsp").forward(request, response);
                break;

            case "registrar":
                registrarReportePDF(request, response);
                break;

            case "listar":
                listarCertificadoSeco(request, response);
                break;

            case "editarEspecif":
                request.setAttribute("idEditar", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/EditarEspLodos.jsp").forward(request, response);
                break;

            case "eliminar":

                eliminarReporte(request, response);
                break;

            default:

                break;
        }
    }

//Metodo Registrar
    private void registrarReportePDF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ReportePdfLodo reportepdfLodo = new ReportePdfLodo();

            // Se carga el objeto
            reportepdfLodo.setProducto(request.getParameter("productos"));
            reportepdfLodo.setCliente(request.getParameter("cliente"));
            reportepdfLodo.setNumCertificado(request.getParameter("numCertificado"));
            reportepdfLodo.setFechaCertificado(request.getParameter("fechaCertificado"));
            reportepdfLodo.setNumRemision(request.getParameter("numRemision"));
            reportepdfLodo.setCantidadKg(request.getParameter("CantidadKg"));
            reportepdfLodo.setLote(request.getParameter("lote"));
            reportepdfLodo.setSolidos(request.getParameter("Solidos"));
            reportepdfLodo.setHumedad(request.getParameter("humedad"));
            reportepdfLodo.setpH(request.getParameter("pH"));
            reportepdfLodo.setDensidadg(request.getParameter("densidadg"));
            reportepdfLodo.setDensidadkggal(request.getParameter("densidadkggal"));
            reportepdfLodo.setViscosidadCp(request.getParameter("viscosidadCp"));
            reportepdfLodo.setViscosidadKu(request.getParameter("viscosidadKu"));
            reportepdfLodo.setRetenido325(request.getParameter("retenido325"));
            reportepdfLodo.setUfc(request.getParameter("ufc"));
            reportepdfLodo.setAA(request.getParameter("AA"));
            reportepdfLodo.setBr(request.getParameter("Br"));
            reportepdfLodo.setWh(request.getParameter("Wh"));
            reportepdfLodo.setYell(request.getParameter("Yell"));
            reportepdfLodo.setDv50(request.getParameter("Dv50"));
            reportepdfLodo.setDv90(request.getParameter("Dv90"));
            reportepdfLodo.setAuxiliar(request.getParameter("Auxiliar"));

            //. Cargamos la List variables
            List<VariablesPL> variables = new ArrayList<VariablesPL>();
            VariablesPL variable1 = new VariablesPL(request.getParameter("variableEsp1"), request.getParameter("rango1"), request.getParameter("metodo1"));
            VariablesPL variable2 = new VariablesPL(request.getParameter("variableEsp2"), request.getParameter("rango2"), request.getParameter("metodo2"));
            VariablesPL variable3 = new VariablesPL(request.getParameter("variableEsp3"), request.getParameter("rango3"), request.getParameter("metodo3"));
            VariablesPL variable4 = new VariablesPL(request.getParameter("variableEsp4"), request.getParameter("rango4"), request.getParameter("metodo4"));
            VariablesPL variable5 = new VariablesPL(request.getParameter("variableEsp5"), request.getParameter("rango5"), request.getParameter("metodo5"));
            VariablesPL variable6 = new VariablesPL(request.getParameter("variableEsp6"), request.getParameter("rango6"), request.getParameter("metodo6"));
            VariablesPL variable7 = new VariablesPL(request.getParameter("variableEsp7"), request.getParameter("rango7"), request.getParameter("metodo7"));
            VariablesPL variable8 = new VariablesPL(request.getParameter("variableEsp8"), request.getParameter("rango8"), request.getParameter("metodo8"));
            VariablesPL variable9 = new VariablesPL(request.getParameter("variableEsp9"), request.getParameter("rango9"), request.getParameter("metodo9"));
            VariablesPL variable10 = new VariablesPL(request.getParameter("variableEsp10"), request.getParameter("rango10"), request.getParameter("metodo10"));
            VariablesPL variable11 = new VariablesPL(request.getParameter("variableEsp11"), request.getParameter("rango11"), request.getParameter("metodo11"));

            // . Agragamos la informacion al asvariables
            variables.add(variable1);
            variables.add(variable2);
            variables.add(variable3);
            variables.add(variable4);
            variables.add(variable5);
            variables.add(variable6);
            variables.add(variable7);
            variables.add(variable8);
            variables.add(variable9);
            variables.add(variable10);
            variables.add(variable11);

            reportepdfLodo.setVariablesPL(variables);

            //Metodo para cargar la informacion para el PDF
            //--------
            try {
                //. Cargamos el obejeto certificadoProductoLodo

                CertificadoProductoLodo certificadoProductoLodo = new CertificadoProductoLodo();

                certificadoProductoLodo.setProducto(request.getParameter("productos"));
                certificadoProductoLodo.setFechaGeneracion(request.getParameter("fechaCertificado"));
                certificadoProductoLodo.setCliente(request.getParameter("cliente"));
                certificadoProductoLodo.setNoCertificado(request.getParameter("numCertificado"));
                certificadoProductoLodo.setNoremision(request.getParameter("numRemision"));
                certificadoProductoLodo.setCantidadkg(request.getParameter("CantidadKg"));
                certificadoProductoLodo.setLote(request.getParameter("lote"));
                certificadoProductoLodo.setAuxiliar(request.getParameter("Auxiliar"));

                //.Variables de Instancia 
                String producto = request.getParameter("productos");
                //String producto2 = request.getParameter("productos");
                String cliente = request.getParameter("cliente");

                switch (producto) {

                    case "OPTIMIN EXTEND MAX V5":

                        // <editor-fold defaultstate="collapsed" desc="* Case  OPTIMIN EXTEND MAX V5 ">
                        if (producto != null && producto.equals("OPTIMIN EXTEND MAX V5")) {
                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicasPL> caracteriticas = new ArrayList<>();

                            caracteriticas.add(new CaracteristicasFisicasPL(variable1, request.getParameter("Solidos")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable2, request.getParameter("densidadg")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable3, request.getParameter("densidadkggal")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable4, request.getParameter("viscosidadKu")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable5, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable6, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable7, request.getParameter("ufc")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoLodo.setListCarFisc(caracteriticas);

                            List<ColorLodo> colors = new ArrayList<>();

                            colors.add(new ColorLodo(variable8.getTipo(), variable8.getRango(), variable8.getMetodo(), request.getParameter("Br")));
                            colors.add(new ColorLodo(variable9.getTipo(), variable9.getRango(), variable9.getMetodo(), request.getParameter("Wh")));

                            //.Variable Global
                            certificadoProductoLodo.setListColor(colors);

                            /*  // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                            List<DtpLodo> dtps = new ArrayList<>();
                            dtps.add(new DtpLodo(request.getParameter("variableEsp10"), request.getParameter("rango10"), request.getParameter("metodo10"), request.getParameter("Dv50")));
                            dtps.add(new DtpLodo(request.getParameter("variableEsp11"), request.getParameter("rango1"), request.getParameter("metodo11"), request.getParameter("Dv90")));
                            certificadoProductoLodo.setListDtps(dtps);*/
                        }
                        break;
                    // </editor-fold>
                    /* .    ----------      */

                    case "OPTIMIN L1117":

                        // <editor-fold defaultstate="collapsed" desc="* Case  OPTIMIN L1117 ">
                        if (producto != null && producto.equals("OPTIMIN L1117")) {

                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicasPL> caracteriticas = new ArrayList<>();

                            caracteriticas.add(new CaracteristicasFisicasPL(variable1, request.getParameter("Solidos")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable2, request.getParameter("densidadg")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable3, request.getParameter("densidadkggal")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable4, request.getParameter("viscosidadKu")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable5, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable6, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable7, request.getParameter("ufc")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoLodo.setListCarFisc(caracteriticas);

                            List<ColorLodo> colors = new ArrayList<>();

                            colors.add(new ColorLodo(variable8.getTipo(), variable8.getRango(), variable8.getMetodo(), request.getParameter("Br")));
                            colors.add(new ColorLodo(variable9.getTipo(), variable9.getRango(), variable9.getMetodo(), request.getParameter("Wh")));

                            //.Variable Global
                            certificadoProductoLodo.setListColor(colors);

                            // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                            List<DtpLodo> dtps = new ArrayList<>();
                            dtps.add(new DtpLodo(request.getParameter("variableEsp10"), request.getParameter("rango10"), request.getParameter("metodo10"), request.getParameter("Dv50")));
                            dtps.add(new DtpLodo(request.getParameter("variableEsp11"), request.getParameter("rango1"), request.getParameter("metodo11"), request.getParameter("Dv90")));
                            certificadoProductoLodo.setListDtps(dtps);

                        }
                        break;
                    // </editor-fold>
                    /* .    ----------      */

                    case "CAOMIN L055":

                        // <editor-fold defaultstate="collapsed" desc="* Case  OPTIMIN L1117 ">
                        if (producto != null && producto.equals("CAOMIN L055")) {

                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicasPL> caracteriticas = new ArrayList<>();

                            caracteriticas.add(new CaracteristicasFisicasPL(variable1, request.getParameter("Solidos")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable2, request.getParameter("densidadg")));
                        //    caracteriticas.add(new CaracteristicasFisicasPL(variable3, request.getParameter("densidadkggal")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable3, request.getParameter("viscosidadCp")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable4, request.getParameter("viscosidadKu")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable5, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable6, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicasPL(variable7, request.getParameter("ufc")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoLodo.setListCarFisc(caracteriticas);

                            List<ColorLodo> colors = new ArrayList<>();

                        colors.add(new ColorLodo(variable8.getTipo(), variable8.getRango(), variable8.getMetodo(), request.getParameter("Br")));
                            colors.add(new ColorLodo(variable9.getTipo(), variable9.getRango(), variable9.getMetodo(), request.getParameter("Wh")));

                            //.Variable Global
                            certificadoProductoLodo.setListColor(colors);

                            // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                            List<DtpLodo> dtps = new ArrayList<>();
                            dtps.add(new DtpLodo(request.getParameter("variableEsp10"), request.getParameter("rango10"), request.getParameter("metodo10"), request.getParameter("Dv50")));
                          //  dtps.add(new DtpLodo(request.getParameter("variableEsp11"), request.getParameter("rango1"), request.getParameter("metodo11"), request.getParameter("Dv90")));
                            certificadoProductoLodo.setListDtps(dtps);

                        }
                        break;
                    // </editor-fold>
                    /* .    ----------      */

                }

                new GenerarPdfLodo().generarPdf(certificadoProductoLodo);

                if (DaoReportePdfLodo.grabar(reportepdfLodo)) {
                    request.setAttribute("mensaje", "Reporte PDF Creado Con  Exitoso");
                } else {
                    request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
                }
                

                listarCertificadoSeco(request, response);
               //request.getRequestDispatcher("index3.jsp").forward(request, response);

            } catch (Exception ex) {
                ex.printStackTrace();
                // request.setAttribute("mensaje", "Error al registrar  la Especificacion");
                 listarCertificadoSeco(request, response);
               // request.getRequestDispatcher("index3.jsp").forward(request, response);

            }

          //  listarCertificadoSeco(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();

           // listarCertificadoSeco(request, response);

        }
       
    }

    private void listarCertificadoSeco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            List<ReportePdfLodo> lt = DaoReportePdfLodo.listar();
            request.setAttribute("listaPdfLodo", lt);
            request.getRequestDispatcher("Vistas/ListarPdfLodo.jsp").forward(request, response);

            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
            request.getRequestDispatcher("Vistas/ListarPdfLodo.jsp").forward(request, response);
        }
    }

    private void eliminarReporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idReporte = Integer.parseInt(request.getParameter("id"));

            if (DaoReportePdfSeco.eliminar(idReporte)) {
                request.setAttribute("mensaje", "El Reporte fue Eliminado Correctamente");
            } else {
                request.setAttribute("mensaje", "No se pudo eliminar el Reporte");
            }

            listarCertificadoSeco(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el Registro");
            listarCertificadoSeco(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
