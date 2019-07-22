package thread;

import org.junit.Test;

public class MyThreadTest {

    // 启动3个线程t1,t2,t3；每个线程各卖10张票！
    // (01) MyThread继承于Thread，它是自定义个线程。每个MyThread都会卖出10张票。
    // (02) 主线程main创建并启动3个MyThread子线程。每个子线程都各自卖出了10张票。
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }




}
