package Modelo;


public class Usuarios {

    private int idUsuarios;
    private String nombres_apellido;    
    private String numero_Telefono;
    private String correo;
    private String usuario;
    private String clave;
    private int perfil_idperfil;
   
    
    
    // <editor-fold defaultstate="collapsed" desc="Metodo Get y Set"> 
     
    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombres_apellido() {
        return nombres_apellido;
    }

    public void setNombres_apellido(String nombres_apellidos) {
        this.nombres_apellido = nombres_apellidos;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPerfil_idperfil() {
        return perfil_idperfil;
    }

    public void setPerfil_idperfil(int perfil_idperfil) {
        this.perfil_idperfil = perfil_idperfil;
    }

     // </editor-fold>
    
}
