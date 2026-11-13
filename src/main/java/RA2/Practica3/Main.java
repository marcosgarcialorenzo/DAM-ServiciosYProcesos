package RA2.Practica3;

// Clase principal: crea y arranca todos los hilos.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Creamos una única ventanilla para compartirla entre todos.
        Ventanilla ventanilla = new Ventanilla();

        // Arrays normales para guardar los tres camareros y los tres cocineros.
        Camarero[] camareros = new Camarero[3];
        Cocinero[] cocineros = new Cocinero[3];

        // Creamos y arrancamos los tres hilos de camareros.
        for (int i = 0; i < 3; i++) {
            camareros[i] = new Camarero("Camarero-" + (i + 1), ventanilla);
            camareros[i].start();
        }

        // Creamos y arrancamos los tres hilos de cocineros.
        for (int i = 0; i < 3; i++) {
            cocineros[i] = new Cocinero("Cocinero-" + (i + 1), ventanilla);
            cocineros[i].start();
        }

        // El hilo principal representa al cliente que recoge los platos.
        // El programa funciona indefinidamente.
        // Se detiene manualmente desde el entorno de ejecución.
        while (true) {
            ventanilla.tomarPlato();
        }
    }
}