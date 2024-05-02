package Modelo;

public class Variable {

    private String tipo;
    private String rango;

    //Costructor
    public Variable(String tipo, String rango) {
        this.tipo = tipo;
        this.rango = rango;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRango() {
        return rango;
    }

}
