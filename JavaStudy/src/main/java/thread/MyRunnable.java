package thread;

public class MyRunnable implements Runnable {
    private volatile int ticket = 20;
//    private  int ticket = 1000;

    @Override
    public void run(){
        for(;;){
            synchronized(this){
                if(ticket <= 0){
                    System.out.println("Thread:" + Thread.currentThread().getName() + " exit for loop,not enough tickets.");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " sales the " + ticket + " ticket.");
                ticket--;
            }
            try{
                Thread.sleep(100);
            }catch(InterruptedException ie){
                System.out.println("Thread:" + Thread.currentThread().getName() + " catch exception.");
            }
        }
    }
}
