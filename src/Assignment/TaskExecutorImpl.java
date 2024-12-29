package Assignment;

import java.util.UUID;
import java.util.concurrent.*;

public class TaskExecutorImpl implements TaskExecutor{
    private final ExecutorService executorService;
    private final ConcurrentHashMap<UUID, Future<?>> runningTasks = new ConcurrentHashMap<>();
    private final BlockingQueue<Task<?>> taskQueue = new LinkedBlockingQueue<>();


    public TaskExecutorImpl(int maxConcurrency) {
        executorService = Executors.newFixedThreadPool(maxConcurrency);
        executorService.submit(() -> {
            while (true) {
                try {
                    Task<?> task = taskQueue.take();
                    if (!runningTasks.containsKey(task.taskGroup().groupUUID())) {
                        Future<?> future = executorService.submit(() -> {
                            try {
                                task.taskAction().call();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            } finally {
                                runningTasks.remove(task.taskGroup().groupUUID());
                            }
                        });
                        runningTasks.put(task.taskGroup().groupUUID(), future);
                    } else {
                        taskQueue.put(task);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }

    @Override
    public <T> Future<T> submitTask(Task<T> task) {
        try {
            taskQueue.put(task);
            // Assuming the Callable<T> returns the result directly
            return (Future<T>) runningTasks.get(task.taskGroup().groupUUID());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task submission interrupted");
        }
    }
}
