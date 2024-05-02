package Persistencia;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;
import org.jasypt.util.text.BasicTextEncryptor;

public class Encriptador {
// Contraseña que usa BasytextEncryptador
    private final String CONTRA = "asda256552aslkksjsjnxxzs";
    BasicTextEncryptor encriptador;

    //Metodo constructor par apasarle la contraseña
    public Encriptador() {
        encriptador = new BasicTextEncryptor();
        encriptador.setPassword(CONTRA);
    }

    //Metodo para encritar contraseña 
    public String encriptar(String clave) {
        return encriptador.encrypt(clave);

    }

    //Metodo para Desencriptar
    public String desencriptar(String clave) {
        try {
            return encriptador.decrypt(clave);
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la pila de excepciones
        }
        return null;
    }

    
    public String encriptarConSalt(String clave, String salt) {
        // Combina la contraseña y el salt antes de aplicar la encriptación
        return encriptar(clave + salt);
    }

    public String generarSalt() {
        // Genera un salt aleatorio usando SecureRandom
        SecureRandom secureRandom = new SecureRandom();
        int TAMANO_SALT = 0;
        byte[] salt = new byte[TAMANO_SALT];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    // Método para hashear la contraseña
    public String hashClave(String clave) {
        // Puedes ajustar el algoritmo según tus necesidades (por ejemplo, SHA-256)
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(clave.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(hash).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
