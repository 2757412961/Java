package edu.zju.zjh.lc.design.queue;

import java.util.Stack;

/**
 * @author: zjh
 * @date : 2022/3/9 9:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0232 {

    private class S1 {

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

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了75.69% 的Java用户
     */
    private class S2 {

        class MyQueue {

            private Stack<Integer> stack;
            private Stack<Integer> reverse;

            public MyQueue() {
                stack = new Stack<>();
                reverse = new Stack<>();
            }

            public void push(int x) {
                this.stack.push(x);
            }

            public int pop() {
                if (reverse.isEmpty()) {
                    while (!stack.isEmpty()) {
                        reverse.push(stack.pop());
                    }
                }

                return reverse.pop();
            }

            public int peek() {
                if (reverse.isEmpty()) {
                    while (!stack.isEmpty()) {
                        reverse.push(stack.pop());
                    }
                }

                return reverse.peek();
            }

            public boolean empty() {
                return stack.isEmpty() && reverse.isEmpty();
            }

        }

    }

}
