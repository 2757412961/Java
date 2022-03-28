package edu.zju.zjh.lc.sort.ordinary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q0179 {

    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        if (strs[0].charAt(0) == '0') return "0";

        for (int i = 0; i < nums.length; i++) {
            res.append(strs[i]);
        }

        return res.toString();
    }

}
