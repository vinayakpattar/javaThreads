package Lesson46.Example2;

public class DBRunnable1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("DB1 Data fetched : "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
