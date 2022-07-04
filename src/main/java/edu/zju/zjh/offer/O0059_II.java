package edu.zju.zjh.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/4/21 21:03
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0059_II {

    /**
     * 方法二：维护一个单调的双端队列
     */
    private class S1 {

        class MaxQueue {

            private LinkedList<Integer> deque;
            private Queue<Integer> que;

            public MaxQueue() {
                this.deque = new LinkedList<>();
                this.que = new LinkedList<>();
            }

            public int max_value() {
                if (que.isEmpty() || deque.isEmpty()) return -1;
                return deque.peekFirst();
            }

            public void push_back(int value) {
                while (!deque.isEmpty() && deque.peekLast() < value) {
                    deque.pollLast();
                }
                deque.offerLast(value);

                // Queue
                que.offer(value);
            }

            public int pop_front() {
                if (que.isEmpty() || deque.isEmpty()) return -1;
                if (que.peek().equals(deque.peekFirst())) {
                    deque.pollFirst();
                }

                // Queue
                return que.poll();
            }

        }

    }

    /**
     * 二刷
     * 执行耗时:24 ms,击败了97.66% 的Java用户
     * 内存消耗:49 MB,击败了72.67% 的Java用户
     */
    private class S2 {

        class MaxQueue {

            LinkedList<Integer> q = new LinkedList<>();
            LinkedList<Integer> stack = new LinkedList<>();

            public MaxQueue() {

            }

            public int max_value() {
                if (q.isEmpty()) return -1;
                return stack.peekFirst();
            }

            public void push_back(int value) {
                q.offerLast(value);

                while (!stack.isEmpty() && stack.peekLast() < value) {
                    stack.pollLast();
                }
                stack.offerLast(value);
            }

            public int pop_front() {
                if (q.isEmpty()) return -1;
                int pop = q.pollFirst();

                if (pop == stack.peekFirst()) {
                    stack.pollFirst();
                }

                return pop;
            }

        }

    }

}
