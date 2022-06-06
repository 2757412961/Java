package edu.zju.zjh.lc.array.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/6/6 9:28
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0560 {

    /**
     * 执行耗时:1534 ms,击败了5.65% 的Java用户
     * 内存消耗:43.5 MB,击败了82.74% 的Java用户
     */
    public int subarraySum1(int[] nums, int k) {
        int res = 0, n = nums.length;
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 方法二：前缀和 + 哈希表优化
     * <p>
     * 执行耗时:17 ms,击败了97.24% 的Java用户
     * 内存消耗:45 MB,击败了9.20% 的Java用户
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0, n = nums.length;
        int[] preSum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= n; i++) {
            int target = preSum[i] - k;
            res += map.getOrDefault(target, 0);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        return res;
    }

}
