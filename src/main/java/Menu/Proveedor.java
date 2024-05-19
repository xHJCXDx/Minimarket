package Menu;

public class Proveedor {
    private String nombre;
    private double deuda;

    public Proveedor(String nombre) {
        this.nombre = nombre;
        this.deuda = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDeuda() {
        return deuda;
    }

    public void agregarDeuda(double monto) {
        this.deuda += monto;
    }

    public void pagarDeuda(double monto) {
        if (monto <= deuda) {
            this.deuda -= monto;
        }
    }
}
