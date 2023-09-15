package Pares;

import Pares.Imagenes.ManejadorEventosCartas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorJuego implements ActionListener {
    public final static int NUMERO_PARES_DISPONIBLES = 52;
    private ModeloJuego modelo = new ModeloJuego();
    private VistaJuego vista = new VistaJuego();
    private Carta ultimaCartaPresionada = null;
    private boolean enTarea = false;

    public ControladorJuego() {
        modelo.setPanelLectura(new Lectura(this));
        vista.agregarPanelDeLectura(modelo.getPanelLectura());
        vista.agregarPanelDeInformacion(modelo.getPanelDeInformacion());
        vista.actualizarPantalla();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (enTarea)
            return;

        if (evt.getSource() == modelo.getPanelLectura().getBotonEnviar()) {
            ControladorLecturaEntrada cle = new ControladorLecturaEntrada(this);
            int numeroPares = cle.leerEntradaDeCajaDeTexto();
            if (numeroPares == Lectura.NUMERO_NO_VALIDO)
                return;

            Carta[] cartas = GeneracionAleatoriaCartas.seleccionarCartasAleatoriamente(numeroPares);
            for (Carta carta : cartas)
                carta.addActionListener(this);
            modelo.setCartas(cartas);
            modelo.asignarCartasAPanelCentral();
            vista.asignarPanelCentral(modelo.getPanelCentral());
            vista.actualizarPantalla();
            vista.ajustarImagenes(cartas);
            vista.actualizarPantalla();
            return;
        }
        Carta carta = (Carta) evt.getSource();
        ((Carta) evt.getSource()).setEnabled(false);
        vista.actualizarPantalla();

        boolean noHayOtraCartaVolteada = ultimaCartaPresionada == null;
        if (noHayOtraCartaVolteada) {
            ultimaCartaPresionada = carta;
            return;
        }

        checarAmbasCartas(carta);
    }
    public void checarAmbasCartas(Carta carta) {
        enTarea = true;
        ActionListener taskPerformer = evt1 -> {
            boolean sonIguales = ultimaCartaPresionada.getRutaImagen().equals(carta.getRutaImagen());
            if (sonIguales) {
                ultimaCartaPresionada = null;
                modelo.getInformacionDeJuego().incrementarAciertos();

                enTarea = false;
                vista.actualizarPantalla();
                return;
            }
            ultimaCartaPresionada.setEnabled(true);
            ultimaCartaPresionada = null;

            carta.setEnabled(true);
            modelo.getInformacionDeJuego().incrementarFallos();

            enTarea = false;
            vista.actualizarPantalla();
        };
        Timer timer = new Timer(500, taskPerformer);
        timer.setRepeats(false);
        timer.start();

        if (seTerminoElJuego())
            JOptionPane.showMessageDialog(null, "¡Felicidades! Has ganado el juego, abajo puedes ver las estadisticas finales");
    }

    public boolean seTerminoElJuego() {
        for (Carta carta : modelo.getCartas())
            if (carta.isEnabled())
                return false;
        return true;
    }

    public ModeloJuego getModelo() {
        return modelo;
    }

    public static void main(String[] args) {
        new ControladorJuego();
    }
}
