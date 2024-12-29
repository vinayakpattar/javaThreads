package Lesson46.Example2;

public class Main {
    public static void main(String[] args) {

        var r1 = new DBRunnable1();
        var r2 = new DBRunnable2();

        var t1 = new Thread(r1,"t1");
        var t2 = new Thread(r2, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Process started on data : " + Thread.currentThread().getName());

    }
}
