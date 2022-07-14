package edu.zju.zjh.core.network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author: zjh
 * @date : 2022/7/13 10:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestUdpChatMulti {

    public static class TalkSender implements Runnable {
        DatagramSocket socket = null;
        BufferedReader reader = null;

        private String toIP;
        private int toPort;
        private int fromPort;

        public TalkSender(String toIP, int toPort, int fromPort) {
            this.toIP = toIP;
            this.toPort = toPort;
            this.fromPort = fromPort;
            try {
                socket = new DatagramSocket(fromPort);
                reader = new BufferedReader(new InputStreamReader(System.in));
            } catch (SocketException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = reader.readLine();
                    DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, new InetSocketAddress(this.toIP, this.toPort));
                    socket.send(packet);
                    if (data.startsWith("bye")) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static class TalkReceiver implements Runnable {
        DatagramSocket socket = null;
        private int Port;
        private String msgFrom;

        public TalkReceiver(int port, String msgFrom) {
            this.Port = port;
            this.msgFrom = msgFrom;
            try {
                socket = new DatagramSocket(port);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            while (true) {
                try {
                    //准备接收包裹
                    byte[] container = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                    socket.receive(packet);//阻塞式接收包裹
                    //断开连接
                    byte[] data = packet.getData();
                    String rdata = new String(data, 0, packet.getLength());

                    System.out.println(msgFrom + ":" + rdata);
                    if (rdata.equals("bye")) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            socket.close();

        }
    }

    public static class TalkStudent {
        public static void main(String[] args) {
            //开启两个线程
            new Thread(new TalkSender("localhost", 9999, 7777)).start();
            new Thread(new TalkReceiver(8888, "老师")).start();

        }
    }

    public static class TalkTeacher {
        public static void main(String[] args) {
            new Thread(new TalkSender("localhost", 8888, 5555)).start();
            new Thread(new TalkReceiver(9999, "学生")).start();
        }
    }

}
