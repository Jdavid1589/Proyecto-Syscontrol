package Modelo;

public class ControlSeco implements ControlCalidadComun {

    //Variables Especificas producto seco
    private Double cant_noconf;
    private String causas;
    /*   private Double humedad_1;
    private Double humedad_2;
    private Double humedad_3;
    private Double humedad_4;
    private Double humedad_5;
    private Double humedad_6;
    private Double humedad_7;
    private Double humedad_8;
    private Double humedad_9;
    private Double humedad_10;
// Agregar hasta humedad_30
    private Double humedad_11;
    private Double humedad_12;
    private Double humedad_13;
    private Double humedad_14;
    private Double humedad_15;
    private Double humedad_16;
    private Double humedad_17;
    private Double humedad_18;
    private Double humedad_19;
    private Double humedad_20;
    private Double humedad_21;
    private Double humedad_22;
    private Double humedad_23;
    private Double humedad_24;
    private Double humedad_25;
    private Double humedad_26;
    private Double humedad_27;
    private Double humedad_28;
    private Double humedad_29;
    private Double humedad_30;*/

    private Double[] humedades = new Double[30]; // Array para almacenar las humedades

    private Double humedad_promedio;
    private Double pH_2;
    private Double pH_3;
    private Double pH_promedio;
    private String comentarios; //17 Variables

    // <editor-fold defaultstate="collapsed" desc="Metodos Get Set Propios de PS">
    public Double getCant_noconf() {
        return cant_noconf;
    }

