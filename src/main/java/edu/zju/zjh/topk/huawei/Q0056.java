package edu.zju.zjh.topk.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/14 19:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0056 {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int min = intervals[0][0], max = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (max < intervals[i][0]) {
                res.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
                continue;
            }

            max = Math.max(max, intervals[i][1]);
        }
        res.add(new int[]{min, max});

        return res.toArray(new int[0][0]);
    }

}
