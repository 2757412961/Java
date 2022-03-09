package edu.zju.zjh.lc.ds.stack;

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

}
