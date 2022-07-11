package edu.zju.zjh.lc.doublepointer.leftright;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/7/11 21:27
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0633 {

    /**
     * 方法零：暴力 + 剪枝
     * 方法一：使用 sqrt 函数
     * <p>
     * 执行耗时:65 ms,击败了5.04% 的Java用户
     * 内存消耗:49.5 MB,击败了5.03% 的Java用户
     */
    private class S1 {

        public boolean judgeSquareSum(int c) {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i <= c; i++) {
                int i2 = i * i;
                set.add(i2);

                if (c - i2 < 0) break;
                if (set.contains(c - i2)) {
                    return true;
                }
            }

            return false;
        }

    }

    /**
     * 方法二：双指针
     * <p>
     * 执行耗时:3 ms,击败了91.38% 的Java用户
     * 内存消耗:38.7 MB,击败了6.46% 的Java用户
     */
    private class S2 {

        public boolean judgeSquareSum(int c) {
            long l = 0, r = (int) (Math.sqrt(c) + 1), m = -1;

            // == 表示 2*2 +2*2 = 8 的情况
            while (l <= r) {
                m = l * l + r * r;

                if (m == c) {
                    return true;
                } else if (m > c) {
                    r--;
                } else if (m < c) {
                    l++;
                }
            }

            return false;
        }

    }

    /**
     * 方法三：数学
     */
    private class S3 {

        public boolean judgeSquareSum(int c) {
            return false;
        }

    }

}
