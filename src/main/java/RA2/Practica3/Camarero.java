package RA2.Practica3;

// Cada objeto de esta clase representa a un camarero.
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
            // El camarero trabaja continuamente.
            while (true) {
                String comanda = "Comanda-" + numeroComanda;
                ventanilla.ponerComanda(comanda);
                numeroComanda++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
