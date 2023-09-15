package Pares;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class GenerarImagenes {
    public static void main(String[] args) throws IOException {
        final BufferedImage PLANTILLA = ImageIO.read(new File("Pares/Imagenes/Cartas/Plantilla.png"));
        final int ANCHURA_CARTA = 225, ALTURA_CARTA = 315,
                  NUMERO_CARTAS_POR_FILA = PLANTILLA.getWidth() / ANCHURA_CARTA,
                  NUMERO_FILAS = PLANTILLA.getHeight() / ALTURA_CARTA;

        for (int i = 0; i < NUMERO_FILAS; i++) {
            for (int j = 0; j < NUMERO_CARTAS_POR_FILA; j++) {
                BufferedImage imagenRecortada = PLANTILLA.getSubimage(j * ANCHURA_CARTA,
                                                                      i * ALTURA_CARTA,
                                                                         ANCHURA_CARTA,
                                                                         ALTURA_CARTA);
                ImageIO.write(imagenRecortada, "png",
                        new File("Pares/Imagenes/Cartas/" + (i * NUMERO_CARTAS_POR_FILA + j) + ".png"));
            }
        }
    }
}
