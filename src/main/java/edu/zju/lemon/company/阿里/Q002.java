package edu.zju.lemon.company.阿里;

import java.util.Arrays;
import java.util.Scanner;

public class Q002 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int res = 0;
            Arrays.sort(nums[i]);
            res += nums[i][0];
            nums[i][2] -= nums[i][0];
            nums[i][3] -= nums[i][0];
            nums[i][4] -= nums[i][0];
            nums[i][0] -= nums[i][0];

            Arrays.sort(nums[i]);
            res += nums[i][1];

            System.out.println(res);
        }

    }

}
