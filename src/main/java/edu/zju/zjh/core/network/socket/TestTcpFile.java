package edu.zju.zjh.core.network.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zjh
 * @date : 2022/7/13 10:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestTcpFile {

    public static class TcpClient {
        public static void main(String[] args) throws Exception {

            //创建socket连接
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            //2.创建一个输出流
            OutputStream os = socket.getOutputStream();
            //3.文件流
            FileInputStream fis = new FileInputStream("bizhi.jpg");
            //4.写出文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);

            }
            //通知服务器结束
            socket.shutdownOutput();//传输完毕
            //确定接收完毕
            InputStream inputStream = socket.getInputStream();
            //String byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while ((len2 = inputStream.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString());

            //5.关闭资源
            baos.close();
            inputStream.close();
            fis.close();
            socket.close();


        }
    }

    public static class TcpServer {

        public static void main(String[] args) throws Exception {
            //1.创建服务
            ServerSocket serverSocket = new ServerSocket(9090);
            //2.监听客户端的连接
            Socket socket = serverSocket.accept();//阻塞式监听，一直等待客户端连接
            //3.获取输入流
            InputStream is = socket.getInputStream();
            //4.文件输出
            FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            //通知客户端接收完毕
            OutputStream os = socket.getOutputStream();
            os.write("我接受完毕，你可以断开l".getBytes());

            //关闭资源
            fos.close();
            is.close();
            socket.close();
            serverSocket.close();
        }

    }

}
