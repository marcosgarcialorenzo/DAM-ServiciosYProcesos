package RA2.Practica3;

// Clase principal: crea y arranca todos los hilos.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ventanilla ventanilla = new Ventanilla();
        Camarero[] camareros = new Camarero[3];
        Cocinero[] cocineros = new Cocinero[3];
        for (Camarero camarero : camareros) {
            int i = 0;
            camarero = new Camarero("Camarero-" + (i + 1), ventanilla);
            camarero.start();
        }
        for (Cocinero cocinero : cocineros) {
            int i = 0;
            cocinero = new Cocinero("Camarero-" + (i + 1), ventanilla);
            cocinero.start();
        }
        while (true) {
            ventanilla.tomarPlato();
        }
    }
}