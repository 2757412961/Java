package edu.zju.zjh.lc.design.queue;

import java.util.Stack;

/**
 * @author: zjh
 * @date : 2022/3/9 9:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0232 {

    class MyQueue {

        private Stack<Integer> stack;
        private Stack<Integer> stackReverse;

        public MyQueue() {
            stack = new Stack<>();
            stackReverse = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            while (!stack.isEmpty()) {
                stackReverse.push(stack.pop());
            }
            int pop = stackReverse.pop();
            while (!stackReverse.isEmpty()) {
                stack.push(stackReverse.pop());
            }

            return pop;
        }

        public int peek() {
            while (!stack.isEmpty()) {
                stackReverse.push(stack.pop());
            }
            int top = stackReverse.peek();
            while (!stackReverse.isEmpty()) {
                stack.push(stackReverse.pop());
            }

            return top;
        }

        public boolean empty() {
            return stack.isEmpty();
        }

    }

}
