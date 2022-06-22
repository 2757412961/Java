package edu.zju.zjh.lc.ds.stack.monotone;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/6/22 下午 08:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0084 {

    /**
     * 方法一：单调栈
     */
    private class Answer {

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Deque<Integer> mono_stack = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }

            mono_stack.clear();
            for (int i = n - 1; i >= 0; --i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
                mono_stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }

    }

    /**
     * 方法一：单调栈
     * 执行耗时:31 ms,击败了44.28% 的Java用户
     * 内存消耗:57.3 MB,击败了32.27% 的Java用户
     */
    private class S1 {

        public int largestRectangleArea(int[] heights) {
            int res = 0, n = heights.length;
            int[] l = new int[n], r = new int[n];
            Deque<Integer> stack = new ArrayDeque<Integer>();

            for (int i = 0; i < n; i++) {
                int pos = i;
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    pos = stack.pop();
                }
                if (stack.size() == 0) {
                    l[i] = 0;
                } else {
                    l[i] = stack.peek() + 1;
                }
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                int pos = i;
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    pos = stack.pop();
                }
                if (stack.size() == 0) {
                    r[i] = n - 1;
                } else {
                    r[i] = stack.peek() - 1;
                }
                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                res = Math.max(res, (r[i] - l[i] + 1) * heights[i]);
            }
            return res;
        }

    }

    /**
     * 方法二：单调栈 + 常数优化
     */

}
