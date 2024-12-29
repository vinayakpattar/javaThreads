package Test1.AlternateNumbers;

import java.util.Objects;

public class Main {
    private static Object obj = new Object();
    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            synchronized (obj){
                for (int i = 0; i <= 100; i += 2) {
                    System.out.println(i);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    obj.notifyAll();
                }
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 99; i += 2) {
                System.out.println(i);
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.notifyAll();
            }
        });

        t1.start();
        t2.start();

    }
}
