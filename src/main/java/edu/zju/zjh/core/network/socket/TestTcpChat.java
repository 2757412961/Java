package edu.zju.zjh.core.network.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: zjh
 * @date : 2022/7/13 10:28
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestTcpChat {

    //客户端
    //连接服务器Socket
    //发送消息
    public static class TcpClient {

        public static void main(String[] args) {
            //1.需要一个地址
            Socket socket = null;
            OutputStream outputStream = null;
            try {
                InetAddress serverip = InetAddress.getByName("127.0.0.1");
                //2.端口号
                int port = 9999;
                //3.创建一个socket连接
                socket = new Socket(serverip, port);

                //4.发送消息
                outputStream = socket.getOutputStream();
                outputStream.write("你好，欢迎学习Java".getBytes());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    //服务器端
    //建立服务器端口ServerSocket
    //等待用户连接accept
    //接收用户消息
    public static class TcpServerDemo01 {

        public static void main(String[] args) {
            //1.我得有个地址
            ServerSocket serverSocket = null;
            Socket socket = null;
            InputStream inputStream = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                serverSocket = new ServerSocket(9999);
                //2.等待客户端连接
                while (true) {
                    socket = serverSocket.accept();
                    //3.读取客户端的消息
                    inputStream = socket.getInputStream();
                    //管道流

                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) != -1) {
                        byteArrayOutputStream.write(buffer, 0, length);
                    }
                    System.out.println(byteArrayOutputStream.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭资源
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

}
