package RA2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Productor productor = new Productor();
        Consumidor consumidor = new Consumidor();
        consumidor.start();
        productor.start();
    }
}