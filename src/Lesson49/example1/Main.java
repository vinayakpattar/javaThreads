package Lesson49.example1;

public class Main {

    public static void main(String[] args) {
        A a = new A();

        a.m1(); //a is the monitor here
        a.m2(); //a is the monitor here

        A a1 = new A();
        a.m1();  //these are not sync since a is monitor here
        a1.m2(); // not sync since a1 is monitor here
    }
}

class A {
    public synchronized void m1(){
        System.out.println("a");
    }
    public synchronized void m2(){
        System.out.println("a");
    }
}
