package RA2.Practica4;

public class Pantalla {

    private int vida = 100;
    private int puntos = 0;
    private int posX = 0, posY = 0;
    
    public synchronized void actualizarVida(int cambio) {
        vida += cambio;
    }
    public synchronized void actualizarPuntos(int cambio) {
        puntos += cambio;
    }
    public synchronized void actualizarPosicion(int x, int y) {
        posX += x;
        posY += y;
    }
    
    public synchronized void dibujar() {
        System.out.println("Vida: " + vida + " | Puntos: " + puntos + " | Monstruo en (" + posX + "," + posY + ")");
    }
}