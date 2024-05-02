
package Modelo;


public class CaracteristicasFisicasPL {
    
      private VariablesPL variablesPL;
    private String valor;

    public CaracteristicasFisicasPL(VariablesPL variablesPL, String valor) {
        this.variablesPL = variablesPL;
        this.valor = valor;
    }
    

    public VariablesPL getVariablesPL() {
        return variablesPL;
    }

    public void setVariablesPL(VariablesPL variablesPL) {
        this.variablesPL = variablesPL;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
