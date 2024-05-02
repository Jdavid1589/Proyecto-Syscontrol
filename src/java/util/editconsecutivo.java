package util;

import Modelo.Consecutivo;
import Modelo.ControlSeco;
import Persistencia.DaoConsecutivo;
import Persistencia.DaoProductoSeco;
import java.util.Scanner;

public class editconsecutivo {

   /* public static void main(String[] args) {
        // Creamos un Obj de la clase 
        DaoConsecutivo daoconsecutivo = new DaoConsecutivo();
        DaoProductoSeco daoProductoSeco = new DaoProductoSeco();
        Consecutivo consecutivo = new Consecutivo();
        ControlSeco controlSeco = new ControlSeco();

        Scanner Leer = new Scanner(System.in);

        /* int idconsecutivo = 0;
        String nroRemision = "";
        int productos_idProductos = 0;
        int nroConsecutivo = 0;
        int clientes_idclientes = 0;
        String fechaCertificado = "";
        String fechaProduccion = "";
        int cantidadMaterial = 0;
        int usuarios_idUsuarios = 0;

        System.out.println("Por favor, IdConsecutivo");
        idconsecutivo = Leer.nextInt();
        
        System.out.println("Por favor, nro Remision");
        nroRemision = Leer.next();

        System.out.println("Por favor, IDproducto");
        productos_idProductos = Leer.nextInt();

        System.out.println("Por favor, nro consecutivo");
        nroConsecutivo = Leer.nextInt();

        System.out.println("Por favor, IDcliente");
        clientes_idclientes = Leer.nextInt();

        System.out.println("Por favor, Ingrese FechaCert");
        fechaCertificado = Leer.next();

        System.out.println("Por favor, Ingrese Fechaprod");
        fechaProduccion = Leer.next();

        System.out.println("Por favor, Ingrese Canti Material");
        cantidadMaterial = Leer.nextInt();

        System.out.println("Por favor, Ingrese iDusuarios");
        usuarios_idUsuarios = Leer.nextInt();

        // Seteamos los parametros, pasandole lo ingresado por el Usuario
        consecutivo.setIdconsecutivo(idconsecutivo);
        consecutivo.setNroRemision(nroRemision);
        consecutivo.setProductosRef_idProductos(productos_idProductos);
        consecutivo.setNroConsecutivo(nroConsecutivo);
        consecutivo.setClientes_idclientes(clientes_idclientes);
        consecutivo.setFechaCertificado(fechaCertificado);
        consecutivo.setFechaProduccion(fechaProduccion);
        consecutivo.setCantidadMaterial(cantidadMaterial);
        consecutivo.setUsuarios_idUsuarios(usuarios_idUsuarios);*/
        
        
        /********/
        
      /*  String fecha = "";
        double cant_noconf = 0;
        String causas = "";
        String lote = "";
        double humedad_1 = 0;
        double humedad_2 = 0;
        double humedad_3 = 0;
        double humedad_4 = 0;
        double humedad_5 = 0;
        double humedad_6 = 0;
        double humedad_7 = 0;
        double humedad_8 = 0;
        double humedad_9 = 0;
        double humedad_10 = 0;
        double humedad_promedio = 0;
        double retenido325 = 0;
        double pH = 0;
        double pH_2 = 0;
        double pH_3 = 0;
        double pH_promedio = 0;
        double abs_Aceite = 0;
        double Brigh = 0;
        double Whitness = 0;
        double Dv50 = 0;
        double Dv90 = 0;
        String observacion = "";

        String comentarios = "";

     //   int especificaciones_idespecificaciones = 0;

        int idControlCalidad = 0;*/

