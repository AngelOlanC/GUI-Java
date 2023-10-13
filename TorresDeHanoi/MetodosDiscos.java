package TorresDeHanoi;

import java.util.Stack;

public class MetodosDiscos {
    private static int n;
    private static Vista vista;

    protected static void inicializarDiscos(int n, Vista vista) {
        MetodosDiscos.n = n;
        MetodosDiscos.vista = vista;

        Stack<Integer>[] pilas = new Stack[3];
        for (int i = 0; i < 3; i++)
            pilas[i] = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
            pilas[0].add(i);
        Disco[] discos = new Disco[n];
        for (int i = 0; i < n; i++) {
            discos[i] = new Disco(i);
            discos[i].setX(getXCentroPalo(1) - discos[i].getAnchura() / 2);
            discos[i].setY(getSiguienteYPalo(n - i - 1));
        }
        vista.setPilas(pilas);
        vista.setDiscs(discos);
    }

    protected static int getXCentroPalo(int numeroDePalo) {
        return vista.getWidth() * numeroDePalo / 4;
    }

    protected static int getSiguienteYPalo(int discosEnPalo) {
        return vista.getHeight() * 3 / 4 - Disco.getAltura() * (discosEnPalo + 1);
    }

    protected static boolean haSubidoLoSuficiente(Disco discoEnMovimiento) {
        return discoEnMovimiento.getY() == getAlturaAdecuada();
    }

    protected static int getAlturaAdecuada() {
        return vista.getHeight() / 4 - Disco.getAltura();
    }

    protected static boolean seHaDesplazadoLoSuficiente(Movimiento movimiento, Disco discoEnMovimiento) {
        return discoEnMovimiento.getX() == getDesplazamientoAdecuado(movimiento, discoEnMovimiento);
    }

    protected static int getDesplazamientoAdecuado(Movimiento movimiento, Disco discoEnMovimiento) {
        return getXCentroPalo(movimiento.paloDestino() + 1) - discoEnMovimiento.getAnchura() / 2;
    }

    protected static boolean haBajadoLoSuficiente(Movimiento movimiento, Disco discoEnMovimiento) {
        return discoEnMovimiento.getY() == getEspacioAdecuado(movimiento);
    }

    protected static int getEspacioAdecuado(Movimiento movimiento) {
        return getSiguienteYPalo(vista.getPilas()[movimiento.paloDestino()].size());
    }
}
