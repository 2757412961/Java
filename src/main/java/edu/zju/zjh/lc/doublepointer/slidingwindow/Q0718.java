package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/6/1 10:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0718 {

    /**
     * 方法一：动态规划
     * <p>
     * 执行耗时:26 ms,击败了94.34% 的Java用户
     * 内存消耗:49.7 MB,击败了63.46% 的Java用户
     */
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

    /**
     * 方法二：滑动窗口
     * <p>
     * 执行耗时:41 ms,击败了21.82% 的Java用户
     * 内存消耗:41.2 MB,击败了80.99% 的Java用户
     */
    public int sameMax(int[] nums1, int[] nums2, int i, int j) {
        int res = 0, count = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i++] == nums2[j++]) {
                res = Math.max(res, ++count);
            } else {
                count = 0;
            }
        }
        return res;
    }

    public int findLengthWindow(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res = Math.max(res, sameMax(nums1, nums2, i, 0));
        }

        for (int j = 0; j < nums1.length; j++) {
            res = Math.max(res, sameMax(nums1, nums2, 0, j));
        }

        return res;
    }

    /**
     * 方法三：二分查找 + 哈希
     */

    /**
     * 方法四：二分查找 + 哈希
     * <p>
     * 执行耗时:2468 ms,击败了5.05% 的Java用户
     * 内存消耗:41 MB,击败了87.30% 的Java用户
     */
    public int same(int[] nums1, int[] nums2, int i, int j) {
        int res = 0;
        while (i < nums1.length && j < nums2.length && nums1[i++] == nums2[j++]) {
            res++;
        }
        return res;
    }

    public int findLengthHash(int[] nums1, int[] nums2) {
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                map.put(nums2[i], new LinkedList<>());
            }
            map.get(nums2[i]).add(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)) {
                for (Integer j : map.get(key)) {
                    res = Math.max(res, same(nums1, nums2, i, j));
                }
            }
        }

        return res;
    }

}
