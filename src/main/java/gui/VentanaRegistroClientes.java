package gui;

import dato.GestorDatos;
import modelo.Automotora;
import modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroClientes extends Ventana implements ActionListener {
    private Automotora automotora;

    private JTextField nombreField;
    private JTextField rutField;
    private JTextField direccionField;
    private JTextField numeroField;
    private JTextField correoField;

    private JButton volverBtn;
    private JButton aceptarBtn;
    private JButton cancelarBtn;

    public VentanaRegistroClientes(Automotora automotora) {
        this.automotora = automotora;

        JLabel titulo = this.generarEtiqueta("Registro Clientes", 80, 100,
                300, 40,"Forte", 30);

        JLabel nombre = this.generarEtiqueta("Nombre: ", 20,200,120,25);
        JLabel rut = this.generarEtiqueta("Rut: ", 20,250,120,25);
        JLabel direccion = this.generarEtiqueta("Dirección: ", 20,300,120,25);
        JLabel numero = this.generarEtiqueta("Número telefónico: ", 20,350,120,25);
        JLabel correo = this.generarEtiqueta("Correo electrónico: ", 20,400,120,25);

        this.nombreField = this.generarCampoDeTexto(150,200,200,25);
        this.rutField = this.generarCampoDeTexto(150,250,200,25);
        this.direccionField = this.generarCampoDeTexto(150,300,200,25);
        this.numeroField = this.generarCampoDeTexto(150,350,200,25);
        this.correoField = this.generarCampoDeTexto(150,400,200,25);

        volverBtn = this.generarBoton("<--", 20,20,50,25);
        volverBtn.addActionListener(this);

        aceptarBtn = this.generarBoton("Aceptar", 100,450,100,50);
        aceptarBtn.addActionListener(this);

        cancelarBtn = this.generarBoton("Cancelar", 200,450,100,50);
        cancelarBtn.addActionListener(this);
    }

    public void registrarCliente() {
        Cliente cliente = new Cliente(nombreField.getText(), rutField.getText(), direccionField.getText(),
                numeroField.getText(), correoField.getText());

        if(this.automotora.añadirCliente(cliente)) {
            JOptionPane.showMessageDialog(this, "Cliente registrado correctamente",
                    "Mensaje informativo", JOptionPane.INFORMATION_MESSAGE);
            GestorDatos.registrarDato(cliente, "target.clientes.txt");
        } else {
            JOptionPane.showMessageDialog(this,
                    "El rut es incorrecto o el cliente ya está registrado",
                    "Rut ingresado inválido", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void limpiarTextField() {
        nombreField.setText("");
        rutField.setText("");
        direccionField.setText("");
        numeroField.setText("");
        correoField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverBtn) {
            this.dispose();
            new MenuVentas(this.automotora);
        } else if(e.getSource() == aceptarBtn) {
            registrarCliente();
            limpiarTextField();
        } else if(e.getSource() == cancelarBtn) {
            limpiarTextField();
        }
    }
}