       /*- //*******
        System.out.println("Por favor, IDControl");
        idControlCalidad = Leer.nextInt();

        System.out.println("Por favor, fecha");
        fecha = Leer.next();

        System.out.println("Por favor, can no conf");
        cant_noconf = Leer.nextDouble();

        System.out.println("Por favor, causas");
        causas = Leer.next();

        System.out.println("Por favor, lote");
        lote = Leer.next();

        System.out.println("Por favor, humedad_1");
        humedad_1 = Leer.nextDouble();
        System.out.println("Por favor, humedad_2");
        humedad_2 = Leer.nextDouble();
        System.out.println("Por favor, humedad_3");
        humedad_3 = Leer.nextDouble();
        System.out.println("Por favor, humedad_4");
        humedad_4 = Leer.nextDouble();
        System.out.println("Por favor, humedad_1");
        humedad_5 = Leer.nextDouble();
        System.out.println("Por favor, humedad_1");
        humedad_6 = Leer.nextDouble();
        System.out.println("Por favor, humedad_1");
        humedad_7 = Leer.nextDouble();
        System.out.println("Por favor, humedad_1");
        humedad_8 = Leer.nextDouble();
        System.out.println("Por favor, humedad_1");
        humedad_9 = Leer.nextDouble();
        System.out.println("Por favor, humedad_1");
        humedad_10 = Leer.nextDouble();
        System.out.println("Por favor, humedad_promedio");
        humedad_promedio = Leer.nextDouble();
        System.out.println("Por favor, retenido325");
        retenido325 = Leer.nextDouble();
        System.out.println("Por favor, pH");
        pH = Leer.nextDouble();
        System.out.println("Por favor, pH_2");
        pH_2 = Leer.nextDouble();
        System.out.println("Por favor, pH_3");
        pH_3 = Leer.nextDouble();
        System.out.println("Por favor, pH_Pro");
        pH_promedio = Leer.nextDouble();
        System.out.println("Por favor, abs_Aceite");
        abs_Aceite = Leer.nextDouble();
        System.out.println("Por favor, Brigh");
        Brigh = Leer.nextDouble();
        System.out.println("Por favor, Whitness");
        Whitness = Leer.nextDouble();
        System.out.println("Por favor, dv50");
        Dv50 = Leer.nextDouble();
        System.out.println("Por favor, dv90");
        Dv90 = Leer.nextDouble();

        System.out.println("Por favor, observacion");
        observacion = Leer.next();

      //  System.out.println("Por favor, id esp");
       // especificaciones_idespecificaciones = Leer.nextInt();

        controlSeco.setFecha(fecha);
        controlSeco.setCausas(causas);
        controlSeco.setLote(lote);
        controlSeco.setCant_noconf(cant_noconf);
        controlSeco.setHumedad_1(humedad_1);
        controlSeco.setHumedad_2(humedad_2);
        controlSeco.setHumedad_3(humedad_3);
        controlSeco.setHumedad_4(humedad_4);
        controlSeco.setHumedad_5(humedad_5);
        controlSeco.setHumedad_6(humedad_6);
        controlSeco.setHumedad_7(humedad_7);
        controlSeco.setHumedad_8(humedad_8);
        controlSeco.setHumedad_9(humedad_9);
        controlSeco.setHumedad_10(humedad_10);
        controlSeco.setHumedad_promedio(humedad_promedio);
        controlSeco.setRetenido325(retenido325);
        controlSeco.setBrigh(Brigh);
        controlSeco.setWhitness(Whitness);
        controlSeco.setDv50(Dv50);
        controlSeco.setDv90(Dv90);
        controlSeco.setPH(pH);
        controlSeco.setpH_2(pH_2);
        controlSeco.setpH_3(pH_3);
        controlSeco.setpH_promedio(pH_promedio);
        controlSeco.setAbs_Aceite(abs_Aceite);
        controlSeco.setObservacion(observacion);
        controlSeco.setComentarios(comentarios);

        controlSeco.setIdControlCalidad(idControlCalidad);
      //  controlSeco.setIdEspecificaciones(especificaciones_idespecificaciones);

        boolean respuesta = DaoProductoSeco.editar(controlSeco);
        if (respuesta) {
            System.out.println("Edición exitosa");
        } else {
            System.out.println("Error al editar");
        }
    }*/

}
