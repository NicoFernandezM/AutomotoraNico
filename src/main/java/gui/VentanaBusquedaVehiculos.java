package gui;

import modelo.MarcaVehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBusquedaVehiculos extends Ventana implements ActionListener {
    JComboBox <MarcaVehiculo> marcasBox = new JComboBox<>(MarcaVehiculo.values());

    JButton volverBtn;
    JButton buscarBtn;
    JButton cancelarBtn;

    JTextField nombreField;

    public VentanaBusquedaVehiculos () {
        JLabel titulo = this.generarEtiqueta("Búsqueda de Vehículos", 35, 80,
                400, 40,"Forte", 30);

        JLabel nombre = this.generarEtiqueta("Nombre vehículo: ", 20,200,140,25,
                "Calibri", 17);

        JLabel marca = this.generarEtiqueta("Marca: ", 20,275,120,25,
                "Calibri", 17);

        nombreField = this.generarCampoDeTexto(160, 200, 150, 20);

        this.add(marcasBox);
        marcasBox.setBounds(160, 275, 120, 20);

        volverBtn = this.generarBoton("<--", 20,20,50,25);
        buscarBtn = this.generarBoton("Buscar", 100,350,100,50);
        cancelarBtn = this.generarBoton("Cancelar", 200,350,100,50);

        volverBtn.addActionListener(this);
        buscarBtn.addActionListener(this);
        cancelarBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverBtn) {
            this.dispose();
            MenuVentas menuVentas = new MenuVentas();
        } else if(e.getSource() == cancelarBtn) {
            nombreField.setText("");
        }
    }
}
