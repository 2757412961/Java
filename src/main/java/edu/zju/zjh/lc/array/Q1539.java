package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/11 15:08
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1539 {

    /**
     * 方法一：枚举
     */

    /**
     * 方法二：二分查找
     */

    /**
     * 方法三：优化的枚举
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了42.17% 的Java用户
     */
    private class S1 {

        public int findKthPositive(int[] arr, int k) {
            int idx = 0, n = 0;

            while (idx < arr.length) {
                int diff = arr[idx] - n - 1;
                if (diff >= k) {
                    break;
                }

                k -= diff;
                n = arr[idx++];
            }

            return n + k;
        }

    }

}
