package RA2.Examen;

import java.util.Random;

public class Cruce {

    private boolean estaCerrado1 = true;
    int direccion = 1;

    public synchronized boolean cruzar() throws InterruptedException {
        if (! estaCerrado1) { // si es false
            System.out.println(Thread.currentThread().getName() + " Estoy cruzando");
            notifyAll();
            wait(1000);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " He pasado");
            return estaCerrado1 = true;
        } else {
            System.out.println("Semáforo en rojo para " + direccion);
            if (direccion == 1) {
                direccion = 0;
            }
            else {
                direccion = 1;
            }
            System.out.println(Thread.currentThread().getName() + " Estoy esperando");
            return estaCerrado1 = false;
        }
    }
    
    public synchronized void ambu() throws InterruptedException {
        Random r = new Random();
        int i = r.nextInt(1000);
        if ( i % 2 == 0) {
            System.out.println("LA AMBULANCIA ESTA PASANDO");
            wait(1000);
            Thread.sleep(1000);
            notifyAll();
        }
    }
}