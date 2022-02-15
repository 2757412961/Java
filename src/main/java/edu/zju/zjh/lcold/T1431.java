package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

public class T1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int n = candies.length;

        for (int i = 0; i < n; i++) {
            if (candies[i] > max)
                max = candies[i];
        }

        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;

        new T1431().kidsWithCandies(candies, extraCandies);
    }
}
