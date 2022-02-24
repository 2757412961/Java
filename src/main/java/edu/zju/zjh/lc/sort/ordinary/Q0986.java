package edu.zju.zjh.lc.sort.ordinary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/2/21 19:16
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int n = firstList.length;
        int m = secondList.length;

        while (i < n && j < m) {
            int[] first = firstList[i];
            int[] second = secondList[j];

            if (first[1] < second[0]) {
                i++;
            } else if (first[0] <= second[0] && second[0] <= first[1]) {
                if (second[1] <= first[1]) {
                    res.add(new int[]{second[0], second[1]});
                    j++;
                } else {
                    res.add(new int[]{second[0], first[1]});
                    i++;
                }
            } else {
                if (second[1] < first[0]) {
                    j++;
                } else if (first[0] <= second[1] && second[1] <= first[1]) {
                    res.add(new int[]{first[0], second[1]});
                    j++;
                } else {
                    res.add(new int[]{first[0], first[1]});
                    i++;
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
