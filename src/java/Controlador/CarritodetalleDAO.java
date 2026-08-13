package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarritodetalleDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. AGREGAR PRODUCTO AL CARRITO (Create) ---
    public int agregar(int cantidad, int idCabeza, int idProducto) {
        String sql = "INSERT INTO Carrito_Detalle (cantidad, Carrito_Cabeza_idCarrito_Cabeza, Producto_id_producto) VALUES (?, ?, ?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idCabeza);
            ps.setInt(3, idProducto);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar detalle de carrito: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR PRODUCTOS DE UN CARRITO (Read) ---
    public List<Object[]> listarPorCarrito(int idCabeza) {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT cd.idCarrito_Detalle, p.nombre_producto, cd.cantidad, p.precio, (cd.cantidad * p.precio) as subtotal " +
                     "FROM Carrito_Detalle cd " +
                     "JOIN Producto p ON cd.Producto_id_producto = p.id_producto " +
                     "WHERE cd.Carrito_Cabeza_idCarrito_Cabeza = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCabeza);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("idCarrito_Detalle");
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getInt("cantidad");
                fila[3] = rs.getDouble("precio");
                fila[4] = rs.getDouble("subtotal");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar detalle: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR CANTIDAD (Update) ---
    public int actualizarCantidad(int idDetalle, int nuevaCantidad) {
        String sql = "UPDATE Carrito_Detalle SET cantidad = ? WHERE idCarrito_Detalle = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevaCantidad);
            ps.setInt(2, idDetalle);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar cantidad: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR UN ITEM (Delete) ---
    public int eliminar(int idDetalle) {
        String sql = "DELETE FROM Carrito_Detalle WHERE idCarrito_Detalle = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar item del carrito: " + e.getMessage());
            return 0;
        }
    }
}