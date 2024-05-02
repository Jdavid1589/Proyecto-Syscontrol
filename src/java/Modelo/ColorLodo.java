
package Modelo;


public class ColorLodo {
    
      private String tipo;
    private String especificacion;
    private String metodo;
    private String valor; 

    public ColorLodo(String tipo, String especificacion, String metodo, String valor) {
        this.tipo = tipo;
        this.especificacion = especificacion;
        this.metodo = metodo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
