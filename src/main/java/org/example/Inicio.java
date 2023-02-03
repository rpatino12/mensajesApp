package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
//        // Creamos un objeto de tipo Conexion
//        Conexion conexion = new Conexion();
//        // Nos conectamos a la base de datos, con el metodo get_connection del objeto conexion
//        try{
//            Connection cnx = conexion.get_connection();
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }

        // Vamos a crear un menu con la clase Scanner, el cual se conecta con la capa de servicios
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("===================================");
            System.out.println("MensajesApp: Aplicacion de mensajes");
            System.out.println("\t1. Crear mensaje");
            System.out.println("\t2. Leer mensajes");
            System.out.println("\t3. Editar mensaje");
            System.out.println("\t4. Eliminar mensaje");
            System.out.println("\t5. Salir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.leerMensajes();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Ingresa una opcion correcta");
                    break;
            }
        } while(opcion != 5);
    }
}
