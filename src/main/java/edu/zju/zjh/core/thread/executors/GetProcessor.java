package edu.zju.zjh.core.thread.executors;

/**
 * @author: zjh
 * @date : 2022/4/22 20:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class GetProcessor {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        System.out.println(availableProcessors);
    }

}
