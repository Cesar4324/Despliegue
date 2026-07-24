package Modelo;

public class Detalledepedido {
    
    // Atributos que coinciden con los campos de tu base de datos MySQL
    private int idDetallePedido;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    // Llaves foráneas (Relaciones con las otras tablas)
    private int Pedido_idPedido;
    private int Producto_idProducto;
    
    // Constructor vacío (Obligatorio para el manejo de datos en los DAO)
    public Detalledepedido() {
    }

    // Constructor completo (Útil para crear el detalle antes de insertarlo)
    public Detalledepedido(int idDetallePedido, int cantidad, double precioUnitario, double subtotal, int Pedido_idPedido, int Producto_idProducto) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.Pedido_idPedido = Pedido_idPedido;
        this.Producto_idProducto = Producto_idProducto;
    }

    // Métodos Getters y Setters
    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.calcularSubtotal(); // Calcula el subtotal automáticamente al cambiar la cantidad
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.calcularSubtotal(); // Calcula el subtotal automáticamente al cambiar el precio
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getPedido_idPedido() {
        return Pedido_idPedido;
    }

    public void setPedido_idPedido(int Pedido_idPedido) {
        this.Pedido_idPedido = Pedido_idPedido;
    }

    public int getProducto_idProducto() {
        return Producto_idProducto;
    }

    public void setProducto_idProducto(int Producto_idProducto) {
        this.Producto_idProducto = Producto_idProducto;
    }
    
    // Método de negocio opcional para calcular el subtotal de forma automática
    private void calcularSubtotal() {
        this.subtotal = this.cantidad * this.precioUnitario;
    }
}