package TorresDeHanoi;

public class RealizadorDeMovimientos {
    private Vista vista;
    private Movimiento movimiento;
    private Disco discoEnMovimiento;
    private Integer estadoActual;
    private Integer D;

    public RealizadorDeMovimientos(Vista vista) {
        this.vista = vista;
    }

    public void preparar(Movimiento movimiento) {
        this.movimiento = movimiento;
        discoEnMovimiento = vista.getDiscos()[vista.getPilas()[movimiento.paloOrigen()].peek()];
        estadoActual = ConstantesEstados.SUBIENDO;
    }

    public boolean movimientoFinalizado() {
        return estadoActual == null || estadoActual == ConstantesEstados.COMPLETADO;
    }

    public void realizarMovimiento() {
        int[] dx = {0, movimiento.paloOrigen() < movimiento.paloDestino() ? 10 : -10, 0},
                dy = {-10, 0, 10};
        discoEnMovimiento.setX(discoEnMovimiento.getX() + dx[estadoActual] * Math.max(1, D / 10));
        discoEnMovimiento.setY(discoEnMovimiento.getY() + dy[estadoActual] * Math.max(1, D / 10));

        normalizarCoordenadasDisco();

        if (estadoActual == ConstantesEstados.SUBIENDO && MetodosDiscos.haSubidoLoSuficiente(discoEnMovimiento))
            estadoActual = ConstantesEstados.DESPLAZANDOSE_HORIZONTALMENTE;
        else if (estadoActual == ConstantesEstados.DESPLAZANDOSE_HORIZONTALMENTE && MetodosDiscos.seHaDesplazadoLoSuficiente(movimiento, discoEnMovimiento))
            estadoActual = ConstantesEstados.BAJANDO;
        else if (estadoActual == ConstantesEstados.BAJANDO && MetodosDiscos.haBajadoLoSuficiente(movimiento, discoEnMovimiento)) {
            estadoActual = ConstantesEstados.COMPLETADO;
            vista.getPilas()[movimiento.paloDestino()].push(vista.getPilas()[movimiento.paloOrigen()].pop());
            vista.aumentarNumeroMovimientosRealizados();
        }
        vista.repaint();
    }

    public void normalizarCoordenadasDisco() {
        if (estadoActual == ConstantesEstados.SUBIENDO) {
            discoEnMovimiento.setY(Math.max(discoEnMovimiento.getY(), MetodosDiscos.getAlturaAdecuada()));
            return;
        }
        if (estadoActual == ConstantesEstados.DESPLAZANDOSE_HORIZONTALMENTE) {
            discoEnMovimiento.setX(movimiento.paloOrigen() < movimiento.paloDestino() ?
                    Math.min(discoEnMovimiento.getX(), MetodosDiscos.getDesplazamientoAdecuado(movimiento, discoEnMovimiento)) :
                    Math.max(discoEnMovimiento.getX(), MetodosDiscos.getDesplazamientoAdecuado(movimiento, discoEnMovimiento)));
            return;
        }
        discoEnMovimiento.setY(Math.min(discoEnMovimiento.getY(), MetodosDiscos.getEspacioAdecuado(movimiento)));
    }

    public void setD(int D) {
        this.D = D;
    }
}