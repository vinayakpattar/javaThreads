package Lesson47.example1;

public class Consumer implements Runnable{
    @Override
    public void run() {
        while (true) {

            synchronized (Main.bucket){
                if(!Main.bucket.isEmpty()){
                    int n = Main.bucket.get(0);
                    Main.bucket.remove(0);
                    System.out.println(Thread.currentThread().getName() + " removed " + n);
                }
            }

        }
    }
}
