package edu.zju.zjh.lcold;

import java.util.Timer;
import java.util.TimerTask;

public class Thread_Argo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {


                System.out.println("11232");


            }
        }, 2 * 1000, 2 * 1000); // 2s后开始执行，每0.5秒执行一次
    }
}
