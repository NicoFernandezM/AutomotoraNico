package modelo;

import utils.DigitoVerificador;
import utils.GestorPDF;

import dato.GestorDatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Automotora {
    private List<Vehiculo> vehiculosAVenta;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private List<Venta> ventas;

    public Automotora() {
        this.vehiculosAVenta = new ArrayList<Vehiculo>();
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public boolean añadirVendedor(Vendedor vendedor) {
        if (DigitoVerificador.validarRut(vendedor.getRut())) {
            this.vendedores.add(vendedor);
            GestorDatos.registrarDato(vendedor, "vendedor.txt");
            return true;
        }

        return false;
    }

    public boolean añadirCliente(Cliente cliente) {
        if (DigitoVerificador.validarRut(cliente.getRut())) {
            this.clientes.add(cliente);
            return true;
        }
        return false;
    }

    public void añadirVehiculosPorVender() {
        this.vehiculosAVenta.add(new Vehiculo("Celerio", ColorVehiculo.GRIS, MarcaVehiculo.SUZUKI,
                2018, 5000000, 40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux", ColorVehiculo.ROJO, MarcaVehiculo.TOYOTA,
                2020, 12000000, 1000));
        this.vehiculosAVenta.add(new Vehiculo("Qashqai", ColorVehiculo.BLANCO, MarcaVehiculo.NISSAN,
                2018, 10590000, 20000.23));
        this.vehiculosAVenta.add(new Vehiculo("Cruze", ColorVehiculo.CELESTE, MarcaVehiculo.CHEVROLET,
                2010, 4500000, 105000.144));
        this.vehiculosAVenta.add(new Vehiculo("Sail", ColorVehiculo.GRIS, MarcaVehiculo.CHEVROLET,
                2020, 6000000, 0));
    }

    public void venderAuto(String nombre, int año) throws AutomovilNoEcontradoException {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                this.vehiculosAVenta.remove(auto);
                Venta venta = new Venta(this.vendedores.get(generarIndice(vendedores.size()))
                        , this.clientes.get(generarIndice(clientes.size())), auto);
                this.ventas.add(venta);
                return;
            }
        }

        throw new AutomovilNoEcontradoException();
    }

    private int generarIndice(int largoLista) {
        return (int) Math.round(Math.random() * (largoLista - 1));
    }

    public List<Vehiculo> buscarAutoNombre(String nombre, List<Vehiculo> listaVehiculos) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        for (Vehiculo auto : listaVehiculos) {
            if (auto.getNombre().equalsIgnoreCase(nombre)) {
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoMarca(String marca) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getMarca().equalsIgnoreCase(marca)) {
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public String mostrarAutosLista(List<Vehiculo> vehiculos) {
        StringBuilder datos = new StringBuilder();
        for (Vehiculo auto : vehiculos) {
            datos.append("nombre: ").append(auto.getNombre()).append(", marca: ").append(auto.getMarca()).
                    append(", año: ").append(auto.getAño()).append(", color: ").append(auto.getColor()).
                    append(", precio: ").append(auto.getPrecio()).append(", kmRecorridos: ").
                    append(auto.getKmRecorridos()).append("\n");
        }

        return datos.toString();
    }

    public void mostrarVendedores() {
        for (Vendedor vendedor : vendedores) {
            String datos = "\nDatos vendedor.\n" + "Nombre: " + vendedor.getNombre() + "\nEdad: " + vendedor.getEdad() + "\nRut: "
                    + vendedor.getRut();
            System.out.println(datos);
        }
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            String datos = "\nDatos cliente.\n" + "Nombre : " + cliente.getNombre() + "\nDirección: " + cliente.getDireccion() +
                    "\nNúmero telefónico: " + cliente.getNumeroTelefonico() + "\nCorreo eléctronico: " +
                    cliente.getCorreoElectronico() + "\nRut: " + cliente.getRut();

            System.out.println(datos);
        }
    }

    public void mostrarVentas() throws IOException {
        System.out.println(ventas);//Preguntar porqué funciona
        GestorPDF gestorPDF = new GestorPDF();
        for (Venta venta : ventas) {
            gestorPDF.generarBoleta(venta);
        }
    }
}


