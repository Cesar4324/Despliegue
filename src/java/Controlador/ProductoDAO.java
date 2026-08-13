package Controlador;

import Conexion.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // ==========================
    // AGREGAR PRODUCTO
    // ==========================
    public int agregar(String nombre, String desc, double precio, int stock,
            int idCat, int idMarca, int idColor, int idTalla) {

        String sql = "INSERT INTO Producto "
                + "(nombre_producto, descripcion, precio, stock, "
                + "Categorias_idCategorias, Marca_idMarca, "
                + "Colores_idColores, Talla_idTalla) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {

            con = Conexion.getConnection();

            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, desc);
            ps.setDouble(3, precio);
            ps.setInt(4, stock);
            ps.setInt(5, idCat);
            ps.setInt(6, idMarca);
            ps.setInt(7, idColor);
            ps.setInt(8, idTalla);

            return ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error al insertar producto: " + e.getMessage());

        }

        return 0;
    }

    // ==========================
    // LISTAR PRODUCTOS
    // ==========================
    public List<Producto> listar() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM Producto";

        try {

            con = Conexion.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Producto p = new Producto();

                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));

                lista.add(p);

            }

        } catch (SQLException e) {

            System.out.println("Error al listar productos: " + e.getMessage());

        }

        return lista;
    }

    // ==========================
    // ACTUALIZAR PRODUCTO
    // ==========================
    public int actualizar(int id, String nombre, double precio, int stock) {

        String sql = "UPDATE Producto "
                + "SET nombre_producto=?, precio=?, stock=? "
                + "WHERE id_producto=?";

        try {

            con = Conexion.getConnection();

            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, stock);
            ps.setInt(4, id);

            return ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error al actualizar producto: " + e.getMessage());

        }

        return 0;
    }

    // ==========================
    // ELIMINAR PRODUCTO
    // ==========================
    public int eliminar(int id) {

        String sql = "DELETE FROM Producto WHERE id_producto=?";

        try {

            con = Conexion.getConnection();

            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error al eliminar producto: " + e.getMessage());

        }

        return 0;
    }
}