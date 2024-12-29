package Lesson53.Fibonacci;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    public static void main(String[] args) {
        //1 1 2 3 5 8 13
        int n = 7;

        FibonacciTask task = new FibonacciTask(n);
        ForkJoinPool pool = new ForkJoinPool();
        int res = pool.invoke(task);
        System.out.println(res);
    }

}

class FibonacciTask extends RecursiveTask<Integer>{

    public final int n;

    FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n == 1 || n == 2){
            return 1;
        } else {
            FibonacciTask t1 = new FibonacciTask(n-1);
            FibonacciTask t2 = new FibonacciTask(n-2);

            t2.fork();

            return t1.compute() + t2.join();
        }
    }
}
