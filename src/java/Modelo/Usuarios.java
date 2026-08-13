package Modelo;

import java.sql.Date;

public class Usuarios {

    private int idusuarios;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String telefono;
    private String direccion;
    private String email;
    private String clave;
    private int TipoIdentificacion_idTipoIdentificacion;
    private int Rol_idRol;
    private Date fecha_nacimiento;

    public Usuarios() {
    }

    public Usuarios(String nombre, String apellido,
            String identificacion, String telefono,
            String direccion, String email,
            String clave,
            int tipoIdentificacion,
            int rol,
            Date fecha_nacimiento) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
        this.TipoIdentificacion_idTipoIdentificacion = tipoIdentificacion;
        this.Rol_idRol = rol;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipoIdentificacion_idTipoIdentificacion() {
        return TipoIdentificacion_idTipoIdentificacion;
    }

    public void setTipoIdentificacion_idTipoIdentificacion(int tipo) {
        this.TipoIdentificacion_idTipoIdentificacion = tipo;
    }

    public int getRol_idRol() {
        return Rol_idRol;
    }

    public void setRol_idRol(int rol) {
        this.Rol_idRol = rol;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}