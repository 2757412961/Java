package edu.zju.zjh.core.thread.threadlocal;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zjh
 * @date : 2022/4/28 10:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class SharedMapWithUserContext implements Runnable {

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

    public static Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();
    private Integer userId;

    public SharedMapWithUserContext(int i) {
        this.userId = i;
    }

    @Override
    public void run() {
        // String userName = userRepository.getUserNameForUserId(userId);
        String userName = UUID.randomUUID().toString();
        userContextPerUserId.put(userId, new Context(userName));
    }

    @SneakyThrows
    public static void main(String[] args) {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        SharedMapWithUserContext thirdUser = new SharedMapWithUserContext(3);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
        new Thread(thirdUser).start();

        Thread.sleep(1000);
        System.out.println(SharedMapWithUserContext.userContextPerUserId);
    }

}
