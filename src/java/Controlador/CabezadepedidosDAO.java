package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CabezadepedidosDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- 1. INSERTAR (Create) ---
    public int agregar(double total, String fecha, int idUser, int idEstado, int idPago) {
        String sql = "INSERT INTO Cabeza_Pedidos (total_Pedido, fecha_pedido, Usuarios_idusuarios, Estado_idEstado, Mediodepago_idMediodepago) VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, total);
            ps.setString(2, fecha);
            ps.setInt(3, idUser);
            ps.setInt(4, idEstado);
            ps.setInt(5, idPago);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar cabeza de pedido: " + e.getMessage());
            return 0;
        }
    }

    // --- 2. LISTAR (Read) ---
    public List<Object[]> listar() {
        List<Object[]> datos = new ArrayList<>();
        String sql = "SELECT * FROM Cabeza_Pedidos";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("idPedidos");
                fila[1] = rs.getDouble("total_Pedido");
                fila[2] = rs.getString("fecha_pedido");
                fila[3] = rs.getInt("Usuarios_idusuarios");
                fila[4] = rs.getInt("Estado_idEstado");
                fila[5] = rs.getInt("Mediodepago_idMediodepago");
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pedidos: " + e.getMessage());
        }
        return datos;
    }

    // --- 3. ACTUALIZAR (Update) ---
    public int actualizar(int id, double nuevoTotal, int nuevoEstado) {
        String sql = "UPDATE Cabeza_Pedidos SET total_Pedido = ?, Estado_idEstado = ? WHERE idPedidos = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, nuevoTotal);
            ps.setInt(2, nuevoEstado);
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar pedido: " + e.getMessage());
            return 0;
        }
    }

    // --- 4. ELIMINAR (Delete) ---
    public int eliminar(int id) {
        String sql = "DELETE FROM Cabeza_Pedidos WHERE idPedidos = ?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error de Integridad: El pedido tiene detalles asociados.");
            return 0;
        }
    }
}