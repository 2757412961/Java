package edu.zju.zjh.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author: zjh
 * @date : 2022/4/27 15:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class FutureProgram {

    /**
        List<Future<String>> futureList = new ArrayList<>();
            for (ChannelModel channel : channels) {
            Future<String> future = executorService
                    .submit(() -> load(channel.getChannel()));
            futureList.add(future);
        }

        final long deadline = System.currentTimeMillis() + MAX_LOAD_SECONDS * 1000;
            for (int i = 0; i < futureList.size(); i++) {
            Future<RateModel> future = futureList.get(i);
            try {
                long timeLeft = deadline - System.currentTimeMillis();
                if (timeLeft > 0) {
                    // 设定时间取出任务
                    String model = future.get(timeLeft, TimeUnit.MILLISECONDS);
                    // ...
                } else {
                    if (future.isDone()) {
                        RateModel rateModel = future.get();
                        // ...
                    } else {
                        future.cancel(true);
                    }
                }
            } catch (InterruptedException e) {
                // ...
            }
        }
     */

}
