package thread;

import java.util.concurrent.*;

public class ExecutorsTest {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        while (true) {
            threadPool.execute(new Runnable() {
//             提交多个线程任务，并执行
                @Override
                public void run() {
                    Future<String> future=threadPool.submit(new MyCallable<String>());
                    try {
                        System.out.println("submit:"+future.get()+"---");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
//        }
    }



    public static void runnabletest(){
        MyRunnable r= new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
//        t2.start();
    }


    public static void threadtest(){
        MyRunnable r= new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
    }

    public static void callabletest(){
        Callable<Object> oneCallable = new MyCallable<Object>();
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
        Thread t = new Thread(oneTask);
        Thread t1 = new Thread(oneTask);
        Thread t2 = new Thread(oneTask);
        t.start();
        t1.start();
        t2.start();
    }

}
