package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 9:02
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0064 {

    /**
     * 方法一：递归 + 逻辑符短路
     */
    private class S1 {

        public int sumNums(int n) {
            boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            return n;
        }

    }

    /**
     * 方法二：快速乘
     */

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了62.97% 的Java用户
     */
    private class S2 {

        public int sumNums(int n) {
            int r = 0;
            boolean flag = (n > 0) && (r = n + sumNums(n - 1)) > 0;

            return r;
        }

    }

}
