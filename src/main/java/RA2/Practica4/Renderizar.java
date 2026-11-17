package RA2.Practica4;

public class Renderizar extends Thread {

    private final Pantalla pantalla;

    public Renderizar(Pantalla p) {
        this.pantalla = p;
    }

    @Override
    public void run() {
        try {
            // Dibuja cada actualización; dibujar() devuelve false al terminar la partida.
            while (pantalla.dibujar()) {}
        } catch (InterruptedException e) {
            // La interrupción se conserva para que el código que llama pueda detectarla.
            Thread.currentThread().interrupt();
        }
    }
}