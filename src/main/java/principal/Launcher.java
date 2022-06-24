package principal;

import gui.MenuVentas;
import modelo.Automotora;
import modelo.AutomovilNoEcontradoException;
import modelo.Cliente;
import modelo.Vendedor;
import dato.GestorDatos;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        MenuVentas menuVentas = new MenuVentas();
        Automotora automotora = new Automotora();
        GestorDatos.leerArchivoVehiculos(automotora, "target.vehiculos.txt");
        automotora.añadirVehiculosPorVender();
        automotora.añadirVendedor(new Vendedor("Juan", 30, "123456785"));
        automotora.añadirCliente(new Cliente("Marcelo", "111111111", "Av. Alemania 2045",
                "12345678", "marcelo@gmail.com"));

        try {
            automotora.venderAuto("Celerio",2018);
        } catch(AutomovilNoEcontradoException e) {
            System.out.println("Automóvil no encotrado");
        }

        automotora.mostrarVentas();
    }
}
