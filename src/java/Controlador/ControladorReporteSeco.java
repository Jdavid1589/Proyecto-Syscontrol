package Controlador;

import Modelo.CaracteristicasFisicas;
import Modelo.CertificadoProductoSeco;
import Modelo.Color;

import Modelo.Dtp;

import Modelo.ReportePdfSeco;
import Modelo.Variable;


import Persistencia.DaoReportePdfSeco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GenerarPdf2;

//import util.Generarpdf;
public class ControladorReporteSeco extends HttpServlet {

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
                request.getRequestDispatcher("Vistas/RegistroReporteSeco.jsp").forward(request, response);
                break;

            case "registrar":
                registrarReportePDF(request, response);
                break;

            case "listar":
                listarCertificadoSeco(request, response);
                break;

            case "editarEspecif":
                request.setAttribute("idEditar", request.getParameter("id"));
                request.getRequestDispatcher("Vistas/EditarEspSeco.jsp").forward(request, response);
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

            ReportePdfSeco reportepdfseco = new ReportePdfSeco();

            // Se carga el objeto
            reportepdfseco.setProducto(request.getParameter("productos"));
            reportepdfseco.setFechaCertificado(request.getParameter("fechaCertificado"));
            reportepdfseco.setCliente(request.getParameter("cliente"));
            reportepdfseco.setNumCertificado(request.getParameter("numCertificado"));
            reportepdfseco.setFechaProduccion(request.getParameter("fechaProduccion"));
            reportepdfseco.setCantidadSacos(request.getParameter("CantidadSacos"));
            reportepdfseco.setLote(request.getParameter("lote"));
            reportepdfseco.setHumedad(request.getParameter("humedad"));
            reportepdfseco.setpH(request.getParameter("pH"));
            reportepdfseco.setRetenido325(request.getParameter("retenido325"));
            reportepdfseco.setAA(request.getParameter("AA"));
            reportepdfseco.setBr(request.getParameter("Br"));
            reportepdfseco.setWh(request.getParameter("Wh"));
            reportepdfseco.setYell(request.getParameter("Yell"));
            reportepdfseco.setDv50(request.getParameter("Dv50"));
            reportepdfseco.setAuxiliar(request.getParameter("Auxiliar"));

            //. Cargamos la List variables
            List<Variable> variables = new ArrayList<Variable>();

            Variable variable1 = new Variable(request.getParameter("variableEsp1"), request.getParameter("rango1"));
            Variable variable2 = new Variable(request.getParameter("variableEsp2"), request.getParameter("rango2"));
            Variable variable3 = new Variable(request.getParameter("variableEsp3"), request.getParameter("rango3"));
            Variable variable4 = new Variable(request.getParameter("variableEsp4"), request.getParameter("rango4"));
            Variable variable5 = new Variable(request.getParameter("variableEsp5"), request.getParameter("rango5"));
            Variable variable6 = new Variable(request.getParameter("variableEsp6"), request.getParameter("rango6"));
            Variable variable7 = new Variable(request.getParameter("variableEsp7"), request.getParameter("rango7"));
            Variable variable8 = new Variable(request.getParameter("variableEsp8"), request.getParameter("rango8"));
            // . Agragamos la informacion al asvariables
            variables.add(variable1);
            variables.add(variable2);
            variables.add(variable3);
            variables.add(variable4);
            variables.add(variable5);
            variables.add(variable6);
            variables.add(variable7);
            variables.add(variable8);

            reportepdfseco.setVariables(variables);

