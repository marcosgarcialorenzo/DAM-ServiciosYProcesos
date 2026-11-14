package RA2.Practica4;

import java.util.Random;

/**
 * Hilo de prioridad normal que actualiza la vida o los puntos.
 */
public class Evento extends Thread {
    public static final int ACTUALIZAR_VIDA = 1;
    public static final int ACTUALIZAR_PUNTOS = 2;

    private final Pantalla pantalla;
    private final int tipo;
    private final int repeticiones;
    private final Random random = new Random();

    public Evento(Pantalla pantalla, int tipo, int repeticiones) {
        super(nombrePara(tipo));
        if (tipo != ACTUALIZAR_VIDA && tipo != ACTUALIZAR_PUNTOS) {
            throw new IllegalArgumentException("Tipo de evento no válido: " + tipo);
        }
        this.pantalla = pantalla;
        this.tipo = tipo;
        this.repeticiones = repeticiones;
        setPriority(Thread.NORM_PRIORITY);
    }

    @Override
    public void run() {
        for (int i = 0; i < repeticiones; i++) {
            if (tipo == ACTUALIZAR_VIDA) {
                pantalla.reducirVida(random.nextInt(5) + 1);
            } else {
                pantalla.sumarPuntos(random.nextInt(10) + 1);
            }
            esperar();
        }
    }

    private static String nombrePara(int tipo) {
        return tipo == ACTUALIZAR_VIDA ? "Evento-Vida" : "Evento-Puntos";
    }

    private void esperar() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException exception) {
            interrupt();
        }
    }
}
