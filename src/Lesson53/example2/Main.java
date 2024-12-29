package Lesson53.example2;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        SumTask task = new SumTask(list);

        ForkJoinPool pool = new ForkJoinPool();
        int res = pool.invoke(task);
        System.out.println(res);
    }
}

class SumTask extends RecursiveTask<Integer> {

    private final List<Integer> list;

    SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if(list.size() <=2){
            return list.stream().mapToInt(n->n).sum();
        } else {
            int mid = list.size()/2;
            List<Integer> list1 = list.subList(0, mid);
            List<Integer> list2 = list.subList(mid, list.size());

            SumTask t1 = new SumTask(list1);
            SumTask t2 = new SumTask(list2);

//            t1.fork();  //t1 splits into 2 threads
//            t2.fork();  //t2 splits into 2 threads
//            return t1.join()+t2.join(); //waits for results to be computed and added

            t2.fork(); //t2 to be executed on separate thread
            return t1.compute() + t2.join(); //t1 will continue on same thread

//            return t2.join()+t1.compute();  //t2.join() before t1.compute() will make it sequential since all of t2 will be completed first and then t1 will be computed
        }
    }
}
