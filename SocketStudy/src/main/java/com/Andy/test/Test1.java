package com.Andy.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {
	public static void main(String[] args) throws Exception {
		startServer();
	}
	
	public static void startServer() throws Exception{
		ServerSocket server = new ServerSocket(9998);
		while(true){
			Socket socket = server.accept();
//			InputStream inputStream = socket.getInputStream();
//			byte[] bytes = new byte[1024];
//			int len;
//			StringBuilder sb = new StringBuilder();
//			while((len = inputStream.read(bytes)) != -1){
//				sb.append(new String(bytes,0,len));
//			}
//			System.out.println(sb.toString());
			
			receiveFile(socket);
			System.out.println("end......");
		}
	}
	
	 public static void receiveFile(Socket socket) {
	        byte[] inputByte = null;
	        int length = 0;
	        DataInputStream dis = null;
	        FileOutputStream fos = null;
	        try {
	            try {
	                dis = new DataInputStream(socket.getInputStream());
	                fos = new FileOutputStream(new File("/opt/web/aaa.jpg"));
	                inputByte = new byte[1024];
	                System.out.println("jieshoudaoltuthg ...");
	                while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
	                    System.out.println(length);
	                    fos.write(inputByte, 0, length);
	                    fos.flush();
	                }
	                System.out.println("jieshou end");
	            } finally {
	                if (fos != null){
	                    fos.close();}
	                if (dis != null){
	                    dis.close();}
	                if (socket != null){
	                    socket.close();}
	            }
	        } catch (Exception e) {
	        }
	    }
}
