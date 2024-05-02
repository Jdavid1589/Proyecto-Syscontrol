package Modelo;

import java.util.List;

public class CertificadoProductoSeco {

    private String producto;
    private String fechaGeneracion;
    private String cliente;
    private String Auxiliar;
    private String noCertificado;
    private String fechaProduccion;
    private String cantidadSacos;
    private String lote;
    private List<CaracteristicasFisicas> listCarFisc;
    private List<Color> listColor;
    private List<Dtp> listDtps;

    public String getAuxiliar() {
        return Auxiliar;
    }

    public void setAuxiliar(String Auxiliar) {
        this.Auxiliar = Auxiliar;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(String fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public String getCantidadSacos() {
        return cantidadSacos;
    }

    public void setCantidadSacos(String cantidadSacos) {
        this.cantidadSacos = cantidadSacos;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public List<CaracteristicasFisicas> getListCarFisc() {
        return listCarFisc;
    }

    public void setListCarFisc(List<CaracteristicasFisicas> listCarFisc) {
        this.listCarFisc = listCarFisc;
    }

    public List<Color> getListColor() {
        return listColor;
    }

    public void setListColor(List<Color> listColor) {
        this.listColor = listColor;
    }

    public List<Dtp> getListDtps() {
        return listDtps;
    }

    public void setListDtps(List<Dtp> listDtps) {
        this.listDtps = listDtps;
    }

}
