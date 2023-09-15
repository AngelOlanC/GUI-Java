package Pares;

import javax.swing.*;

public class ControladorLecturaEntrada {
    private ControladorJuego controlador;
    public ControladorLecturaEntrada(ControladorJuego controlador) {
        this.controlador = controlador;
    }
    public int leerEntradaDeCajaDeTexto() {
        int numeroPares;
        try {
            numeroPares = extraerEntradaDeCajaDeTexto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, vuelva a intentarlo ingresando un numero.");
            return Lectura.NUMERO_NO_VALIDO;
        }
        if (numeroPares <= 0) {
            JOptionPane.showMessageDialog(null, "Por favor, vuelva a intentarlo ingresando un numero mayor a cero.");
            return Lectura.NUMERO_NO_VALIDO;
        }
        if (numeroPares > ControladorJuego.NUMERO_PARES_DISPONIBLES) {
            JOptionPane.showMessageDialog(null, "Por favor, vuelva a intentarlo ingresando un numero menor a " + ControladorJuego.NUMERO_PARES_DISPONIBLES + ".");
            return Lectura.NUMERO_NO_VALIDO;
        }
        return numeroPares;
    }
    private int extraerEntradaDeCajaDeTexto() throws NumberFormatException {
        Lectura panelLectura = controlador.getModelo().getPanelLectura();
        return Integer.parseInt(panelLectura.getAreaDeTexto().getText());
    }
}
