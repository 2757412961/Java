package edu.zju.zjh.core.thread.problem.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @author: zjh
 * @date : 2022/5/13 9:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class OrderRun_CountDownLatch {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderCDL implements Runnable {
        private String name;
        private CountDownLatch prev;
        private CountDownLatch cur;

        @SneakyThrows
        @Override
        public void run() {
            prev.await();
            System.out.println("Thread: " + name);
            cur.countDown();
        }

    }

    public static void main(String[] args) {
        int num = 10;
        OrderCDL[] orderCDLS = new OrderCDL[num];
        CountDownLatch last = null;

        for (int i = 0; i < num; i++) {
            CountDownLatch cur = null;
            if (i == num - 1) {
                cur = new CountDownLatch(0);
            } else {
                cur = new CountDownLatch(1);
            }
            orderCDLS[i] = new OrderCDL("id" + i, last, cur);
            last = cur;
        }
        orderCDLS[0].setPrev(last);

        for (int i = num - 1; i >= 0; i--) {
            new Thread(orderCDLS[i]).start();
        }
    }

}
