package RA2.Practica4;

public class Evento extends Thread {

    private final Pantalla pantalla;
    private final int tipoEvento;

    public Evento(Pantalla p, int tipo) {
        this.pantalla = p;
        this.tipoEvento = tipo;
    }

    @Override
    public void run() {
        while (!pantalla.estaTerminado()) {
            if (tipoEvento == 1) {
                pantalla.actualizarVida(-5);
            } else {
                pantalla.actualizarPuntos(10);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}