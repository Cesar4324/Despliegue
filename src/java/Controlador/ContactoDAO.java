package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContactoDAO {

    Connection con;
    PreparedStatement ps;

    public boolean guardar(String nombre,
                           String correo,
                           String mensaje) {

        String sql =
        "INSERT INTO contacto(nombre,correo,mensaje) VALUES(?,?,?)";

        try {

            con = Conexion.getConnection();

            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, mensaje);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println("Error contacto: "
                    + e.getMessage());

            return false;
        }
    }
}