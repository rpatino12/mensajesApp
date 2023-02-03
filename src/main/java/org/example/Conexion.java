package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connection(){
        Connection connection = null;
        try{
            // En este caso se utiliza localhost para el ejemplo, pero en un caso profesional se utiliza la url de la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/mensajes_app","root","");
            // Ahora validamos si efectivamente la conexion se realiza
//            if (connection != null){
//                // Si el objeto no es nulo entonces imprimimos un mensaje de conexion exitosa
//                System.out.println("Conexion exitosa!");
//            }
        }
        // Ahora en caso de que no se pueda generar esa conexion el bloque catch recibe la excepcion e imrpime el mensaje
        catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
