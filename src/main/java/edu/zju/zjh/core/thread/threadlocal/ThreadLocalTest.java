package edu.zju.zjh.core.thread.threadlocal;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: zjh
 * @date : 2022/4/28 9:38
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadLocalTest {

    private List<String> messages = Lists.newArrayList();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadLocalTest.add("一枝花算不算浪漫");
        ThreadLocalTest.add("两枝花算不算浪漫");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();

        for (int i = 0; i < 5; i++) {
            LocalCallable callable = new LocalCallable();
            FutureTask<Integer> futureTask = new FutureTask<>(callable);
            Thread thread = new Thread(futureTask);
            thread.start();
            System.out.println(futureTask.get());
        }
    }

    /**
     * 在实际的应用中，我们通常会需要为不同的用户请求存储不同的用户信息，一般来说我们需要构建一个全局的Map，
     * 来根据不同的用户ID，来存储不同的用户信息，方便在后面获取。
     */
    static class LocalCallable implements Callable<Integer> {

        // ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

        @Override
        public Integer call() throws Exception {
            Integer result = threadLocalValue.get();
            threadLocalValue.set(result + 1);
            return threadLocalValue.get();
        }

    }

}

