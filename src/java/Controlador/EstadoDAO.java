package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. AGREGAR (Create) ---
    public int agregar(String nombreEstado) {
        String sql = "INSERT INTO Estado (nombre_estado) VALUES (?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreEstado);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar estado: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR (Read) ---
    public List<Object[]> listar() {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT * FROM Estado";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("idEstado");
                fila[1] = rs.getString("nombre_estado");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar estados: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR (Update) ---
    public int actualizar(int id, String nuevoNombre) {
        String sql = "UPDATE Estado SET nombre_estado = ? WHERE idEstado = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar estado: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR (Delete) ---
    public int eliminar(int id) {
        String sql = "DELETE FROM Estado WHERE idEstado = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error de Integridad: No se puede eliminar un estado que ya está asignado a un pedido.");
            return 0;
        }
    }
}