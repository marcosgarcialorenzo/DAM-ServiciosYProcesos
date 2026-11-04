package RA2;

public class Consumidor extends Thread{

    @Override
    public void run() {
        while (true) {
            synchronized (Story.storyList) {
                try {
                    int posicionOcupada = buscarPosicionOcupada();
                    if (posicionOcupada == -1) { // si está vacío
                        System.out.println("Consumidor está esperando a que haya historias...");
                        Story.storyList.wait();
                    } else {
                        System.out.println("Consumidor ha consumido: " + Story.storyList[posicionOcupada].nombre);
                        Story.storyList[posicionOcupada] = null;
                        Story.storyList.notifyAll();
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int buscarPosicionOcupada() {
        for (int i = 0; i < Story.storyList.length; i++) {
            if (Story.storyList[i] != null) {
                return i;
            }
        }
        return -1;
    }
}