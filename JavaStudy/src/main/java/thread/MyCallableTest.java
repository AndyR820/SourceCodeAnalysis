package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Object> oneCallable = new MyCallable<Object>();
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
        Thread t = new Thread(oneTask);
        Thread t1 = new Thread(oneTask);
        Thread t2 = new Thread(oneTask);
        t.start();
        System.out.println("拿到的线程结果 "+oneTask.get());
        t1.start();
        t2.start();

    }
}
