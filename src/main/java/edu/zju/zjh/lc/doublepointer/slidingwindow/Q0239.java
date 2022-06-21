package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/6/21 下午 05:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0239 {

    /**
     * 方法二：单调队列
     * 执行耗时:27 ms,击败了92.88% 的Java用户
     * 内存消耗:57.4 MB,击败了46.42% 的Java用户
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();

            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);

            if (i + 1 >= k) {
                res[i + 1 - k] = nums[q.peekFirst()];
            }
        }

        return res;
    }

    /**
     * 方法三：分块 + 预处理
     */

}
