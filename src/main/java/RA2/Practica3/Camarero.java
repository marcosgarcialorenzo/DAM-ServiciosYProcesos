package RA2.Practica3;

// Esta clase representa a un camarero.
// Al heredar de Thread, el camarero puede trabajar en su propio hilo.
public class Camarero extends Thread {
    // Todos los camareros utilizan la misma ventanilla.
    private final Ventanilla ventanilla;

    // Constructor del camarero.
    // nombre es el nombre que veremos en los mensajes.
    public Camarero(String nombre, Ventanilla ventanilla) {
        super(nombre);
        this.ventanilla = ventanilla;
    }

    // Este método contiene el trabajo que hace el hilo.
    @Override
    public void run() {
        // El número empieza en uno y aumenta con cada comanda.
        int numeroComanda = 1;

        try {
            // El camarero trabaja sin parar hasta detener el programa.
            while (true) {
                // Se crea el nombre de la comanda.
                String comanda = "Comanda-" + numeroComanda;

                // Se deja la comanda en la ventanilla.
                ventanilla.ponerComanda(comanda);

                // La siguiente comanda tendrá otro número.
                numeroComanda++;

                // Simulamos el tiempo que tarda en tomar otra comanda.
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Si el hilo es interrumpido, se marca como interrumpido otra vez.
            Thread.currentThread().interrupt();
        }
    }
}
