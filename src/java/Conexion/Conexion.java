package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://sakura.proxy.rlwy.net:25635/railway?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "sIZLYldtrwPIiEJZJQQbAHGiDUJEtbUn";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

    public static Connection getConexion() {
        return getConnection();
    }
}