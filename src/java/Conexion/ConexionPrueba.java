package Conexion;

import java.sql.Connection;

public class ConexionPrueba {

    public static void main(String[] args) {

        Connection c = Conexion.getConnection();

        if (c != null) {

            System.out.println(">>> CONEXIÓN EXITOSA CON MYSQL <<<");

            try {
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            System.out.println(">>> ERROR: LA CONEXIÓN ES NULA (NULL) <<<");
        }
    }
}