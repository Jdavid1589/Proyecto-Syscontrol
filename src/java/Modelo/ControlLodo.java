package Modelo;

public class ControlLodo implements ControlCalidadComun {

    //Variables Especificas producto Lodo
    private double cantiKgLodo;
    private String numeroTanque;
    private double solidos;
    private double humedad;
    private double viscosidadKu;
    private double viscosidadCp;
    private int ltAgua;
    private double dispersante;
    private double kgCarbonatoSosio;
    private int ltNatrosol;
    private int ltBiocidad;
    private double biocidadPorcentaje;
    private int idSeguimiento;
    private String comentarios;//Total 14

    // <editor-fold defaultstate="collapsed" desc="Metodos Get Set Propios de PL">
    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public double getCantiKgLodo() {
        return cantiKgLodo;
    }

    public void setCantiKgLodo(double cantiKgLodo) {
        this.cantiKgLodo = cantiKgLodo;
    }

    public String getNumeroTanque() {
        return numeroTanque;
    }

    public void setNumeroTanque(String numeroTanque) {
        this.numeroTanque = numeroTanque;
    }

    public double getSolidos() {
        return solidos;
    }

    public void setSolidos(double solidos) {
        this.solidos = solidos;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public double getViscosidadKu() {
        return viscosidadKu;
    }

    public void setViscosidadKu(double viscosidadKu) {
        this.viscosidadKu = viscosidadKu;
    }

    public double getViscosidadCp() {
        return viscosidadCp;
    }

    public void setViscosidadCp(double viscosidadCp) {
        this.viscosidadCp = viscosidadCp;
    }

    public int getLtAgua() {
        return ltAgua;
    }

    public void setLtAgua(int ltAgua) {
        this.ltAgua = ltAgua;
    }

    public double getDispersante() {
        return dispersante;
    }

    public void setDispersante(double dispersante) {
        this.dispersante = dispersante;
    }

    public double getKgCarbonatoSosio() {
        return kgCarbonatoSosio;
    }

    public void setKgCarbonatoSosio(double kgCarbonatoSosio) {
        this.kgCarbonatoSosio = kgCarbonatoSosio;
    }

    public int getLtNatrosol() {
        return ltNatrosol;
    }

    public void setLtNatrosol(int ltNatrosol) {
        this.ltNatrosol = ltNatrosol;
    }

    public int getLtBiocidad() {
        return ltBiocidad;
    }

    public void setLtBiocidad(int ltBiocidad) {
        this.ltBiocidad = ltBiocidad;
    }

    public double getBiocidadPorcentaje() {
        return biocidadPorcentaje;
    }

    public void setBiocidadPorcentaje(double biocidadPorcentaje) {
        this.biocidadPorcentaje = biocidadPorcentaje;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    // </editor-fold>
    /*---------------*/
    //Variables Interfaces ControlCalidadComun
    private int idControlCalidad;
    private String lote;
    private int idProductos;
    private int idConsecutivo;
    private int idUsuarios;
    private String fecha;
    private double pH;
    private double abs_Aceite;
    private double Brigh;
    private double Whitness;
    private double Dv50;
    private double Dv90;
    private String observacion;
    private double retenido325; // total 14 + 14 =28

    // <editor-fold defaultstate="collapsed" desc="Implementacion Variables Comunes Interface">
    @Override
    public int getIdControlCalidad() {
        return idControlCalidad;
    }

    @Override
    public void setIdControlCalidad(int idControlCalidad) {
        this.idControlCalidad = idControlCalidad;
    }

    @Override
    public int getIdUsuarios() {
        return idUsuarios;
    }

    @Override
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    //Productos
    @Override
    public int getIdProductos() {
        return idProductos;
    }

    @Override
    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    //Consecutivo
    @Override
    public int getIdConsecutivo() {
        return idConsecutivo;
    }

    @Override
    public void setIdConsecutivo(int idConsecutivo) {
        this.idConsecutivo = idConsecutivo;
    }

    @Override
    public String getLote() {
        return lote;
    }

    @Override
    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public double getPH() {
        return pH;
    }

    @Override
    public void setPH(double pH) {
        this.pH = pH;
    }

    @Override
    public double getAbs_Aceite() {
        return abs_Aceite;
    }

    @Override
    public void setAbs_Aceite(double abs_Aceite) {
        this.abs_Aceite = abs_Aceite;
    }

    @Override
    public double getBrigh() {
        return Brigh;
    }

    @Override
    public void setBrigh(double Brigh) {
        this.Brigh = Brigh;
    }

    @Override
    public double getWhitness() {
        return Whitness;
    }

    @Override
    public void setWhitness(double Whitness) {
        this.Whitness = Whitness;
    }

    @Override
    public double getDv50() {
        return Dv50;
    }

    @Override
    public void setDv50(double Dv50) {
        this.Dv50 = Dv50;
    }

    @Override
    public double getDv90() {
        return Dv90;
    }

    @Override
    public void setDv90(double Dv90) {
        this.Dv90 = Dv90;
    }

    @Override
    public double getRetenido325() {
        return retenido325;
    }

    @Override
    public void setRetenido325(double retenido325) {
        this.retenido325 = retenido325;
    }

    @Override
    public String getObservacion() {
        return observacion;
    }

    @Override
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    // </editor-fold>
    /*---------------*/
}
