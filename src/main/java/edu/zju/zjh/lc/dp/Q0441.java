package edu.zju.zjh.lc.dp;

/**
 * @author: zjh
 * @date : 2022/7/11 16:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0441 {

    /**
     * 方法一：二分查找
     * 执行耗时:1 ms,击败了95.57% 的Java用户
     * 内存消耗:39 MB,击败了21.92% 的Java用户
     */
    private class S1 {

        public int arrangeCoins(int n) {
            long l = 1, r = n / 2 + 1, m = -1, y = -1;

            while (l < r) {
                m = l + (r - l + 1) / 2;
                y = m * (m + 1) / 2;

                if (y == n) {
                    return (int) m;
                } else if (y > n) {
                    r = m - 1;
                } else if (y < n) {
                    l = m;
                }
            }

            return (int) l;
        }

    }

    /**
     * 方法二：数学
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/arranging-coins/solution/pai-lie-ying-bi-by-leetcode-solution-w52c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private class S2 {

        class Solution {
            public int arrangeCoins(int n) {
                return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
            }
        }

    }

}
