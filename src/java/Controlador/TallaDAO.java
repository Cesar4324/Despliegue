package Controlador ;

import Conexion .Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TallaDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. INSERTAR (Create) ---
    public int agregar(String descripcion) {
        String sql = "INSERT INTO Tallas (descripcionTallas) VALUES (?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, descripcion);
            return ps.executeUpdate(); 
        } catch (SQLException e) {
            System.err.println("Error al insertar talla: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. CONSULTAR TODOS (Read) ---
    public List<Object[]> listar() {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT * FROM Tallas";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("idTallas"); // idTallas del script 
                fila[1] = rs.getString("descripcionTallas"); // descripcionTallas del script 
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar tallas: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR (Update) ---
    public int actualizar(int id, String nuevaDescripcion) {
        String sql = "UPDATE Tallas SET descripcionTallas = ? WHERE idTallas = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevaDescripcion);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar talla: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR (Delete) ---
    public int eliminar(int id) {
        String sql = "DELETE FROM Tallas WHERE idTallas = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            // Error común: llave foránea vinculada a la tabla Producto 
            System.err.println("Error: No se puede eliminar. La talla está en uso por un producto.");
            return 0;
        }
    }
}