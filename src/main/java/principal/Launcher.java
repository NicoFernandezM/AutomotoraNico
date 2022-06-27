package principal;

import gui.MenuVentas;
import modelo.Automotora;
import dato.GestorDatos;
import modelo.Venta;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        Automotora automotora = new Automotora();
        automotora.añadirVehiculosPorVender();

        GestorDatos.leerArchivoVendedores(automotora, "target.vendedores.txt");
        GestorDatos.leerArchivoClientes(automotora, "target.clientes.txt");
        GestorDatos.leerArchivoVehiculos(automotora, "target.vehiculos.txt");

        new MenuVentas(automotora);
    }
}
