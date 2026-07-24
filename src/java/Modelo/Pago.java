package Modelo;
        
public class Pago {
    // Atributos básicos
    private int idPago;
    private int idVenta;      // Para saber qué venta se está pagando
    private String metodo;    // Ejemplo: "Efectivo", "Tarjeta", "Transferencia"
    private double monto;     // La cantidad de dinero pagada
    private String fechaPago; // Fecha en que se realizó el pago

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

   
    }
