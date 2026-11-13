package RA2.Practica3;

public class Ventanilla {

    private final String[] comandas = new String[3];
    private final String[] platos = new String[3];
    private int numeroComandas = 0;
    private int numeroPlatos = 0;

    // synchronized permite que solo un hilo entre aquí cada vez.
    public synchronized void ponerComanda(String comanda) throws InterruptedException {
        while (numeroComandas == 3) { // Si el array está lleno, el camarero espera.
            wait();
        }
        comandas[numeroComandas] = comanda; // Guardamos la comanda en la primera posición libre.
        numeroComandas++;
        System.out.println(Thread.currentThread().getName() + " deja comanda " + comanda + " (" + numeroComandas + "/3)");
        // Avisamos a los cocineros de que hay una comanda nueva.
        notifyAll();
    }

    public synchronized String tomarComanda() throws InterruptedException {
        while (numeroComandas == 0) { // Si no hay comandas, el cocinero espera.
            wait();
        }
        String comanda = comandas[0]; // Recogemos la primera comanda del array.
        for (int i = 0; i < numeroComandas; i++) {
            if (comandas[i] == null) {
                comandas[i] = comandas[i + 1];
                comandas[i + 1] = null;
            }
        }
        numeroComandas--;
        System.out.println(Thread.currentThread().getName() + " recoge comanda " + comanda + " (" + numeroComandas + "/3)");
        // Avisamos a los camareros de que hay espacio libre.
        notifyAll();
        return comanda;
    }

    public synchronized void ponerPlato(String plato) throws InterruptedException {
        while (numeroPlatos == 3) {// Si el array de platos está lleno, el cocinero espera.
            wait();
        }
        platos[numeroPlatos] = plato;// Guardamos el plato en la primera posición libre.
        numeroPlatos++;
        System.out.println(Thread.currentThread().getName() + " deja el plato de la comanda " + plato + " (" + numeroPlatos + "/3)");
        // Avisamos al cliente de que hay un plato disponible.
        notifyAll();
    }
    
    public synchronized String tomarPlato() throws InterruptedException {
        while (numeroPlatos == 0) { // Si no hay platos preparados, el cliente espera.
            wait();
        }
        String plato = platos[0];// Recogemos el primer plato del array.
        for (int i = 0; i < numeroPlatos; i++) {// Desplazamos los platos para ocupar el hueco libre.
            if (platos[i] == null) {
                platos[i] = platos[i + 1];
                platos[i + 1] = null;
            }
        }
        numeroPlatos--;
        System.out.println("Se entrega el plato de comanda " + plato + " (" + numeroPlatos + "/3)");
        // Avisamos a los cocineros de que hay espacio para otro plato.
        notifyAll();
        return plato;
    }
}