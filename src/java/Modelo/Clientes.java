package Modelo;

public class Clientes {

    private int idclientes;    
    private String razon_Social;
    private String nombres_apellidos;
    private int idDocumento;
    private String numero_Documento;
    private String direccion;
    private String numero_Telefono;
    private String correo;
    

    public int getIdclientes() {
        return idclientes;
    }

    public void setIdclientes(int idclientes) {
        this.idclientes = idclientes;
    }

    public String getNombres_apellidos() {
        return nombres_apellidos;
    }

    public void setNombres_apellidos(String nombres_apellidos) {
        this.nombres_apellidos = nombres_apellidos;
    }

    public  String getRazon_Social() {
        return razon_Social;
    }

    public  void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNumero_Documento() {
        return numero_Documento;
    }

    public void setNumero_Documento(String numero_Documento) {
        this.numero_Documento = numero_Documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero_Telefono() {
        return numero_Telefono;
    }

    public void setNumero_Telefono(String numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
