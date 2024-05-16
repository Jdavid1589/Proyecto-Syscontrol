
import Modelo.Usuarios;
import Persistencia.DaoUsuarios;
import java.util.List;
import static org.testng.Assert.*;


import org.testng.annotations.Test;
public class TestUser {
    private DaoUsuarios daoUsuarios; 
    public TestUser() {
        daoUsuarios = new DaoUsuarios(); // Instancia 
    }

 @Test
public void testListar2() {
    List<Usuarios> listaUsuarios = daoUsuarios.listar(); // Obtener la lista de usuarios desde el método listar()

    // Verificar si la lista no está vacía
    assertEquals(false, listaUsuarios.isEmpty());

    // Verificar el tamaño de la lista
    int tamañoEsperado = 4; // Cambia esto al tamaño esperado de tu lista
    assertEquals(tamañoEsperado, listaUsuarios.size());

    // Imprimir mensaje en la consola dependiendo del resultado de la aserción
    if (listaUsuarios.size() == tamañoEsperado) {
        System.out.println("Prueba exitosa: El tamaño de la lista es correcto.");
    } else {
        System.out.println("Error en la prueba: El tamaño de la lista es incorrecto.");
    }

    // También puedes hacer otras verificaciones, como verificar propiedades de los objetos Usuarios en la lista.
}


}



/*
  @BeforeClass
    public static void setUpClass() throws Exception {
        // Aquí puedes realizar la configuración inicial para todas las pruebas de la clase
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Aquí puedes realizar la limpieza después de todas las pruebas de la clase
    }

    @BeforeClass
    public void setUp() throws Exception {
        // Aquí puedes realizar la configuración inicial para cada prueba
    }

    @AfterClass
    public void tearDown() throws Exception {
        // Aquí puedes realizar la limpieza después de cada prueba
    }*/