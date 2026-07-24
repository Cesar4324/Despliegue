package Modelo;

public class Tienda {
    // Atributos privados que representan los datos de la tienda ByStyles
    private int idTienda;
    private String nombre;
    private String eslogan;
    private String direccion;
    private String telefono;
    private String correo;

    // Constructor vacío (Esencial para Java Beans)
    public Tienda() {
    }

    // Constructor con parámetros
    public Tienda(int idTienda, String nombre, String eslogan, String direccion, String telefono, String correo) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.eslogan = eslogan;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Métodos Getters y Setters (Obligatorios para Expression Language ${tienda.nombre})
    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEslogan() {
        return eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}