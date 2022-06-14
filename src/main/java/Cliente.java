public class Cliente extends Persona {
    private String direccion;
    private int numeroTelefonico;
    private String correoElectronico;

    public Cliente (String nombre, String direccion, int numeroTelefonico, String correoElectronico, String rut) {
        super(nombre, rut);
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion () {
        return this.direccion;
    }

    public int getNumeroTelefonico () {
        return this.numeroTelefonico;
    }

    public String getCorreoElectronico () {
        return this.correoElectronico;
    }

    public void obtenerDescuento() {
        System.out.println("El cliente " + getNombre() + " tiene un 20% de descuento");
    }

    public String toString() {
        return ("\nNombre: " + this.nombre + "\nDirección: " + this.direccion +
                "\nRut: " + this.rut);
    }
}
