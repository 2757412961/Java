package edu.zju.zjh.topk.蔚来.d20220703;

import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/7/3 下午 08:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }

        int sum1 = nums[0], sum2 = nums[1];

        for (int i = 2; i < n; i++) {
            if (sum1 < sum2) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }

        System.out.println(Math.max(sum1, sum2));
    }

}
