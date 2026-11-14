package RA2.Practica4;

import java.util.Random;

public class Monstruo extends Thread {
    private final Pantalla pantalla;
    private final Random random = new Random();

    public Monstruo(Pantalla p) {
        this.pantalla = p;
    }

    @Override
    public void run() {
        while (!pantalla.estaTerminado()) {
            pantalla.actualizarPosicion(random.nextInt(100), random.nextInt(100));
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}