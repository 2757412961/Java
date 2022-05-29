package edu.zju.zjh.lc.array.prefix;

import java.util.Random;

/**
 * @author: zjh
 * @date : 2022/5/29 15:31
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0528 {

    /**
     * https://labuladong.github.io/algo/2/18/27/
     * 到这里，这道题的核心思路就说完了，主要分几步：
     * 1、根据权重数组 w 生成前缀和数组 preSum。
     * 2、生成一个取值在 preSum 之内的随机数，用二分搜索算法寻找大于等于这个随机数的最小元素索引。
     * 3、最后对这个索引减一（因为前缀和数组有一位索引偏移），就可以作为权重数组的索引，即最终答案:
     * <p>
     * 执行耗时:23 ms,击败了89.66% 的Java用户
     * 内存消耗:46.2 MB,击败了13.61% 的Java用户
     */
    class Solution {

        private int[] w;
        private int[] preSum;
        private int range = 0;
        private Random rand = new Random();

        public Solution(int[] w) {
            int len = w.length;
            this.w = w;
            this.preSum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
            range = preSum[len];
        }

        public int pickIndex() {
            int target = rand.nextInt(range) + 1;
            int l = 1, r = w.length, m = -1;

            while (l < r) {
                m = l + (r - l) / 2;
                if (preSum[m] == target) {
                    r = m;
                } else if (preSum[m] > target) {
                    r = m;
                } else if (preSum[m] < target) {
                    l = m + 1;
                }
            }

            return l - 1;
        }

    }

}
