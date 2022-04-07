package edu.zju.skr.company.ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zjh
 * @date : 2022/4/7 下午 06:56
 * @Email : 2757412961@qq.com
 * @update:
 */

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



    }

}
