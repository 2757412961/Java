package edu.zju.zjh.topk.huawei;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/5/14 19:05
 * @Email : 2757412961@qq.com
 * @update:
 */

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
