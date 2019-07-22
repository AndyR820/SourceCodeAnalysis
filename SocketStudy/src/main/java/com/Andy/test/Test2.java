package com.Andy.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Test2 {
	public static void main(String[] args) throws Exception{
		startClient();
	}
	
	public static void startClient() throws Exception{
		String host = "127.0.0.1"; 
	    int port = 4789;
	    Socket socket = new Socket(host, port);
//	    OutputStream outputStream = socket.getOutputStream();
//	    String message="���  yiwangzhibujian";
//	    socket.getOutputStream().write(message.getBytes("UTF-8"));
	    
	    File f = new File("e:/abc.png"); 
	    FileInputStream fis = new FileInputStream(f);
	    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	    int length = 0;
	    byte[] sendBytes = new byte[1024];
	    while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
            dos.write(sendBytes, 0, length);
            dos.flush();
        }
//	    socket.getOutputStream().write(getImageBinary());
//	    outputStream.close();
	    socket.close();
	}
	
	/**
     * ��ͼƬת���ɶ�����
     * 
     * @return
     */ 
    static byte[] getImageBinary() throws Exception{ 
        File f = new File("e:/abc.png"); 
        BufferedImage bi = ImageIO.read(f); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        ImageIO.write(bi, "jpg", baos);  //������ת����ͼƬ�Ǹ�ʽ�����ʲô��ʽ�������ʧ�� 
        byte[] bytes = baos.toByteArray(); 
        return bytes; 
    }  
}
