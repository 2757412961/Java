package edu.zju.zjh.core.thread.problem.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

/**
 * @author: zjh
 * @date : 2022/5/12 19:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class OrderRun_Join {

    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinThread extends Thread {
        private JoinThread prev;
        private int idx;

        @SneakyThrows
        @Override
        public void run() {
            if (prev != null) {
                prev.join();
            }
            System.out.println("This is thread: " + idx);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        int count = 20;
        JoinThread last = null;
        JoinThread[] threads = new JoinThread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new JoinThread(last, i);
            last = threads[i];
        }

        Thread.sleep(100);
        for (int i = count - 1; i >= 0; i--) {
            threads[i].start();
        }

    }

}
