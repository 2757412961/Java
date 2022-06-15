package edu.zju.zjh.lc.thread;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * @author: zjh
 * @date : 2022/6/14 21:09
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1116 {

    private interface IntConsumer {

        public default void accept(Integer x) {
            System.out.print(x);
        }

    }

    /**
     * Semaphore
     * 执行耗时:5 ms,击败了99.87% 的Java用户
     * 内存消耗:40.2 MB,击败了75.05% 的Java用户
     */
    private class S1 {

        public class ZeroEvenOdd {

            private int n;
            private Semaphore sZero = new Semaphore(1);
            private Semaphore sEven = new Semaphore(0);
            private Semaphore sOdd = new Semaphore(0);

            public ZeroEvenOdd(int n) {
                this.n = n;
            }

            // printNumber.accept(x) outputs "x", where x is an integer.
            public void zero(IntConsumer printNumber) throws InterruptedException {
                for (int i = 1; i <= n; i++) {
                    sZero.acquire();
                    printNumber.accept(0);
                    if ((i & 1) == 0) {
                        sEven.release();
                    } else {
                        sOdd.release();
                    }
                }
            }

            public void even(IntConsumer printNumber) throws InterruptedException {
                for (int i = 2; i <= n; i += 2) {
                    sEven.acquire();
                    printNumber.accept(i);
                    sZero.release();
                }
            }

            public void odd(IntConsumer printNumber) throws InterruptedException {
                for (int i = 1; i <= n; i += 2) {
                    sOdd.acquire();
                    printNumber.accept(i);
                    sZero.release();
                }
            }

        }

    }

    /**
     * 超时
     */
    public class S2 {

        public class ZeroEvenOdd {

            private int n;
            private int step = 1;
            private Semaphore sZero = new Semaphore(1);
            private Semaphore sEven = new Semaphore(0);
            private Semaphore sOdd = new Semaphore(0);

            public ZeroEvenOdd(int n) {
                this.n = n;
            }

            // printNumber.accept(x) outputs "x", where x is an integer.
            public void zero(IntConsumer printNumber) throws InterruptedException {
                for (int i = 1; i <= n; i++) {
                    sZero.acquire();
                    System.out.print("T");
                    printNumber.accept(0);
                    if ((step & 1) == 0) {
                        sEven.release();
                    } else {
                        sOdd.release();
                    }
                }
            }

            public void even(IntConsumer printNumber) throws InterruptedException {
                while (step <= n) {
                    if ((step & 1) == 0) {
                        sEven.acquire();
                        printNumber.accept(step);
                        step++;
                        sZero.release();
                    }
                }
            }

            public void odd(IntConsumer printNumber) throws InterruptedException {
                while (step <= n) {
                    if ((step & 1) == 1) {
                        sOdd.acquire();
                        printNumber.accept(step);
                        step++;
                        sZero.release();
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        final IntConsumer consumer = new IntConsumer() {
        };

        S1.ZeroEvenOdd s1 = new Q1116().new S1().new ZeroEvenOdd(5);
        S2.ZeroEvenOdd s2 = new Q1116().new S2().new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                s1.even(consumer);
                s2.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                s1.odd(consumer);
                s2.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                s1.zero(consumer);
                s2.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
