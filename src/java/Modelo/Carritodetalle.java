package Modelo;

public class Carritodetalle{
    // Atributos básicos
    private int idCarritoDetalle;
    private int idUsuario;    // Para saber de qué usuario es el carrito
    private int idProducto;   // La prenda seleccionada
    private int cantidad;     // Cuántas unidades quiere llevar
    private double precioUnitario; // Precio al momento de agregar al carrito

    public int getIdCarritoDetalle() {
        return idCarritoDetalle;
    }

    public void setIdCarritoDetalle(int idCarritoDetalle) {
        this.idCarritoDetalle = idCarritoDetalle;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    }
