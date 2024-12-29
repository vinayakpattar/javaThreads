//package Assignment;
//
//import java.util.UUID;
//import java.util.concurrent.*;
//
//public class ExecutorCallable implements Callable<T> {
//
//    private final ConcurrentHashMap<UUID, Future<?>> runningTasks = new ConcurrentHashMap<>();
//    private final BlockingQueue<Task<?>> taskQueue = new LinkedBlockingQueue<>();
//    @Override
//    public T call() throws Exception {
//        while (true) {
//            try {
//                Task<?> task = taskQueue.take();
//                if (!runningTasks.containsKey(task.taskGroup().groupUUID())) {
//                    Future<?> future = executorService.submit(() -> {
//                        try {
//                            task.taskAction().call();
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        } finally {
//                            runningTasks.remove(task.taskGroup().groupUUID());
//                        }
//                    });
//                    runningTasks.put(task.taskGroup().groupUUID(), future);
//                } else {
//                    taskQueue.put(task);
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
//    }
//}
