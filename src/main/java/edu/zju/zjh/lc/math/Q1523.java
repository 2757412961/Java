package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/7/17 21:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1523 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了56.94% 的Java用户
     */
    public int countOdds(int low, int high) {
        int cnt = (high - low + 1) / 2;
        if (high % 2 == 1 && low % 2 == 1) {
            cnt++;
        }

        return cnt;
    }

}
