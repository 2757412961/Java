package edu.zju.zjh.lc.design.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: zjh
 * @date : 2022/5/31 16:36
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0155 {

    /**
     * 执行耗时:4 ms,击败了93.14% 的Java用户
     * 内存消耗:43.2 MB,击败了45.47% 的Java用户
     */
    class MinStack {

        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.offerLast(val);
            if (minStack.isEmpty() || val <= minStack.peekLast()) {
                minStack.offerLast(val);
            }
        }

        public void pop() {
            Integer last = stack.pollLast();
            if (last.equals(minStack.peekLast())) {
                minStack.pollLast();
            }
        }

        public int top() {
            return stack.peekLast();
        }

        public int getMin() {
            return minStack.peekLast();
        }

    }

}
