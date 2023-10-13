package TorresDeHanoi;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener, ChangeListener {
    private SimuladorJuego simuladorJuego;
    private Vista vista;

    public Controlador(Vista vista) {
        simuladorJuego = new SimuladorJuego(this);
        this.vista = vista;
        vista.getBotonEnviar().addActionListener(this);
        vista.getSliderVelocidad().addChangeListener(this);
    }

    public Vista getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBotonEnviar()) {
            int n = Integer.parseInt(vista.getAreaDeTexto().getText());

            if (n < 3 || n > 13) {
                JOptionPane.showMessageDialog(vista, "Numero de discos no valido, intentelo de nuevo con un numero entre 3 y 13", "Error de lectura", JOptionPane.ERROR_MESSAGE);
                vista.getAreaDeTexto().setText("");
                return;
            }

            vista.establecerValoresInicioJuego();
            simuladorJuego.simular(n);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        simuladorJuego.actualizarVelocidadAnimacion();
    }
}
