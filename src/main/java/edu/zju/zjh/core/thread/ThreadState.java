package main.java.edu.zju.zjh.core.thread;

/**
 * @author: zjh
 * @date : 2021/8/20 上午 09:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadState {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("***子线程休眠0.1s***");
            }
        });

        //启动前
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        //启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);//RUNABLE

        //阻塞时与结束时
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();
            //TIMED_WAITING或者TERMINATED
            System.out.println(state);
        }
    }

}
