package Pares;

import javax.swing.*;
import java.awt.*;

public class Lectura extends JPanel {
    public static final int NUMERO_NO_VALIDO = -1;
    private JTextArea areaDeTexto;
    private JButton botonEnviar;
    public Lectura(ControladorJuego controlador) {
        setLayout(new GridLayout(0,3));
        add(new JLabel("Ingrese la cantidad de pares: "));
        add(areaDeTexto = new JTextArea());
        botonEnviar = new JButton();
        botonEnviar.addActionListener(controlador);
        add(botonEnviar);
    }

    public JTextArea getAreaDeTexto() {
        return areaDeTexto;
    }

    public void setAreaDeTexto(JTextArea areaDeTexto) {
        this.areaDeTexto = areaDeTexto;
    }

    public JButton getBotonEnviar() {
        return botonEnviar;
    }

    public void setBotonEnviar(JButton botonEnviar) {
        this.botonEnviar = botonEnviar;
    }


}
