package RA2.Practica4;

public class Pantalla {

    private int vida = 100;
    private int puntos = 0;
    private int posX = 0, posY = 0;
    private boolean hayCambios = false, terminado = false;

    public synchronized void actualizarVida(int cambio) {
        if (terminado) {
            return;
        }
        vida += cambio;
        if (vida <= 0) {
            vida = 0;
            terminado = true;
        }
        hayCambios = true;
        notifyAll();
    }

    public synchronized void actualizarPuntos(int cambio) {
        if (terminado) {
            return;
        }
        puntos += cambio;
        hayCambios = true;
        notifyAll();
    }

    public synchronized void actualizarPosicion(int x, int y) {
        if (terminado) {
            return;
        }
        posX += x;
        posY += y;
        hayCambios = true;
        notifyAll();
    }

    public synchronized boolean dibujar() throws InterruptedException {
        while (! hayCambios && ! terminado) {
            wait();
        }
        if (! hayCambios) {
            return false;
        }
        System.out.println("Vida: " + vida + " | Puntos: " + puntos + " | Monstruo en (" + posX + "," + posY + ")");
        hayCambios = false;
        return true;
    }

    public synchronized boolean estaTerminado() {
        return terminado;
    }
}