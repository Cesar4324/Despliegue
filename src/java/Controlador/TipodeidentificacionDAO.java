package Controlador;

import Conexion.Conexion;
import Modelo.Tipodeidentificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipodeidentificacionDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // 1. LISTAR
    public List<Tipodeidentificacion> listar() {
        List<Tipodeidentificacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipodeidentificacion"; 
        try {
            con = Conexion.getConnection(); 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tipodeidentificacion tipo = new Tipodeidentificacion();
                tipo.setId(rs.getInt("idTipoIdentificacion")); 
                // CORREGIDO: usar "descripcionTipoDoc" en vez de "descripcion"
                tipo.setDescripcion(rs.getString("descripcionTipoDoc"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            System.err.println("Error al listar tipos de identificación: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    // 2. INSERTAR
    public boolean insertar(Tipodeidentificacion tipo) {
        // CORREGIDO: usar "descripcionTipoDoc" en vez de "descripcion"
        String sql = "INSERT INTO tipodeidentificacion (descripcionTipoDoc) VALUES (?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo.getDescripcion());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.err.println("Error al insertar tipo de identificación: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // 3. CONSULTAR POR ID
    public Tipodeidentificacion buscarPorId(int id) {
        Tipodeidentificacion tipo = null;
        String sql = "SELECT * FROM tipodeidentificacion WHERE idTipoIdentificacion = ?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                tipo = new Tipodeidentificacion();
                tipo.setId(rs.getInt("idTipoIdentificacion"));
                // CORREGIDO: usar "descripcionTipoDoc" en vez de "descripcion"
                tipo.setDescripcion(rs.getString("descripcionTipoDoc"));
            }
        } catch (Exception e) {
            System.err.println("Error al buscar tipo de identificación: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return tipo;
    }

    // 4. ACTUALIZAR
    public boolean actualizar(Tipodeidentificacion tipo) {
        // CORREGIDO: usar "descripcionTipoDoc" en vez de "descripcion"
        String sql = "UPDATE tipodeidentificacion SET descripcionTipoDoc = ? WHERE idTipoIdentificacion = ?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo.getDescripcion());
            ps.setInt(2, tipo.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.err.println("Error al actualizar tipo de identificación: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // 5. ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM tipodeidentificacion WHERE idTipoIdentificacion = ?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.err.println("Error al eliminar tipo de identificación: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // Método para cerrar las conexiones
    private void cerrarRecursos() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}