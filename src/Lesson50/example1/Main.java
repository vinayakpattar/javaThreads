package Lesson50.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        //Executor <---ExecutorService

        int n = Runtime.getRuntime().availableProcessors();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(n);

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hi : " + Thread.currentThread().getName());
                }
            };

            service.execute(r);  //--> void
            service.submit(r);    // --> return future


        } finally {
            service.shutdown();
        }

        System.out.println("hello : " + Thread.currentThread().getName());

    }
}
