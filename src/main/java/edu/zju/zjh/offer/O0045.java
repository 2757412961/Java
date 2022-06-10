package edu.zju.zjh.offer;

import java.util.Arrays;

public class O0045 {

    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ab.compareTo(ba);
        });

        for (int i = 0; i < nums.length; i++) {
            res.append(strs[i]);
        }

        return res.toString();
    }

}
