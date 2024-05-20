package Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Tienda minimarket = new Tienda();

            // Agregar productos
            Producto producto1 = new Producto("Leche", 1.5, 100);
            Producto.agregarProducto(producto1);

            Producto producto2 = new Producto("Pan", 0.5, 200);
            Producto.agregarProducto(producto2);

            // Operaciones
            minimarket.venderProducto("Leche", 10);
            minimarket.ingresarMercaderia("Pan", 50);

            minimarket.consultaVentasDiaria();
            minimarket.consultaVentasMensual();
            minimarket.mostrarBalance();
            minimarket.solicitarComanda("Leche", 20);
            minimarket.pagarCuenta(50);
            minimarket.estadisticasPlatosMasPedidos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
