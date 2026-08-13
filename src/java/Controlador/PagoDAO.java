package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;

    public int eliminarPago(int idPago) {
        // SQL basado en la estructura de tu tabla 'Pago'
        String sql = "DELETE FROM Pago WHERE idPago = ?";
        
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPago);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas; 
        } catch (SQLException e) {
            System.err.println("Error al intentar eliminar el pago: " + e.getMessage());
            return 0;
        } finally {
            // Es buena práctica cerrar la conexión
            try { if(con != null) con.close(); } catch (SQLException ex) {}
        }
    }
}