package Controlador;

import Conexion.Conexion;
import Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // REGISTRAR
    public boolean registrar(Usuarios usuario) {
        // CORREGIDO: "usuarios" en minúsculas para coincidir con la Base de Datos
        String sql = "INSERT INTO usuarios "
                + "(nombre, apellido, identificacion, telefono, direccion, email, clave, fecha_nacimiento, TipoIdentificacion_idTipoIdentificacion, Rol_idRol) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getIdentificacion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getClave());
            ps.setDate(8, usuario.getFecha_nacimiento());
            ps.setInt(9, usuario.getTipoIdentificacion_idTipoIdentificacion());
            ps.setInt(10, usuario.getRol_idRol());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error registrar: " + e.getMessage());
            return false;
        } finally {
            cerrar();
        }
    }

    // LOGIN
    public Usuarios validarLogin(String email, String clave) {
        Usuarios usuario = null;
        // CORREGIDO: "usuarios" en minúsculas
        String sql = "SELECT * FROM usuarios WHERE email=? AND clave=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, clave);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuarios();
                usuario.setIdusuarios(rs.getInt("idusuarios"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setEmail(rs.getString("email"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRol_idRol(rs.getInt("Rol_idRol"));
                usuario.setTipoIdentificacion_idTipoIdentificacion(
                        rs.getInt("TipoIdentificacion_idTipoIdentificacion"));
                usuario.setFecha_nacimiento(
                        rs.getDate("fecha_nacimiento"));
            }

        } catch (Exception e) {
            System.out.println("Error login: " + e.getMessage());
        } finally {
            cerrar();
        }

        return usuario;
    }

    // VALIDAR ACCESO
    public Usuarios validarAcceso(String email, String clave) {
        return validarLogin(email, clave);
    }

    // LISTAR
    public List<Usuarios> listar() {
        List<Usuarios> lista = new ArrayList<>();
        // CORREGIDO: "usuarios" en minúsculas
        String sql = "SELECT * FROM usuarios";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setIdusuarios(rs.getInt("idusuarios"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setIdentificacion(rs.getString("identificacion"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));

                lista.add(u);
            }

        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
        } finally {
            cerrar();
        }

        return lista;
    }

    private void cerrar() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("Error cerrar: " + e.getMessage());
        }
    }
}