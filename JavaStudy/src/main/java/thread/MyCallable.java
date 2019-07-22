package thread;

import java.util.concurrent.Callable;

public class MyCallable<String> implements Callable<String> {
    private volatile int ticket = 20;
    java.lang.String str="1";
    @Override
    public String call() throws Exception {
        for(;;){
            synchronized(this){
                if(ticket <= 0){
                    str="Thread:" + Thread.currentThread().getName() + " exit for loop,not enough tickets.";
                    break;
                }
            str=Thread.currentThread().getName() + " sales the " + ticket + " ticket.";
                System.out.println(str);
                ticket--;
            }
            try{
                Thread.sleep(10);
            }catch(InterruptedException ie){

                str="Thread:" + Thread.currentThread().getName() + " catch exception.";
            }
        }
        return (String) str;
    }
}
