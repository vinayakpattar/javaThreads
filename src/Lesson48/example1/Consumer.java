package Lesson48.example1;

import Lesson47.example1.Main;

public class Consumer implements Runnable{
    @Override
    public void run() {
        while (true) {
            synchronized (Main.bucket) {
                if (Main.bucket.size() > 0) {
                    int n = Main.bucket.get(0);
                    Main.bucket.remove(0);
                    Main.bucket.notifyAll();
                } else {
                    try {
                        Main.bucket.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
