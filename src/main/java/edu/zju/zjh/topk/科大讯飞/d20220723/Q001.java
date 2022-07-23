package edu.zju.zjh.topk.科大讯飞.d20220723;

import java.util.*;

public class Q001 {

    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            double[] nums = new double[n];
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                res[i] = Math.round(nums[i] * 0.5 * (1 - Math.cos(2 * 3.1415927 * i / n)));
            }

            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }

}
