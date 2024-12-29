package Lesson47.example1;

import java.util.Map;
import java.util.Random;

public class Producer implements Runnable {
    @Override
    public void run() {

        Random r = new Random();
        while (true){
            int n = r.nextInt(1000);
            synchronized (Main.bucket){  //Wherever Main.bucket is used as Monitor, only one thread is inside the synchronized block at any given time.
                if(Main.bucket.size() < 100){
                    Main.bucket.add(n);
                    System.out.println(Thread.currentThread().getName() + " added " + n);
                }
            }
        }
    }
}
