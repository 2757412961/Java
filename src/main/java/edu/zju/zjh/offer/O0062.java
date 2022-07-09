package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/24 12:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0062 {

    /**
     * 方法一：数学 + 递归
     */
    private class S1 {

        public int lastRemaining(int n, int m) {
            int idx = 0;

            for (int i = 2; i <= n; i++) {
                idx = (idx + m) % i;
            }

            return idx;
        }

        public int f(int n, int k) {
            if (n == 1) return 0;

            return (f(n - 1, k) + k) % n;
        }

    }

    /**
     * 数学 / 动态规划
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     * 执行耗时:4 ms,击败了99.99% 的Java用户
     * 内存消耗:38.4 MB,击败了53.76% 的Java用户
     */
    private class S2 {

        public int lastRemaining(int n, int m) {
            int res = 0;

            for (int i = 2; i <= n; i++) {
                res = (res + m) % i;
            }

            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(new O0062().new S1().lastRemaining(5, 3));
        System.out.println(new O0062().new S1().f(5, 3));
        System.out.println(new O0062().new S1().f(9, 3));

    }

}
