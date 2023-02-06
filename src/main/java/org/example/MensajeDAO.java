package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajeDAO {
    // DAO (Data access object) son los metodos que permiten la conexion con la base de datos
    // Esta capa es la que ejecuta los comandos SQL para poder traer o enviar datos a la base de datos

    public static void crearMensajeDB(Mensaje mensaje){
        // Creamos una conexion a la base de datos
        Conexion mensajesDB = new Conexion();

        // Ahora con el objeto tipo Connection, creado con el metodo get_connection, nos conectamos a la base de datos
        try (Connection conexionDB = mensajesDB.get_connection()) {

            // Ahora creamos otro bloque try-catch para la insercion de los datos en la base de datos
            try{
                // Ahora guardamos el query necesario para insertar un registro en la base de datos
                String insertQuery = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                // Preparamos el query que se va a ejecutar sobre la base de datos
                PreparedStatement ps = conexionDB.prepareStatement(insertQuery);
                // Y como este query tiene 2 parametros los indicamos en el objeto ps
                ps.setString(1, mensaje.getMensaje()); // El texto del mensaje sera el atributo mensaje del objeto mensaje
                ps.setString(2, mensaje.getAutorMensaje()); // El autor del mensaje sera el atributo autorMensaje del objeto mensaje

                // Ahora con el metodo executeUpdate se ejecuta el query sobre la base de datos
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente!");

            } catch (SQLException e){
                System.out.println(e);
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static ArrayList<Mensaje> leerMensajesDB(){
        Conexion mensajesDB = new Conexion();
        ArrayList<Mensaje> list = new ArrayList<>();

        try (Connection conexionDB = mensajesDB.get_connection()) {

            String readQuery = "SELECT * FROM mensajes";
            PreparedStatement ps = conexionDB.prepareStatement(readQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Mensaje listElement = new Mensaje();
                listElement.setIdMensaje(rs.getInt("id_mensaje"));
                listElement.setMensaje(rs.getString("mensaje"));
                listElement.setAutorMensaje(rs.getString("autor_mensaje"));
                listElement.setFechaMensaje(rs.getString("fecha_mensaje"));
                list.add(listElement);
            }
            rs.close();
        } catch (SQLException e){
            System.out.println("No fue posible recuperar los mensajes");
            System.out.println(e);
        }
        return list;
    }

    public static void borrarMensajeDB(int idMensaje){
    }

    public static void editarMensajeDB(Mensaje mensaje){
    }
}
