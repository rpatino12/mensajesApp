package org.example;

import java.sql.Connection;

public class Inicio {
    public static void main(String[] args) {
        // Creamos un objeto de tipo Conexion
        Conexion conexion = new Conexion();
        // Nos conectamos a la base de datos, con el metodo get_connection del objeto conexion
        try{
            Connection cnx = conexion.get_connection();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
