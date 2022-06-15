package edu.zju.zjh.core.thread.problem.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.RunAs;

/**
 * @author: zjh
 * @date : 2022/5/12 8:26
 * @Email : 2757412961@qq.com
 * @update:
 */

public class AZ_Sync {

    private static char c = 'A';
    private static volatile int count = 0;

    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyThread implements Runnable {

        private int id;

        @Override
        public void run() {
            while (count < 26) {
                if (count % 3 == id) {
                    synchronized (MyThread.class) {
                        count++;
                        System.out.println("thread:" + count + c);
                        c++;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new MyThread(i)).start();
        }
    }

}
