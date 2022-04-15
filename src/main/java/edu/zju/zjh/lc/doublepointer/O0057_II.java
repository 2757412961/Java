package edu.zju.zjh.lc.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 04:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0057_II {

    public int calSum(int i, int j) {
        return (i + j) * (j - i + 1) / 2;
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1, r = 2;

        while (l < r) {
            int sum = calSum(l, r);
            if (sum > target) {
                l++;
            } else if (sum < target) {
                r++;
            } else if (sum == target) {
                int[] a = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    a[i - l] = i;
                }
                res.add(a);
                l++;
            }
        }

        return res.toArray(new int[0][0]);
    }

}
