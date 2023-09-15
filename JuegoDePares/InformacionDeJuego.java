package JuegoDePares;

import javax.swing.*;

public class InformacionDeJuego extends JPanel {
    private JLabel labelAciertos, labelFallos;
    private int aciertos = 0, fallos = 0;
    public InformacionDeJuego() {
        super();
        add(labelAciertos = new JLabel("ACIERTOS: " + aciertos, JLabel.CENTER));
        add(labelFallos = new JLabel("FALLOS: " + fallos, JLabel.CENTER));
    }
    public void incrementarAciertos() {
        labelAciertos.setText("ACIERTOS: " + (++aciertos));
    }
    public void incrementarFallos() {
        labelFallos.setText("FALLOS: " + (++fallos));
    }
}
