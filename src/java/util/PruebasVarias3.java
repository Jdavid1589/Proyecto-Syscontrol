
package util;

import Modelo.ControlSeco;
import Modelo.EspecificacionesLodos;
import Modelo.ReportePdfSeco;
import Modelo.Variable;
import Persistencia.DaoEspecificaciones;
import Persistencia.DaoEspecificacionesLodos;
import Persistencia.DaoProductoSeco;
import Persistencia.DaoReportePdfSeco;
import java.lang.reflect.Field;
import java.util.List;

public class PruebasVarias3 {
    
    public static void main(String[] args) {
        // Crear un objeto ControlSeco con los valores que se desean editar
        ControlSeco controlSeco = new ControlSeco();
        controlSeco.setIdControlCalidad(1); // ID del registro que se desea editar
        controlSeco.setIdUsuarios(1); // ID del registro que se desea editar
        controlSeco.setIdProductos(1); // ID del registro que se desea editar
        controlSeco.setIdConsecutivo(0001); // ID del registro que se desea editar
        controlSeco.setFecha("2024-03-27"); // Nueva fecha
        controlSeco.setLote("Nuevo lote"); // Nuevo lote
     
        controlSeco.setCausas("Nuevas causas"); // Nuevas causas
        controlSeco.setHumedad_promedio(5.0); // Nuevo valor de humedad promedio
        controlSeco.setpH(5.0); // Nuevo valor de humedad promedio
        controlSeco.setpH_2(5.0); // Nuevo valor de humedad promedio
        controlSeco.setpH_3(5.0); // Nuevo valor de humedad promedio
        controlSeco.setpH_promedio(5.0); // Nuevo valor de humedad promedio
        controlSeco.setAbs_Aceite(5.0); // Nuevo valor de humedad promedio
        controlSeco.setDv50(5.0); // Nuevo valor de humedad promedio
        controlSeco.setDv90(5.0); // Nuevo valor de humedad promedio
        controlSeco.setBrigh(5.0); // Nuevo valor de humedad promedio
        controlSeco.setWhitness(5.0); // Nuevo valor de humedad promedio
      
        controlSeco.setpH_promedio(5.0); // Nuevo valor de humedad promedio
        controlSeco.setHumedad_promedio(5.0); // Nuevo valor de humedad promedio
        controlSeco.setHumedad_promedio(5.0); // Nuevo valor de humedad promedio
        // Se deben establecer los valores de los demás atributos según sea necesario

        // Llamar al método editar2 para actualizar el registro en la base de datos
        boolean editado = DaoProductoSeco.editar2(controlSeco);

        // Verificar si la edición fue exitosa
        if (editado) {
            System.out.println("El registro se ha editado correctamente.");
        } else {
            System.out.println("Hubo un problema al intentar editar el registro.");
        }
        }
    
    
    
    
   /* 
    public static void main(String[] args) {
        // Crear un objeto ControlSeco con datos de ejemplo
        ControlSeco controlSeco = new ControlSeco();
        controlSeco.setFecha("2024-03-27");
        controlSeco.setCant_noconf(10.5);
        controlSeco.setCausas("Causas de ejemplo");
        controlSeco.setLote("Lote de ejemplo");
        controlSeco.setHumedad(1, 5.3); // Establecer humedad para el campo 1
        controlSeco.setHumedad(2, 6.2); // Establecer humedad para el campo 2
        // Establecer más campos de humedad si es necesario
        
        // Establecer los demás campos de ejemplo
        controlSeco.setHumedad_promedio(7.8);
        controlSeco.setRetenido325(15.6);
        controlSeco.setPH(3.2);
        controlSeco.setpH_2(4.1);
        controlSeco.setpH_3(5.5);
        controlSeco.setpH_promedio(4.5);
        controlSeco.setAbs_Aceite(0.025);
        controlSeco.setBrigh(90.5);
        controlSeco.setWhitness(95.7);
        controlSeco.setDv50(10.3);
        controlSeco.setDv90(20.7);
        controlSeco.setObservacion("Observación de ejemplo");
        controlSeco.setComentarios("Comentarios de ejemplo");
        controlSeco.setIdProductos(1);
        controlSeco.setIdUsuarios(1);
        controlSeco.setIdConsecutivo(1);
        
        // Llamar al método grabar3 para intentar insertar los datos en la base de datos
        if (DaoProductoSeco.grabar4(controlSeco)) {
            System.out.println("Los datos se han insertado correctamente en la base de datos.");
        } else {
            System.out.println("Ha ocurrido un error al insertar los datos en la base de datos.");
        }
    }
    }*/
 

/*
    public static void main(String[] args) {
        // Llamar al método listar() para obtener la lista de ControlSeco desde la base de datos
        List<ControlSeco> listaControlSeco = DaoProductoSeco.listar();

        // Iterar sobre la lista de ControlSeco y mostrar la información en la consola
        for (ControlSeco controlSeco : listaControlSeco) {
            System.out.println("ID: " + controlSeco.getIdControlCalidad());
            System.out.println("Fecha: " + controlSeco.getFecha());
            System.out.println("Lote: " + controlSeco.getLote());
            // Agregar más campos según sea necesario

            // Mostrar las humedades
            for (int i = 1; i <= 30; i++) {
                System.out.println("Humedad " + i + ": " + controlSeco.getHumedad(i));
            }

            System.out.println("------------------------------------");
        }
    }
}*/




    
    /*
    public static void main(String[] args) {
    // Supongamos que tenemos un id específico para probar
    int id = 6;

    // Llamamos al método para obtener las especificaciones por el id proporcionado
    EspecificacionesLodos especificaciones = DaoEspecificacionesLodos.obtenerEspecificPorId(id);

    // Verificamos si se encontraron especificaciones
    if (especificaciones != null) {
        // Imprimimos las especificaciones encontradas
        System.out.println("Especificaciones encontradas para el ID " + id + ":");
        System.out.println("ID Especificaciones: " + especificaciones.getIdespecificaciones());
        System.out.println("ID Productos: " + especificaciones.getIdProductos());
        System.out.println("ID Clientes: " + especificaciones.getIdclientes());
        System.out.println("Variables Específicas:");
        System.out.println("Variable Esp1: " + especificaciones.getVariableEsp1());
        System.out.println("Variable Esp1: " + especificaciones.getVariableEsp1());
        System.out.println("Rango 1: " + especificaciones.getRango1());
        System.out.println("Metodo 1: " + especificaciones.getMetodo1());
        // Repite para todas las variables específicas, rangos y métodos...

    } else {
        // Si no se encuentran especificaciones para el ID proporcionado
        System.out.println("No se encontraron especificaciones para el ID " + id);
    }
}

    
    
   /* public static void main(String[] args) {
        List<EspecificacionesLodos> listaEspecificaciones = DaoEspecificacionesLodos.listarEspPDF(100);
        
        // Iterar sobre la lista e imprimir los detalles de cada objeto EspecificacionesLodos
        for (EspecificacionesLodos espe : listaEspecificaciones) {
            System.out.println("Id Especificaciones: " + espe.getIdespecificaciones());
            System.out.println("Id Productos: " + espe.getIdProductos());
            System.out.println("Id Clientes: " + espe.getIdclientes());
            System.out.println("VariableEsp1: " + espe.getVariableEsp1());
            System.out.println("VariableEsp2: " + espe.getVariableEsp2());
            // Continuar para todas las variables que desees imprimir
            System.out.println("----------------------------------");
        }
    }*/
    
  
   /*
    public static void main(String[] args) {
        List<ReportePdfSeco> reportes = DaoReportePdfSeco.listar();

        // Imprimir los reportes
        for (ReportePdfSeco reporte : reportes) {
            System.out.println("ID Certificado Seco: " + reporte.getIdCertificadoSeco());
            System.out.println("Producto: " + reporte.getProducto());
            System.out.println("Fecha de Certificado: " + reporte.getFechaCertificado());
            System.out.println("Cliente: " + reporte.getCliente());
            System.out.println("Número de Certificado: " + reporte.getNumCertificado());
            System.out.println("Fecha de Producción: " + reporte.getFechaProduccion());
            System.out.println("Cantidad de Sacos: " + reporte.getCantidadSacos());
            System.out.println("Lote: " + reporte.getLote());
            System.out.println("Humedad: " + reporte.getHumedad());
            System.out.println("pH: " + reporte.getpH());
            System.out.println("Retenido 325: " + reporte.getRetenido325());
            System.out.println("AA: " + reporte.getAA());
            System.out.println("Br: " + reporte.getBr());
            System.out.println("Wh: " + reporte.getWh());
            System.out.println("Yell: " + reporte.getYell());
            System.out.println("Dv50: " + reporte.getDv50());
            System.out.println("Auxiliar: " + reporte.getAuxiliar());

            // Imprimir variables y rangos
            List<Variable> variables = reporte.getVariables();
            for (int i = 0; i < variables.size(); i++) {
                Variable variable = variables.get(i);
                System.out.println("Variable " + (i+1) + ": " + variable.getTipo());
                System.out.println("Rango " + (i+1) + ": " + variable.getRango());
            }
            System.out.println("-----------------------------------------");
        }
    }
*/
}


    
    
    

