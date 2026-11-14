package RA2.Practica4;

/**
 * Estado compartido que muestran los hilos del juego.
 */
public class Pantalla {
    private int vida = 100;
    private int puntos;
    private int posicionSiguienteMonstruo;

    public synchronized void actualizarVida(int vida) {
        this.vida = Math.max(0, vida);
    }

    public synchronized void reducirVida(int cantidad) {
        actualizarVida(vida - cantidad);
    }

    public synchronized void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public synchronized void actualizarPosicionMonstruo(int posicion) {
        posicionSiguienteMonstruo = posicion;
    }

    public synchronized Estado obtenerEstado() {
        return new Estado(vida, puntos, posicionSiguienteMonstruo);
    }

    public record Estado(int vida, int puntos, int posicionSiguienteMonstruo) {
    }
}
