package edu.zju.zjh.core.thread;

/**
 * @author: zjh
 * @date : 2021/8/20 上午 11:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程执行---" + i);
        }
    }

    public static void main(String[] args) {
        ThreadJoin testJoin = new ThreadJoin();
        Thread thread = new Thread(testJoin);
        thread.start();


        for (int i = 0; i < 400; i++) {
            if (i == 200) {
                try {
                    //阻塞主线程，使子线程优先执行完
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程执行---" + i);
        }
    }

}
