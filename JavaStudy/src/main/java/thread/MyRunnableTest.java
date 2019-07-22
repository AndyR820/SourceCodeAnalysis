package thread;

public class MyRunnableTest {


    public static void main(String[] args) {
        MyRunnable r= new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
