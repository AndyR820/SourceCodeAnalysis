package com.Andy.test;

import java.io.InputStream;
import java.net.Socket;

public class ServerThread extends Thread {


	    private Socket socket;
	    private InputStream inputStream;


	    public ServerThread(Socket socket) {
	        this.socket = socket;
	    }

	    @Override
	    public void run() {
	        while (true) {

	            if (socketStatus) {
	                try {

	                    inputStream = socket.getInputStream();

	                } catch (IOException e) {
	                    e.printStackTrace();
	                }

	                int len;
	                byte[] bytes = new byte[1024];
	                boolean isString = false;


	                try {
	                    //这里必须是无限循环的，因为服务端要随时等待客户端发送数据
	                    //当客户端断开后其结果等于-1，循环结束
	                    while ((len = inputStream.read(bytes)) != -1) {
	                        for (int i = 0; i < len; i++) {

	                            if (bytes[i] != '\0') {
	                                stringBuffer.append((char) bytes[i]);

	                            } else {
	                                isString = true;
	                                break;
	                            }
	                        }
	                        if (isString) {

	                            Message message_1 = handler.obtainMessage();
	                            message_1.what = 1;
	                            message_1.obj = stringBuffer;
	                            handler.sendMessage(message_1);
	                            isString = false;
	                            stringBuffer = new StringBuffer();

	                        }
	                    }
	                    //当这个异常发生时，说明客户端那边的连接已经断开
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    try {
	                        inputStream.close();
	                        socket.close();
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	}
}
