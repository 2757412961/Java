package edu.zju.zjh.lc.sort.ordinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/2/21 17:36
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0056 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (max < intervals[i][0]) {
                res.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            } else if (max < intervals[i][1]) {
                max = intervals[i][1];
            } else if (max > intervals[i][1]) {

            }
        }
        res.add(new int[]{min, max});

        return res.toArray(new int[0][]);
    }

}
