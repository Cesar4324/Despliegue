package Modelo;

public class Imagenesdeproducto {
    // Atributos básicos
    private int idImagen;
    private int idProducto; // Para saber a qué prenda pertenece la foto
    private String rutaArchivo; // Ejemplo: "C:/fotos/camisa_roja.jpg"
    private String descripcion; // Ejemplo: "Vista frontal"

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    }
