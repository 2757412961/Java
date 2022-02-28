package edu.zju.zjh.lc.sort.quicksort;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/2/24 12:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0179 {

    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);
            return (int) (Long.parseLong(ab) - Long.parseLong(ba));
        });

        if (strs[0].charAt(0) == '0') return "0";

        for (int i = 0; i < nums.length; i++) {
            res.append(strs[i]);
        }

        return res.toString();
    }

}
