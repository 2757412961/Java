package edu.zju.zjh.lc.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zjh
 * @date : 2022/6/15 15:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1195 {

    private class IntConsumer {

        public void accept(Integer x) {
            System.out.print(x);
        }

    }

    /**
     * Semaphore
     * 执行耗时:5 ms,击败了93.99% 的Java用户
     * 内存消耗:41.5 MB,击败了5.10% 的Java用户
     */
    private class S1 {

        class FizzBuzz {

            private int n;
            private Semaphore snumber = new Semaphore(1);
            private Semaphore sfizz = new Semaphore(0);
            private Semaphore sbuzz = new Semaphore(0);
            private Semaphore sfizzbuzz = new Semaphore(0);

            public FizzBuzz(int n) {
                this.n = n;
            }

            // printFizz.run() outputs "fizz".
            public void fizz(Runnable printFizz) throws InterruptedException {
                for (int i = 1; i <= n; i++) {
                    if (i % 3 == 0 && i % 5 != 0) {
                        sfizz.acquire();
                        printFizz.run();
                        snumber.release();
                    }
                }
            }

            // printBuzz.run() outputs "buzz".
            public void buzz(Runnable printBuzz) throws InterruptedException {
                for (int i = 1; i <= n; i++) {
                    if (i % 3 != 0 && i % 5 == 0) {
                        sbuzz.acquire();
                        printBuzz.run();
                        snumber.release();
                    }
                }
            }

            // printFizzBuzz.run() outputs "fizzbuzz".
            public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
                for (int i = 1; i <= n; i++) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        sfizzbuzz.acquire();
                        printFizzBuzz.run();
                        snumber.release();
                    }
                }
            }

            // printNumber.accept(x) outputs "x", where x is an integer.
            public void number(IntConsumer printNumber) throws InterruptedException {
                for (int i = 1; i <= n; i++) {
                    snumber.acquire();
                    if (i % 3 == 0 && i % 5 != 0) {
                        sfizz.release();
                    } else if (i % 3 != 0 && i % 5 == 0) {
                        sbuzz.release();
                    } else if (i % 3 == 0 && i % 5 == 0) {
                        sfizzbuzz.release();
                    } else {
                        printNumber.accept(i);
                        snumber.release();
                    }
                }
            }

        }

    }

    /**
     * 执行耗时:5 ms,击败了93.80% 的Java用户
     * 内存消耗:41.4 MB,击败了5.11% 的Java用户
     */
    private class S2 {

        class FizzBuzz {

            private int n;
            private int state = 1;
            private ReentrantLock relock = new ReentrantLock();
            private Condition cnumber = relock.newCondition();

            public FizzBuzz(int n) {
                this.n = n;
            }

            // printFizz.run() outputs "fizz".
            public void fizz(Runnable printFizz) throws InterruptedException {
                while (state <= n) {
                    relock.lock();
                    try {
                        while (state <= n && state % 3 == 0 && state % 5 != 0) {
                            printFizz.run();
                            state++;
                        }
                    } finally {
                        relock.unlock();
                    }
                }
            }

            // printBuzz.run() outputs "buzz".
            public void buzz(Runnable printBuzz) throws InterruptedException {
                while (state <= n) {
                    relock.lock();
                    try {
                        while (state <= n && state % 3 != 0 && state % 5 == 0) {
                            printBuzz.run();
                            state++;
                        }
                    } finally {
                        relock.unlock();
                    }
                }
            }

            // printFizzBuzz.run() outputs "fizzbuzz".
            public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
                while (state <= n) {
                    relock.lock();
                    try {
                        while (state <= n && state % 3 == 0 && state % 5 == 0) {
                            printFizzBuzz.run();
                            state++;
                        }
                    } finally {
                        relock.unlock();
                    }
                }
            }

            // printNumber.accept(x) outputs "x", where x is an integer.
            public void number(IntConsumer printNumber) throws InterruptedException {
                while (state <= n) {
                    relock.lock();
                    try {
                        while (state <= n && state % 3 != 0 && state % 5 != 0) {
                            printNumber.accept(state);
                            state++;
                        }
                    } finally {
                        relock.unlock();
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        Runnable printFizz = () -> {
            System.out.printf(" %s ", "fizz");
        };
        Runnable printBuzz = () -> {
            System.out.printf(" %s ", "buzz");
        };
        Runnable printFizzBuzz = () -> {
            System.out.printf(" %s ", "fizzbuzz");
        };
        IntConsumer intConsumer = new Q1195().new IntConsumer();
        S2.FizzBuzz fb = new Q1195().new S2().new FizzBuzz(15);
        new Thread(() -> {
            try {
                fb.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
