package edu.zju.zjh.core.thread.threadlocal;

import lombok.SneakyThrows;

import java.util.UUID;

/**
 * @author: zjh
 * @date : 2022/4/28 10:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class ThreadLocalWithUserContext implements Runnable {

    class Context {
        private String userName;

        public Context(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "Context{" +
                    "userName='" + userName + '\'' +
                    '}';
        }
    }

    // 只针对当前线程
    public static ThreadLocal<Context> userContext = new ThreadLocal<>();
    public static ThreadLocal<Context> userContext2 = new ThreadLocal<>();
    private Integer userId;
    // private UserRepository userRepository = new UserRepository();

    public ThreadLocalWithUserContext(int i) {
        this.userId = i;
    }

    @Override
    public void run() {
        // String userName = userRepository.getUserNameForUserId(userId);
        String userName = UUID.randomUUID().toString();
        userContext.set(new Context(userName));
        System.out.println(
                "Thread: " + Thread.currentThread().getName() +
                "thread context for given userId: " + userId + " is: " + userContext.get()
        );

        userContext2.set(new Context("userName"));
        System.out.println(
                "Thread: " + Thread.currentThread().getName() +
                "thread context for given userId: " + userId + " is: " + userContext2.get()
        );
    }

    @SneakyThrows
    public static void main(String[] args) {
        ThreadLocalWithUserContext firstUser = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser = new ThreadLocalWithUserContext(2);
        Thread first = new Thread(firstUser, "First Thread 1");
        Thread second = new Thread(secondUser, "Second Thread 2");
        first.start();
        second.start();

        Thread.sleep(1000);
        System.out.println("=========================");
        System.out.println(ThreadLocalWithUserContext.userContext);
        System.out.println(ThreadLocalWithUserContext.userContext.get());
    }

}
