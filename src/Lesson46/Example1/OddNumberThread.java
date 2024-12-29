package Lesson46.Example1;

public class OddNumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=11; i+=2){
            System.out.println(i + " : " + Thread.currentThread().getName());
        }
    }
}
