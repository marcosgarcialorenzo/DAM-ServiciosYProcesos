package RA2.Practica4;

public class Renderizar extends Thread {

    private final Pantalla pantalla;

    public Renderizar(Pantalla p) {
        this.pantalla = p;
    }

    @Override
    public void run() {
        while (true) {
            pantalla.dibujar();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}