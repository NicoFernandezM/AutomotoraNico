import java.util.ArrayList;
import java.util.List;

public class Automotora {
    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    public Automotora(){
        this.vehiculosAVenta= new ArrayList<Vehiculo>();
        this.vehiculosVendidos= new ArrayList<Vehiculo>();
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean añadirVendedor(Vendedor vendedor) {
        if(DigitoVerificador.validarRut(vendedor.getRut())) {
            this.vendedores.add(vendedor);
            return true;
        }

        return false;
    }

    public boolean añadirCliente(Cliente cliente) {
        if(DigitoVerificador.validarRut(cliente.getRut())) {
            this.clientes.add(cliente);
            return true;
        }
        return false;
    }

    public void añadirVehiculosPorVender(){
        this.vehiculosAVenta.add(new Vehiculo("Celerio","Gris","Suzuki",
                2018,5000000,40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux","Rojo","Toyota",
                2020,12000000,1000));
        this.vehiculosAVenta.add(new Vehiculo("Qashqai","Blanco","Nissan",
                2018,10590000,20000.23));
        this.vehiculosAVenta.add(new Vehiculo("Cruze","Celeste","Chevrolet",
                2010,4500000,105000.144));
        this.vehiculosAVenta.add(new Vehiculo("Sail","Gris","Chevrolet",
                2020,6000000,0));
    }
    public void venderAuto(String nombre, int año){
        for(Vehiculo auto: this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre) && auto.getAño()==año){
               this.vehiculosVendidos.add(auto);
               this.vehiculosAVenta.remove(auto);
               break;
            }
        }
    }

    public List<Vehiculo> buscarAutoNombre(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
        }

    public List<Vehiculo> buscarAutoMarca(String marca){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getMarca().equals(marca)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }
    public void mostrarAutosLista(List<Vehiculo> vehiculos){
        for(Vehiculo auto : vehiculos){
            String datos="nombre: "+auto.getNombre()+", marca: "+auto.getMarca()+", año: "+auto.getAño()
                    +", color= "+auto.getColor()+", precio: "+auto.getPrecio()+", kmRecorridos: "+auto.getKmRecorridos();
            System.out.println(datos);
        }
    }

    public void mostrarVendedores() {
        for(Vendedor vendedor : vendedores) {
            String datos = "Nombre: " + vendedor.getNombre() + "\nEdad: " + vendedor.getEdad() + "\nRut: "
                    + vendedor.getRut();
            System.out.println(datos);
        }
    }

    public void mostrarClientes() {
        for(Cliente cliente : clientes) {
            String datos = "Nombre: " + cliente.getNombre() + "\nDirección: " + cliente.getDireccion() +
                    "\nNúmero telefónico: " + cliente.getNumeroTelefonico() + "\nCorreo eléctronico: " +
                    cliente.getCorreoElectronico() + "\nRut: " + cliente.getRut();

            System.out.println(datos);
        }
    }
    }


