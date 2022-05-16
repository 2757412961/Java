package edu.zju.zjh.lc.divideconquer;

/**
 * @author: zjh
 * @date : 2022/5/16 16:03
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0327 {

    /**
     * 难哭了, 为什么对数组排序前后所求的区间数量不会改变呢?
     * https://leetcode.cn/problems/count-of-range-sum/solution/shuo-ming-yi-xia-guan-fang-gui-bing-pai-xu-by-sing/
     */
    private int res = 0;
    private int lower, upper;

    public void sort(long[] preSum, long[] temp, int l, int r) {
        if (l >= r) return;

        int m = (r - l) / 2 + l;
        sort(preSum, temp, l, m);
        sort(preSum, temp, m + 1, r);
        merge(preSum, temp, l, m, r);
    }

    public void merge(long[] preSum, long[] temp, int l, int m, int r) {
        for (int i = l, j = m + 1, k = m + 1; i <= m && j <= r; ) {
            long sum = preSum[j] - preSum[i];
            if (sum < lower) {
                j++;
                continue;
            } else if (sum > upper) {
                i++;
                continue;
            }

            while (k <= r && preSum[k] - preSum[i] <= upper) {
                k++;
            }
            res += k - j;
        }

        // 进行效率优化
        // 维护左闭右开区间 [start, end) 中的元素和 nums[i] 的差在 [lower, upper] 中
        /*
            int start = m + 1, end = m + 1;
            for (int i = l; i <= m; i++) {
                // 如果 nums[i] 对应的区间是 [start, end)，
                // 那么 nums[i+1] 对应的区间一定会整体右移，类似滑动窗口
                while (start <= r && preSum[start] - preSum[i] < lower) {
                    start++;
                }
                while (end <= r && preSum[end] - preSum[i] <= upper) {
                    end++;
                }
                res += end - start;
            }
         */

        for (int i = l, j = m + 1, k = l; k <= r; k++) {
            if (i == m + 1) {
                temp[k] = preSum[j++];
            } else if (j == r + 1) {
                temp[k] = preSum[i++];
            } else {
                if (preSum[i] <= preSum[j]) {
                    temp[k] = preSum[i++];
                } else if (preSum[i] > preSum[j]) {
                    temp[k] = preSum[j++];
                }
            }
        }

        for (int k = l; k <= r; k++) {
            preSum[k] = temp[k];
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] preSum = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        sort(preSum, temp, 0, preSum.length - 1);
        return res;
    }

}
