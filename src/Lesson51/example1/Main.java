package Lesson51.example1;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Runnable r = () -> System.out.println("Hello World!!!");
        Future<?> f = service.submit(r);
        try {
            f.get();
        } catch (InterruptedException | ExecutionException ignored){

        }

        service.shutdown();
    }
}
