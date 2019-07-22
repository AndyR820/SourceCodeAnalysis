package com.Andy.test;

import sun.plugin2.message.Message;

import java.io.IOException;
import java.net.ServerSocket;

public class ReceiveDataDemo {

	public void receiveData() {
	 	final ServerSocket serverSocket=null;
	    Thread thread = new Thread() {
	        @Override
	        public void run() {
	            super.run();
	        /*指明服务器端的端口号*/
	            try {
	            	serverSocket = new ServerSocket(8000);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            //获取IP地址
	            GetIpAddress.getLocalIpAddress(serverSocket);
	            Message message_2 = handler.obtainMessage();
	            message_2.what = 2;
	            message_2.obj = GetIpAddress.getIP() + "   " + GetIpAddress.getPort();
	            handler.sendMessage(message_2);

	            while (true) {
	                try {
	                    mSocket = serverSocket.accept();
	                    socketStatus = true;

	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                //开启接收数据的线程
	                new ServerThread(mSocket).start();

	            }
	        }
	    };
	    thread.start();

	}
}
