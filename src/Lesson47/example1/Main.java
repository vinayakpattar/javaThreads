package Lesson47.example1;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> bucket = new ArrayList<>();

    public static void main(String[] args) {
        var pr1 = new Producer();
        var pr2 = new Producer();

        var cr1 = new Consumer();
        var cr2 = new Consumer();

        var t1 = new Thread(pr1, "pr1");
        var t2 = new Thread(pr2, "pr2");
        var t3 = new Thread(cr1, "cr1");
        var t4 = new Thread(cr2, "cr2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
