package RA2.Examen;

public class Vehiculo extends Thread {

    private final Cruce cruce;
    private int direccion;

    public Vehiculo(String nombre, int direccion, Cruce p) {
        super(nombre);
        this.direccion = direccion;
        this.cruce = p;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (cruce.cruzar() && cruce.direccion == direccion) {
                    cruce.direccion = 1;
                } else if (cruce.cruzar() && cruce.direccion == direccion) {
                    cruce.direccion = 0;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}