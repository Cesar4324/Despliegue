package Controlador;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarritocabezaDAO {

    Conexion cn = new Conexion();

    // INSERTAR
    public boolean agregar(double total, int idUsuario) {

        String sql = "INSERT INTO Carrito_Cabeza(total_pagar, Usuarios_idusuarios) VALUES(?,?)";

        try (
                Connection con = cn.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setDouble(1, total);
            ps.setInt(2, idUsuario);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al agregar carrito: " + e.getMessage());

            return false;
        }
    }

    // LISTAR
    public List<Object[]> listar() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT * FROM Carrito_Cabeza";

        try (
                Connection con = cn.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Object[] fila = new Object[3];

                fila[0] = rs.getInt("idCarrito_Cabeza");
                fila[1] = rs.getDouble("total_pagar");
                fila[2] = rs.getInt("Usuarios_idusuarios");

                lista.add(fila);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar carritos: " + e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public boolean actualizarTotal(int id, double total) {

        String sql = "UPDATE Carrito_Cabeza SET total_pagar=? WHERE idCarrito_Cabeza=?";

        try (
                Connection con = cn.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setDouble(1, total);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al actualizar carrito: " + e.getMessage());

            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {

        String sql = "DELETE FROM Carrito_Cabeza WHERE idCarrito_Cabeza=?";

        try (
                Connection con = cn.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al eliminar carrito: " + e.getMessage());

            return false;
        }
    }
}