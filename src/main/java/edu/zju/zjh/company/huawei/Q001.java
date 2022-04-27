package edu.zju.zjh.company.huawei;

import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/4/20 下午 07:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    static int res = 0;
    static int[] nums = new int[]{
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
            8, 8, 8, 8, 8
    };

    public static void backTrack(int pos, int error, int target) {
        if (error < 0 || target < 0) return;
        if (target == 0) {
            res++;
            return;
        }
        if (error == 0) return;
        if (pos >= nums.length) return;

        backTrack(pos + 1, error, target - nums[pos]);
        backTrack(pos + 1, error - 1, target);
    }


    public static void main(String[] args) {
        // 94 10 * 10
        // 100 1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        backTrack(0, 3, n);

        System.out.println(res);
    }
}
