package Modelo;

public interface ControlCalidadComun {

    int getIdControlCalidad();

    void setIdControlCalidad(int idControlCalidad);

    int getIdUsuarios();

    void setIdUsuarios(int idUsuarios);

    int getIdProductos();

    void setIdProductos(int idProductos); //Nuevo

    int getIdConsecutivo();

    void setIdConsecutivo(int idConsecutivo); //Nuevo

    String getLote();

    // Método set para lote
    void setLote(String lote);

    String getFecha();

    void setFecha(String fecha);

    double getPH();

    void setPH(double pH);

    double getAbs_Aceite();

    void setAbs_Aceite(double abs_Aceite);

    double getBrigh();

    void setBrigh(double Brigh);

    double getWhitness();

    void setWhitness(double Whitness);

    double getDv50();

    void setDv50(double Dv50);

    double getDv90();

    void setDv90(double Dv90);

    double getRetenido325();

    void setRetenido325(double retenido325);

    String getObservacion();

    void setObservacion(String observacion);

}
