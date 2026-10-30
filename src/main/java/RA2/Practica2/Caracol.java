package RA2.Practica2;

import java.util.Random;

public class Caracol extends Thread {

    public static final int META = 50; // distancia hasta la meta
    private static boolean hayGanador = false; // bandera compartida: true cuando alguien ya ha ganado
    private final String nombre; //String para el nombre
    private final Random random = new Random(); // esto es para sacar numeros aleatorios
    private int posicion = 0; // esto es para ver en que posicion esta el caracol, empieza en 0 y va avanzando hasta llegar a la meta

    public Caracol(String nombre) {
        this.nombre = nombre;
    }

    // Solo un hilo a la vez puede entrar. El primero que llega pone hayGanador a true y devuelve true;
    // si otro llega justo después, encuentra la bandera ya activada y devuelve false.
    private static synchronized boolean intentarGanar() {
        if (hayGanador) { // ¿ya hay ganador?
            return false; // SÍ → sale aquí y se acaba el metodo y devuelve false
        }
        hayGanador = true; // solo llega aquí si hayGanador era false
        return true; // y devuelve true si es el primer caracol que llega a la meta
    }

    @Override
    public void run() {
        while (posicion < META && !hayGanador) { // no he llegado a la meta Y nadie ha ganado
            posicion += random.nextInt(5) + 1; // Avanza de 1 a 5 posiciones
            /*if (posicion > META) {
                posicion = META;
            }*/
            dibujarPista();
            try {
                Thread.sleep(400 + random.nextInt(101)); // Descansa entre 400 y 500 ms
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido");
                return;
            }
        }
        if (posicion >= META && intentarGanar()) { // comprueba si he llegado a la meta Y intentarGanar() devuelve true: y imprime el ganador. Despues termina el hilo
            System.out.println(">>> ¡" + nombre + " ha ganado la carrera!");
        }
    }

    private void dibujarPista() {
        int visualDistancia = Math.min(posicion, META - 1); // La última casilla visible de la pista es META - 1
        StringBuilder pista = new StringBuilder();
        pista.append(String.format("%-50s [", nombre));
        for (int i = 0; i < META; i++) {
            if (i == visualDistancia) {
                pista.append("\uD83C\uDFCE\uFE0F"); // 🐌
            } else {
                pista.append("_");
            }
        }
        pista.append("] Meta!");
        synchronized (Caracol.class) { // Evita que las líneas de varios hilos se mezclen
            System.out.println(pista.toString()); // Ese bloque garantiza que solo un caracol a la vez pueda imprimir su línea en la consola.
        }
    }
}