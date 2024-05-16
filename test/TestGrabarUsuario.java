
import Modelo.Usuarios;
import Persistencia.DaoUsuarios;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class TestGrabarUsuario {    
 
    private DaoUsuarios daoUsuarios; // Suponiendo que tengas una clase UsuariosDAO que contiene el método listar()

    public TestGrabarUsuario() {
        daoUsuarios = new DaoUsuarios(); // Instancia de tu DAO
    }    

   @Test
    public void testGrabar() {
        Usuarios usuario = new Usuarios();
        usuario.setNombres_apellido("Test Juan");
        usuario.setNumero_Telefono("1234");
        usuario.setCorreo("correo@example3.com");
        usuario.setUsuario("jd");
        usuario.setClave("cc3");
        usuario.setPerfil_idperfil(1); // Id de perfil válido
        try {
            assertTrue(daoUsuarios.grabar(usuario)); // Comprueba si el método devuelve true

        } catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage()); // Si se lanza una excepción, la prueba falla
        }
    }

}
