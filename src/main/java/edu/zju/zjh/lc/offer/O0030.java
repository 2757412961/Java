package edu.zju.zjh.lc.offer;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/3/16 18:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0030 {

    class MinStack {

        private LinkedList<Integer> stack;
        private LinkedList<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.stack = new LinkedList<>();
            this.min = new LinkedList<>();
        }

        public void push(int x) {
            stack.offerLast(x);
            if (x <= min()) {
                min.offerLast(x);
            }
        }

        public void pop() {
            int pop = stack.pollLast();
            if (pop == min()) {
                min.pollLast();
            }
        }

        public int top() {
            return stack.peekLast();
        }

        public int min() {
            return min.peekLast();
        }
    }

}
