package util;

import Modelo.CaracteristicasFisicas;
import Modelo.CaracteristicasFisicasPL;
import Modelo.CertificadoProductoLodo;
import Modelo.CertificadoProductoSeco;
import Modelo.Color;
import Modelo.ColorLodo;
import Modelo.Dtp;
import Modelo.DtpLodo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GenerarPdfLodo {

    //Se crea un objeto vacio 
    private CertificadoProductoLodo certificadoProductoLodo;
    private static final AtomicInteger Serial = new AtomicInteger(0);
    private Document doc;
    private PdfWriter pdf;
    private Font fontBold = new Font(Font.FontFamily.COURIER, 13, Font.BOLD);
    private Font fontBold2 = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL);
    private Font fontBold4 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
    private Font fontBold3 = new Font(Font.FontFamily.HELVETICA, 5, Font.NORMAL);
    private Font fontBold6 = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL);
    BaseColor lightBlue = new BaseColor(173, 216, 230); // RGB para un azul más claro

    public void generarPdf(CertificadoProductoLodo certificadoProductoLodo) {

        this.certificadoProductoLodo = certificadoProductoLodo;

        try {
//Nombre del archivo PDF
            int numeroConsecutivo = Serial.incrementAndGet();
            FileOutputStream file = new FileOutputStream("C:/Certificadospdf/" + numeroConsecutivo + " ." + " "
                    + certificadoProductoLodo.getCliente() + "  " + certificadoProductoLodo.getProducto() + "  " + "Lote" + " " + certificadoProductoLodo.getLote() + ".pdf");

            doc = new Document(PageSize.LETTER, 36, 36, 10, 10);
            pdf = PdfWriter.getInstance(doc, file);
            doc.open();
            header();
            body();
            doc.close();
            file.close();
        } catch (Exception e) {
            // System.out.println("fallo Certificado ");
        }
    }

    private void header() {
        try {
            agregarSaltosDeLinea();

            //  Image logo = Image.getInstance("E:/User/Documents/NetBeansProjects/SyscontrolFinal3/web/logoMI.png");
            Image logo = Image.getInstance("C:/LogoMI/logoMI.png");
            logo.scaleToFit(160, 200);
            logo.setAlignment(Image.LEFT | Image.TEXTWRAP);

            //Image logoincontec = Image.getInstance("E:/User/Documents/NetBeansProjects/SyscontrolFinal3/web/logoincontec.png");
            Image logoincontec = Image.getInstance("C:/LogoMI/logoincontec.png");
            logoincontec.scaleToFit(160, 200);
            logoincontec.setAlignment(Image.RIGHT | Image.TEXTWRAP);

            doc.add(logo);
            doc.add(logoincontec);

            agregarSaltosDeLinea2();
            agregarSaltosDeLinea();
            agregarSaltosDeLinea();

            doc.add(addParagraf("CERTIFICADO DE CALIDAD", fontBold4, 0, 1));
            doc.add(addParagraf(certificadoProductoLodo.getProducto(), fontBold4, 0, 1));

            String c2[] = {"CLIENTE", certificadoProductoLodo.getCliente()};
            doc.add(addFila(getCells2(c2, fontBold4, 0), 20, 50));

            String c3[] = {"No Certificado", String.format("%04d", Integer.parseInt(certificadoProductoLodo.getNoCertificado()))};
            doc.add(addFila(getCells(c3, fontBold2, 0), 20, 50));

            String c1[] = {"FECHA : ", certificadoProductoLodo.getFechaGeneracion(),};
            doc.add(addFila(getCells(c1, fontBold2, 0), 0, 50));

            String c6[] = {"REMISION : ", certificadoProductoLodo.getNoremision(),};
            doc.add(addFila(getCells(c6, fontBold2, 0), 0, 50));

            String c5[] = {"Cantidad Kg", certificadoProductoLodo.getCantidadkg()};
            doc.add(addFila(getCells(c5, fontBold2, 0), 0, 50));

        } catch (Exception e) {
            //logger.error("GeneratePdf.generatePdf.header " + e.getMessage());
        }

    }

    //Metodos para ajustar el docuemnto de forma automatica
    public void body() {
        try {
            // Realizar el switch según el producto
            switch (certificadoProductoLodo.getProducto().trim()) {
                case "OPTIMIN L1117":

                    String c3[] = {"CARACTERISTICA", "ESPECIFICACION", "METODO DE ANALISIS", "VALOR"};
                    //   doc.add(addFila(getCells(c3, fontBold2, 0), 20, 100));
                    doc.add(addFila(getCells4(c3, fontBold4, 1), 20, 100));

                    String c4[] = {"LOTE", " ", " ", certificadoProductoLodo.getLote()};
                    doc.add(addFila(getCells(c4, fontBold2, 1), 0, 100));

                    String c10[] = {"PRESENTACION", "DISPERSION ACUOSA ", " ", " "};
                    doc.add(addFila(getCells(c10, fontBold4, 1), 0, 100));

                    String c5[] = {"CARACTRISTICAS FISICAS"};
                    doc.add(addFila(getCells4(c5, fontBold4, 1), 0, 100));
                    //doc.add(addFila(getCells3(c5, fontBold2, Element.ALIGN_LEFT, 0), 0, 100));

                    for (CaracteristicasFisicasPL caracteristicasFisicas : certificadoProductoLodo.getListCarFisc()) {
                        String c6[] = {caracteristicasFisicas.getVariablesPL().getTipo(), caracteristicasFisicas.getVariablesPL().getRango(), caracteristicasFisicas.getVariablesPL().getMetodo(), caracteristicasFisicas.getValor()};
                        doc.add(addFila(getCells(c6, fontBold2, 1), 0, 100));
                    }
                    String c7[] = {"COLOR"};
                    doc.add(addFila(getCells4(c7, fontBold4, 1), 0, 100));

                    for (ColorLodo color : certificadoProductoLodo.getListColor()) {
                        String c8[] = {color.getTipo(), color.getEspecificacion(), color.getMetodo(), color.getValor()};
                        doc.add(addFila(getCells(c8, fontBold2, 1), 0, 100));
                    }
                    // validacion

                    String c8[] = {"TAMAÑO DE PARTICULA"};
                    // doc.add(addFila(getCells(c8, fontBold2, 1), 0, 100));
                    doc.add(addFila(getCells4(c8, fontBold4, 1), 0, 100));

                    for (DtpLodo dtp : certificadoProductoLodo.getListDtps()) {
                        String c9[] = {dtp.getTipo(), dtp.getEspecificacion(), dtp.getMetodo(), dtp.getValor()};
                        doc.add(addFila(getCells(c9, fontBold2, 1), 0, 100));
                    }

                    doc.add(addParagraf("** Variables Informativas ", fontBold3, 10, 0));
                    doc.add(addParagraf("Nota: Lo metodos de analisis estan disponibles para quien los requiera", fontBold3, 10, 0));
                    doc.add(addParagraf(" Copia Mercadear y Vender", fontBold3, 10, 0));

                    doc.add(addParagraf(certificadoProductoLodo.getAuxiliar(), fontBold6, 20, 2));
                    doc.add(addParagraf(" Auxiliar De Calidad", fontBold3, 0, 2));

                    doc.add(addParagraf(" CRA 48 72SUR-01, AV LAS VEGAS TEL:(57) (604) 305 8200 FAX:(57) (604) 301 3712\n"
                            + "mercadeo@mineralesindustriales.com.co www.mineralesindustriales.com\n"
                            + "SABANETA – COLOMBIA - SURAMÉRICA", fontBold6, 50, 1));

                    break;
                    
                       case "OPTIMIN EXTEND MAX V5":

                    String c3_V5[] = {"CARACTERISTICA", "ESPECIFICACION", "METODO DE ANALISIS", "VALOR"};
                    //   doc.add(addFila(getCells(c3, fontBold2, 0), 20, 100));
                    doc.add(addFila(getCells4(c3_V5, fontBold4, 1), 20, 100));

                    String c4_V5[] = {"LOTE", " ", " ", certificadoProductoLodo.getLote()};
                    doc.add(addFila(getCells(c4_V5, fontBold2, 1), 0, 100));

                    String c10_V5[] = {"PRESENTACION", "DISPERSION ACUOSA ", " ", " "};
                    doc.add(addFila(getCells(c10_V5, fontBold4, 1), 0, 100));

                    String c5_V5[] = {"CARACTRISTICAS FISICAS"};
                    doc.add(addFila(getCells4(c5_V5, fontBold4, 1), 0, 100));
                    //doc.add(addFila(getCells3(c5, fontBold2, Element.ALIGN_LEFT, 0), 0, 100));

                    for (CaracteristicasFisicasPL caracteristicasFisicas : certificadoProductoLodo.getListCarFisc()) {
                        String c6_V5[] = {caracteristicasFisicas.getVariablesPL().getTipo(), caracteristicasFisicas.getVariablesPL().getRango(), caracteristicasFisicas.getVariablesPL().getMetodo(), caracteristicasFisicas.getValor()};
                        doc.add(addFila(getCells(c6_V5, fontBold2, 1), 0, 100));
                    }
                    String c7_V5[] = {"COLOR"};
                    doc.add(addFila(getCells4(c7_V5, fontBold4, 1), 0, 100));

                    for (ColorLodo color : certificadoProductoLodo.getListColor()) {
                        String c8_V5[] = {color.getTipo(), color.getEspecificacion(), color.getMetodo(), color.getValor()};
                        doc.add(addFila(getCells(c8_V5, fontBold2, 1), 0, 100));
                    }
          

                /*    String c8_V5[] = {"TAMAÑO DE PARTICULA"};
                    // doc.add(addFila(getCells(c8, fontBold2, 1), 0, 100));
                    doc.add(addFila(getCells4(c8_V5, fontBold4, 1), 0, 100));

                    for (DtpLodo dtp : certificadoProductoLodo.getListDtps()) {
                        String c9_V5[] = {dtp.getTipo(), dtp.getEspecificacion(), dtp.getMetodo(), dtp.getValor()};
                        doc.add(addFila(getCells(c9_V5, fontBold2, 1), 0, 100));
                    }*/

                    doc.add(addParagraf("** Variables Informativas ", fontBold3, 10, 0));
                    doc.add(addParagraf("Nota: Lo metodos de analisis estan disponibles para quien los requiera", fontBold3, 10, 0));
                    doc.add(addParagraf(" Copia Mercadear y Vender", fontBold3, 10, 0));

                    doc.add(addParagraf(certificadoProductoLodo.getAuxiliar(), fontBold6, 20, 2));
                    doc.add(addParagraf(" Auxiliar De Calidad", fontBold3, 0, 2));

                    doc.add(addParagraf(" CRA 48 72SUR-01, AV LAS VEGAS TEL:(57) (604) 305 8200 FAX:(57) (604) 301 3712\n"
                            + "mercadeo@mineralesindustriales.com.co www.mineralesindustriales.com\n"
                            + "SABANETA – COLOMBIA - SURAMÉRICA", fontBold6, 50, 1));

                    break;

                case "CAOMIN L055":
                    
                      String c3_L055[] = {"CARACTERISTICA", "ESPECIFICACION", "VALOR"};
                    //   doc.add(addFila(getCells(c3, fontBold2, 0), 20, 100));
                    doc.add(addFila(getCells4(c3_L055, fontBold4, 1), 20, 100));

                    String c4_L055[] = {"LOTE", " ", certificadoProductoLodo.getLote()};
                    doc.add(addFila(getCells(c4_L055, fontBold2, 1), 0, 100));

                    String c10_L055[] = {"PRESENTACION", "DISPERSION ACUOSA ", " "};
                    doc.add(addFila(getCells(c10_L055, fontBold4, 1), 0, 100));

                    String c5_L055[] = {"CARACTRISTICAS FISICAS"};
                    doc.add(addFila(getCells4(c5_L055, fontBold4, 1), 0, 100));
                    //doc.add(addFila(getCells3(c5, fontBold2, Element.ALIGN_LEFT, 0), 0, 100));

                    for (CaracteristicasFisicasPL caracteristicasFisicas : certificadoProductoLodo.getListCarFisc()) {
                        String c6_L055[] = {caracteristicasFisicas.getVariablesPL().getTipo(), caracteristicasFisicas.getVariablesPL().getRango(), caracteristicasFisicas.getValor()};
                        doc.add(addFila(getCells(c6_L055, fontBold2, 1), 0, 100));
                    }
                    String c7_L055[] = {"COLOR"};
                    doc.add(addFila(getCells4(c7_L055, fontBold4, 1), 0, 100));

                    for (ColorLodo color : certificadoProductoLodo.getListColor()) {
                        String c8_L055[] = {color.getTipo(), color.getEspecificacion(), color.getValor()};
                        doc.add(addFila(getCells(c8_L055, fontBold2, 1), 0, 100));
                    }
                    // validacion

                    String c8_L055[] = {"TAMAÑO DE PARTICULA"};
                    // doc.add(addFila(getCells(c8, fontBold2, 1), 0, 100));
                    doc.add(addFila(getCells4(c8_L055, fontBold4, 1), 0, 100));

                    for (DtpLodo dtp : certificadoProductoLodo.getListDtps()) {
                        String c9_L055[] = {dtp.getTipo(), dtp.getEspecificacion(), dtp.getValor()};
                        doc.add(addFila(getCells(c9_L055, fontBold2, 1), 0, 100));
                    }

                    doc.add(addParagraf("** Variables Informativas ", fontBold3, 10, 0));
                    doc.add(addParagraf("Nota: Lo metodos de analisis estan disponibles para quien los requiera", fontBold3, 10, 0));
                    doc.add(addParagraf(" Copia Mercadear y Vender", fontBold3, 10, 0));

                    doc.add(addParagraf(certificadoProductoLodo.getAuxiliar(), fontBold6, 20, 2));
                    doc.add(addParagraf(" Auxiliar De Calidad", fontBold3, 0, 2));

                    doc.add(addParagraf(" CRA 48 72SUR-01, AV LAS VEGAS TEL:(57) (604) 305 8200 FAX:(57) (604) 301 3712\n"
                            + "mercadeo@mineralesindustriales.com.co www.mineralesindustriales.com\n"
                            + "SABANETA – COLOMBIA - SURAMÉRICA", fontBold6, 50, 1));
                    
                case "ALGUN OTRO PRODUCTO":

                    break;

                default:
                    // No hay cambios adicionales en este caso
                    break;
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }

    /*  
                
                
            
            String c3[] = {"CARACTERISTICA", "ESPECIFICACION", "METODO DE ANALISIS", "VALOR"};
            //   doc.add(addFila(getCells(c3, fontBold2, 0), 20, 100));
            doc.add(addFila(getCells4(c3, fontBold4, 1), 20, 100));

            String c4[] = {"LOTE", " ", " ", certificadoProductoLodo.getLote()};
            doc.add(addFila(getCells(c4, fontBold2, 1), 0, 100));

            String c10[] = {"PRESENTACION", "DISPERSION ACUOSA ", " ", " "};
            doc.add(addFila(getCells(c10, fontBold4, 1), 0, 100));

            String c5[] = {"CARACTRISTICAS FISICAS"};
            doc.add(addFila(getCells4(c5, fontBold4, 1), 0, 100));
            //doc.add(addFila(getCells3(c5, fontBold2, Element.ALIGN_LEFT, 0), 0, 100));

            for (CaracteristicasFisicasPL caracteristicasFisicas : certificadoProductoLodo.getListCarFisc()) {
                String c6[] = {caracteristicasFisicas.getVariablesPL().getTipo(), caracteristicasFisicas.getVariablesPL().getRango(), caracteristicasFisicas.getVariablesPL().getMetodo(), caracteristicasFisicas.getValor()};
                doc.add(addFila(getCells(c6, fontBold2, 1), 0, 100));
            }
            String c7[] = {"COLOR"};
            doc.add(addFila(getCells4(c7, fontBold4, 1), 0, 100));

            for (ColorLodo color : certificadoProductoLodo.getListColor()) {
                String c8[] = {color.getTipo(), color.getEspecificacion(), color.getMetodo(), color.getValor()};
                doc.add(addFila(getCells(c8, fontBold2, 1), 0, 100));
            }
            // validacion
            if (certificadoProductoLodo.getProducto().equals("OPTIMIN L1117")
                    
                    || certificadoProductoLodo.getProducto().equals("OTRO PRODUCTO")
                    || certificadoProductoLodo.getProducto().equals("ALGUN OTRO PRODUCTO")) {

                String c8[] = {"TAMAÑO DE PARTICULA"};
                // doc.add(addFila(getCells(c8, fontBold2, 1), 0, 100));
                doc.add(addFila(getCells4(c8, fontBold4, 1), 0, 100));

                for (DtpLodo dtp : certificadoProductoLodo.getListDtps()) {
                    String c9[] = {dtp.getTipo(), dtp.getEspecificacion(), dtp.getMetodo(), dtp.getValor()};
                    doc.add(addFila(getCells(c9, fontBold2, 1), 0, 100));
                }

                doc.add(addParagraf("** Variables Informativas ", fontBold3, 10, 0));
                doc.add(addParagraf("Nota: Lo metodos de analisis estan disponibles para quien los requiera", fontBold3, 10, 0));
                doc.add(addParagraf(" Copia Mercadear y Vender", fontBold3, 10, 0));

                doc.add(addParagraf(certificadoProductoLodo.getAuxiliar(), fontBold6, 20, 2));
                doc.add(addParagraf(" Auxiliar De Calidad", fontBold3, 0, 2));

                doc.add(addParagraf(" CRA 48 72SUR-01, AV LAS VEGAS TEL:(57) (604) 305 8200 FAX:(57) (604) 301 3712\n"
                        + "mercadeo@mineralesindustriales.com.co www.mineralesindustriales.com\n"
                        + "SABANETA – COLOMBIA - SURAMÉRICA", fontBold6, 50, 1));
            } else {
                doc.add(addParagraf("** Variables Informativas ", fontBold3, 10, 0));
                doc.add(addParagraf("Nota: Lo metodos de analisis estan disponibles para quien los requiera", fontBold3, 10, 0));
                doc.add(addParagraf(" Copia Mercadear y Vender", fontBold3, 10, 0));

                doc.add(addParagraf(certificadoProductoLodo.getAuxiliar(), fontBold6, 20, 2));
                doc.add(addParagraf(" Auxiliar De Calidad", fontBold3, 0, 2));

                doc.add(addParagraf(" CRA 48 72SUR-01, AV LAS VEGAS TEL:(57) (604) 305 8200 FAX:(57) (604) 301 3712\n"
                        + "mercadeo@mineralesindustriales.com.co www.mineralesindustriales.com\n"
                        + "SABANETA – COLOMBIA - SURAMÉRICA", fontBold6, 50, 1));
            }*/
    //center=1  left=0  rigth=2  bottom=6 top=4
    private Paragraph addParagraf(String text, Font font, int spacing, int align) {
        //center=1  left=0  rigth=2  bottom=6 top=4
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk();
        chunk.append(text);
        chunk.setFont(font);
        paragraph.add(chunk);
        paragraph.setSpacingBefore(spacing);
        paragraph.setAlignment(align);
        return paragraph;

    }

    public PdfPTable addFila(List<PdfPCell> cells, int spacing, int width) {
        try {
            int columns = cells.size();
            PdfPTable fila = new PdfPTable(columns);
            fila.setSpacingBefore(spacing);
            fila.setWidthPercentage(width);
            fila.setHorizontalAlignment(2);

            if (cells != null) {
                if (cells.size() > 0) {
                    for (PdfPCell pdfCell : cells) {
                        fila.addCell(pdfCell);
                    }
                }
            }
            return fila;
        } catch (Exception e) {
            return null;
        }

    }

    public PdfPTable addFila2(List<PdfPCell> cells, int spacing, int width) {
        try {
            int columns = cells.size();
            PdfPTable fila = new PdfPTable(columns);
            fila.setSpacingBefore(spacing);
            fila.setWidthPercentage(width);
            fila.setHorizontalAlignment(Element.ALIGN_LEFT); // Alinea la tabla a la derecha

            if (cells != null) {
                if (cells.size() > 0) {
                    for (PdfPCell pdfCell : cells) {
                        fila.addCell(pdfCell);
                    }
                }
            }
            return fila;
        } catch (Exception e) {
            return null;
        }
    }

    public List<PdfPCell> getCells(String[] texts, Font font, int align) {
        if (texts.length > 0) {
            List<PdfPCell> cells = new ArrayList<>();
            for (String text : texts) {
                PdfPCell pdfPCell = new PdfPCell(addParagraf(text, font, 0, align));
                pdfPCell.setHorizontalAlignment(align);
                pdfPCell.setVerticalAlignment(align);
                cells.add(pdfPCell);
            }
            return cells;
        }
        return null;
    }

    //Sin borde
    public List<PdfPCell> getCells2(String[] texts, Font font, int align) {
        if (texts.length > 0) {
            List<PdfPCell> cells = new ArrayList<>();
            for (String text : texts) {
                PdfPCell pdfPCell = new PdfPCell(addParagraf(text, font, 2, align));
                pdfPCell.setHorizontalAlignment(align);
                pdfPCell.setVerticalAlignment(align);
                pdfPCell.setBorder(Rectangle.NO_BORDER); // Aquí estableces el borde de cada celda
                cells.add(pdfPCell);
            }
            return cells;
        }
        return null;
    }

    // Con color azul
    public List<PdfPCell> getCells3(String[] texts, Font font, int align, int blueCellIndex) {
        if (texts.length > 0) {
            List<PdfPCell> cells = new ArrayList<>();
            for (int i = 0; i < texts.length; i++) {
                PdfPCell pdfPCell = new PdfPCell(addParagraf(texts[i], font, 2, align));
                pdfPCell.setHorizontalAlignment(align);
                pdfPCell.setVerticalAlignment(align);
                if (i == blueCellIndex) { // Si es el índice de la celda azul
                    pdfPCell.setBackgroundColor(lightBlue);

                    /* ******** nota de color  ******  */
                    // Establecer el color de fondo a azul Para usar un tono de azul más claro en lugar de 
                    //BaseColor.BLUE, puedes definir tu propio color utilizando el constructor new BaseColor()
                }
                cells.add(pdfPCell);
            }
            return cells;
        }
        return null;
    }
    // Con color azul  y alineacion normal

    public List<PdfPCell> getCells4(String[] texts, Font font, int align) {
        if (texts.length > 0) {
            List<PdfPCell> cells = new ArrayList<>();
            for (String text : texts) {
                PdfPCell pdfPCell = new PdfPCell(addParagraf(text, font, 2, align));
                //    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar el texto horizontalmente
                pdfPCell.setHorizontalAlignment(align);
                pdfPCell.setVerticalAlignment(align);
                pdfPCell.setBackgroundColor(lightBlue); // Establecer el color de fondo al azul más claro           
                cells.add(pdfPCell);
            }
            return cells;
        }
        return null;
    }

    public void agregarSaltosDeLinea() throws DocumentException {
        Paragraph saltosdelinea = new Paragraph();
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        doc.add(saltosdelinea);
    }

    //Dos espacios
    public void agregarSaltosDeLinea2() throws DocumentException {
        Paragraph saltosdelinea = new Paragraph();
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        doc.add(saltosdelinea);
    }

    public String getFecha() {
        GregorianCalendar gcal = new GregorianCalendar();
        int dia = gcal.get(Calendar.DAY_OF_MONTH);
        int mes = gcal.get(Calendar.MONTH);
        int anio = gcal.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + anio;
    }

    public static String getFecha2() {

        // Crear un objeto SimpleDateFormat para formatear la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yyyy");

        String fechaActual = formatoFecha.format(new Date());

        return fechaActual;
    }

}
