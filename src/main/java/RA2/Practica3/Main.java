package RA2.Practica3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ventanilla ventanilla = new Ventanilla();
        Camarero[] camareros = new Camarero[3];
        Cocinero[] cocineros = new Cocinero[3]; 

        // Creamos y arrancamos los tres camareros.
        for (int i = 0; i < 3; i++) {
            camareros[i] = new Camarero("Camarero-" + (i + 1), ventanilla);
            camareros[i].start();
        }

        // Creamos y arrancamos los tres cocineros.
        for (int i = 0; i < 3; i++) {
            cocineros[i] = new Cocinero("Cocinero-" + (i + 1), ventanilla);
            cocineros[i].start();
        }
        
        // El programa funciona indefinidamente.
        // Se detiene manualmente desde el entorno de ejecución.
        while (true) {
            ventanilla.tomarPlato();
        }
    }
}