            //Metodo para cargar la informacion para el PDF
            //--------
            try {
                //. Cargamos el obejeto certificadoProductoSeco
                CertificadoProductoSeco certificadoProductoSeco = new CertificadoProductoSeco();
                certificadoProductoSeco.setProducto(request.getParameter("productos"));
                certificadoProductoSeco.setFechaGeneracion(request.getParameter("fechaCertificado"));
                certificadoProductoSeco.setCliente(request.getParameter("cliente"));
                certificadoProductoSeco.setNoCertificado(request.getParameter("numCertificado"));
                certificadoProductoSeco.setFechaProduccion(request.getParameter("fechaProduccion"));
                certificadoProductoSeco.setCantidadSacos(request.getParameter("CantidadSacos"));
                certificadoProductoSeco.setLote(request.getParameter("lote"));
                certificadoProductoSeco.setAuxiliar(request.getParameter("Auxiliar"));

                //.Variables de Instancia 
                String producto = request.getParameter("productos");
                //String producto2 = request.getParameter("productos");
                String cliente = request.getParameter("cliente");

                switch (producto) {

                    case "OPTIMIN P1015":
                    case "OPTIMIN P1025":
                    case "OPTIMIN P1090":

                        // Realizar el split solo para productos OPTIMIN
                        String[] partesProducto = producto.split(" ");
                        String primeraPalabra = partesProducto[0];

                        if (primeraPalabra != null && primeraPalabra.startsWith("OPTIMIN")) {
                            // Lógica común para todos los productos OPTIMIN

                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicas> caracteriticas = new ArrayList<>();
                            // colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                            caracteriticas.add(new CaracteristicasFisicas(variable1, request.getParameter("humedad")));
                            // caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicas(variable3, request.getParameter("AA")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoSeco.setListCarFisc(caracteriticas);

                            List<Color> colors = new ArrayList<>();

                            colors.add(new Color(variable4.getTipo(), variable4.getRango(), request.getParameter("Wh")));

                            //.Variable Global
                            certificadoProductoSeco.setListColor(colors);

                            List<Dtp> dtps = new ArrayList<>();
                            dtps.add(new Dtp(request.getParameter("variableEsp5"), request.getParameter("rango5"), request.getParameter("Dv50")));
                            certificadoProductoSeco.setListDtps(dtps);

                            if (producto.equals("OPTIMIN P1090")) {

                                // se puede cambiar alguno en ´particular
                            } else if (producto.equals("OPTIMIN P1016")) {
                                // Lógica específica para OPTIMIN P1016

                            } else if (producto.equals("OPTIMIN P1017")) {
                                // Lógica específica para OPTIMIN P1017

                            }

                            // Más lógica común para todos los productos OPTIMIN
                        }
                        break;

                    // <editor-fold defaultstate="collapsed" desc="* Case  CAOMIN P1050 ">
                    case "OPTIMIN P1050":
                        if (producto != null && producto.equals("OPTIMIN P1050")) {

                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicas> caracteriticas = new ArrayList<>();

                            caracteriticas.add(new CaracteristicasFisicas(variable1, request.getParameter("humedad")));
                            // caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicas(variable3, request.getParameter("AA")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoSeco.setListCarFisc(caracteriticas);

                            List<Color> colors = new ArrayList<>();

                            colors.add(new Color(variable4.getTipo(), variable4.getRango(), request.getParameter("Br")));

                            //.Variable Global
                            certificadoProductoSeco.setListColor(colors);

                            // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                            List<Dtp> dtps = new ArrayList<>();
                            dtps.add(new Dtp(request.getParameter("variableEsp5"), request.getParameter("rango5"), request.getParameter("Dv50")));
                            certificadoProductoSeco.setListDtps(dtps);

                        }
                        break;
                    // </editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="*Case 2 CAOMIN C08-20 ">
                    case "CAOMIN C08-20":
                        if (cliente != null && cliente.equals("CORLANC")) {

                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicas> caracteriticas = new ArrayList<>();
                            caracteriticas.add(new CaracteristicasFisicas(variable1, request.getParameter("humedad")));
                            caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicas(variable3, request.getParameter("retenido325")));
                            // caracteriticas.add(new CaracteristicasFisicas(variable4, request.getParameter("AA")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoSeco.setListCarFisc(caracteriticas);

                            // 3.Seteamos los atributos del objeto  colors
                            List<Color> colors = new ArrayList<>();

                            // Validación basada en si variable5 es igual a "% Brightness" o no
                            //  if (variable4.getTipo() != null && variable4.getTipo().equals("Whiteness, %")) {
                            colors.add(new Color(variable4.getTipo(), variable4.getRango(), request.getParameter("wh")));

                            // Seteamos la lista de colors en certificadoProductoSeco
                            certificadoProductoSeco.setListColor(colors);

                            // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                            List<Dtp> dtps = new ArrayList<>();
                            dtps.add(new Dtp(request.getParameter("variableEsp5"), request.getParameter("rango5"), request.getParameter("Dv50")));
                            certificadoProductoSeco.setListDtps(dtps);

                            //.Variable Global
                            certificadoProductoSeco.setListColor(colors);

                        }
                        break;
                    // </editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="* Case 3 CAOMIN C055-20 ">
                    case "CAOMIN C055-20":
                        if (!cliente.equals("Corlanc")) {
                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicas> caracteriticas = new ArrayList<>();

                            caracteriticas.add(new CaracteristicasFisicas(variable1, request.getParameter("humedad")));
                            caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicas(variable3, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicas(variable4, request.getParameter("AA")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoSeco.setListCarFisc(caracteriticas);

                            // 3.Seteamos los atributos del objeto  colors
                            List<Color> colors = new ArrayList<>();

                            // 1. Validación 
                            if (variable6.getTipo() != null && variable6.getTipo().equals("% Whiteness")) {
                                colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                                colors.add(new Color(variable6.getTipo(), variable6.getRango(), request.getParameter("Wh")));

                                // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                                List<Dtp> dtps = new ArrayList<>();
                                dtps.add(new Dtp(request.getParameter("variableEsp7"), request.getParameter("rango7"), request.getParameter("Dv50")));
                                certificadoProductoSeco.setListDtps(dtps);
                            } else {
                                // Si variable5 no es "% Brightness", agregamos tanto variable5 como variable6 a colors
                                colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                                // colors.add(new Color(variable6.getTipo(), variable6.getRango(), request.getParameter("Wh")));

                                // Agregamos un nuevo Dtp para variable7
                                List<Dtp> dtps = new ArrayList<>();
                                dtps.add(new Dtp(request.getParameter("variableEsp6"), request.getParameter("rango6"), request.getParameter("Dv50")));
                                certificadoProductoSeco.setListDtps(dtps);
                            }

                            // . Seteamos la lista de colors en certificadoProductoSeco
                            certificadoProductoSeco.setListColor(colors);
                        }
                        break;
                    // </editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="* Case 4 CAOMIN P055 ">
                    case "CAOMIN P055":
                        if (producto.equals("CAOMIN P055")) {
                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicas> caracteriticas = new ArrayList<>();

                            // colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                            caracteriticas.add(new CaracteristicasFisicas(variable1, request.getParameter("humedad")));
                            caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicas(variable3, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicas(variable4, request.getParameter("AA")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoSeco.setListCarFisc(caracteriticas);

                            // 3.Seteamos los atributos del objeto  colors
                            List<Color> colors = new ArrayList<>();

                            //.  Validación basada en si variable5 es igual a "% Brightness" 
                            if (variable5.getTipo() != null && variable5.getTipo().equals("% Brightness")) {
                                colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));

                                // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                                List<Dtp> dtps = new ArrayList<>();
                                dtps.add(new Dtp(request.getParameter("variableEsp6"), request.getParameter("rango6"), request.getParameter("Dv50")));
                                certificadoProductoSeco.setListDtps(dtps);
                            } else {
                                // Si variable5 no es "% Brightness", agregamos tanto variable5 como variable6 a colors
                                colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                                colors.add(new Color(variable6.getTipo(), variable6.getRango(), request.getParameter("Wh")));

                                // Agregamos un nuevo Dtp para variable7
                                List<Dtp> dtps = new ArrayList<>();
                                dtps.add(new Dtp(request.getParameter("variableEsp7"), request.getParameter("rango7"), request.getParameter("Dv50")));
                                certificadoProductoSeco.setListDtps(dtps);
                            }

                            //.Variable Global
                            certificadoProductoSeco.setListColor(colors);
                        }
                        break;
                    // </editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="* Case 5 CAOMIN <>  ">
                    default:
                        if (!producto.equals("CAOMIN C08-20") && !producto.equals("CAOMIN C055-20") && !producto.equals("CAOMIN P055")) {
                            // 2. Seteamos los atributos del objeto  caracteriticas
                            List<CaracteristicasFisicas> caracteriticas = new ArrayList<>();

                            // colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                            caracteriticas.add(new CaracteristicasFisicas(variable1, request.getParameter("humedad")));
                            caracteriticas.add(new CaracteristicasFisicas(variable2, request.getParameter("pH")));
                            caracteriticas.add(new CaracteristicasFisicas(variable3, request.getParameter("retenido325")));
                            caracteriticas.add(new CaracteristicasFisicas(variable4, request.getParameter("AA")));

                            //Setamos el ListCarFis para cargar la informacion
                            certificadoProductoSeco.setListCarFisc(caracteriticas);

                            // 3.Seteamos los atributos del objeto  colors
                            List<Color> colors = new ArrayList<>();

                            //.  Validación basada en si variable5 es igual a "% Brightness" 
                            if (variable5.getTipo() != null && variable5.getTipo().equals("% Brightness")) {
                                colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));

                                // Si variable5 es "% Brightness", agregamos un nuevo Dtp
                                List<Dtp> dtps = new ArrayList<>();
                                dtps.add(new Dtp(request.getParameter("variableEsp6"), request.getParameter("rango6"), request.getParameter("Dv50")));
                                certificadoProductoSeco.setListDtps(dtps);
                            } else {
                                // Si variable5 no es "% Brightness", agregamos tanto variable5 como variable6 a colors
                                colors.add(new Color(variable5.getTipo(), variable5.getRango(), request.getParameter("Br")));
                                colors.add(new Color(variable6.getTipo(), variable6.getRango(), request.getParameter("Wh")));

                                // Agregamos un nuevo Dtp para variable7
                                List<Dtp> dtps = new ArrayList<>();
                                dtps.add(new Dtp(request.getParameter("variableEsp7"), request.getParameter("rango7"), request.getParameter("Dv50")));
                                certificadoProductoSeco.setListDtps(dtps);
                            }

                            //.Variable Global
                            certificadoProductoSeco.setListColor(colors);
                        }
                }
                // </editor-fold>

