package edu.zju.zjh.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: zjh
 * @date : 2022/4/21 19:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0059_I {

    /**
     * 方法一：优先队列
     * 执行耗时:12 ms,击败了43.36% 的Java用户
     * 内存消耗:50.5 MB,击败了25.84% 的Java用户
     */
    private class S1 {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length <= 0) return new int[0];
            int n = nums.length;
            int[] res = new int[n - k + 1];
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((i, j) -> {
                return nums[j] - nums[i];
            });

            for (int i = 0; i < n; i++) {
                if (i < k - 1) {
                    heap.offer(i);
                } else {
                    heap.offer(i);
                    while (!heap.isEmpty() && heap.peek() < i - k + 1) {
                        heap.poll();
                    }
                    res[i - k + 1] = nums[heap.peek()];
                }
            }

            return res;
        }

    }

    /**
     * 方法二：单调队列
     * 执行耗时:11 ms,击败了74.04% 的Java用户
     * 内存消耗:50.4 MB,击败了33.92% 的Java用户
     */
    private class S2 {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length <= 0 || k == 0) return new int[0];
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int idx = 0;
            Deque<Integer> que = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (i >= k && que.peekFirst() == nums[i - k]) {
                    que.pollFirst();
                }
                while (!que.isEmpty() && que.peekLast() < nums[i]) {
                    que.pollLast();
                }
                que.offerLast(nums[i]);
                if (i >= k - 1) {
                    res[idx++] = que.peekFirst();
                }
            }

            return res;
        }

    }

    /**
     * 方法三：分块 + 预处理
     */

    /**
     * 二刷 方法二：单调队列
     * 执行耗时:10 ms,击败了81.94% 的Java用户
     * 内存消耗:50.2 MB,击败了50.09% 的Java用户
     */
    private class S3 {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) return new int[0];
            int n = nums.length;
            int[] res = new int[n - k + 1];
            LinkedList<Integer> stack = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                    stack.pollLast();
                }
                stack.offerLast(i);

                if (i >= k - 1) {
                    if (!stack.isEmpty() && stack.peekFirst() < i - k + 1) {
                        stack.pollFirst();
                    }

                    res[i - k + 1] = nums[stack.peekFirst()];
                }
            }

            return res;
        }

    }

}
