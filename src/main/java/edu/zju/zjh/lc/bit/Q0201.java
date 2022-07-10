package edu.zju.zjh.lc.bit;

import java.util.ArrayList;

/**
 * @author: zjh
 * @date : 2022/7/10 17:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0201 {

    /**
     * Long Long ago
     */
    private class S0 {

        public int rangeBitwiseAnd(int m, int n) {
            int res = 0;
            boolean is = true;
            ArrayList<Integer> am = new ArrayList<>();
            ArrayList<Integer> an = new ArrayList<>();

            while (!(m == 0 && n == 0)) {
                am.add(m % 2);
                an.add(n % 2);

                m /= 2;
                n /= 2;
            }

            for (int i = am.size() - 1; i >= 0; i--) {
                if (am.get(i) != an.get(i)) {
                    is = false;
                }
                int wei = is ? am.get(i) : 0;

                res = res * 2 + wei;
            }

            return res;
        }

    }

    /**
     * 最直观的解决方案就是迭代范围内的每个数字，依次执行按位与运算，得到最终的结果，
     * 但此方法在范围较大的测试用例中会因超出时间限制。
     * <p>
     * 方法：遇到零，直接返回
     * 执行耗时:435 ms,击败了7.19% 的Java用户
     * 内存消耗:41.3 MB,击败了5.26% 的Java用户
     */
    private class S1 {

        public int rangeBitwiseAnd(int left, int right) {
            int res = right;

            for (int i = left; i < right; i++) {
                if (res == 0) break;
                res &= i;
            }

            return res;
        }

    }

    /**
     * 方法一：二进制公共前缀
     * 因此，最终我们可以将问题重新表述为：给定两个整数，我们要找到它们对应的二进制字符串的公共前缀。
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了32.81% 的Java用户
     */
    private class S2 {

        public int rangeBitwiseAnd(int left, int right) {
            int n = 0;
            while (left != right) {
                left >>= 1;
                right >>= 1;
                n++;
            }

            while (n > 0) {
                left <<= 1;
                n--;
            }

            return left;
        }

    }

    /**
     * 方法二：Brian Kernighan 算法
     */

}
