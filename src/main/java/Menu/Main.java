package Menu;

public class Main {
    public static void main(String[] args) {
        Tienda minimarket = new Tienda();

        // Agregar productos
        Producto producto1 = new Producto("Leche", 1.5, 100);
        Producto producto2 = new Producto("Pan", 0.5, 200);
        minimarket.agregarProducto(producto1);
        minimarket.agregarProducto(producto2);

        // Agregar proveedores
        Proveedor proveedor1 = new Proveedor("Proveedor A");
        minimarket.agregarProveedor(proveedor1);

        // Operaciones
        minimarket.venderProducto("Leche", 10);
        minimarket.ingresarMercaderia("Pan", 50);
        minimarket.pagarProveedor("Proveedor A", 100);
        minimarket.consultaVentasDiaria();
        minimarket.consultaVentasMensual();
        minimarket.mostrarBalance();
        minimarket.solicitarComanda("Leche", 20);
        minimarket.pagarCuenta(50);
        minimarket.estadisticasPlatosMasPedidos();

    }
}
