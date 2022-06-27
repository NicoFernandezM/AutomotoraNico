package modelo;

public class Vehiculo {
    private String nombre;
    private ColorVehiculo colorVehiculo;
    private MarcaVehiculo marcaVehiculo;
    private int año, precio;
    private double kmRecorridos;

    public Vehiculo(String nombre, ColorVehiculo colorVehiculo, MarcaVehiculo marcaVehiculo,
                    int año, int precio, double kmRecorridos){

        this.nombre = nombre;
        this.colorVehiculo = colorVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        this.año = año;
        this.precio = precio;
        this.kmRecorridos = kmRecorridos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return colorVehiculo.getColorVehiculo();
    }

    public String getMarca() {
        return marcaVehiculo.getMarcaVehiculo();
    }

    public int getAño() {
        return año;
    }

    public int getPrecio() {
        return precio;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public String toString() {
        return (this.nombre + "," + this.colorVehiculo +
                "," + this.marcaVehiculo + "," + this.año + "," + this.precio + "," + this.kmRecorridos);
    }
}
