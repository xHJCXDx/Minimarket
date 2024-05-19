package Menu;

import java.util.*;

public class Tienda {
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<Venta> ventas;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void venderProducto(String nombreProducto, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto) && producto.getStock() >= cantidad) {
                producto.setStock(producto.getStock() - cantidad);
                ventas.add(new Venta(producto, cantidad, new Date()));
                System.out.println("Producto vendido: " + nombreProducto + " Cantidad: " + cantidad);
                return;
            }
        }
        System.out.println("Producto no disponible o stock insuficiente");
    }

    public void ingresarMercaderia(String nombreProducto, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.setStock(producto.getStock() + cantidad);
                System.out.println("Mercadería ingresada: " + nombreProducto + " Cantidad: " + cantidad);
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void pagarProveedor(String nombreProveedor, double monto) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre().equals(nombreProveedor)) {
                proveedor.pagarDeuda(monto);
                System.out.println("Deuda pagada al proveedor: " + nombreProveedor + " Monto: " + monto);
                return;
            }
        }
        System.out.println("Proveedor no encontrado");
    }

    public void consultaVentasDiaria() {
        double totalVentas = 0;
        Date hoy = new Date();
        for (Venta venta : ventas) {
            if (esMismaFecha(venta.getFecha(), hoy)) {
                totalVentas += venta.getTotal();
            }
        }
        System.out.println("Total ventas del día: $" + totalVentas);
    }

    public void consultaVentasMensual() {
        double totalVentas = 0;
        Date hoy = new Date();
        for (Venta venta : ventas) {
            if (esMismoMes(venta.getFecha(), hoy)) {
                totalVentas += venta.getTotal();
            }
        }
        System.out.println("Total ventas del mes: $" + totalVentas);
    }

    public void mostrarBalance() {
        double totalVentas = 0;
        double totalGastos = 0;

        for (Venta venta : ventas) {
            totalVentas += venta.getTotal();
        }

        for (Proveedor proveedor : proveedores) {
            totalGastos += proveedor.getDeuda();
        }

        System.out.println("Balance: Ingresos = $" + totalVentas + ", Gastos = $" + totalGastos + ", Ganancia = $" + (totalVentas - totalGastos));
    }

    public void solicitarComanda(String nombreProducto, int cantidad) {
        System.out.println("Comanda solicitada: Producto = " + nombreProducto + ", Cantidad = " + cantidad);
    }

    public void pagarCuenta(double monto) {
        System.out.println("Cuenta pagada: $" + monto);
    }

    public void estadisticasPlatosMasPedidos() {
        Map<String, Integer> conteoProductos = new HashMap<>();
        for (Venta venta : ventas) {
            String nombreProducto = venta.getProducto().getNombre();
            conteoProductos.put(nombreProducto, conteoProductos.getOrDefault(nombreProducto, 0) + venta.getCantidad());
        }

        System.out.println("Platos más pedidos:");
        for (Map.Entry<String, Integer> entry : conteoProductos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pedidos");
        }
    }

    private boolean esMismaFecha(Date fecha1, Date fecha2) {
        return fecha1.getYear() == fecha2.getYear() &&
                fecha1.getMonth() == fecha2.getMonth() &&
                fecha1.getDate() == fecha2.getDate();
    }

    private boolean esMismoMes(Date fecha1, Date fecha2) {
        return fecha1.getYear() == fecha2.getYear() &&
                fecha1.getMonth() == fecha2.getMonth();
    }
}
