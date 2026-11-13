package RA2.Practica3;

// Cada objeto de esta clase representa a un cocinero.
public class Cocinero extends Thread {
    private final Ventanilla ventanilla;

    public Cocinero(String nombre, Ventanilla ventanilla) {
        super(nombre);
        this.ventanilla = ventanilla;
    }

    @Override
    public void run() {
        try {
            while (true) {
                
                // El cocinero recoge una comanda y la cocina.
                String comanda = ventanilla.tomarComanda();
                Thread.sleep(2000); // tiempo de cocinado
                ventanilla.ponerPlato(comanda);
            }
        } catch (InterruptedException e) {
            // El programa principal interrumpe al cocinero al acabar.
            Thread.currentThread().interrupt();
        }
    }
}
