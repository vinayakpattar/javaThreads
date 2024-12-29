package Assignment;

import java.util.UUID;
import java.util.concurrent.Callable;


public class Main {
//    TaskExecutor executor = null; // Maximum 2 concurrent tasks

    public static void main(String[] args) {
        TaskExecutor executor = new TaskExecutorImpl(2);
        Callable<Integer> t1 = new TaskCallable();
        Task<Integer> task1 = new Task<>(UUID.randomUUID(), new TaskGroup(UUID.randomUUID()), TaskType.READ, () -> {
            System.out.println("Task 1 started");
            Thread.sleep(1000);
            System.out.println("Task 1 finished");
            return 1;
        });

        Task<Integer> task2 = new Task<>(UUID.randomUUID(), new TaskGroup(UUID.randomUUID()), TaskType.WRITE, () -> {
            System.out.println("Task 2 started");
            Thread.sleep(500);
            System.out.println("Task 2 finished");
            return 2;
        });

        Task<Integer> task3 = new Task<>(UUID.randomUUID(), new TaskGroup(task1.taskGroup().groupUUID()), TaskType.READ, () -> {
            System.out.println("Task 3 started");
            Thread.sleep(500);
            System.out.println("Task 3 finished");
            return 3;
        });

        executor.submitTask(task1);
        executor.submitTask(task2);
        executor.submitTask(task3);
    }

}
