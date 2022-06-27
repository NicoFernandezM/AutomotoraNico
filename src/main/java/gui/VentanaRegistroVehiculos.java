package gui;

import dato.GestorDatos;
import modelo.Automotora;
import modelo.ColorVehiculo;
import modelo.MarcaVehiculo;
import modelo.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroVehiculos extends Ventana implements ActionListener {
    private Automotora automotora;

    private JComboBox <MarcaVehiculo> marcasBox = new JComboBox<>(MarcaVehiculo.values());
    private JComboBox <ColorVehiculo> colorVehiculoBox = new JComboBox<>(ColorVehiculo.values());
    private JComboBox añoBox;

    private JTextField precioField;
    private JTextField kmField;
    private JTextField nombreField;

    private JButton volverBtn;
    private JButton registrarBtn;
    private JButton cancelarBtn;

    public VentanaRegistroVehiculos (Automotora automotora) {
        this.automotora = automotora;
        JLabel titulo = this.generarEtiqueta("Registro Vehículos", 70, 80,
                300, 40,"Forte", 30);

        JLabel nombre = this.generarEtiqueta("Nombre vehículo: ", 20,150,140,25,
                "Calibri", 17);

        JLabel color = this.generarEtiqueta("Color: ", 20,200,120,25,
                "Calibri", 17);
        JLabel marca = this.generarEtiqueta("Marca: ", 20,250,120,25,
                "Calibri", 17);
        JLabel año = this.generarEtiqueta("Año: ", 20,300,120,25,
                "Calibri", 17);

        JLabel precio = this.generarEtiqueta("Precio: ", 20,350,120,25,
                "Calibri", 17);

        JLabel km = this.generarEtiqueta("Km recorridos: ", 20,400,120,25,
                "Calibri", 17);


        nombreField = this.generarCampoDeTexto(160, 150, 150, 20);

        this.add(colorVehiculoBox);
        colorVehiculoBox.setBounds(160, 200, 120, 20);

        this.add(marcasBox);
        marcasBox.setBounds(160, 250, 120, 20);

        añoBox = this.generarComboBox(1950, 2022, 160, 300,120,20);

        precioField = this.generarCampoDeTexto(160, 350, 150, 20);
        kmField = this.generarCampoDeTexto(160, 400, 150, 20);

        volverBtn = this.generarBoton("<--", 20,20,50,25);
        registrarBtn = this.generarBoton("Aceptar", 100,450,100,50);
        cancelarBtn = this.generarBoton("Cancelar", 200,450,100,50);

        volverBtn.addActionListener(this);
        registrarBtn.addActionListener(this);
        cancelarBtn.addActionListener(this);
    }

    public boolean esNumero(String entrada) {
        return entrada.matches("[+-]?\\d*(\\.\\d+)?") && !entrada.equals("");
    }

    public void limpiarTextField() {
        precioField.setText("");
        kmField.setText("");
        nombreField.setText("");
    }

    public boolean validarEntradas() {
        return !nombreField.getText().equals("") && esNumero(precioField.getText()) &&
                esNumero(kmField.getText());
    }

    public void registrarAuto() {
        if(validarEntradas()) {
            Vehiculo vehiculo = new Vehiculo(nombreField.getText(), obtenerColor(),
                    obtenerMarca(), Integer.parseInt(añoBox.getSelectedItem().toString()),
                    Integer.parseInt(precioField.getText()), Integer.parseInt(kmField.getText()));

            this.automotora.registrarAuto(vehiculo);
            GestorDatos.registrarDato(vehiculo, "target.vehiculos.txt");

            JOptionPane.showMessageDialog(this, "Vehículo registrado correctamente",
                    "Mensaje informativo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Datos incorrectos, por favor intente nuevamente",
                    "Mensaje informativo", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public MarcaVehiculo obtenerMarca() {
        return (MarcaVehiculo) marcasBox.getSelectedItem();
    }

    public ColorVehiculo obtenerColor() {
        return (ColorVehiculo) colorVehiculoBox.getSelectedItem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverBtn) {
            this.dispose();
            new MenuVentas(this.automotora);
        } else if(e.getSource() == cancelarBtn) {
            limpiarTextField();
        } else if(e.getSource() == registrarBtn) {
            registrarAuto();
            limpiarTextField();
        }
    }
}
