package Persistencia;

import Modelo.Productos;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class DaoProductosNGTest {
    private DaoProductos daoProductos;
    public DaoProductosNGTest() {
        daoProductos = new DaoProductos();
    }

    @Test
    public void testRegistrar2() {
        // Imprime un mensaje indicando que se está ejecutando la prueba
        System.out.println("Prueba de registro de productos");

        // Crea un objeto Productos válido para pasar al método registrar
        Productos productos = new Productos();
        // Asigna valores a los campos del objeto Productos
        productos.setNombres_Productos("Caolin 2");
        productos.setTipoProducto_idtipoProducto(1);

        // Establece el resultado esperado como verdadero, ya que se espera que el registro sea exitoso
        boolean expResult = true;

        // Llama al método registrar y obtiene el resultado
        boolean result = DaoProductos.registrar(productos);
        System.out.println("Registro en BD Exitoso");
        // Comprueba si el resultado obtenido es igual al resultado esperado
        assertEquals(expResult, result);
    }

}
