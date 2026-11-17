package RA2.Practica4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Objeto compartido: contiene la vida, los puntos y la posición del monstruo.
        Pantalla pantalla = new Pantalla();

        // Se crean cuatro hilos con funciones distintas.
        Renderizar render = new Renderizar(pantalla);
        Evento vida = new Evento(pantalla, 1);
        Evento puntos = new Evento(pantalla, 2);
        Monstruo monstruo = new Monstruo(pantalla);

        // La prioridad es una sugerencia para el planificador, no una garantía de ejecución.
        render.setPriority(Thread.MAX_PRIORITY);    // 10
        vida.setPriority(Thread.NORM_PRIORITY);     // 5
        puntos.setPriority(Thread.NORM_PRIORITY);   // 5
        monstruo.setPriority(Thread.MIN_PRIORITY);  // 1

        // start() crea/inicia cada hilo y hace que ejecute su método run().
        render.start();
        vida.start();
        puntos.start();
        monstruo.start();

        // join() hace que el hilo principal espere a que cada hilo termine.
        render.join();
        vida.join();
        puntos.join();
        monstruo.join();
        
        // Solo se muestra cuando todos los hilos han finalizado.
        System.out.println("Fin del juego");
    }
}