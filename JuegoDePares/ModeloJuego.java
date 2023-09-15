package Pares;

import javax.swing.*;
import java.awt.*;

public class ModeloJuego {
    private Carta cartas[];
    private JPanel panelCentral, panelDeInformacion;
    private InformacionDeJuego informacionDeJuego;
    private Lectura panelLectura;

    public ModeloJuego() {
        panelCentral = new JPanel(new GridLayout(0, 10));
        panelDeInformacion = new JPanel(new GridLayout(2, 1));
        panelDeInformacion.add(informacionDeJuego = new InformacionDeJuego());
        panelDeInformacion.add(new JLabel("Alumno. Olan Castro Angel Eduardo", JLabel.CENTER));
    }

    public Carta[] getCartas() {
        return cartas;
    }
    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }
    public void asignarCartasAPanelCentral() {
        panelCentral.removeAll();
        for (int i = 0; i < cartas.length; i++)
            panelCentral.add(cartas[i]);
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public JPanel getPanelDeInformacion() {
        return panelDeInformacion;
    }

    public void setPanelDeInformacion(JPanel panelDeInformacion) {
        this.panelDeInformacion = panelDeInformacion;
    }

    public Lectura getPanelLectura() {
        return panelLectura;
    }
    public void setPanelLectura(Lectura panelLectura) {
        this.panelLectura = panelLectura;
    }

    public InformacionDeJuego getInformacionDeJuego() {
        return informacionDeJuego;
    }

    public void setInformacionDeJuego(InformacionDeJuego informacionDeJuego) {
        this.informacionDeJuego = informacionDeJuego;
    }
}
