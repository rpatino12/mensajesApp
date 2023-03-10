package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MensajeService {
    // Esta clase es la capa intermedia entre el menu principal y la capa de acceso (DAO)

    // Aqui vamos a crear los metodos que va a usar el menu de usuario para conectar con la capa DAO
    // Y luego con la capa DAO (clase MensajeDAO) conectar con la base de datos
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String texto = sc.nextLine();

        System.out.println("Autor del mensaje: ");
        String autor = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(texto);
        registro.setAutorMensaje(autor);
        // Como con los metodos de la capa de servicio, este metodo obtendra los datos desde el menu principal
        // Y posteriormente llama al metodo de la capa de acceso
        MensajeDAO.crearMensajeDB(registro);
    }

    public static void leerMensajes(){
        ArrayList<Mensaje> listaMensajes = MensajeDAO.leerMensajesDB();
        System.out.printf("Se encontraron %d registro(s): \n\n", listaMensajes.size());
        for (Mensaje m:listaMensajes) {
            System.out.println("ID: "+m.getIdMensaje());
            System.out.println("Mensaje: "+m.getMensaje());
            System.out.println("Autor: "+m.getAutorMensaje());
            System.out.println("Fecha: "+m.getFechaMensaje());
            System.out.println("");
        }
    }

    public static void borrarMensaje(){
        System.out.println("Por favor indica el id del mensaje a borrar: ");
        Scanner sc = new Scanner(System.in);
        int idMensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(idMensaje);
    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje nuevo: ");
        String texto = sc.nextLine();

        System.out.println("Autor del mensaje nuevo: ");
        String autor = sc.nextLine();

        System.out.println("Id del mensaje que vas a editar: ");
        int idMensaje = sc.nextInt();

        Mensaje actualizacion = new Mensaje();
        actualizacion.setMensaje(texto);
        actualizacion.setAutorMensaje(autor);
        actualizacion.setIdMensaje(idMensaje);

        MensajeDAO.editarMensajeDB(actualizacion);
    }

}
