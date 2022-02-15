package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadMultiArgo {
    private List<Integer> list = new ArrayList<>();

    public void print() {
        for (Integer l : list) {
            System.out.println(l);
        }
    }

    public void addToList(Integer sta) {
        for (int i = 0; i < 100; i++) {
            list.add(sta + i);
        }
    }

    public static void main(String[] args) {
        ThreadMultiArgo tma = new ThreadMultiArgo();

//        tma.addToList(1);
//        tma.addToList(20);

//        new Thread() {
//            @Override
//            public void run() {
//                tma.addToList(1);
//            }
//        }.start();
//
//        new Thread() {
//            @Override
//            public void run() {
//                tma.addToList(101);
//            }
//        }.start();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
        try {
            for (int i = 0; i < 99; i++) {
                int finalI = i;
                fixedThreadPool.execute(new Thread(){
                    @Override
                    public void run() {
                        tma.addToList(finalI *100);
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fixedThreadPool.shutdown();
                fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        tma.print();
    }
}
