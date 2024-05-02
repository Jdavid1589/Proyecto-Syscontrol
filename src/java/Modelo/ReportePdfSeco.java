package Modelo;

import java.util.List;

public class ReportePdfSeco {

    private int idCertificadoSeco;
    private String producto;
    private String fechaCertificado;
    private String cliente;
    private String numCertificado;
    private String fechaProduccion;
    private String CantidadSacos;
    private String lote;
    private String humedad;
    private String pH;
    private String retenido325;
    private String AA;
    private String Br;
    private String Wh;
    private String Yell;
    private String Dv50;
    private String Auxiliar;

    private List<Variable> variables;

    public int getIdCertificadoSeco() {
        return idCertificadoSeco;
    }

    public void setIdCertificadoSeco(int idCertificadoSeco) {
        this.idCertificadoSeco = idCertificadoSeco;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFechaCertificado() {
        return fechaCertificado;
    }

    public void setFechaCertificado(String fechaCertificado) {
        this.fechaCertificado = fechaCertificado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumCertificado() {
        return numCertificado;
    }

    public void setNumCertificado(String numCertificado) {
        this.numCertificado = numCertificado;
    }

    public String getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(String fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public String getCantidadSacos() {
        return CantidadSacos;
    }

    public void setCantidadSacos(String CantidadSacos) {
        this.CantidadSacos = CantidadSacos;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getpH() {
        return pH;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public String getRetenido325() {
        return retenido325;
    }

    public void setRetenido325(String retenido325) {
        this.retenido325 = retenido325;
    }

    public String getAA() {
        return AA;
    }

    public void setAA(String AA) {
        this.AA = AA;
    }

    public String getBr() {
        return Br;
    }

    public void setBr(String Br) {
        this.Br = Br;
    }

    public String getWh() {
        return Wh;
    }

    public void setWh(String Wh) {
        this.Wh = Wh;
    }

    public String getYell() {
        return Yell;
    }

    public void setYell(String Yell) {
        this.Yell = Yell;
    }

    public String getDv50() {
        return Dv50;
    }

    public void setDv50(String Dv50) {
        this.Dv50 = Dv50;
    }

    public String getAuxiliar() {
        return Auxiliar;
    }

    public void setAuxiliar(String Auxiliar) {
        this.Auxiliar = Auxiliar;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

}
