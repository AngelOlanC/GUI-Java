package TorresDeHanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class Vista extends JFrame {
    private Stack<Integer>[] pilas;
    private Disco discos[];
    private JSlider sliderVelocidad;
    private JTextArea areaDeTexto;
    private JButton botonEnviar;
    private JLabel labelNumeroMovimientosRealizados;
    private final Integer ANCHURA_PALO = 15, ALTURA_PALO;
    private final String colores[] = {"#FFC28B", "#174D7C", "#FF5342", "#AF7AC5", "#FBE7C6", "#795548", "#FE4365", "#83AF9B",
    "#003B46", "#E99787", "#DCEDC2", "#594F4F", "#FFAEBC"};
    private final Graphics gi;
    private final Image img;

    public Vista() {
        super("Torres de hanoi");
        crearInterfaz();
        ALTURA_PALO = getHeight() / 2;
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TRANSLUCENT);
        gi = img.getGraphics();
        repaint();
        revalidate();
    }

    public void crearInterfaz() {
        setResizable(false);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelSuperior = new JPanel(new GridLayout(0, 3));
        panelSuperior.setBackground(Color.decode("#92c37e"));

        JPanel panelSlider = new JPanel(new GridLayout(2, 1));
        panelSlider.setOpaque(false);
        panelSlider.add(new JLabel("Rapidez de la animacion", JLabel.CENTER));
        sliderVelocidad = new JSlider(0, 300, 0);
        sliderVelocidad.setOpaque(false);
        sliderVelocidad.setEnabled(false);
        panelSlider.add(sliderVelocidad);
        panelSuperior.add(panelSlider);

        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 25));
        panelEntrada.setOpaque(false);
        panelEntrada.add(new JLabel("Ingrese el numero de discos:", JLabel.RIGHT));
        areaDeTexto = new JTextArea();
        areaDeTexto.setPreferredSize(new Dimension(100, 20));
        panelEntrada.add(areaDeTexto);
        panelEntrada.add(botonEnviar = new JButton("Enviar"));
        panelSuperior.add(panelEntrada);

        JPanel panelMovimientosRealizados = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
        panelMovimientosRealizados.add(new JLabel("# Movimientos realizados:"));
        panelMovimientosRealizados.add(labelNumeroMovimientosRealizados = new JLabel("0"));
        panelMovimientosRealizados.setOpaque(false);
        panelSuperior.add(panelMovimientosRealizados);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panelInferior.add(new JLabel("Tópicos Avanzados de programación - Angel Eduardo Olan Castro", JLabel.CENTER));
        add(panelInferior, BorderLayout.SOUTH);
    }

    public void dibujaSobreImagen() {
        if (ALTURA_PALO == null || pilas == null)
            return;
        gi.setColor(Color.BLACK);
        for (int i = 1; i <= 3; i++)
            gi.fillRect(getWidth() / 4 * i - ANCHURA_PALO / 2, getHeight() / 4, ANCHURA_PALO, ALTURA_PALO);
        gi.fillRect(getWidth() / 8, getHeight() * 3 / 4, getWidth() * 3 / 4, ANCHURA_PALO);

        for (Disco disco : discos) {
            gi.setColor(Color.decode(colores[disco.getIndice()]));
            gi.fillRoundRect(disco.getX(), disco.getY(), disco.getAnchura(), Disco.getAltura(), 25, 25);
        }
    }

    @Override
    public void paint(Graphics g) {
        if (g == null || gi == null)
            return;

        super.paintComponents(gi);
        dibujaSobreImagen();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public void establecerValoresInicioJuego() {
        labelNumeroMovimientosRealizados.setText("0");
        getAreaDeTexto().setText("");
        botonEnviar.setEnabled(false);
        areaDeTexto.setEnabled(false);
        sliderVelocidad.setEnabled(true);
    }

    public void establecerValoresFinJuego() {
        botonEnviar.setEnabled(true);
        areaDeTexto.setEnabled(true);
        sliderVelocidad.setEnabled(false);
    }

    public void aumentarNumeroMovimientosRealizados() {
        labelNumeroMovimientosRealizados.setText(Integer.parseInt(labelNumeroMovimientosRealizados.getText()) + 1 + "");
    }

    public void setPilas(Stack<Integer> pilas[]) {
        this.pilas = pilas;
    }

    public void setDiscs(Disco[] discos) {
        this.discos = discos;
    }

    public JTextArea getAreaDeTexto() {
        return areaDeTexto;
    }

    public JButton getBotonEnviar() {
        return botonEnviar;
    }

    public Disco[] getDiscos() {
        return discos;
    }

    public Stack<Integer>[] getPilas() {
        return pilas;
    }

    public JSlider getSliderVelocidad() {
        return sliderVelocidad;
    }
}