package RA2;

public class Productor extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Story.storyList) {
                System.out.println("Productor está produciendo...");
                try {
                    if (Story.storyList.size() >= 4) {
                        Story.storyList.wait();
                    } else if (Story.storyList.size() < 3) {
                        Story story = new Story();
                        int contador = 0;
                        story.nombre = "Story " + contador;
                        contador = contador + 1;
                        Story.storyList.add(story);
                        System.out.println("Productor ha producido: " + story.nombre);
                        Story.storyList.notifyAll();
                        //Thread.sleep(1200);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}