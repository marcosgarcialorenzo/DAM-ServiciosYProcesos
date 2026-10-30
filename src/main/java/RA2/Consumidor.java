package RA2;

public class Consumidor extends Thread{

    @Override
    public void run() {
        while (true) {
            synchronized (Story.storyList) {
                System.out.println("Consumidor está intentando consumir");
                try {
                    if (Story.storyList.size() == 0) {
                        Story.storyList.wait();
                    } else {
                        for (int i = 0; i < Story.storyList.size(); i++) {
                            if (Story.storyList.get(i) != null) {
                                Story.storyList.remove(i);
                                System.out.println("Consumidor ha consumido una historia");
                                break;
                            }
                        }
                        //Thread.sleep(100);
                        Story.storyList.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}