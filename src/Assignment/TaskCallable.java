package Assignment;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Task 1 started");
        Thread.sleep(1000);
        System.out.println("Task 1 finished");
        return 1;
    }
}
