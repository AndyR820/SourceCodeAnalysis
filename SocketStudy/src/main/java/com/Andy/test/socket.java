package com.Andy.test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class socket {
    public static final int cache = 10 * 1024;

	public static void main(String[] args) {
		int port = 9998;
		try {// 启动服务
			final ServerSocket server = new ServerSocket(port);
//			server.setSoTimeout(30000);
			// 输出提示语
			System.out.println("The server is running..");
			// 输出服务
			System.out.println(server);
			// 无限循环
			while (true) {
				// 类似于sleep效果
				final Socket socket = server.accept();
				System.out.println(socket.getInetAddress().getHostAddress());
				// 新建线程
				new Thread(new Runnable() {
					@Override
					public void run() {
						// 要处理的动作：读取
						Reader reader;
						try {
							 //获取读取内容
							reader = new InputStreamReader(socket.getInputStream());
							char[] chars = new char[64];
							int len;
							// 不断读取就要不断创建对象
							StringBuilder sb = new StringBuilder();
							// 不断附加消息
							while ((len = reader.read(chars)) != -1) {
								sb.append(new String(chars, 0, len));
							}
//					        Base64.encodeToString(appicon, Base64.DEFAULT);


				            File file = new File("/opt/web/bb.jpg");
				            file.getParentFile().mkdirs();
				            FileOutputStream fileout = new FileOutputStream(file);
//				            /**
//				             * 根据实际运行效果 设置缓冲区大小
//				             */
				            byte[] buffer = new byte[cache];
				            int ch = 0;
				            while ((ch = reader.read(buffer)) != -1) {
				                fileout.write(buffer, 0, ch);
				            }
				            is.close();
				            fileout.flush();
				            fileout.close();
							// 读取完后输出消息
							System.out.println("From client:" + sb);
						} catch (Exception e) {
						}
					}
				}).start();// 线程的开始







			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
