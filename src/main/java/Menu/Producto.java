package Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //SQL
    public static Producto getProductoPorNombre(String nombre) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM productos WHERE nombre = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Producto producto = new Producto(
                    resultSet.getString("nombre"),
                    resultSet.getDouble("precio"),
                    resultSet.getInt("stock")
            );
            producto.id = resultSet.getInt("id");
            return producto;
        }

        return null;
    }

    public void actualizarStock(int nuevoStock) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE productos SET stock = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, nuevoStock);
        preparedStatement.setInt(2, this.id);
        preparedStatement.executeUpdate();
    }

    public static void agregarProducto(Producto producto) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, producto.getNombre());
        preparedStatement.setDouble(2, producto.getPrecio());
        preparedStatement.setInt(3, producto.getStock());
        preparedStatement.executeUpdate();
    }
}
