package RA2.Practica4;

public class Pantalla {

    // Estos datos son compartidos y solo se modifican dentro de métodos sincronizados.
    private int vida = 100;
    private int puntos = 0;
    private int posX = 0, posY = 0;
    // hayCambios indica al renderizador que debe volver a pintar.
    // terminado indica que la partida ha acabado.
    private boolean hayCambios = false, terminado = false;

    // synchronized permite que solo un hilo entre a la vez y evita condiciones de carrera.
    public synchronized void actualizarVida(int cambio) {
        if (terminado) {
            return;
        }
        vida += cambio;
        if (vida <= 0) {
            vida = 0;
            // La vida a cero es la condición de finalización del juego.
            terminado = true;
        }
        hayCambios = true;
        // Despierta al hilo de renderizado si estaba esperando una actualización.
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
        // Se acumula el desplazamiento recibido en la posición actual.
        posX += x;
        posY += y;
        hayCambios = true;
        notifyAll();
    }

    public synchronized boolean dibujar() throws InterruptedException {
        // Mientras no haya cambios, el renderizador libera el monitor con wait().
        while (! hayCambios && ! terminado) {
            wait();
        }
        // Si terminó sin dejar una actualización pendiente, no hay nada que pintar.
        if (! hayCambios) {
            return false;
        }
        // Se imprime el estado más reciente de la partida.
        System.out.println("Vida: " + vida + " | Puntos: " + puntos + " | Monstruo en (" + posX + "," + posY + ")");
        // El cambio ya se ha consumido; el siguiente dibujo volverá a esperar.
        hayCambios = false;
        return true;
    }

    // Método sincronizado para leer de forma segura el estado compartido.
    public synchronized boolean estaTerminado() {
        return terminado;
    }
}