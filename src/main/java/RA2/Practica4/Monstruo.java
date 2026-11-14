package RA2.Practica4;

import java.util.Random;

/**
 * Hilo de baja prioridad que calcula la posición del siguiente monstruo.
 */
public class Monstruo extends Thread {
    private static final int POSICION_MAXIMA = 100;

    private final Pantalla pantalla;
    private final int movimientos;
    private final Random random = new Random();

    public Monstruo(Pantalla pantalla, int movimientos) {
        super("Monstruo");
        this.pantalla = pantalla;
        this.movimientos = movimientos;
        setPriority(Thread.MIN_PRIORITY);
    }

    @Override
    public void run() {
        for (int i = 0; i < movimientos; i++) {
            pantalla.actualizarPosicionMonstruo(random.nextInt(POSICION_MAXIMA + 1));
            try {
                Thread.sleep(300);
            } catch (InterruptedException exception) {
                interrupt();
                return;
            }
        }
    }
}
