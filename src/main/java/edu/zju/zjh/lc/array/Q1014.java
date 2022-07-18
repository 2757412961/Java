package edu.zju.zjh.lc.array;

/**
 * @author: zjh
 * @date : 2022/7/18 21:04
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1014 {

    /**
     * 执行耗时:3 ms,击败了97.35% 的Java用户
     * 内存消耗:49.9 MB,击败了48.41% 的Java用户
     */
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0, maxi = 0;

        int n = values.length;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxi + values[i] - i);
            maxi = Math.max(maxi, values[i] + i);
        }

        return res;
    }

}
