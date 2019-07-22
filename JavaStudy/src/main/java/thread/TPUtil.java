package thread;


import java.util.*;
import java.util.concurrent.*;

/**
 * Created by wzp on 2018/9/12.
 */
public class TPUtil {
    public static void main(String[] args) throws Exception {
        //用线程池处理
//        (int corePoolSize,//核心线程池大小
//        int maximumPoolSize,//最大线程池大小
//        long keepAliveTime,//线程池中超过corePoolSize数目的空闲线程最大存活时间；可以allowCoreThreadTimeOut(true)成为核心线程的有效时间
//        TimeUnit unit,//keepAliveTime的时间单位
//        BlockingQueue<Runnable> workQueue,//阻塞任务队列
//        ThreadFactory threadFactory,//线程工厂
//        RejectedExecutionHandler handler) {//当提交任务数超过maxmumPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue());
        for (int i=0;i<10;i++) {
            Future<Object> executeResult = threadPoolExecutor.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println("Inserting user............");
                    return insert(1);
                }
            });
            Integer insertResult = (Integer)executeResult.get();
            Thread.currentThread().sleep(6000);
            if(insertResult!=null && insertResult==1){
                System.out.println("Insert succeed.");
            }else {
                System.out.println("Insert failed.");
            }
        }
    }
    public static int insert(int i){
        return i;


    }
}
