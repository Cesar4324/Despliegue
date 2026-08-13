package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. AGREGAR (Create) ---
    public int agregar(String nombre) {
        String sql = "INSERT INTO Pais (nombre_pais) VALUES (?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar país: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR (Read) ---
    public List<Object[]> listar() {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT * FROM Pais";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("idPais");
                fila[1] = rs.getString("nombre_pais");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar países: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR (Update) ---
    public int actualizar(int id, String nuevoNombre) {
        String sql = "UPDATE Pais SET nombre_pais = ? WHERE idPais = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar país: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR (Delete) ---
    public int eliminar(int id) {
        String sql = "DELETE FROM Pais WHERE idPais = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error de Integridad: No se puede eliminar un país que tiene departamentos o ciudades asociadas.");
            return 0;
        }
    }
}