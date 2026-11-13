package RA2.Practica3;

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
                String comanda = ventanilla.tomarComanda();
                Thread.sleep(2000); // tiempo de cocinado
                ventanilla.ponerPlato(comanda);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();// El programa principal interrumpe al cocinero al acabar.
        }
    }
}
