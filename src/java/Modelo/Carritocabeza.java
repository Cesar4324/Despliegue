package Modelo;

public class Carritocabeza {
    // Atributos básicos
    private int idCarrito;
    private int idUsuario;    // Para saber de quién es este carrito
    private double total;     // La suma de todos los productos en el carrito
    private String fechaCreacion; // Cuándo empezó a comprar el usuario

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

  
    }
