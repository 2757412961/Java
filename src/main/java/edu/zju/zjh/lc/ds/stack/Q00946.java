package edu.zju.zjh.lc.ds.stack;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/1 19:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q00946 {

    /**
     * 执行耗时:1 ms,击败了93.63% 的Java用户
     * 内存消耗:40.9 MB,击败了73.67% 的Java用户
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, pos = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            stack.offerLast(pushed[i]);
            while (!stack.isEmpty() && pos < n && stack.peekLast() == popped[pos]) {
                stack.pollLast();
                pos++;
            }
        }

        return stack.isEmpty();
    }

}
