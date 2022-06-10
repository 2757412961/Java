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
