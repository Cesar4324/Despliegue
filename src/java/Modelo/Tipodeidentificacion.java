package Modelo;

public class Tipodeidentificacion {
    // Usamos el nombre 'id' para que coincida con tus getters y setters estándar
    private int id; 
    private String descripcion;

    // Constructor vacío (Obligatorio para que el DAO pueda instanciarlo)
    public Tipodeidentificacion() {
    }

    // Constructor con descripción
    public Tipodeidentificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Constructor completo (Por si necesitas pasarle ID y Descripción juntos)
    public Tipodeidentificacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // --- GETTERS Y SETTERS (Cruciales para JSTL y EL) ---

    // EL mapeará esto en el JSP como ${variable.id}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // EL mapeará esto en el JSP como ${variable.descripcion}
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}