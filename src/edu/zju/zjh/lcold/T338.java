package edu.zju.zjh.lcold;

import java.util.Arrays;

public class T338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int base = 1;
        dp[0] = 0;
        if (num == 0) return dp;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            if (i == base * 2) {
                base *= 2;
                dp[i] = 1;
            } else {
                dp[i] = dp[base] + dp[i - base];
            }
        }

        return dp;
    }

    public static void main(String[] args) {
//        给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

//        示例 1:
//        输入: 2
//        输出: [0,1,1]

//        示例 2:
//        输入: 5
//        输出: [0,1,1,2,1,2]

        int num = 17;
        System.out.println(Arrays.toString(new T338().countBits(num)));
    }
}
