package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalledepedidoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. INSERTAR (Create) ---
    // Este método se llama por cada producto que estaba en el carrito al confirmar la compra
    public int agregar(int cantidad, double precio, int idPedido, int idProducto) {
        String sql = "INSERT INTO Detalle_pedido (cantidad_pedido, precio_unitario, Pedidos_idPedidos, Producto_id_producto) VALUES (?, ?, ?, ?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setDouble(2, precio);
            ps.setInt(3, idPedido);
            ps.setInt(4, idProducto);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar detalle de pedido: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR POR PEDIDO (Read) ---
    public List<Object[]> listarPorPedido(int idPedido) {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT d.idDetalle_pedido, p.nombre_producto, d.cantidad_pedido, d.precio_unitario, (d.cantidad_pedido * d.precio_unitario) as subtotal " +
                     "FROM Detalle_pedido d " +
                     "JOIN Producto p ON d.Producto_id_producto = p.id_producto " +
                     "WHERE d.Pedidos_idPedidos = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("idDetalle_pedido");
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getInt("cantidad_pedido");
                fila[3] = rs.getDouble("precio_unitario");
                fila[4] = rs.getDouble("subtotal");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar detalles del pedido: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ELIMINAR (Delete) ---
    // Nota: Normalmente los detalles de pedido no se actualizan ni eliminan por auditoría, 
    // pero incluimos el método para tus pruebas de desarrollo.
    public int eliminar(int id) {
        String sql = "DELETE FROM Detalle_pedido WHERE idDetalle_pedido = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar detalle: " + e.getMessage());
            return 0;
        }
    }
}