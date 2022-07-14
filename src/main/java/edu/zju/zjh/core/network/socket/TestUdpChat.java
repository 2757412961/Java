package edu.zju.zjh.core.network.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author: zjh
 * @date : 2022/7/13 10:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestUdpChat {

    public static class TestUdpClient {

        public static void main(String[] args) throws Exception {
            DatagramSocket socket = new DatagramSocket(8888);

            //准备数据  控制台读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String data = reader.readLine();


                DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, new InetSocketAddress("localhost", 8000));

                socket.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            }
            socket.close();
        }

    }

    public static class TestUdpServer {

        public static void main(String[] args) throws Exception {
            DatagramSocket socket = new DatagramSocket(8000);
            while (true) {
                //准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);//阻塞式接收包裹
                //断开连接
                byte[] data = packet.getData();
                String rdata = new String(data, 0, packet.getLength());

                System.out.println(rdata);
                if (rdata.equals("bye")) {
                    break;
                }


            }
            socket.close();

        }

    }

}
