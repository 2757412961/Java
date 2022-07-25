package edu.zju.zjh.lc.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/7/25 21:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q2354 {

    /**
     * 执行耗时:51 ms,击败了100.00% 的Java用户
     * 内存消耗:55.3 MB,击败了100.00% 的Java用户
     */
    private class S1 {

        public int countBit(int n) {
            int cnt = 0;

            while (n != 0) {
                cnt++;
                n = n & (n - 1);
            }

            return cnt;
        }

        public long countExcellentPairs(int[] nums, int k) {
            long res = 0;
            Set<Integer> s = new HashSet<>();
            int[] cnts = new int[33];

            // 去重
            for (int i = 0; i < nums.length; i++) {
                s.add(nums[i]);
            }
            // 统计个数
            for (Integer num : s) {
                cnts[countBit(num)]++;
            }
            // 统计对数
            for (int i = 0; i < cnts.length; i++) {
                for (int j = 0; j < cnts.length; j++) {
                    if (i + j >= k) res += cnts[i] * cnts[j];
                }
            }

            return res;
        }

    }

}
