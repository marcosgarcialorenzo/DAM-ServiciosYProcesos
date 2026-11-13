package RA2.Practica3;

// Clase principal: crea y arranca todos los hilos.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ventanilla ventanilla = new Ventanilla();
        Camarero[] camareros = new Camarero[3];
        Cocinero[] cocineros = new Cocinero[3];
        for (int i = 0; i < 3; i++) {// Creamos y arrancamos los tres hilos de camareros.
            camareros[i] = new Camarero("Camarero-" + (i + 1), ventanilla);
            camareros[i].start();
        }
        for (int i = 0; i < 3; i++) {// Creamos y arrancamos los tres hilos de cocineros.
            cocineros[i] = new Cocinero("Cocinero-" + (i + 1), ventanilla);
            cocineros[i].start();
        }
        while (true) {
            ventanilla.tomarPlato();
        }
    }
}