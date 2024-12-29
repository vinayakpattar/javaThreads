package Lesson45;

public class Main {
    public static void main(String[] args) {

        EvenNumbersThread t1 = new EvenNumbersThread();
        t1.start();
//        t1.start(); //Starting 2 times :: Exception in thread "main" java.lang.IllegalThreadStateException
//        t1.run();   //Runs in the main thread, it will not run in EvenNumbersThread

        System.out.println("END!!! : " + Thread.currentThread().getName());

    }
}
