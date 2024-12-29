package Lesson53.example1;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new DoubleNumber(list));
    }


}

class DoubleNumber extends RecursiveAction{

    private final List<Integer> list;

    DoubleNumber(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected void compute() {
        if(list.size()<=2){
            list.stream().map(n -> n*2).forEach(System.out::println);
        } else {
            int mid = list.size()/2;
            List<Integer> list1 = list.subList(0,mid);
            List<Integer> list2 = list.subList(mid,list.size());
            DoubleNumber r1 = new DoubleNumber(list1);
            DoubleNumber r2 =  new DoubleNumber(list2);

            invokeAll(r1,r2);


        }


    }
}
