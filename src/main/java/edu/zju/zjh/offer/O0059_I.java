package edu.zju.zjh.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/4/21 19:58
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0059_I {

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
