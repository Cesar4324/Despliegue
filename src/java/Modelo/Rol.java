package Modelo;

public class Rol {
    // Atributos básicos
    private int idRol;
    private String nombreRol; // Ejemplo: "Admin", "Vendedor", "Cajero"
    private String descripcion; // Ejemplo: "Acceso total al sistema"

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    }
