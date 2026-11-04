package RA2;

public class Consumidor extends Thread{

    @Override
    public void run() {
        while (true) {
            synchronized (Story.storyList) {
                try {
                    int posicionOcupada = buscarPosicionOcupada();
                    if (posicionOcupada == -1) { // si está vacío
                        Story.storyList.wait();
                    } else {
                        System.out.println("Consumidor ha consumido la historia " + Story.storyList[posicionOcupada].nombre);
                        Story.storyList[posicionOcupada] = null;
                        Thread.sleep(100);
                        Story.storyList.notifyAll();
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