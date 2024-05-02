package util;

import Modelo.Consecutivo;
import Modelo.ControlLodo;
import Modelo.Especificaciones;
import Modelo.Productos;
import Persistencia.DaoClientes;
import Persistencia.DaoConsecutivo;
import Persistencia.DaoEspecificaciones;
import Persistencia.DaoProductoLodo;
import Persistencia.DaoProductoSeco;
import Persistencia.DaoProductos;
import static Persistencia.DaoProductos.listar;
import java.util.Iterator;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VArias2 {

  /* public static void main(String[] args) {
        // Crear un objeto ControlLodo con datos de prueba
        ControlLodo controlLodo = new ControlLodo();
        
        controlLodo.setIdControlCalidad(108); // Suponiendo que el ID del control de calidad a editar es 1 

        controlLodo.setFecha("2024-03-11");
        controlLodo.setLote("Lote123");
        controlLodo.setRetenido325(0.5);
        controlLodo.setPH(7.0);
        controlLodo.setAbs_Aceite(0.1); // Ejemplo
        controlLodo.setBrigh(0.9); // Ejemplo
        controlLodo.setWhitness(0.8); // Ejemplo
        controlLodo.setDv50(50.0); // Ejemplo
        controlLodo.setDv90(90.0); // Ejemplo
        controlLodo.setObservacion("Observación de prueba"); // Ejemplo

        controlLodo.setHumedad(37); // Ejemplo
        controlLodo.setViscosidadKu(60.0); // Ejemplo
        controlLodo.setViscosidadCp(700); // Ejemplo
        controlLodo.setLtAgua(10); // Ejemplo
        controlLodo.setDispersante(0.2); // Ejemplo
        controlLodo.setKgCarbonatoSosio(1.5); // Ejemplo
        controlLodo.setLtNatrosol(20); // Ejemplo
        controlLodo.setLtBiocidad(25); // Ejemplo
        controlLodo.setBiocidadPorcentaje(5); // Ejemplo
        controlLodo.setCantiKgLodo(2.0); // Ejemplo
        controlLodo.setNumeroTanque("25"); // Ejemplo
        controlLodo.setSolidos(53); // Ejemplo
        controlLodo.setComentarios("Comentarios de prueba"); // Ejemplo
        controlLodo.setIdProductos(4); // Ejemplo
        controlLodo.setIdUsuarios(1); // Ejemplo
        controlLodo.setIdConsecutivo(1); // Ejemplo
        controlLodo.setIdSeguimiento(4); // Ejemplo

        // Establecer los valores restantes según sea necesario
        // Llamar al método editar() y mostrar el resultado
        boolean resultado = DaoProductoLodo.editar(controlLodo);
        if (resultado) {
            System.out.println("Datos editados exitosamente.");
        } else {
            System.out.println("Error al editar los datos.");
        }
    }*/

    /*  
  public static void main(String[] args) {
    // Crear un objeto ControlLodo con datos de prueba
    ControlLodo controlLodo = new ControlLodo();
    controlLodo.setFecha("2024-03-11");
    controlLodo.setLote("Lote123");
    controlLodo.setRetenido325(0.5);
    controlLodo.setPH(7.0);
    controlLodo.setAbs_Aceite(0.1); // Ejemplo
    controlLodo.setBrigh(0.9); // Ejemplo
    controlLodo.setWhitness(0.8); // Ejemplo
    controlLodo.setDv50(50.0); // Ejemplo
    controlLodo.setDv90(90.0); // Ejemplo
    controlLodo.setObservacion("Observación de prueba"); // Ejemplo
  
    controlLodo.setHumedad(37); // Ejemplo
    controlLodo.setViscosidadKu(60.0); // Ejemplo
    controlLodo.setViscosidadCp(700); // Ejemplo
    controlLodo.setLtAgua(10); // Ejemplo
    controlLodo.setDispersante(0.2); // Ejemplo
    controlLodo.setKgCarbonatoSosio(1.5); // Ejemplo
    controlLodo.setLtNatrosol(20); // Ejemplo
    controlLodo.setLtBiocidad(25); // Ejemplo
    controlLodo.setBiocidadPorcentaje(5); // Ejemplo
    controlLodo.setCantiKgLodo(2.0); // Ejemplo
    controlLodo.setNumeroTanque("25"); // Ejemplo
    controlLodo.setSolidos(53); // Ejemplo
    controlLodo.setComentarios("Comentarios de prueba"); // Ejemplo
      controlLodo.setIdProductos(4); // Ejemplo
    controlLodo.setIdUsuarios(1); // Ejemplo
    controlLodo.setIdConsecutivo(1); // Ejemplo
    controlLodo.setIdSeguimiento(1); // Ejemplo

    // Llama al método grabar() y muestra el resultado
    boolean resultado = DaoProductoLodo.grabar(controlLodo);
    if (resultado) {
        System.out.println("Datos grabados exitosamente.");
    } else {
        System.out.println("Error al grabar los datos.");
    }
}
}

/*public static void main(String[] args) {
    List<ControlLodo> listaControlLodo = DaoProductoLodo.listar();
    for (ControlLodo controlLodo : listaControlLodo) {
        System.out.println(controlLodo);
    }*/
 /*
    public static void main(String[] args) {

        Productos productos = new Productos();

         
        System.out.println(DaoProductoSeco.obtenerUsuario(1));

    }*/
 /* public static void main(String[] args) {
        int idEspecificaciones = 5; // El ID de especificaciones que deseas probar

        // Llamada al método DAO
        String resultado = DaoEspecificaciones.obtrRef_y_TipoProducto2(idEspecificaciones);

        // Imprimir el resultado en la consola
        System.out.println("Resultado: " + resultado);
    }*/
 /* 
   public static void main(String[] args) {
        DaoEspecificaciones daoEsp = new DaoEspecificaciones();
        
        int idEspecificaciones = 2; // El ID de especificaciones que deseas probar

        // Llamada al método DAO
               List<String> resultados = daoEsp.obtenerProductoyCliente2(idEspecificaciones);

        // Imprimir cada resultado en la consola
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }*/
 /*  public static void main(String[] args) {

        DaoProductoSeco daop = new DaoProductoSeco();
        String resulfff = DaoProductoSeco.obtenerNombreproducto(3);
        String resul2 = DaoProductoSeco.obtenerNombrecliente(3);
        String resul3 = DaoEspecificaciones.obtrRef_y_TipoProducto2(1);
        // Imprimir el resultado en la consola
        System.out.println("Resultado: " + resulfff);
        System.out.println("Resultado: " + resul2);
        System.out.println("Resultado3: " + resul3);

    }
}*/
 /* public static void main(String[] args) {
        DaoProductoSeco daop = new DaoProductoSeco();
        // String resulfff= String.valueOf(DaoProductoSeco.obtenerIdProductoCliente(1));
        //   System.out.println("Resultado: " + resulfff);
        List<String> resultados = DaoProductoSeco.obtenerTodosProductosClientes2();

        for (String cadena : resultados) {
            System.out.println("Cadena nombres_Productos: " + cadena);
            // Puedes imprimir o procesar más campos según sea necesario
        }

    }*/

 /* public static void main(String[] args) {
        DaoProductoSeco daop = new DaoProductoSeco();
        String Cliente= DaoProductoSeco.obtenerCliente(2);
         System.out.println("El clientes es: " + Cliente);

    }*/
 /* public static void main(String[] args) {
        // Crear una instancia de tu clase DAO
        DaoProductos dao = new DaoProductos();
        Productos pro = new Productos();

        Scanner Leer = new java.util.Scanner(System.in);

        int tipoid = 0;
        int client = 0;
        String nomb = "";
        String variable = "";
        String rango = "";
        String meto = "";

        System.out.println("Por favor, producto");
        nomb = Leer.nextLine();

        System.out.println("Por favor, tipo Produtcto");
        tipoid = Leer.nextInt();

        System.out.println("Por favor, tipo Cliente");
        client = Leer.nextInt();

        System.out.println("Por favor, Variable1");
        variable = Leer.nextLine();

        System.out.println("Por favor, rango");
        rango = Leer.next();

        System.out.println("Por favor,  metdod");
        meto = Leer.next();

        pro.setNombres_Productos(nomb);
        pro.setTipoProducto_idtipoProducto(tipoid);
        pro.setClientes_idclientes(client);
        pro.setVariableEsp1(variable);
        pro.setRango1(rango);
        pro.setMetodo1(meto);

        boolean respuesta = DaoProductos.registrar(pro);

        if (respuesta == true) {

            System.out.println("Registro Exitoso");
        } else {
            System.out.println("Error en el Registro");
        }

    }
 */
 /* //Liatar Productosref
    public static void main(String[] args) {
    List<Productos> listaProductos = listarNotNull();

    if (listaProductos.isEmpty()) {
        System.out.println("No hay productos para mostrar.");
    } else {
        for (Productos producto : listaProductos) {
            System.out.println("ID: " + producto.getIdProductos());
            System.out.println("Nombre: " + producto.getNombres_Productos());
            System.out.println("Tipo de Producto ID: " + producto.getTipoProducto_idtipoProducto());
            System.out.println("Clientes ID: " + producto.getClientes_idclientes());
            System.out.println("VariableEsp1: " + producto.getVariableEsp1());
            System.out.println("Rango1: " + producto.getRango1());
            System.out.println("Metodo1: " + producto.getMetodo1());
            System.out.println("VariableEsp2: " + producto.getVariableEsp2());
            System.out.println("Rango1: " + producto.getRango2());
            System.out.println("Metodo2: " + producto.getMetodo2());
            // Repite para las demás propiedades...

            // Separador entre productos
            System.out.println("----------------------------------------");
        }
    }
}*/

 /* 
    public static void main(String[] args) {
   
    DaoProductoSeco dao = new DaoProductoSeco();

    
    int idControlCalidad = 1;

    // Llamada al método obtenerclienteFinal
    String clienteFinal = DaoProductoSeco.obtenerclienteFinal(idControlCalidad);

    // Imprimir el resultado
    System.out.println("Cliente final para el control de calidad " + ": " + clienteFinal);
}
 */
//METODO PARA VALIDAR LISTAS
/* public static void main(String[] args) {
        int idControlCalidad = 14; // Cambia este valor por el ID que deseas probar

        List<Especificaciones> especificacionesList = DaoEspecificaciones.listarEspPDF(idControlCalidad);

        // Imprimir los resultados
        System.out.println("Especificaciones encontradas para el control de calidad con ID " + idControlCalidad + ":");
        for (Especificaciones espe : especificacionesList) {
            System.out.println("ID de Especificaciones: " + espe.getIdespecificaciones());
            System.out.println("ID de Producto: " + espe.getIdProductos());
            System.out.println("ID de Cliente: " + espe.getIdclientes());
            System.out.println("Variables de Especificación: " + espe.getVariablesEspecificacion());
            System.out.println("Valor Específico: " + espe.getValorEspecific());
            System.out.println("Método de Análisis: " + espe.getMetodoAnalisis());
            System.out.println("--------------------------------------");
        }

}*/ // Supongamos que tienes una instancia de tu clase que contiene el método listarConsecporIdControl
/*   Consecutivo consecutivo = new Consecutivo();
   // public static void main(String[] args) {
       

        // Supongamos que este es el id del control de calidad que quieres buscar
        int idControlCalidad = 1;

        // Llamamos al método para obtener la lista de consecutivos
        List<Consecutivo> listaConsecutivos = DaoConsecutivo.listarConsecporIdControl(idControlCalidad);

        // Mostramos los resultados
        System.out.println("Consecutivos encontrados para el control de calidad con id " + idControlCalidad + ":");

        for (Consecutivo consecutivo : listaConsecutivos) {
            System.out.println("ID: " + consecutivo.getIdconsecutivo());
            System.out.println("ID Especificaciones: " + consecutivo.getIdEspecificaciones());
            System.out.println("Nro Remisión: " + consecutivo.getNroRemision());
            System.out.println("Nro Consecutivo: " + consecutivo.getNroConsecutivo());
            System.out.println("Fecha Certificado: " + consecutivo.getFechaCertificado());
            System.out.println("Fecha Producción: " + consecutivo.getFechaProduccion());
            System.out.println("Cantidad Material: " + consecutivo.getCantidadMaterial());
            System.out.println("Lote: " + consecutivo.getLote());
            System.out.println("ID Usuarios: " + consecutivo.getIdUsuarios());
            System.out.println("-------------------------");
        }
    }

 }*/
 }
