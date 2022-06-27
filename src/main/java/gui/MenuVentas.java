package gui;

import modelo.Automotora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVentas extends Ventana implements ActionListener {
    private JButton btnRegistroClientes;
    private JButton btnRegistroVehiculos;
    private JButton btnBusquedaVehiculos;
    private JButton btnVenderVehiculo;
    private JButton btnSalir;
    private Automotora automotora;

    public MenuVentas(Automotora automotora) {
        this.automotora = automotora;
        JLabel titulo = this.generarEtiqueta("Automotora", 115, 40, 300, 40,
                "Forte", 30);

        this.btnRegistroClientes = generarBoton("Registrar cliente", 125, 100, 150, 60);
        this.btnRegistroVehiculos = generarBoton("Registrar vehículo", 125, 180, 150, 60);
        this.btnBusquedaVehiculos = generarBoton("Buscar vehículo", 125, 260, 150, 60);
        this.btnVenderVehiculo = generarBoton("Vender vehículo", 125, 340, 150, 60);
        this.btnSalir = generarBoton("Salir", 125, 420, 150, 60);

        btnRegistroClientes.addActionListener(this);
        btnRegistroVehiculos.addActionListener(this);
        btnBusquedaVehiculos.addActionListener(this);
        btnVenderVehiculo.addActionListener(this);
        btnSalir.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRegistroClientes) {
            new VentanaRegistroClientes(this.automotora);
            this.dispose();
        } else if(e.getSource() == btnRegistroVehiculos) {
            new VentanaRegistroVehiculos(this.automotora);
            this.dispose();
        } else if(e.getSource() == btnBusquedaVehiculos) {
            new VentanaBusquedaVehiculos(this.automotora);
            this.dispose();
        } else if(e.getSource() == btnVenderVehiculo) {
            JOptionPane.showMessageDialog(this, "Próximamente", "Mensaje informativo",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.dispose();
        }
    }
}