    public void setCant_noconf(Double cant_noconf) {
        this.cant_noconf = cant_noconf;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

  // Getters y setters
public Double getHumedad(int index) {
    if (index < 1 || index > 30) {
        throw new IllegalArgumentException("Index out of bounds for humedades array");
    }

    Double humedad = humedades[index - 1];
    if (humedad == null) {
        return 0.0; // O cualquier otro valor predeterminado que desees usar cuando la humedad sea null
    } else {
        return humedad;
    }
}

public void setHumedad(int index, Double value) {
    if (index >= 1 && index <= 30) { // Ajuste aquí
        humedades[index - 1] = value; // Ajuste aquí
    } else {
        throw new IllegalArgumentException("Index out of bounds for humedades array");
    }
}

    /*  public Double getHumedad_1() {
        return humedad_1;
    }

    public void setHumedad_1(Double humedad_1) {
        this.humedad_1 = humedad_1;
    }

    public Double getHumedad_2() {
        return humedad_2;
    }

    public void setHumedad_2(Double humedad_2) {
        this.humedad_2 = humedad_2;
    }

    public Double getHumedad_3() {
        return humedad_3;
    }

    public void setHumedad_3(Double humedad_3) {
        this.humedad_3 = humedad_3;
    }

    public Double getHumedad_4() {
        return humedad_4;
    }

    public void setHumedad_4(Double humedad_4) {
        this.humedad_4 = humedad_4;
    }

    public Double getHumedad_5() {
        return humedad_5;
    }

    public void setHumedad_5(Double humedad_5) {
        this.humedad_5 = humedad_5;
    }

    public Double getHumedad_6() {
        return humedad_6;
    }

    public void setHumedad_6(Double humedad_6) {
        this.humedad_6 = humedad_6;
    }

    public Double getHumedad_7() {
        return humedad_7;
    }

    public void setHumedad_7(Double humedad_7) {
        this.humedad_7 = humedad_7;
    }

    public Double getHumedad_8() {
        return humedad_8;
    }

    public void setHumedad_8(Double humedad_8) {
        this.humedad_8 = humedad_8;
    }

    public Double getHumedad_9() {
        return humedad_9;
    }

    public void setHumedad_9(Double humedad_9) {
        this.humedad_9 = humedad_9;
    }

    public Double getHumedad_10() {
        return humedad_10;
    }

    public void setHumedad_10(Double humedad_10) {
        this.humedad_10 = humedad_10;
    }

    public Double getHumedad_11() {
        return humedad_11;
    }

    public void setHumedad_11(Double humedad_11) {
        this.humedad_11 = humedad_11;
    }

    public Double getHumedad_12() {
        return humedad_12;
    }

    public void setHumedad_12(Double humedad_12) {
        this.humedad_12 = humedad_12;
    }

    public Double getHumedad_13() {
        return humedad_13;
    }

    public void setHumedad_13(Double humedad_13) {
        this.humedad_13 = humedad_13;
    }

    public Double getHumedad_14() {
        return humedad_14;
    }

    public void setHumedad_14(Double humedad_14) {
        this.humedad_14 = humedad_14;
    }

    public Double getHumedad_15() {
        return humedad_15;
    }

    public void setHumedad_15(Double humedad_15) {
        this.humedad_15 = humedad_15;
    }

    public Double getHumedad_16() {
        return humedad_16;
    }

    public void setHumedad_16(Double humedad_16) {
        this.humedad_16 = humedad_16;
    }

    public Double getHumedad_17() {
        return humedad_17;
    }

    public void setHumedad_17(Double humedad_17) {
        this.humedad_17 = humedad_17;
    }

    public Double getHumedad_18() {
        return humedad_18;
    }

    public void setHumedad_18(Double humedad_18) {
        this.humedad_18 = humedad_18;
    }

    public Double getHumedad_19() {
        return humedad_19;
    }

    public void setHumedad_19(Double humedad_19) {
        this.humedad_19 = humedad_19;
    }

    public Double getHumedad_20() {
        return humedad_20;
    }

    public void setHumedad_20(Double humedad_20) {
        this.humedad_20 = humedad_20;
    }

    public Double getHumedad_21() {
        return humedad_21;
    }

    public void setHumedad_21(Double humedad_21) {
        this.humedad_21 = humedad_21;
    }

    public Double getHumedad_22() {
        return humedad_22;
    }

    public void setHumedad_22(Double humedad_22) {
        this.humedad_22 = humedad_22;
    }

    public Double getHumedad_23() {
        return humedad_23;
    }

    public void setHumedad_23(Double humedad_23) {
        this.humedad_23 = humedad_23;
    }

    public Double getHumedad_24() {
        return humedad_24;
    }

    public void setHumedad_24(Double humedad_24) {
        this.humedad_24 = humedad_24;
    }

    public Double getHumedad_25() {
        return humedad_25;
    }

    public void setHumedad_25(Double humedad_25) {
        this.humedad_25 = humedad_25;
    }

    public Double getHumedad_26() {
        return humedad_26;
    }

    public void setHumedad_26(Double humedad_26) {
        this.humedad_26 = humedad_26;
    }

    public Double getHumedad_27() {
        return humedad_27;
    }

    public void setHumedad_27(Double humedad_27) {
        this.humedad_27 = humedad_27;
    }

    public Double getHumedad_28() {
        return humedad_28;
    }

    public void setHumedad_28(Double humedad_28) {
        this.humedad_28 = humedad_28;
    }

    public Double getHumedad_29() {
        return humedad_29;
    }

    public void setHumedad_29(Double humedad_29) {
        this.humedad_29 = humedad_29;
    }

    public Double getHumedad_30() {
        return humedad_30;
    }

    public void setHumedad_30(Double humedad_30) {
        this.humedad_30 = humedad_30;
    }*/
    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public Double getHumedad_promedio() {
        return humedad_promedio;
    }

    public void setHumedad_promedio(Double humedad_promedio) {
        this.humedad_promedio = humedad_promedio;
    }

    public Double getpH_2() {
        return pH_2;
    }

    public void setpH_2(Double pH_2) {
        this.pH_2 = pH_2;
    }

    public Double getpH_3() {
        return pH_3;
    }

    public void setpH_3(Double pH_3) {
        this.pH_3 = pH_3;
    }

    public Double getpH_promedio() {
        return pH_promedio;
    }

    public void setpH_promedio(Double pH_promedio) {
        this.pH_promedio = pH_promedio;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    // </editor-fold>
    /*---------------*/
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
    private double retenido325; // total 17 + 14 =31

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

    /*
    @Override
    public int getIdClientes() {
        return idClientes;
    }

    @Override
    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }*/
    // </editor-fold> 
}
