package edu.zju.zjh.lc.array;

import java.util.Arrays;

public class Q0453 {

    public int minMoves(int[] nums) {
        if (nums.length <= 1) return 0;
        int res = 0;
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) min = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }

        return res;
    }

}
