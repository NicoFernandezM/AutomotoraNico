public class main {
    public static void main(String[] args) {
        Automotora automotora= new Automotora();
        automotora.añadirVehiculosPorVender();
        automotora.mostrarAutosLista(automotora.buscarAutoNombre("Celerio"));
        automotora.venderAuto("Celerio",2018);
        automotora.mostrarAutosLista(automotora.getVehiculosVendidos());
        automotora.añadirVendedor(new Vendedor("juan", 30, "123456785"));
        automotora.mostrarVendedores();
    }
}
