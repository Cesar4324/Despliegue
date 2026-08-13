package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Importaciones oficiales de tu proyecto
import Conexion.Conexion;
import Modelo.Producto;

public class TiendaDAO {

    private Conexion conexionBase = new Conexion();

    // Consultas SQL adaptadas a los campos de tu base de datos
    private static final String SQL_PRODUCTOS_DESTACADOS = 
            "SELECT id_producto, nombre, descripcion, precio, stock, id_categoria, url_imagen FROM productos ORDER BY id_producto DESC LIMIT 6";
    
    private static final String SQL_BUSCAR_PRODUCTO = 
            "SELECT id_producto, nombre, descripcion, precio, stock, id_categoria, url_imagen FROM productos WHERE nombre LIKE ?";

    /**
     * Obtiene los productos destacados para mostrar en las tarjetas de la Tienda
     */
    public List<Producto> obtenerProductosDestacados() throws Exception {
        List<Producto> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = conexionBase.getConexion();
            ps = conn.prepareStatement(SQL_PRODUCTOS_DESTACADOS);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                
                // Mapeo corregido usando los métodos exactos del modelo Producto
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdCategoria(rs.getInt("id_categoria"));
                prod.setUrlImagen(rs.getString("url_imagen"));

                lista.add(prod);
            }
        } catch (Exception e) {
            System.out.println("Error en TiendaDAO.obtenerProductosDestacados: " + e.getMessage());
            throw e;
        } finally {
            cerrarRecursos(conn, ps, rs);
        }
        return lista;
    }

    /**
     * Busca productos por nombre para el buscador de ByStyles
     */
    public List<Producto> buscarProductos(String textoBusqueda) throws Exception {
        List<Producto> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = conexionBase.getConexion();
            ps = conn.prepareStatement(SQL_BUSCAR_PRODUCTO);
            ps.setString(1, "%" + textoBusqueda + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdCategoria(rs.getInt("id_categoria"));
                prod.setUrlImagen(rs.getString("url_imagen"));

                lista.add(prod);
            }
        } catch (Exception e) {
            System.out.println("Error en TiendaDAO.buscarProductos: " + e.getMessage());
            throw e;
        } finally {
            cerrarRecursos(conn, ps, rs);
        }
        return lista;
    }

    // Cierre seguro de conexiones que limpia los errores del finally
    private void cerrarRecursos(Connection conn, PreparedStatement ps, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
}