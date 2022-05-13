package edu.zju.zjh.core.thread.problem.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: zjh
 * @date : 2022/5/13 10:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Order_BlockQueue {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Work implements Runnable {
        private String name;

        @Override
        public void run() {
            System.out.println("Thread: " + name);
        }
    }

    public static void main(String[] args) {
        int num = 10;
        BlockingQueue<Thread> bq = new LinkedBlockingDeque<>();

        for (int i = 0; i < num; i++) {
            bq.offer(new Thread(new Work("name" + i)));
        }

        while (!bq.isEmpty()) {
            try {
                Thread t = bq.take();
                t.start();

                while (t.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
