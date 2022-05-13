package edu.zju.zjh.core.thread.problem.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zjh
 * @date : 2022/5/12 16:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ABC_Synch_State {

    private static final int NUM = 4;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrintABC implements Runnable {
        private int idx;
        private char name;
        private static int state;

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                if (state % NUM == idx) {
                    synchronized (this.getClass()) {
                        count--;
                        state++;
                        System.out.println("Thread:" + idx + ' ' + name);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        char c = 'A';
        for (int i = 0; i < NUM; i++) {
            new Thread(new PrintABC(i, c++)).start();
        }
    }

}
