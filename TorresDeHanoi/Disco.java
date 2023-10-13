package TorresDeHanoi;

public class Disco {
    private static final int ANCHURA_DEFAULT = 100, INCREMENTO_ANCHURA = 20, ALTURA_DEFAULT = 30;
    private int x, y, indice;

    public Disco(int indice) {
        this.indice = indice;
    }

    public int getAnchura() {
        return ANCHURA_DEFAULT + INCREMENTO_ANCHURA * indice;
    }

    public static int getAltura() {
        return ALTURA_DEFAULT;
    }

    public int getIndice() {
        return indice;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}