package Modelo;

public class Cabezadepedidos {
    // Atributos básicos
    private int idPedido;
    private int idUsuario;    // El usuario/cliente que realiza el pedido
    private int idEstado;     // Relación con la tabla Estado (ej: 1-Pendiente, 2-Enviado)
    private String fechaPedido;
    private double total;     // Suma de todos los productos del detalle de este pedido

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
    }
