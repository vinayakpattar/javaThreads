package Lesson46.Example2;

public class DBRunnable2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("DB2 data fetched : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
