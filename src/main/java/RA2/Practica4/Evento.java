package RA2.Practica4;

public class Evento extends Thread {

    private final Pantalla pantalla;
    private final int tipoEvento;

    /**
     * @param p pantalla compartida por todos los hilos
     * @param tipo 1 resta vida; cualquier otro valor suma puntos
     */
    public Evento(Pantalla p, int tipo) {
        this.pantalla = p;
        this.tipoEvento = tipo;
    }

    @Override
    public void run() {
        // Los eventos se repiten hasta que la vida llega a cero.
        while (! pantalla.estaTerminado()) {
            if (tipoEvento == 1) {
                // El evento de tipo 1 quita 5 puntos de vida.
                pantalla.actualizarVida(- 5);
            } else {
                // El evento de tipo 2 añade 10 puntos.
                pantalla.actualizarPuntos(10);
            }
            try {
                // Espera medio segundo antes de producir el siguiente evento.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}