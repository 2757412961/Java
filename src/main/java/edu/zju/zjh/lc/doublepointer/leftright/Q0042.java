package edu.zju.zjh.lc.doublepointer.leftright;

import java.util.Deque;
import java.util.LinkedList;

public class Q0042 {

    /**
     * 方法一：动态规划
     * 时间复杂度：O(n)，其中 nn 是数组 height 的长度。
     * 计算数组 leftMax 和 rightMax 的元素值各需要遍历数组 height 一次，计算能接的雨水总量还需要遍历一次。
     */
    private class S1 {

        public int trap(int[] height) {
            int n = height.length;
            int[] maxl = new int[n], maxr = new int[n];
            int max, res = 0;

            max = 0;
            for (int i = 0; i < n; i++) {
                maxl[i] = max;
                if (height[i] > max) max = height[i];
            }
            max = 0;
            for (int i = n - 1; i >= 0; i--) {
                maxr[i] = max;
                if (height[i] > max) max = height[i];
            }

            for (int i = 0; i < n; i++) {
                int trapi = Math.min(maxl[i], maxr[i]) - height[i];
                if (trapi > 0) {
                    res += trapi;
                }
            }

            return res;
        }

    }

    /**
     * 方法二：单调栈
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private class S2 {

        class Solution {
            public int trap(int[] height) {
                int ans = 0;
                Deque<Integer> stack = new LinkedList<Integer>();
                int n = height.length;
                for (int i = 0; i < n; ++i) {
                    while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                        int top = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                        int left = stack.peek();
                        int currWidth = i - left - 1;
                        int currHeight = Math.min(height[left], height[i]) - height[top];
                        ans += currWidth * currHeight;
                    }
                    stack.push(i);
                }
                return ans;
            }
        }

    }

    /**
     * 方法三：双指针
     * 动态规划的做法中，需要维护两个数组 leftMax 和 rightMax，因此空间复杂度是 O(n)。是否可以将空间复杂度降到 O(1)
     * 执行耗时:1 ms,击败了74.14% 的Java用户
     * 内存消耗:42 MB,击败了52.38% 的Java用户
     */
    private class S3 {

        public int trap(int[] height) {
            int res = 0;
            int left = 0, right = height.length - 1, maxl = 0, maxr = 0;

            while (left < right) {
                maxl = Math.max(maxl, height[left]);
                maxr = Math.max(maxr, height[right]);
                if (maxl < maxr) {
                    res += maxl - height[left];
                    left++;
                } else if (maxl > maxr) {
                    res += maxr - height[right];
                    right--;
                } else if (maxl == maxr) {
                    res += maxr - height[right];
                    right--;
                }
            }

            return res;
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了73.96% 的Java用户
     * 内存消耗:42.1 MB,击败了32.05% 的Java用户
     */
    private class S4 {

        public int trap(int[] height) {
            int res = 0;
            int n = height.length;
            int[] lmax = new int[n];
            int[] rmax = new int[n];

            // record max left & right
            for (int i = 1; i < n; i++) {
                lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
            }

            for (int i = 0; i < n; i++) {
                int min = Math.min(lmax[i], rmax[i]);
                if (height[i] < min) {
                    res += min - height[i];
                }
            }

            return res;
        }

    }

    /**
     * 三刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.4 MB,击败了12.47% 的Java用户
     */
    private class S5 {

        public int trap(int[] height) {
            int res = 0;
            int l = 0, r = height.length - 1, lmax = 0, rmax = 0;

            while (l < r) {
                lmax = Math.max(lmax, height[l]);
                rmax = Math.max(rmax, height[r]);

                if (lmax < rmax) {
                    res += lmax - height[l++];
                } else if (lmax > rmax) {
                    res += rmax - height[r--];
                } else if (lmax == rmax) {
                    res += rmax - height[r--];
                }
            }

            return res;
        }

    }

}
