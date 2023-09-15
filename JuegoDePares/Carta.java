package Pares;

import javax.swing.*;

class Carta extends JButton {
    public static String rutaImagenPorDefecto = "Pares/Imagenes/Cartas/CartaCubierta.png";
    private String rutaImagen;

    public Carta(String rutaImagen) {
        super();
        this.rutaImagen = rutaImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}
