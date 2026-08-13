package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImagendeproductoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. AGREGAR RUTA DE IMAGEN (Create) ---
    public int agregar(String ruta, int idProducto) {
        String sql = "INSERT INTO Imagenes_Producto (ruta_imagen, Producto_id_producto) VALUES (?, ?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ruta);
            ps.setInt(2, idProducto);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar imagen: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR IMÁGENES DE UN PRODUCTO (Read) ---
    public List<Object[]> listarPorProducto(int idProducto) {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT * FROM Imagenes_Producto WHERE Producto_id_producto = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("idImagenes_Producto");
                fila[1] = rs.getString("ruta_imagen");
                fila[2] = rs.getInt("Producto_id_producto");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar imágenes: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR RUTA (Update) ---
    public int actualizar(int idImagen, String nuevaRuta) {
        String sql = "UPDATE Imagenes_Producto SET ruta_imagen = ? WHERE idImagenes_Producto = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevaRuta);
            ps.setInt(2, idImagen);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar imagen: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR REGISTRO DE IMAGEN (Delete) ---
    public int eliminar(int idImagen) {
        String sql = "DELETE FROM Imagenes_Producto WHERE idImagenes_Producto = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idImagen);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar imagen: " + e.getMessage());
            return 0;
        }
    }
}