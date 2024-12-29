package Lesson46.Example1;

public class Main {

    public static void main(String[] args) {

        Runnable r1 = new OddNumberThread();

        Thread t1 = new Thread(r1, "T1");
        t1.start();

        Thread t2 = new Thread(r1, "T2");
        t2.start();

        System.out.println("END!!!");

    }
}
