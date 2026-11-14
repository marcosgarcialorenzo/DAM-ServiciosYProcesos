package RA2.Practica4;

/**
 * Punto de entrada del juego concurrente.
 */
public class Juego {
    private static final int REPETICIONES_EVENTOS = 8;
    private static final int MOVIMIENTOS_MONSTRUO = 7;
    private static final int FOTOGRAMAS = 24;

    public static void main(String[] args) throws InterruptedException {
        Pantalla pantalla = new Pantalla();
        Thread renderizar = new Renderizar(pantalla, FOTOGRAMAS);
        Thread actualizarVida = new Evento(pantalla, Evento.ACTUALIZAR_VIDA, REPETICIONES_EVENTOS);
        Thread actualizarPuntos = new Evento(pantalla, Evento.ACTUALIZAR_PUNTOS, REPETICIONES_EVENTOS);
        Thread monstruo = new Monstruo(pantalla, MOVIMIENTOS_MONSTRUO);

        renderizar.start();
        actualizarVida.start();
        actualizarPuntos.start();
        monstruo.start();

        renderizar.join();
        actualizarVida.join();
        actualizarPuntos.join();
        monstruo.join();

        Pantalla.Estado estadoFinal = pantalla.obtenerEstado();
        System.out.printf(
                "Juego terminado. Vida: %d | Puntos: %d | Siguiente monstruo: posición %d%n",
                estadoFinal.vida(), estadoFinal.puntos(), estadoFinal.posicionSiguienteMonstruo());
    }
}
