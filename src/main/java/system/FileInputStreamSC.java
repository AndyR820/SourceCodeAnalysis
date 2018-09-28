package system;

import java.io.*;

/**
 * Created by andy on 2018/9/20.
 */
public class FileInputStreamSC {

    //按字节读取
    public static void readTest(InputStream is){
        try {
            int contact;
            while((contact=is.read())!=-1){
                System.out.print((char)contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("读取失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读流失败");
        }

    }
    //按字节读取
    public static void readTest(InputStream in,int i) throws IOException {
        byte[] tt = new byte[i];
        int b;
        while ((in.read(tt)) != -1) {
            String tzt = new String(tt, "utf-8");
            System.out.println(tzt);
            InputStream is = null;

        }
    }
    public static void main(String[] args) throws IOException {
        File file=new File("data/user");
        InputStream is=new FileInputStream(file);
        readTest(is,1024);
    }
}
