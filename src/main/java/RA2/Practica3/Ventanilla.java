package RA2.Practica3;

// La ventanilla es el espacio compartido por todos los hilos.
public class Ventanilla {
    // Arrays normales con capacidad para tres elementos.
    private final String[] comandas = new String[3];
    private final String[] platos = new String[3];
    private int numeroComandas = 0;
    private int numeroPlatos = 0;

    public synchronized void ponerComanda(String comanda) throws InterruptedException {
        while (numeroComandas == 3) {
            wait(); // Si hay tres comandas, el camarero espera.
        }
        comandas[numeroComandas] = comanda;
        numeroComandas++;
        System.out.println(Thread.currentThread().getName() + " deja comanda " + comanda + " (" + numeroComandas + "/3)");
        notifyAll();
    }

    public synchronized String tomarComanda() throws InterruptedException {
        while (numeroComandas == 0) {
            wait(); // Si no hay comandas, el cocinero espera.
        }
        String comanda = comandas[0];
        // Desplazamos las comandas para ocupar el hueco libre.
        for (int i = 1; i < numeroComandas; i++) {
            comandas[i - 1] = comandas[i];
        }
        numeroComandas--;
        System.out.println(Thread.currentThread().getName()
                + " recoge comanda " + comanda + " (" + numeroComandas + "/3)");
        notifyAll();
        return comanda;
    }

    public synchronized void ponerPlato(String plato) throws InterruptedException {
        // Si hay tres platos, el cocinero espera.
        while (numeroPlatos == 3) {
            wait();
        }
        platos[numeroPlatos] = plato;
        numeroPlatos++;
        System.out.println(Thread.currentThread().getName()
                + " deja el plato de la comanda " + plato + " (" + numeroPlatos + "/3)");
        notifyAll();
    }

    public synchronized String tomarPlato() throws InterruptedException {
        // Si no hay platos, el cliente espera.
        while (numeroPlatos == 0) {
            wait();
        }
        String plato = platos[0];
        // Desplazamos los platos para ocupar el hueco libre.
        for (int i = 0; i < numeroPlatos; i++) {
            if (platos[i] == null) {
                platos[i] = platos[i + 1];
                platos[i + 1] = null;
            }
        }
        numeroPlatos--;
        System.out.println("Se entrega el plato de comanda " + plato + " (" + numeroPlatos + "/3)");
        notifyAll();
        return plato;
    }
}
