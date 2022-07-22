package edu.zju.zjh.topk.蔚来.d20220715;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/7/13 20:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q003 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                new int[]{1, 3},
                new int[]{5, 2},
                new int[]{3, 1},
                new int[]{2, 1},
                new int[]{4, 3},
        };
        int k = 3;
        Arrays.sort(nums, (a, b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i][0] + " " + nums[i][1]);
        }


        int ans = 0, tmp = 0;
        int i = 0, j = 0, n = nums.length;

        while (j < n) {
            tmp += nums[j++][1];

            while (i < j && nums[j - 1][0] - nums[i][0] >= k) {
                tmp -= nums[i++][1];
            }

            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }

}
