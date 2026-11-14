package RA2.Practica4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pantalla pantalla = new Pantalla();

        Renderizar render = new Renderizar(pantalla);
        Evento vida = new Evento(pantalla, 1);
        Evento puntos = new Evento(pantalla, 2);
        Monstruo monstruo = new Monstruo(pantalla);

        render.setPriority(Thread.MAX_PRIORITY);    // 10
        vida.setPriority(Thread.NORM_PRIORITY);     // 5
        puntos.setPriority(Thread.NORM_PRIORITY);   // 5
        monstruo.setPriority(Thread.MIN_PRIORITY);  // 1

        render.start();
        vida.start();
        puntos.start();
        monstruo.start();

        render.join();
        vida.join();
        puntos.join();
        monstruo.join();
        
        System.out.println("Fin del juego");
    }
}