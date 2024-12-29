package Test1.AlternateNumbers;

public class Main1 {

    private static int counter = 1;
    private final static Object object = new Object();
     public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            while(counter < 100){
                synchronized (object){
                    if (counter%2 == 1){
                        System.out.println(counter + " " + Thread.currentThread().getName());
                        counter++;
                        object.notifyAll();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }, "T1");

        Thread t2 = new Thread(()->{
            while(counter < 100){
                synchronized (object){
                    if (counter%2 == 0){
                        System.out.println(counter + " " + Thread.currentThread().getName());
                        counter++;
                        object.notifyAll();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        },"T2");

        t1.start();
        t2.start();
    }
}
