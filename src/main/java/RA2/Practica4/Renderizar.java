package RA2.Practica4;

public class Renderizar extends Thread {

    private final Pantalla pantalla;

    public Renderizar(Pantalla p) {
        this.pantalla = p;
    }

    @Override
    public void run() {
        try {
            while (pantalla.dibujar()) {}
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}