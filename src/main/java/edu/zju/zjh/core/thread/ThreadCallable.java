package edu.zju.zjh.core.thread;

import java.util.concurrent.*;

/**
 * @author: zjh
 * @date : 2022/4/22 13:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadCallable {

    static class CallableThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            // do some job
            TimeUnit.SECONDS.sleep(3);
            return "complete the job";
        }
    }

    public static void main(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new CallableThread());
        Thread thread = new Thread(stringFutureTask);
        thread.start();

        boolean done = stringFutureTask.isDone();
        boolean cancelled = stringFutureTask.isCancelled();

        // while (!Thread.interrupted())，那么本次任务会一直执行，只有mayInterruptIfRunning=true
        // stringFutureTask.cancel(true);

        try {
            // 设置获取结果的等待时间,超时抛出timeOutException
            // String s = futureTask.get(1, TimeUnit.SECONDS);
            // 阻塞等待
            String res = stringFutureTask.get(3, TimeUnit.SECONDS);
//            String res = stringFutureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
