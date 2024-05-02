package util;

import Modelo.ControlSeco;
import Modelo.Especificaciones;
import Persistencia.DaoEspecificaciones;
import Persistencia.DaoProductoSeco;
import java.util.Scanner;

/*public class addEspecificaciones {

 /*  public static void main(String[] args) {
/*
        // Creamos un Obj de la clase DaoVentas
        DaoEspecificaciones daoEspecificaciones = new DaoEspecificaciones();
        DaoProductoSeco daops = new DaoProductoSeco();
        Especificaciones especificaciones = new Especificaciones();
        ControlSeco controlSeco = new ControlSeco();

        Scanner Leer = new java.util.Scanner(System.in);

        String fecha = "";
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
        int idproducto = 0;
        int idusuarios = 0;
        int idconsecutivo = 0;

        System.out.println("Por favor, fecha");
        fecha = Leer.nextLine();

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
        System.out.println("Por favor, humedad_5");
        humedad_5 = Leer.nextDouble();
        System.out.println("Por favor, humedad_6");
        humedad_6 = Leer.nextDouble();
        System.out.println("Por favor, humedad_7");
        humedad_7 = Leer.nextDouble();
        System.out.println("Por favor, humedad_8");
        humedad_8 = Leer.nextDouble();
        System.out.println("Por favor, humedad_9");
        humedad_9 = Leer.nextDouble();
        System.out.println("Por favor, humedad_10");
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
        System.out.println("Por favor, id producto");
        idproducto = Leer.nextInt();
        System.out.println("Por favor, id Usuario");
        idusuarios = Leer.nextInt();
        System.out.println("Por favor, id Consecutivo");
        idconsecutivo = Leer.nextInt();

        // Seteamos los parametros, pasandole lo ingresado por el Usuario
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
        controlSeco.setObservacion(observacion);
        controlSeco.setIdProductos(idproducto);
       // controlSeco.setComentarios(comentarios);
        controlSeco.setAbs_Aceite(abs_Aceite);
        controlSeco.setIdUsuarios(idusuarios);
        controlSeco.setIdConsecutivo(idconsecutivo);

        boolean respuesta = daops.grabar3(controlSeco);
        if (respuesta == true) {
            System.out.println("Registro Exitoso");
        } else {
            System.out.println("Error" + respuesta);
        }

     /*
        int productos_idProductos = 0;
        int clientes_idclientes = 0;
        String variablesEspecificacion = "";
        String especificaciones2 = "";
        String metodoAnalisis = "";

        System.out.println("Por favor, IDproducto");
        productos_idProductos = Leer.nextInt();

        System.out.println("Por favor, IDcliente");
        clientes_idclientes = Leer.nextInt();

        System.out.println("Por favor, variablesEspecificacion");
        variablesEspecificacion = Leer.next();

        System.out.println("Por favor, especificaciones2");
        especificaciones2 = Leer.next();

        System.out.println("Por favor, metodoAnalisis");
        metodoAnalisis = Leer.next();

        // Seteamos los parametros, pasandole lo ingresado por el Usuario
        especificaciones.setProductos_idProductos(productos_idProductos);
        especificaciones.setClientes_idclientes(clientes_idclientes);
        especificaciones.setVariablesEspecificacion(variablesEspecificacion);
        especificaciones.setValorEspecific(especificaciones2);
        especificaciones.setMetodoAnalisis(metodoAnalisis);

        boolean respuesta = daoEspecificaciones.grabarEsp(especificaciones);
        if (respuesta == true) {
            System.out.println("Registro Exitoso");
        } else {
            System.out.println("Error" + respuesta);
        }
    */



