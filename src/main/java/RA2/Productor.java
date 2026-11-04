package RA2;

public class Productor extends Thread {
    private int contador = 1;

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (Story.storyList) {
                    int posicionLibre = buscarPosicionLibre();
                    if (posicionLibre == -1) { // si está lleno
                        System.out.println("Productor está esperando a que haya espacio para producir...");
                        Story.storyList.wait();
                    } else {
                        Story story = new Story();
                        story.nombre = "Story " + contador;
                        contador += 1;
                        Story.storyList[posicionLibre] = story;
                        System.out.println("Productor ha producido: " + story.nombre);
                        Story.storyList.notifyAll();
                    }
                }
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private int buscarPosicionLibre() {
        for (int i = 0; i < Story.storyList.length; i++) {
            if (Story.storyList[i] == null) {
                return i;
            }
        }
        return -1;
    }
}