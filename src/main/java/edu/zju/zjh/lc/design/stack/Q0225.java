package edu.zju.zjh.lc.design.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/3/9 9:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0225 {

    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
            int top = queue.peek();
            queue.offer(queue.poll());
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了55.77% 的Java用户
     */
    class S2 {

        class MyStack {

            Queue<Integer> q = new LinkedList<>();

            public MyStack() {

            }

            public void push(int x) {
                q.offer(x);
            }

            public int pop() {
                int size = q.size();
                for (int i = 1; i < size; i++) {
                    q.offer(q.poll());
                }

                return q.poll();
            }

            public int top() {
                int size = q.size();
                for (int i = 1; i < size; i++) {
                    q.offer(q.poll());
                }
                int top = q.peek();
                q.offer(q.poll());
                return top;
            }

            public boolean empty() {
                return q.isEmpty();
            }
        }

    }

}
