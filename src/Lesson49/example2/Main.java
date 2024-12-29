package Lesson49.example2;

import java.util.Objects;

public class Main {
    private Object a = new Object();
    private Object b = new Object();

    public void m1(){
        //t1 --> takes lock on a
        synchronized (a){
            //t1  --> waiting for lock on b but lock on a is taken by t2
            synchronized (b){

            }
        }
    }

    public void m2(){
        //t2 takes lock on b
        synchronized (b){

            //t2 --> waiting for lock on a but lock on a is taken by t1
            synchronized (a){

            }
        }
    }


    public static void main(String[] args) {

    }


}
