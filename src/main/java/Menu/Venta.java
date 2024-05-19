package Menu;

import java.util.Date;

public class Venta {
    private Producto producto;
    private int cantidad;
    private Date fecha;

    public Venta(Producto producto, int cantidad, Date fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public double getTotal() {
        return producto.getPrecio() * cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
