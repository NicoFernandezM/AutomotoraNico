package test;

import modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomotoraTest {
    private List<Vehiculo> vehiculosAVenta = new ArrayList<>();

    private Vehiculo v1;
    private Vehiculo v2;
    private Vehiculo v3;

    private String [] nombresAutos;

    private Automotora automotora;

    @BeforeEach
    public void init() {
        automotora = new Automotora();

        v1 = new Vehiculo("Hilux", ColorVehiculo.ROJO, MarcaVehiculo.TOYOTA,
                2020, 12000000, 1000);
        v2 = new Vehiculo("Qashqai", ColorVehiculo.BLANCO, MarcaVehiculo.NISSAN,
                2018, 10590000, 20000.23);
        v3 = new Vehiculo("Sail", ColorVehiculo.GRIS, MarcaVehiculo.CHEVROLET,
                2020, 6000000, 0);

        vehiculosAVenta.add(v1);
        vehiculosAVenta.add(v2);
        vehiculosAVenta.add(v3);

        nombresAutos = new String [] {"Cruze", "Sail", "Corolla"};
    }


    @Test
    public void buscarAutoNombreTest() {
        List<Vehiculo> vehiculosEncontrados = new ArrayList<>();
        int autosEncontrados = 0;

        for (int i = 0; i < nombresAutos.length; i++) {
            vehiculosEncontrados = automotora.buscarAutoNombre(nombresAutos[i], vehiculosAVenta);

            if(vehiculosEncontrados.size() != 0) {
                autosEncontrados++;
            }
        }

        assertEquals(1, autosEncontrados);
    }
}