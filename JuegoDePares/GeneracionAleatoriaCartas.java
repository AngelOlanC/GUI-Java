package Pares;

import java.util.Random;

public class GeneracionAleatoriaCartas {

    public static Carta[] seleccionarCartasAleatoriamente(final int numeroPares) {
        Integer[] indices = getIndicesRevueltos();
        Carta[] cartas = new Carta[numeroPares * 2];
        for (int i = 0, j = 0; i < numeroPares; i++) {
            cartas[j++] = new Carta("Pares/Imagenes/Cartas/" + indices[i] + ".png");
            cartas[j++] = new Carta("Pares/Imagenes/Cartas/" + indices[i] + ".png");
        }

        return (Carta[]) mezclarElementosAleatoriamente(cartas);
    }

    private static Integer[] getIndicesRevueltos() { // Indices en [0, 52]
        Integer[] indices = new Integer[ControladorJuego.NUMERO_PARES_DISPONIBLES];
        for (int i = 0; i < indices.length; i++)
            indices[i] = i;
        return (Integer[]) mezclarElementosAleatoriamente(indices);
    }

    private static Object[] mezclarElementosAleatoriamente(Object arr[]) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length * 10; i++) {
            int ind1 = rnd.nextInt(arr.length), ind2 = rnd.nextInt(arr.length);
            Object aux = arr[ind1];
            arr[ind1] = arr[ind2];
            arr[ind2] = aux;
        }
        return arr;
    }
}
