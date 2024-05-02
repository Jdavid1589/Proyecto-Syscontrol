package Modelo;

import java.util.List;

public class CertificadoProductoLodo {

    private String producto;
    private String cliente;
    private String noCertificado;
    private String fechaGeneracion;
    private String noremision;
    private String cantidadkg;

    private String lote;
    private List<CaracteristicasFisicasPL> listCarFisc;
    private List<ColorLodo> listColor;
    private List<DtpLodo> listDtps;
    private String Auxiliar;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getNoremision() {
        return noremision;
    }

    public void setNoremision(String noremision) {
        this.noremision = noremision;
    }

    public String getCantidadkg() {
        return cantidadkg;
    }

    public void setCantidadkg(String cantidadkg) {
        this.cantidadkg = cantidadkg;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public List<CaracteristicasFisicasPL> getListCarFisc() {
        return listCarFisc;
    }

    public void setListCarFisc(List<CaracteristicasFisicasPL> listCarFisc) {
        this.listCarFisc = listCarFisc;
    }

    public List<ColorLodo> getListColor() {
        return listColor;
    }

    public void setListColor(List<ColorLodo> listColor) {
        this.listColor = listColor;
    }

    public List<DtpLodo> getListDtps() {
        return listDtps;
    }

    public void setListDtps(List<DtpLodo> listDtps) {
        this.listDtps = listDtps;
    }


    public String getAuxiliar() {
        return Auxiliar;
    }

    public void setAuxiliar(String Auxiliar) {
        this.Auxiliar = Auxiliar;
    }

}
