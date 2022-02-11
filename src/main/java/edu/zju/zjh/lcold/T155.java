package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

public class T155 {

    static class MinStack {

        /**
         * initialize your data structure here.
         */
        ArrayList<Integer> stack = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int x) {
            stack.add(x);

            if (min > x) {
                min = x;
            }
        }

        public void pop() {
            int last = stack.remove(stack.size() - 1);
            if (last == min) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < stack.size(); i++) {
                    if (min > stack.get(i)) {
                        min = stack.get(i);
                    }
                }
            }
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int a = minStack.getMin();   //--> 返回 -3.
        minStack.pop();
        int b = minStack.top();      //--> 返回 0.
        int c = minStack.getMin();   //--> 返回 -2.
        int d = 0;
    }
}
