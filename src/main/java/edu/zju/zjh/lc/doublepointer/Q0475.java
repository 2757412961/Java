package edu.zju.zjh.lc.doublepointer;

/**
 * @author: zjh
 * @date : 2022/5/17 15:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0475 {

    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        int m = houses.length, n = heaters.length;
        int ldis = 0, rdis = 0;

        for (int i = 0, j = 0; i < m; i++) {
            while (j < n -1 && houses[i] > heaters[j]) {
                j++;
            }
            if (j == 0) {
                ldis = Integer.MAX_VALUE;
            } else {
                ldis = houses[i] - heaters[j - 1];
            }
            rdis = Math.abs(heaters[j] - houses[i]);

            res = Math.max(res, Math.min(ldis, rdis));
        }

        return res;
    }

}
