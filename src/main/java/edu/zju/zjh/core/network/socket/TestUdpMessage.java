package edu.zju.zjh.core.network.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author: zjh
 * @date : 2022/7/13 10:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestUdpMessage {

    public static class TestUdpClient {

        public static void main(String[] args) throws Exception {
            //不需要连接服务器
            //1.建立一个socket
            DatagramSocket socket = new DatagramSocket();

            //2.建个包
            String msg = "你好啊，我是胡歌";
            //发送给谁
            InetAddress localhost = InetAddress.getByName("localhost");
            int port = 9000;
            //数据，数据的长度起始，要发送给谁
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
            //3.发送包
            socket.send(packet);
            //4.关闭流
            socket.close();
        }

    }

    public static class TestUdpServer {

        public static void main(String[] args) throws Exception {
            //1.开放端口
            DatagramSocket socket = new DatagramSocket(9000);
            //2.接收数据包
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);
            //System.out.println(packet.getData().toString());
            System.out.println(packet.getAddress());
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
            //3.关闭连接
            socket.close();
        }

    }

}
