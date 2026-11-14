package RA2.Practica4;

/**
 * Hilo de máxima prioridad que dibuja el estado actual de la pantalla.
 */
public class Renderizar extends Thread {
    private static final int INTERVALO_MS = 100;

    private final Pantalla pantalla;
    private final int fotogramas;

    public Renderizar(Pantalla pantalla, int fotogramas) {
        super("Renderizar");
        this.pantalla = pantalla;
        this.fotogramas = fotogramas;
        setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void run() {
        for (int i = 0; i < fotogramas; i++) {
            Pantalla.Estado estado = pantalla.obtenerEstado();
            System.out.printf(
                    "[Renderizar] Vida: %d | Puntos: %d | Siguiente monstruo: posición %d%n",
                    estado.vida(), estado.puntos(), estado.posicionSiguienteMonstruo());
            esperar();
        }
    }

    private void esperar() {
        try {
            Thread.sleep(INTERVALO_MS);
        } catch (InterruptedException exception) {
            interrupt();
        }
    }
}
