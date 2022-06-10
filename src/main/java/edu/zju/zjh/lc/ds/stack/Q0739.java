package edu.zju.zjh.lc.ds.stack;

import java.util.LinkedList;

public class Q0739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                stack.pollLast();
            }

            if (!stack.isEmpty()){
                res[i] = stack.peekLast() - i;
            }
            stack.offerLast(i);
        }

        return res;
    }

}