                new GenerarPdf2().generarPdf(certificadoProductoSeco);

                if (DaoReportePdfSeco.grabar(reportepdfseco)) {
                    request.setAttribute("mensaje", "Reporte PDF Creado Con  Exitoso");
                } else {
                    request.setAttribute("mensaje", "Error! no se Registro, validar campos ingresados");
                }

                listarCertificadoSeco(request, response);
                //  request.getRequestDispatcher("index3.jsp").forward(request, response);

            } catch (Exception ex) {
                ex.printStackTrace();
                // request.setAttribute("mensaje", "Error al registrar  la Especificacion");
                listarCertificadoSeco(request, response);
                //  request.getRequestDispatcher("index3.jsp").forward(request, response);

            }

           // listarCertificadoSeco(request, response);

        } catch (IOException | ServletException ex) {

         //   listarCertificadoSeco(request, response);

        }
  
    }

    private void listarCertificadoSeco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            List<ReportePdfSeco> lt = DaoReportePdfSeco.listar();
            request.setAttribute("listaPdfSeco", lt);
            request.getRequestDispatcher("Vistas/ListarPdfSeco.jsp").forward(request, response);
            // request.getRequestDispatcher("index3.jsp").forward(request, response);
        } catch (IOException | ServletException ex) {
            request.setAttribute("mensaje", "Error al listar los Consecutivos");
            // request.getRequestDispatcher("Vistas/ListarPdfSeco.jsp").forward(request, response);
            request.getRequestDispatcher("index3.jsp").forward(request, response);
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
        } catch (IOException | NumberFormatException | ServletException ex) {
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
