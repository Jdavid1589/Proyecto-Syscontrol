package util;

import Modelo.Clientes;
import Persistencia.DaoClientes;
import java.util.Scanner;

public class Prueba_Editar_Clientes {

   /* public static void main(String[] args) {
        DaoClientes daoClientes = new DaoClientes();
        Clientes clientes = new Clientes();

        Scanner scanner = new Scanner(System.in);

        int IDventa = 0;
        String razon_Social = "";
        String nombres_apellidos = "";
        int documento_idDocumento = 0;
        String numero_Documento = "";
        String direccion = "";
        String numero_Telefono = "";
        String correo = "";

        System.out.println("Ingrese el ID de la Venta a editar:");
        IDventa = scanner.nextInt();

        System.out.println("Ingrese Nombre empresa:");
        razon_Social = scanner.next();

        System.out.println("Ingrese Nuevo Nombres:");
        nombres_apellidos = scanner.next();

        System.out.println("Ingrese ID tipo doc:");
        documento_idDocumento = scanner.nextInt();
        
        System.out.println("Ingrese # doc:");
        numero_Documento = scanner.next();
        
        System.out.println("Ingrese direc:");
        direccion = scanner.next();
        
        System.out.println("Ingrese telef:");
        numero_Telefono = scanner.next();
        
        System.out.println("Ingrese correo:");
        correo = scanner.next();

        // Seteamos los parámetros con lo ingresado por el usuario
        clientes.setRazon_Social(razon_Social);
        clientes.setNombres_apellidos(nombres_apellidos);
        clientes.setDocumento_idDocumento(documento_idDocumento);
        clientes.setNumero_Documento(numero_Documento);
        clientes.setDireccion(direccion);
        clientes.setNumero_Telefono(numero_Telefono);
        clientes.setCorreo(correo);
        clientes.setIdclientes(IDventa);

        boolean respuesta = daoClientes.editar(clientes);
        if (respuesta) {
            System.out.println("Edición exitosa");
        } else {
            System.out.println("Error al editar");
        }
    }*/

}
