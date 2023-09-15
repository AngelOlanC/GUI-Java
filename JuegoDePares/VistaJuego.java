package Pares;

import javax.swing.*;
import java.awt.*;

class VistaJuego extends JFrame {
    public VistaJuego() {
        super("Juego de pares");
        setSize(1000,800);
        setResizable(false);

        setIconImage(new ImageIcon("Pares/Imagenes/Icono.png").getImage());

        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void agregarPanelDeLectura(Lectura panelDeLectura) {
        add(panelDeLectura, BorderLayout.NORTH);
    }
    public void asignarPanelCentral(JPanel panelCentral) {
        remove(panelCentral);
        add(panelCentral);
    }

    public void agregarPanelDeInformacion(JPanel panelDeInformacion) {
        add(panelDeInformacion, BorderLayout.SOUTH);
    }

    public void ajustarImagenes(Carta[] cartas) {
        for (Carta c : cartas)
            ajustarImagenes(c);
    }
    public void ajustarImagenes(Carta carta) {
        carta.setIcon(ajustarImagen(Carta.rutaImagenPorDefecto, carta.getWidth(), carta.getHeight()));
        carta.setDisabledIcon(ajustarImagen(carta.getRutaImagen(), carta.getWidth(), carta.getHeight()));
    }
    private ImageIcon ajustarImagen(String ico, int Ancho, int Alto){
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
                Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
        return tmpIcon;
    }

    public void actualizarPantalla() {
        revalidate();
        repaint();
    }
}