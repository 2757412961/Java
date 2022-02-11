package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

public class T056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return null;
        }

        ArrayList<int[]> bull = new ArrayList<>();
        int[][] res;
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (intervals[minIndex][0] > intervals[j][0]) {
                    minIndex = j;
                }
            }
            int[] temp = intervals[i];
            intervals[i] = intervals[minIndex];
            intervals[minIndex] = temp;
        }

        int mini = intervals[0][0], maxi = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] item = intervals[i];
            if (maxi < item[0]) {
                bull.add(new int[]{mini, maxi});
                mini = item[0];
                maxi = item[1];
            } else {
                maxi = Math.max(maxi, item[1]);
            }
        }
        bull.add(new int[]{mini, maxi});


        res = new int[bull.size()][2];
        for (int i = 0; i < bull.size(); i++) {
            res[i] = bull.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {8, 10},
                {2, 6},
                {15, 18}
        };

        T056 t056 = new T056();
        t056.merge(intervals);
    }
}
