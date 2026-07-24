package Controlador;

import  Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. INSERTAR (Create) ---
    public int agregar(String nombre) {
        String sql = "INSERT INTO Categorias (nombre_categoria) VALUES (?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar categoría: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR (Read) ---
    public List<Object[]> listar() {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT * FROM Categorias";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("idCategorias");
                fila[1] = rs.getString("nombre_categoria");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR (Update) ---
    public int actualizar(int id, String nuevoNombre) {
        String sql = "UPDATE Categorias SET nombre_categoria = ? WHERE idCategorias = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar categoría: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR (Delete) ---
    public int eliminar(int id) {
        String sql = "DELETE FROM Categorias WHERE idCategorias = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error de Integridad: No se puede eliminar una categoría que tiene productos asociados.");
            return 0;
        }
    }
}