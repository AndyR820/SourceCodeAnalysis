package com.Andy.test;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

//Socket Client
public class SendMMSSocket {
    public static void sendMMSSocket(String mms,String host,int port){
    Socket client;
    try{
        client=new Socket(host,port);

        Writer writer=new OutputStreamWriter(client.getOutputStream());
        writer.write(mms);
        writer.flush();
        writer.close();
        writer.close();
    }catch (Exception e ){

    }
    }
public static void main(String[] args) {
//    String className=getClass().toString();
//    String testName=getName().toString();
    String flag="mms test";
//    String mms=className+","+testName+","+flag;
    String mms="test";    
    SendMMSSocket.sendMMSSocket(mms,"192.168.1.3",9998);//这里的IP是本机IP
    //多发送几条，方便查看
//    for(int i=0;i<10;i++){
//    	SendMMSSocket.sendMMSSocket(i+":"+mms,"192.168.1.3",9998);
//    }

}
}
