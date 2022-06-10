package edu.zju.zjh.offer;

import java.util.LinkedList;

public class O0031 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int out = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[out]) {
                stack.pop();
                out++;
                if (out == popped.length) {
                    return true;
                }
            }
        }

        return stack.isEmpty();
    }

}
