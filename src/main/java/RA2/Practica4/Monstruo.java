package RA2.Practica4;

import java.util.Random;

/**
 * Hilo que mueve al monstruo periódicamente.
 * Cada segundo genera una posición aleatoria y la comunica a la pantalla.
 */
public class   Monstruo extends Thread {
    private final Pantalla pantalla;
    private final Random random = new Random();

    // Todos los hilos comparten la misma pantalla para modificar y consultar el estado.
    public Monstruo(Pantalla p) {
        this.pantalla = p;
    }

    @Override
    public void run() {
        // El hilo sigue trabajando hasta que la partida termina.
        while (! pantalla.estaTerminado()) {
            // nextInt(100) genera un valor entre 0 y 99.
            pantalla.actualizarPosicion(random.nextInt(100), random.nextInt(100));
            try {
                // sleep pausa este hilo, pero no bloquea los demás hilos.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Se transforma la interrupción en una excepción no comprobada.
                throw new RuntimeException(e);
            }
        }
    }
}