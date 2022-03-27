package edu.zju.zjh.lc.ds.stack;

import java.util.LinkedList;

public class Q0503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i % n] = -1;
            } else {
                res[i % n] = stack.peek();
            }

            stack.push(nums[i % n]);
        }

        return res;
    }

}
