package RA2.Examen;

public class Ambulancia extends Thread {

    private final Cruce cruce;
    private int direccion;

    public Ambulancia (String nombre, Cruce p) {
        this.cruce = p;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cruce.ambu();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}