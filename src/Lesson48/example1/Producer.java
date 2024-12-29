package Lesson48.example1;

import Lesson47.example1.Main;

import java.util.Random;

public class Producer implements Runnable {
    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            int n = r.nextInt(1000);
            synchronized (Main.bucket) {
                if (Main.bucket.size() < 100) {
                    Main.bucket.add(n);
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
