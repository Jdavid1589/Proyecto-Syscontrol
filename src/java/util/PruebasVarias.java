package util;

import Modelo.ControlCalidadComun;
import Modelo.ControlSeco;
import Modelo.Especificaciones;

import Modelo.Usuarios;
import Persistencia.DaoConsecutivo;
import Persistencia.DaoProductoSeco;

import Persistencia.Encriptador;
import java.util.List;

class PruebasVarias {

   /* public static void main(String[] args) {
        // Crear instancias de las clases necesarias
        Especificaciones especificaciones = new Especificaciones();
        DaoConsecutivo dao = new DaoConsecutivo();
        // Crear una instancia de ControlSeco
        ControlSeco controlSeco = new ControlSeco();
        String variable = "";

        
        // Establecer valores de prueba
        controlSeco.setIdControlCalidad(45);
        controlSeco.setWhitness(5555);
        controlSeco.setBrigh(65);

        controlSeco.setCausas("mi prueba");
      

        // Obtener e imprimir algunos valores
        System.out.println("Humedad_1: " + controlSeco.getIdControlCalidad());
        System.out.println("Humedad_1: " + controlSeco.getWhitness());
        System.out.println("Humedad_1: " + controlSeco.getBrigh());
        
       

        /* System.out.println("Especificaciones ID: " + cs.getEspecificacionesId());
        System.out.println("Fecha: " + cs.getFecha());
        System.out.println("Lote: " + cs.getLote());
        System.out.println("Retenido 325: " + cs.getRetenido325());
        System.out.println("pH: " + cs.getpH());
        System.out.println("Abs Aceite: " + cs.getAbsAceite());
        System.out.println("Brigh: " + cs.getBrigh());
        System.out.println("Whitness: " + cs.getWhitness());
        System.out.println("Dv50: " + cs.getDv50());
        System.out.println("Dv90: " + cs.getDv90());
        System.out.println("Observación: " + cs.getObservacion());
        System.out.println("Comentarios: " + cs.getComentarios());*/
    }
    /*
      int nuemro = DaoConsecutivo.obtenerUltimoValorNroConsecutivo();
       System.out.println(nuemro);*/
 /* // Suponiendo que tienes una clase Especificaciones con un constructor apropiado
        List<Especificaciones> resultados = listarparapdf("100", "215");

        // Imprimir los resultados para ver si se obtuvieron correctamente
        for (Especificaciones especificacion : resultados) {
            System.out.println("ID: " + especificacion.getProductos_idProductos());
            System.out.println("Clientes ID: " + especificacion.getClientes_idclientes());
            System.out.println("Valor Especific: " + especificacion.getValorEspecific());
            System.out.println("Variables Especificacion: " + especificacion.getVariablesEspecificacion());
            System.out.println("Método de Análisis: " + especificacion.getMetodoAnalisis());
            // ... imprimir otros atributos según sea necesario
            System.out.println("-----------------------------------");*/


/*Encriptador en = new Encriptador();

        String pass = en.encriptar("cc3");
        System.out.println(pass);

        //System.out.println("Mi Contrase es:" + en.desencriptar("4A8F5YHOC7khQWoKP1r5nA=="));
        System.out.println("Mi Contrase es:" + en.desencriptar("kBACYEB0dZOdxzmmbSMSwQ=="));*/
