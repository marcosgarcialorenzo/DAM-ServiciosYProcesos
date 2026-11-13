package RA2.Practica3;

public class Camarero extends Thread {

    private final Ventanilla ventanilla;

    public Camarero(String nombre, Ventanilla ventanilla) {
        super(nombre);
        this.ventanilla = ventanilla;
    }

    @Override
    public void run() {
        int numeroComanda = 1;
        try {
            while (true) {
                String comanda = "Comanda-" + numeroComanda;
                ventanilla.ponerComanda(comanda);
                numeroComanda++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Si el hilo es interrumpido, se marca como interrumpido otra vez.
            Thread.currentThread().interrupt();
        }
    }
}
